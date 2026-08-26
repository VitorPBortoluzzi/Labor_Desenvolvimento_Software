package pkg2_continuacao;

import java.util.ArrayList;

public class Pessoa {
    public String nome;
    public char sexo;
    public String idioma;
    public ArrayList<String> interesses;

    public Pessoa(String nome, char sexo, String idioma, ArrayList<String> interesses) {
        this.nome = nome;
        this.sexo = sexo;
        this.idioma = idioma;
        this.interesses = interesses;
    }

    public Object[] obterDados(){
        String interessesFormatados = String.join(",", interesses);
        
        return new Object[] {nome,sexo,idioma,interessesFormatados};
    }
    
    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", sexo=" + sexo + ", idioma=" + idioma + ", interesses=" + interesses + '}';
    }

}