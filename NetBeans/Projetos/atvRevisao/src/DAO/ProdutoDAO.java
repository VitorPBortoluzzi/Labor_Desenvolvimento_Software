package DAO;

import beans.Categoria;
import beans.Produto;
import conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Conexao conexao;
    private Connection conn;

    // SELECT base com JOIN: já traz o nome da categoria junto com o produto
    private static final String SELECT_BASE =
            "SELECT p.id, p.nome, p.preco, p.quantidade, c.id AS cat_id, c.nome AS cat_nome "
          + "FROM Produtos p INNER JOIN Categorias c ON c.id = p.categoria_id ";

    public ProdutoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Produto produto) {
        String sql = "INSERT INTO Produtos(nome,preco,quantidade,categoria_id) VALUES (?,?,?,?);";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, produto.getNome());
            stmt.setBigDecimal(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getCategoria().getId());
            stmt.execute();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    produto.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

    public void editar(Produto produto) {
        String sql = "UPDATE Produtos SET nome=?, preco=?, quantidade=?, categoria_id=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setBigDecimal(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getCategoria().getId()); // permite trocar a categoria
            stmt.setInt(5, produto.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar produto: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM Produtos WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir produto: " + ex.getMessage());
        }
    }

    public Produto getProduto(int id) {
        List<Produto> lista = consultar("WHERE p.id = ?", String.valueOf(id), true);
        return lista.isEmpty() ? null : lista.get(0);
    }

    public List<Produto> getProdutos() {
        return consultar("", null, false);
    }

    public List<Produto> getProdutosNome(String nome) {
        return consultar("WHERE p.nome LIKE ?", "%" + nome + "%", false);
    }

    public List<Produto> getProdutosCategoria(String categoria) {
        return consultar("WHERE c.nome LIKE ?", "%" + categoria + "%", false);
    }

    private List<Produto> consultar(String where, String parametro, boolean parametroInteiro) {
        List<Produto> lista = new ArrayList<>();
        String sql = SELECT_BASE + where + " ORDER BY p.nome";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (parametro != null) {
                if (parametroInteiro) stmt.setInt(1, Integer.parseInt(parametro));
                else stmt.setString(1, parametro);
            }
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Produto p = new Produto();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setPreco(rs.getBigDecimal("preco"));
                    p.setQuantidade(rs.getInt("quantidade"));

                    Categoria c = new Categoria();
                    c.setId(rs.getInt("cat_id"));
                    c.setNome(rs.getString("cat_nome"));
                    p.setCategoria(c);

                    lista.add(p);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar produtos: " + ex.getMessage());
        }
        return lista;
    }
}
