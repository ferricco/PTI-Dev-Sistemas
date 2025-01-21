
package dao;

import beans.Lote;
import beans.Producao;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class LoteDAO {
    private Conexao  conexao;
    private Connection conn;
    
    public LoteDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void cadastrarLote(Lote lote){
        String sql = "INSERT INTO lote (prioridade, fragilidade, data_do_lote, status, id_processo) VALUES (?, ?, ?, ?, ?)";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        
        try{
            conn.setAutoCommit(false);
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, lote.getPrioridade());
            stmt.setString(2, lote.getFragilidade());
            stmt.setString(3, sdf.format(lote.getDataLote()));
            stmt.setString(4, lote.getStatus());
            stmt.setInt(5, lote.getIdProcesso());
            stmt.executeUpdate();
            
            conn.commit();
            System.out.println("Lote cadastrado com sucesso!");
            
        }catch(SQLException e){
            try{
                conn.rollback();
                System.out.println("Erro ao cadastrar Lote. Cadastro desfeito");
                
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
    
    public void editarLote(Lote lote){
        String sql = "UPDATE lote SET prioridade = ?, fragilidade = ?, data_do_lote = ?, status = ?, id_processo = ? WHERE id = ?";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        
        try{
            conn.setAutoCommit(false);
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, lote.getPrioridade());
            stmt.setString(2, lote.getFragilidade());
            stmt.setString(3, sdf.format(lote.getDataLote()));
            stmt.setString(4, lote.getStatus());
            stmt.setInt(5, lote.getIdProcesso());
            stmt.setInt(6, lote.getId());
            stmt.executeUpdate();
            stmt.close();
            
            conn.commit();
            conn.setAutoCommit(true);
            
            System.out.println("Lote atualizado com sucesso!");
            
        }catch(Exception e){
            try{
                conn.rollback();
            }catch(Exception rollbackEx){
                System.out.println("Erro ao realizar rollback: " + rollbackEx.getMessage());
            }
            System.out.println("Erro ao editar Lote: " + e.getMessage());
        }
    }
    
    public void excluir(int id){
        String sql = "DELETE FROM lote WHERE id = ?";
        
        try{
            conn.setAutoCommit(false);
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            
            conn.commit();
            conn.setAutoCommit(true);
            
            System.out.println("Lote excluído com sucesso");
            
        }catch(Exception e){
            System.out.println("Erro ao excluir Lote: " + e.getMessage());
        }
    }
    
    public List<Lote> getLotes(){
        List<Lote> lotes = new ArrayList<>();
        String sql = "SELECT l.id, l.prioridade, l.fragilidade, l.data_do_lote, l.status,\n" +
                    "	p.nome_processo\n" +
                    "FROM lote l\n" +
                    "LEFT JOIN processo_de_producao p ON l.id_processo = p.id";
        
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Lote l = new Lote();
                l.setId(rs.getInt("id"));
                l.setPrioridade(rs.getString("prioridade"));
                l.setFragilidade(rs.getString("fragilidade"));
                l.setDataLote(rs.getDate("data_do_lote"));
                l.setStatus(rs.getString("status"));
                
                Producao p = new Producao();
                p.setNomeProcesso(rs.getString("nome_processo"));
                l.setProducao(p);
                
                lotes.add(l);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return lotes;
    }
}
