package DAO;

import beans.Funcionario;
import java.sql.Connection;
import conexao.Conexao;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import java.sql.SQLException;

public class FuncionarioDAO {
    private Conexao conexao;
    private Connection conn;
    
    public FuncionarioDAO(){
            this.conexao = new Conexao();
            this.conn = this.conexao.getConexao();
        }
    
    public void inserir (Funcionario f){
    String sql = "INSERT INTO funcionarios(nome,idade,genero,cargo,salario) values (?,?,?,?,?);";
    try (PreparedStatement stmt = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
         stmt.setString(1, f.getNome());
         stmt.setInt(2, f.getIdade());
         stmt.setString(3, f.getGenero());
         stmt.setString(4,f.getCargo());
         stmt.setDouble(5, f.getSalario());
         
         stmt.execute();
         
         try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) {
                f.setId(rs.getInt(1));
            }
        }
    } catch (SQLException e) {
         System.out.println("Erro ao inserir pessoa:"+e.getMessage());
        }
    }
    
    public List<Funcionario> listar(){
        String sql = "SELECT * FROM funcionarios";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery();
            List<Funcionario> listaFuncionarios = new ArrayList();

            while(rs.next()){
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setIdade(rs.getInt("idade"));
                f.setGenero(rs.getString("genero"));
                f.setCargo(rs.getString("cargo"));
                f.setSalario(rs.getDouble("salario"));
                listaFuncionarios.add(f);
            }         
            return listaFuncionarios;                  
        } catch (SQLException ex){
            System.out.println("Erro ao consultar todos os funcionarios: "+ ex.getMessage());
            return null;
        }
    }
}
