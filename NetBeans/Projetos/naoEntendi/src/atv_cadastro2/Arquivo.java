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

    private List<Aluno> listaAlunos;
    private String nomeArquivo;

    public Arquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        this.listaAlunos = new ArrayList<>();
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public List<Aluno> leArquivo() {
        listaAlunos.clear();

        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo + ".txt"))) {
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
                    
                    Endereco endereco = new Endereco(
                        campos[6],  // rua
                        campos[7],  // numero
                        campos[8],  // bairro
                        campos[9],  // cidade
                        campos[10], // estado
                        campos[11]  // cep
                    );

                    String estadoCivil = campos[12];
                    String telefone = campos[13];

                    Aluno aluno = new Aluno(
                        nomeCompleto, dataNascimento, sexo, matricula, 
                        curso, cpf, endereco, estadoCivil, telefone
                    );

                    listaAlunos.add(aluno);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo '" + nomeArquivo + ".txt' ainda não existe. Será criado ao salvar.");
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro de conversão ao ler arquivo: " + e.getMessage());
        }

        return this.listaAlunos;
    }

    /**
     * Grava a lista de alunos no arquivo TXT utilizando os Getters das classes Aluno e Endereco.
     */
    public void gravaArquivo() {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo + ".txt"))) {
            for (Aluno a : listaAlunos) {
                // Montagem da linha utilizando explicitamente os Getters do Aluno e do Endereco
                String linha = a.getNomeCompleto() + ";" +
                               a.getDataNascimento() + ";" +
                               a.getSexo() + ";" +
                               a.getMatricula() + ";" +
                               a.getCurso() + ";" +
                               a.getCpf() + ";" +
                               a.getEndereco().getRua() + ";" +
                               a.getEndereco().getNumero() + ";" +
                               a.getEndereco().getBairro() + ";" +
                               a.getEndereco().getCidade() + ";" +
                               a.getEndereco().getEstado() + ";" +
                               a.getEndereco().getCep() + ";" +
                               a.getEstadoCivil() + ";" +
                               a.getTelefone();

                escritor.write(linha);
                escritor.newLine();
            }
            System.out.println("Lista de alunos salva com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }
}