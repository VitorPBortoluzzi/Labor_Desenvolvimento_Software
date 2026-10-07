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
 
 public Pessoa getPessoa(int id){
     String sql = "SELECT * FROM pessoa WHERE id = ?";
     Pessoa p = null;
     try{
         PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         stmt.setInt(1,id);
         ResultSet rs = stmt.executeQuery();
         p = new Pessoa();
         rs.first();
         p.setId(rs.getInt("id"));
         p.setNome(rs.getString("nome"));
         p.setSexo(rs.getString("sexo"));
         p.setIdioma(rs.getString("idioma"));
        return p;                  
     } catch (SQLException ex){
         System.out.println("Erro ao consultar pessoa: "+ ex.getMessage());
         return null;
     }
 } 
 
 public void editar(Pessoa pessoa){
     try{
            String sql = "UPDATE pessoa set nome=?, sexo=?, idioma=? WHERE id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3, pessoa.getIdioma());
            stmt.setInt(4, pessoa.getId());
            stmt.execute();
        } catch (SQLException ex){
                System.out.println("Erro ao atualizar pessoa: "+ex.getMessage());
        }
         
 }
 
 public void excluir(int id){
     try{
         String sql = "delete from pessoa WHERE id=?";
         
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.setInt(1,id);
         stmt.execute();
     } catch(SQLException ex){
         System.out.println("Erro ao atualizar pessoa: "+ex.getMessage());
     }
 }
 
 public List<Pessoa> getPessoas(){
     String sql = "SELECT * FROM pessoa";
     try{
         PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         
         ResultSet rs = stmt.executeQuery();
         List<Pessoa> listaPessoas = new ArrayList();
         
         while(rs.next()){
             Pessoa p = new Pessoa();
             p.setId(rs.getInt("id"));
             p.setNome(rs.getString("nome"));
             p.setSexo(rs.getString("sexo"));
             p.setIdioma(rs.getString("idioma"));
             listaPessoas.add(p);
         }         
         return listaPessoas;                  
     } catch (SQLException ex){
         System.out.println("Erro ao consultar todas as pessoas: "+ ex.getMessage());
         return null;
     }
}

 public List<Pessoa> getPessoasNome(String nome){
     String sql = "SELECT * FROM pessoa WHERE nome LIKE ?";
     try{
         PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         
         stmt.setString(1,"%" + nome + "%");
         ResultSet rs = stmt.executeQuery();
         List<Pessoa> listaPessoas = new ArrayList();
         
         while(rs.next()){
             Pessoa p = new Pessoa();
             p.setId(rs.getInt("id"));
             p.setNome(rs.getString("nome"));
             p.setSexo(rs.getString("sexo"));
             p.setIdioma(rs.getString("idioma"));
             listaPessoas.add(p);
         }         
         return listaPessoas;                  
     } catch (SQLException ex){
         System.out.println("Erro ao consultar todas as pessoas: "+ ex.getMessage());
         return null;
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
