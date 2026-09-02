package atv_cadastro2;

public class Aluno {
    
    private String nomeCompleto;
    private String dataNascimento;
    private char sexo; // 'M' ou 'F'
    private int matricula;
    private String curso;
    private String cpf;
    private Endereco endereco;
    private String estadoCivil;
    private String telefone;

    public Aluno(String nomeCompleto, String dataNascimento, char sexo, int matricula, 
                 String curso, String cpf, Endereco endereco, String estadoCivil, String telefone) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.matricula = matricula;
        this.curso = curso;
        this.cpf = cpf;
        this.endereco = endereco;
        this.estadoCivil = estadoCivil;
        this.telefone = telefone;
    }

    // Getters e Setters
    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }

    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    public char getSexo() { return sexo; }
    public void setSexo(char sexo) { this.sexo = sexo; }

    public int getMatricula() { return matricula; }
    public void setMatricula(int matricula) { this.matricula = matricula; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    public String getEstadoCivil() { return estadoCivil; }
    public void setEstadoCivil(String estadoCivil) { this.estadoCivil = estadoCivil; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    /**
     * Retorna os dados formatados para exibição na JTable.
     */
    public Object[] obterDados() {
        return new Object[]{
            nomeCompleto,
            dataNascimento,
            (sexo == 'M' ? "Masculino" : "Feminino"),
            matricula,
            curso,
            cpf,
            endereco.getRua(),
            endereco.getNumero(),
            endereco.getBairro(),
            endereco.getCidade(),
            endereco.getEstado(),
            endereco.getCep(),
            estadoCivil,
            telefone
        };
    }

    /**
     * Retorna a string serializada para gravação em arquivo TXT (separado por ;)
     */
    @Override
    public String toString() {
        return nomeCompleto + ";" + 
               dataNascimento + ";" + 
               sexo + ";" + 
               matricula + ";" + 
               curso + ";" + 
               cpf + ";" + 
               endereco.toString() + ";" + 
               estadoCivil + ";" + 
               telefone;
    }
}