
package dao;

import beans.Equipe;
import beans.Membro;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MembroDAO {
    private Conexao conexao;
    private Connection conn;
    
    public MembroDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void cadastrarMembro(Membro membro){
        String sql = "INSERT INTO membros_equipe (nome_membro, id_equipe) VALUES (?, ?)";
        
        try{
            conn.setAutoCommit(false);
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, membro.getNomeMembro());
            stmt.setInt(2, membro.getIdEquipe());
            stmt.executeUpdate();
            
            conn.commit();
            System.out.println("Membro cadastrado com sucesso!");
            
            }catch(SQLException e){
                try{
                    conn.rollback();
                    System.out.println("Erro ao cadastrar Membro. Cadastro desfeito");
                
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
    
    public void editarMembro(Membro membro){
        String sql = "UPDATE membros_equipe SET nome_membro = ?, id_equipe = ? WHERE id = ?";
        
        try{
            conn.setAutoCommit(false);
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, membro.getNomeMembro());
            stmt.setInt(2, membro.getIdEquipe());
            stmt.setInt(3, membro.getIdMembro());
            stmt.executeUpdate();
            stmt.close();
            
            conn.commit();
            conn.setAutoCommit(true);
            
            System.out.println("Membro atualizado com sucesso!");
            
            }catch(Exception e){
                try{
                    conn.rollback();
                }catch(Exception rollbackEx){
                    System.out.println("Erro ao realizar rollback: " + rollbackEx.getMessage());
            }
            System.out.println("Erro ao editar Membro: " + e.getMessage());
        }
            
    }
    
    public void excluir(int id){
        String sql = "DELETE FROM membros_equipe WHERE id = ?";
        
        try{
            conn.setAutoCommit(false);
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            
            conn.commit();
            conn.setAutoCommit(true);
            
            System.out.println("Membro de Equipe excluido com sucesso!");
            
        }catch(Exception e){
            System.out.println("Erro ao excluir Membro de Equipe: " + e.getMessage());
        }
    }
    
    public List<Membro> getMembros(){
        List<Membro> membros = new ArrayList<>();
        String sql = "SELECT m.id, m.nome_membro,\n" +
                    "	e.nome_da_equipe\n" +
                    "FROM membros_equipe m\n" +
                    "LEFT JOIN equipe e ON m.id_equipe = e.id";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Membro m = new Membro();
                m.setIdMembro(rs.getInt("id"));
                m.setNomeMembro(rs.getString("nome_membro"));
                
                Equipe e = new Equipe();
                e.setNomeEquipe(rs.getString("nome_da_equipe"));
                m.setEquipe(e);
                
                membros.add(m);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return membros;
    }
}
