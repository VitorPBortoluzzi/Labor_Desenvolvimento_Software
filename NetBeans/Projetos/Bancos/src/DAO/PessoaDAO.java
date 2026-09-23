package DAO;

import beans.Pessoa;
import java.sql.Connection;
import conexao.Conexao;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import java.sql.SQLException;


public class PessoaDAO {
    private Conexao conexao;
    private Connection conn;
    
    public PessoaDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
 public void inserir (Pessoa pessoa){
     try {
         String sql = "INSERT INTO pessoa(nome,sexo,idioma) values (?,?,?);";
         PreparedStatement stmt = this.conn.prepareStatement(sql);
         stmt.setString(1, pessoa.getNome());
         stmt.setString(2, pessoa.getSexo());
         stmt.setString(3, pessoa.getIdioma());
         
         stmt.execute();
     } catch (SQLException e) {
         System.out.println("Erro ao inserir pessoa:"+e.getMessage());
     }
 }
   
}

//package DAO;
//
//import beans.Pessoa;
//import java.sql.Connection;
//import conexao.Conexao;
//import java.util.List;
//import java.util.ArrayList;
//import java.sql.*;
//import java.sql.SQLException;
//
//
//public class PessoaDAO {
//    private Conexao conexao;
//    private Connection conn;
//    
//    public PessoaDAO(){
//        this.conexao = new Conexao();
//        this.conn = this.conexao.getConexao();
//    }
//    
// public void inserir (Pessoa pessoa){
//     String sql = "INSERT INTO pessoas (nome, sexo, idioma) VALUES (?, ?, ?)";
//        
//        // Note o argumento Statement.RETURN_GENERATED_KEYS aqui embaixou:
//        try (
////            Connection conn = new Conexao().getConexao();
//            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//            
//            stmt.setString(1, pessoa.getNome());
//            stmt.setString(2, pessoa.getSexo());
//            stmt.setString(3, pessoa.getIdioma());
//            
//            stmt.executeUpdate();
//            
//            // Captura o ID gerado pelo MySQL
//            try (ResultSet rs = stmt.getGeneratedKeys()) {
//                if (rs.next()) {
//                    int idGerado = rs.getInt(1); // Pega o primeiro campo (o ID)
//                    pessoa.setId(idGerado);      // Guarda o ID de volta no objeto Pessoa
//                }
//            }
//            
//        } catch (SQLException e) {
//            throw new RuntimeException("Erro ao inserir pessoa: " + e.getMessage(), e);
//        }
//    }
//}
