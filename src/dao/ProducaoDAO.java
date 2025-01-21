
package dao;

import beans.Equipe;
import beans.Producao;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProducaoDAO {
    private Conexao  conexao;
    private Connection conn;
    
    public ProducaoDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void cadastrarProducao(Producao producao){
        String sql = "INSERT INTO processo_de_producao (nome_processo, data_inicio, data_termino, status, id_equipe) VALUES (?, ?, ?, ?, ?)";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        
        try{
            conn.setAutoCommit(false);
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, producao.getNomeProcesso());
            stmt.setString(2, sdf.format(producao.getDataInicio()));
            stmt.setString(3, sdf.format(producao.getDataFim()));
            stmt.setString(4, producao.getStatus());
            stmt.setInt(5, producao.getIdEquipe());
            stmt.executeUpdate();
            stmt.close();
            
            conn.commit();
            System.out.println("Processo de Produção cadastrada com sucesso!");
            
        }catch(SQLException e){
            try{
                conn.rollback();
                System.out.println("Erro ao cadastrar Processo de Produção. Cadastro desfeito");
                
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
    
    public void editarProducao(Producao producao){
        String sql = "UPDATE processo_de_producao SET nome_processo = ?, data_inicio = ?, data_termino = ?, status = ?, id_equipe = ? WHERE id = ?";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        
        try{
            conn.setAutoCommit(false);
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, producao.getNomeProcesso());
            stmt.setString(2, sdf.format(producao.getDataInicio()));
            stmt.setString(3, sdf.format(producao.getDataFim()));
            stmt.setString(4, producao.getStatus());
            stmt.setInt(5, producao.getIdEquipe());
            stmt.setInt(6, producao.getId());
            stmt.executeUpdate();
            stmt.close();
            
            conn.commit();
            conn.setAutoCommit(true);
            
            System.out.println("Processo de Produção atualizado com sucesso!");
            
        }catch(Exception e){
            try{
                conn.rollback();
            }catch(Exception rollbackEx){
                System.out.println("Erro ao realizar rollback: " + rollbackEx.getMessage());
            }
            System.out.println("Erro ao editar Processo de Produção: " + e.getMessage());
        }
    }
    
    public void excluir(int id){
        String sql = "DELETE FROM processo_de_producao WHERE id = ?";
        
        try{
            conn.setAutoCommit(false);
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            
            conn.commit();
            conn.setAutoCommit(true);
            
            System.out.println("Processo de Produção excluído com sucesso");
            
        }catch(Exception e){
            System.out.println("Erro ao excluir Processo de Produção: " + e.getMessage());
        }
    }
    
    public List<Producao> getProducoes(){
        List<Producao> producoes = new ArrayList<>();
        String sql = "SELECT p.id, p.nome_processo, p.data_inicio, p.data_termino, p.status, p.id_estoque,\n" +
                    "	e.nome_da_equipe\n" +
                    "FROM processo_de_producao p\n" +
                    "LEFT JOIN equipe e ON p.id_equipe = e.id";
        
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Producao p = new Producao();
                p.setId(rs.getInt("id"));
                p.setNomeProcesso(rs.getString("nome_processo"));
                p.setDataInicio(rs.getDate("data_inicio"));
                p.setDataFim(rs.getDate("data_termino"));
                p.setStatus(rs.getString("status"));
                p.setIdEstoque(rs.getInt("id_estoque"));
                
                Equipe eq = new Equipe();
                eq.setNomeEquipe(rs.getString("nome_da_equipe"));
                p.setEquipe(eq);
                
                producoes.add(p);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return producoes;
    }
}