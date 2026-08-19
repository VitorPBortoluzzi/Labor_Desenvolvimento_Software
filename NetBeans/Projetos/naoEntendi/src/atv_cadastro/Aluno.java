/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atv_cadastro;

/**
 *
 * @author laboratorio
 */
public class Aluno {
    
    public String nomeCompleto;
    public String dataNascimento;
    public char sexo;
    public int matricula;
    public String curso;
    public String cpf;
    public Endereco endereco;
    public String estado;
    public String telefone;

    public Aluno(String nomeCompleto, String dataNascimento, char sexo, int matricula, String curso, String cpf, Endereco endereco, String estado, String telefone) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.matricula = matricula;
        this.curso = curso;
        this.cpf = cpf;
        this.endereco = endereco;
        this.estado = estado;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Aluno{" + nomeCompleto + ";" + dataNascimento + ";" + sexo + ";" + matricula + ";" + curso + ";" + cpf + ";" + endereco + ";" + estado + ";" + telefone + ";";
    }
    
}