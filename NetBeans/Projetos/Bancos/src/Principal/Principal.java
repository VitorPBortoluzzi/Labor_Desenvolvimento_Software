package Principal;

import conexao.Conexao;
import beans.Pessoa;
import DAO.PessoaDAO;

public class Principal {
    public static void main(String[] args) {
        Conexao c = new Conexao();
        c.getConexao();
        
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Maria");
        pessoa.setSexo("F");
        pessoa.setIdioma("Português");
        
        PessoaDAO pdao = new PessoaDAO();
        pdao.inserir(pessoa);
        
    } 
}
