
package beans;

public class Pessoa {
    private int id;
    private String nome;
    private String sexo;
    private String idioma;

    public int getId() {
        return id;
    }

//  acho não precisar do método setId já que o banco de dados possui auto_increment na variável ID
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", idioma=" + idioma + '}';
    }
    
    
}
