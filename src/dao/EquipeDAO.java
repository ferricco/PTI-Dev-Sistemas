
package dao;

import beans.Equipe;
import beans.Funcionario;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EquipeDAO {
    
    private Conexao conexao;
    private Connection conn;
    
    public EquipeDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
        
        public void cadastrarEquipe(Equipe equipe){
            String sql = "INSERT INTO equipe (id, nome_da_equipe, id_lider_producao) VALUES (?, ?, ?)";
            
            try{
                conn.setAutoCommit(false);
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, equipe.getIdEquipe());
                stmt.setString(2, equipe.getNomeEquipe());
                stmt.setInt(3, equipe.getIdLider());
                stmt.executeUpdate();
                
                conn.commit();
                System.out.println("Equipe cadastrada com sucesso!");
            
            }catch(SQLException e){
                try{
                    conn.rollback();
                    System.out.println("Erro ao cadastrar Equipe. Cadastro desfeito");
                
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
        
        public void editarEquipe(Equipe equipe){
            String sql = "UPDATE equipe SET nome_da_equipe = ?, id_lider_producao = ? WHERE id = ?";
            
            try{
                conn.setAutoCommit(false);
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, equipe.getNomeEquipe());
                stmt.setInt(2, equipe.getIdLider());
                stmt.setInt(3, equipe.getIdEquipe());
                stmt.executeUpdate();
                stmt.close();
                
                conn.commit();
                conn.setAutoCommit(true);
            
                System.out.println("Equipe atualizada com sucesso");
            
            }catch(Exception e){
                try{
                    conn.rollback();
                }catch(Exception rollbackEx){
                    System.out.println("Erro ao realizar rollback: " + rollbackEx.getMessage());
            }
            System.out.println("Erro ao editar equipes: " + e.getMessage());
        }
            
        }
        
        public void excluir(int id){
            String sql = "DELETE FROM equipe WHERE id = ?";
            
            try{
                conn.setAutoCommit(false);
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.executeUpdate();
                stmt.close();
                
                conn.commit();
                conn.setAutoCommit(true);
                
                System.out.println("Equipe excluída com sucesso");
                
            }catch(Exception e){
                System.out.println("Erro ao excluir Equipe: " + e.getMessage());
            }
        }
        
        public List<Equipe> getEquipes(){
            List<Equipe> equipes = new ArrayList<>();
            String sql = "SELECT e.id, e.nome_da_equipe,\n" +
                        "	m.nome\n" +
                        "FROM equipe e\n" +
                        "LEFT JOIN usuario m ON e.id_lider_producao = m.id;";
            
            try{
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()){
                    Equipe e = new Equipe();
                    e.setIdEquipe(rs.getInt("id"));
                    e.setNomeEquipe(rs.getString("nome_da_equipe"));
                    
                    Funcionario f = new Funcionario();
                    f.setNome(rs.getString("nome"));
                    e.setFuncionario(f);
                    
                    equipes.add(e);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return equipes;
        }
        
    
}
