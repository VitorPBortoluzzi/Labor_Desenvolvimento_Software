package Biblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {
    
    private FileWriter arqW;
    private BufferedWriter escritor;
    
    private FileReader arqR;
    private BufferedReader leitor;
    
    private List<Livro> listaLivros;
    
    public String nomeArquivo;
    
    public Arquivo(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
        listaLivros = new ArrayList<>();
    }
    
    public List<Livro> leArquivo(){
        listaLivros.clear();
        
        try {
            arqR = new FileReader(nomeArquivo + ".txt");
            leitor = new BufferedReader(arqR);
            
            String linha;
            
            while((linha = leitor.readLine()) != null){
                String[] campos = linha.split(";");
                
                String titulo = campos[0];
                String autor = campos[1];
                String anoPublicacao = campos[2];
                char tipo = campos[3].charAt(0);
                String categoria = campos[4];
                String sitLeitura = campos[5];
                
                Livro l = new Livro(titulo, autor, anoPublicacao, tipo, categoria, sitLeitura);
                listaLivros.add(l);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo ainda não existe");        
        }
        
        catch (IOException e){
            e.printStackTrace();
            
        } return listaLivros;
    }
    
    public void gravarArquivo(){
        try {
            arqW = new FileWriter(nomeArquivo + ".txt");
            escritor = new BufferedWriter(arqW);
            
            for (Livro l : listaLivros){
                escritor.write(
                    l.getTitulo() + ";" +
                    l.getAutor() + ";" +
                    l.getAnoPublicacao() + ";" +
                    l.getTipo() + ";" +
                    l.getCategorias() + ";" +
                    l.getSitLeitura()

                );
                
                escritor.newLine();
            }
            
            escritor.close();
            arqW.close();
            
            
        } catch (Exception e) {
        }
    }
    
}
