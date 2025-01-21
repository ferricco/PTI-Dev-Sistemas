
package dao;

import beans.Expedicao;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ExpedicaoDAO {
    
    private Conexao conexao;
    private Connection conn;
    
    public ExpedicaoDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void cadastrarExpedicao(Expedicao expedicao){
          String sql = "INSERT INTO expedicao (modo_envio, data_envio, status, id_lote) VALUES (?, ?, ?, ?)";
          
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
          
          try{
              conn.setAutoCommit(false);
              
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, expedicao.getModoEnvio());
            stmt.setString(2, sdf.format(expedicao.getDataEnvio()));
            stmt.setString(3, expedicao.getStatus());
            stmt.setInt(4, expedicao.getIdLote());
            stmt.executeUpdate();
            
            conn.commit();
              System.out.println("Expedição cadastrada com sucesso");
              
          }catch(SQLException e){
            try{
                conn.rollback();
                System.out.println("Erro ao cadastrar Expedição. Cadastro desfeito");
                
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            e.printStackTrace();
            
            }finally{
                try{
                    conn.setAutoCommit(true);
                
                }catch(SQLException e){
                    e.printStackTrace();
                }
        }
    }
    
    public void editarExpedicao(Expedicao expedicao){
        String sql = "UPDATE expedicao SET modo_envio = ?, data_envio = ?, status = ?, id_lote = ? WHERE id = ?";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        
        try{
            conn.setAutoCommit(false);
        
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, expedicao.getModoEnvio());
            stmt.setString(2, sdf.format(expedicao.getDataEnvio()));
            stmt.setString(3, expedicao.getStatus());
            stmt.setInt(4, expedicao.getIdLote());
            stmt.setInt(5, expedicao.getId());
            stmt.executeUpdate();
            stmt.close();
        
            conn.commit();
            conn.setAutoCommit(true);
            
            System.out.println("Expedição atualizada com sucesso");
        
        }catch(Exception e){
            try{
                conn.rollback();
            }catch(Exception rollbackEx){
                System.out.println("Erro ao realizar rollback: " + rollbackEx.getMessage());
            }
            System.out.println("Erro ao editar Lote: " + e.getMessage());
        }
    }
    
    public void excluirExpedicao(int id){
        String sql = "DELETE FROM expedicao WHERE id = ?";
        
        try{
            conn.setAutoCommit(false);
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            
            conn.commit();
            conn.setAutoCommit(true);
            
            System.out.println("Expedição excluído com sucesso");
            
        }catch(Exception e){
            System.out.println("Erro ao excluir Expedição: " + e.getMessage());
        }
    }
    
    public List<Expedicao> getExpedicoes(){
        List<Expedicao> expedicoes = new ArrayList<>();
        String sql = "SELECT * FROM expedicao";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Expedicao ex = new Expedicao();
                ex.setId(rs.getInt("id"));
                ex.setModoEnvio(rs.getString("modo_envio"));
                ex.setDataEnvio(rs.getDate("data_envio"));
                ex.setStatus(rs.getString("status"));
                ex.setIdLote(rs.getInt("id_lote"));
                
                expedicoes.add(ex);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return expedicoes;
    }
}
