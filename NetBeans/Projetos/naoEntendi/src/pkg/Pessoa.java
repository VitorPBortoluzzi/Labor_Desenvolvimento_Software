/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

import java.util.ArrayList;

/**
 *
 * @author laboratorio
 */
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

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", sexo=" + sexo + ", idioma=" + idioma + ", interesses=" + interesses + '}';
    }

}