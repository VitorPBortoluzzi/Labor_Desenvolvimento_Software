
package DAO;

import beans.Pessoa;
import beans.Veiculos;
import conexao.Conexao;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;


public class VeiculosDAO {
    private Conexao conexao;
    private Connection conn;
    
    public VeiculosDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Veiculos veiculo){
        String sql = "INSERT INTO veiculo(modelo,placa,id_pessoa) value (?,?,?);";
        try (PreparedStatement stmt = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setInt(3, veiculo.getPessoaid().getId());
            
            stmt.execute();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    veiculo.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
         System.out.println("Erro ao inserir veiculo:"+e.getMessage());
     }
    }
    
    public void editar(Veiculos veiculo){
        try{
            String sql = "UPDATE veiculo set modelo=?, placa=?, id_pessoa=? WHERE id=?;";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setInt(3, veiculo.getPessoaid().getId());
            stmt.setInt(4, veiculo.getId());
            stmt.execute();
        } catch (SQLException ex){
            System.out.println("Erro ao atualizar Veiculo: "+ex.getMessage());
        }
    }
        
    public void excluir(int id){
        try{
            String sql = "DELETE from veiculo where id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch(SQLException ex){
            System.out.println("Erro ao excluir pessoa: "+ex.getMessage());
        }
    }
    
    public List<Veiculos> getVeiculos(){
        String sql = "SELECT * FROM veiculo";
        try{
         PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         
         ResultSet rs = stmt.executeQuery();
         List<Veiculos> listaVeiculos = new ArrayList();
         
         while(rs.next()){
             Veiculos v = new Veiculos();
             v.setId(rs.getInt("id"));
             v.setModelo(rs.getString("modelo"));
             v.setPlaca(rs.getString("placa"));
             PessoaDAO pdao = new PessoaDAO();
             
             Pessoa p = pdao.getPessoa(rs.getInt("id_pessoa"));
             v.setPessoaid(p);
             listaVeiculos.add(v);
         }         
         return listaVeiculos;                  
     } catch (SQLException ex){
         System.out.println("Erro ao consultar todas os veiculos: "+ ex.getMessage());
         return null;
     }
    }
    
    public Veiculos getVeiculo(int id){
        String sql = "SELECT * FROM veiculo where id = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Veiculos v = new Veiculos();
            
            rs.first();
            
            v.setId(rs.getInt("id"));
            v.setModelo(rs.getString("modelo"));
            v.setPlaca(rs.getString("placa"));
            
            PessoaDAO pdao = new PessoaDAO();
            Pessoa p = pdao.getPessoa(rs.getInt("id_pessoa"));
            v.setPessoaid(p);
            return v;
        } catch(SQLException ex){
            System.out.println("Erro ao consultar Pessoa: "+ex.getMessage());
            return null;
        }
    }
    
//    public Veiculos getVeiculo(int id){
//        String sql = "SELECT * from veiculo WHERE id = ?";
//        Veiculos v = null;
//        try{
//            PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            stmt.setInt(1, id);
//            ResultSet rs=stmt.executeQuery();
//            v = new Veiculos();
//            rs.first();
//            v.setId(rs.getInt("id"));
//            v.setModelo(rs.getString("modelo"));
//            v.setPlaca(rs.getString("placa"));
//            v.setPessoaid(rs.getInt(""));
//        }
//    }
}
