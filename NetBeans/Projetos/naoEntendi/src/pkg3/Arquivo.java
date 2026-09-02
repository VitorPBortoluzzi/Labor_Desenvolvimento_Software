package pkg3;

import pkg2_continuacao.*;
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

    private List<Pessoa> listaPessoas;
    private ArrayList<String> interesses = new ArrayList<>();

    public String nomeArquivo;
    
    public Arquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        listaPessoas = new ArrayList<>();
    }
    
    public List<Pessoa> leArquivo(){
        listaPessoas.clear();
        
        try {
            arqR = new FileReader(nomeArquivo + ".txt");
            leitor = new BufferedReader(arqR);
            
            String linha;
            
            while((linha = leitor.readLine()) != null){
                
                String[] campos = linha.split(";");
                
                String nome = campos[0];
                char sexo = campos[1].charAt(0);
                String idioma = campos[2];
                
                if(campos.length > 3 && !campos[3].isEmpty()){
                    String interessesLimpos = campos[3].replace("[","").replace("]","");
                    
                    String[] temp = interessesLimpos.split(",");
                    
                    for(String item : temp){
                        interesses.add(item.trim());
                    }
                }

                Pessoa p = new Pessoa(nome,sexo,idioma,interesses);                
                listaPessoas.add(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo ainda não existe");        
        }
        
        catch (IOException e){
            e.printStackTrace();
        }
        
        return listaPessoas;
    }
    
    public void gravaArquivo(){
        try {
            arqW = new FileWriter(nomeArquivo + ".txt");
            escritor = new BufferedWriter(arqW);
            
            for (Pessoa p : listaPessoas){
                escritor.write(
                        p.nome + ";" +
                        p.sexo + ";" + 
                        p.idioma + ";"+
                        p.interesses
                );
                
                escritor.newLine();
                
            }
            
            escritor.close();
            arqW.close();
            
            System.out.println("Lista Salva no Arquivo");
        } catch (Exception e) {
        }
    }
}
