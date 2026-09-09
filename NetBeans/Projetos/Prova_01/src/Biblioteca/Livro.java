/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

public class Livro {
    private String titulo;
    private String autor;
    private String anoPublicacao;
    private char tipo;
    private String categorias;
    private String sitLeitura;

    public Livro(String titulo, String autor, String anoPublicacao, char tipo, String categorias, String sitLeitura) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.tipo = tipo;
        this.categorias = categorias;
        this.sitLeitura = sitLeitura;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    public String getSitLeitura() {
        return sitLeitura;
    }

    public void setSitLeitura(String sitLeitura) {
        this.sitLeitura = sitLeitura;
    }

//    (sexo == 'M' ? "Masculino" : "Feminino")
//    (tipo == 'D' ? "Digital" : "Físico")

    public Object[] obterDados(){
        return new Object[] {titulo,autor,anoPublicacao,(tipo == 'D' ? "Digital" : "Físico"),categorias,sitLeitura};
        
    }
    
    
}
