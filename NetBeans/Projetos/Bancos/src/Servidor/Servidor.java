package Servidor;

import DAO.PessoaDAO;
import beans.Pessoa;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        int porta = 12345; //Use uma constante para a porta
        
        try (ServerSocket servidorSocket = new ServerSocket(porta)){
            System.out.println("Servidor aguardando conexões na porta " + porta);
            
//            while(true){
//                try {
//                    Socket clienteSocket = servidorSocket.accept();
//                    System.out.println("Conexão aceita de " + clienteSocket.getInetAddress());
//                    ObjectOutputStream out = new ObjectOutputStream(clienteSocket.getOutputStream());
//                    ObjectInputStream in = new ObjectInputStream(clienteSocket.getInputStream());
//                    
//                    int id = in.readInt();
//                    System.out.println("ID recebido: " + id);
//                    
//                    //Simule a obtenção de uma pessoa a partir do ID
//                    PessoaDAO pdao = new PessoaDAO();
//                    Pessoa p = pdao.getPessoa(id);
//                    System.out.println("Pessoa: "+p);
//                    
//                    out.writeObject(p);
//                    
//                } catch (IOException ex) {
//                    System.out.println("Erro ao atender cliente");
//                    ex.printStackTrace();   // mostra a causa real
//                }

            //USANDO THREAD
            
            while(true){
                try {
                    Socket clienteSocket = servidorSocket.accept();
                    System.out.println("Conexão aceita de " + clienteSocket.getInetAddress());
                    
                    //Thread
                    Thread threadCliente = new ThreadServer(clienteSocket);
                    threadCliente.start();
                    
                } catch (IOException ex) {
                    System.out.println("Erro ao atender cliente");
                    ex.printStackTrace();   // mostra a causa real
                }
               
            }
        } catch (IOException ex) {
            System.out.println("Erro ao criar serverSocket");
        }
    } 
}
