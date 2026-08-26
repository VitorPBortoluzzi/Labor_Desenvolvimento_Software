/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atv_cadastro;

/**
 *
 * @author laboratorio
 */
public class Endereco {
    public String rua;
    public String numero;
    public String bairro;
    public String cidade;
    public String cep;
    public String estado;

    public Endereco(String rua, String numero, String bairro, String cidade,String estado, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return rua + ";" + numero + ";" + bairro + ";" + cidade + ";" + estado + ";" + cep;
    }



    
    
}
