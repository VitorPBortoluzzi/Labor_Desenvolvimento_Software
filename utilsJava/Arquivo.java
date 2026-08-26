import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {

    private final String caminhoArquivo;

    // Construtor que recebe o nome ou caminho do arquivo (ex: "alunos.txt")
    public Arquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    /**
     * Salva o texto informado no arquivo.
     * @param conteudo Texto a ser gravado.
     * @param sobrescrever 'false' para adicionar no final do arquivo, 'true' para substituir o conteúdo.
     * @return true se salvou com sucesso, false em caso de erro.
     */
    public boolean salvar(String conteudo, boolean sobrescrever) {
        // try-with-resources garante o fechamento do arquivo mesmo em caso de erro
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, !sobrescrever))) {
            writer.write(conteudo);
            return true;
        } catch (IOException e) {
            System.err.println("Erro ao salvar arquivo: " + e.getMessage());
            return false;
        }
    }

    /**
     * Le todo o conteudo do arquivo e retorna como uma String.
     * @return O texto contido no arquivo ou String vazia se estiver vazio/nao existir.
     */
    public String ler() {
        StringBuilder conteudo = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo (pode nao existir ainda): " + e.getMessage());
        }

        return conteudo.toString();
    }
}