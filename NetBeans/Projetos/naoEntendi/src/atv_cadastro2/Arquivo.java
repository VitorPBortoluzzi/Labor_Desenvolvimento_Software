package atv_cadastro2;

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

    public List<Aluno> listaAlunos;
    public String nomeArquivo;

    public Arquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        this.listaAlunos = new ArrayList<>();
    }

    public List<Aluno> leArquivo() {
        listaAlunos.clear();

        try {
            arqR = new FileReader(nomeArquivo + ".txt");
            leitor = new BufferedReader(arqR);

            String linha;

            while ((linha = leitor.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;

                String[] campos = linha.split(";");

                if (campos.length >= 14) {
                    String nomeCompleto = campos[0];
                    String dataNascimento = campos[1];
                    char sexo = campos[2].charAt(0);
                    int matricula = Integer.parseInt(campos[3]);
                    String curso = campos[4];
                    String cpf = campos[5];
                    
                    // Instância do Endereço
                    String rua = campos[6];
                    String numero = campos[7];
                    String bairro = campos[8];
                    String cidade = campos[9];
                    String estado = campos[10];
                    String cep = campos[11];
                    
                    Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);

                    String estadoCivil = campos[12];
                    String telefone = campos[13];

                    Aluno aluno = new Aluno(
                        nomeCompleto, dataNascimento, sexo, matricula, 
                        curso, cpf, endereco, estadoCivil, telefone
                    );

                    listaAlunos.add(aluno);
                }
            }

            leitor.close();
            arqR.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo ainda não existe.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter matrícula: " + e.getMessage());
        }

        return listaAlunos;
    }

    public void gravaArquivo() {
        try {
            arqW = new FileWriter(nomeArquivo + ".txt");
            escritor = new BufferedWriter(arqW);

            for (Aluno a : listaAlunos) {
                // Acesso direto aos atributos públicos de Aluno e Endereco
                escritor.write(
                    a.nomeCompleto + ";" +
                    a.dataNascimento + ";" +
                    a.sexo + ";" +
                    a.matricula + ";" +
                    a.curso + ";" +
                    a.cpf + ";" +
                    a.endereco.rua + ";" +
                    a.endereco.numero + ";" +
                    a.endereco.bairro + ";" +
                    a.endereco.cidade + ";" +
                    a.endereco.estado + ";" +
                    a.endereco.cep + ";" +
                    a.estadoCivil + ";" +
                    a.telefone
                );

                escritor.newLine();
            }

            escritor.close();
            arqW.close();

            System.out.println("Lista Salva no Arquivo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}