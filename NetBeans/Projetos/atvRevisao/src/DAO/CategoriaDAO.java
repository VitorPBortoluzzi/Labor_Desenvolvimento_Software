package DAO;

import beans.Categoria;
import conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private Conexao conexao;
    private Connection conn;

    public CategoriaDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Categoria categoria) {
        String sql = "INSERT INTO Categorias(nome) VALUES (?);";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, categoria.getNome());
            stmt.execute();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    categoria.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir categoria: " + e.getMessage());
        }
    }

    public void editar(Categoria categoria) {
        String sql = "UPDATE Categorias SET nome=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar categoria: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM Categorias WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir categoria: " + ex.getMessage());
        }
    }

    public Categoria getCategoria(int id) {
        String sql = "SELECT * FROM Categorias WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Categoria c = new Categoria();
                    c.setId(rs.getInt("id"));
                    c.setNome(rs.getString("nome"));
                    return c;
                }
            }
            return null;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar categoria: " + ex.getMessage());
            return null;
        }
    }

    public List<Categoria> getCategorias() {
        String sql = "SELECT * FROM Categorias ORDER BY nome";
        List<Categoria> lista = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                lista.add(c);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar todas as categorias: " + ex.getMessage());
            return lista;
        }
    }
}
