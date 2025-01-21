
package dao;

import beans.Estoque;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {
    
    private Conexao conexao;
    private Connection conn;
    
    public EstoqueDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void cadastrarEstoque(Estoque estoque){
        String sql = "INSERT INTO estoque (produto, quantidade) VALUES (?, ?)";      
        
        try{
            conn.setAutoCommit(false);
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, estoque.getProduto());
            stmt.setString(2, estoque.getQuantidade());
            stmt.executeUpdate();
            
            conn.commit();
            System.out.println("Produto adicionado ao estoque com sucesso!");
            
        }catch(SQLException e){
            try{
                conn.rollback();
                System.out.println("Erro ao cadastrar produto. Cadastro desfeito");
                
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
    
    public void editarEstoque(Estoque estoque){
        String sql = "UPDATE estoque SET produto = ?, quantidade = ? WHERE id = ?";
        
        try{
            conn.setAutoCommit(false);
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, estoque.getProduto());
            stmt.setString(2, estoque.getQuantidade());
            stmt.setInt(3, estoque.getId());
            stmt.executeUpdate();
            stmt.close();
            
            conn.commit();
            conn.setAutoCommit(true);
            
            System.out.println("Estoque atualizado com sucesso");
            
        }catch(Exception e){
            try{
                conn.rollback();
            }catch(Exception rollbackEx){
                System.out.println("Erro ao realizar rollback: " + rollbackEx.getMessage());
            }
            System.out.println("Erro ao editar produtos: " + e.getMessage());
        }
    }
    
    public void excluirEstoque(int id){
        String sql = "DELETE FROM estoque WHERE id = ?";
        
        try{
            conn.setAutoCommit(false);
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            
            conn.commit();
            conn.setAutoCommit(true);
            
            System.out.println("Produto excluído com sucesso!");
            
        }catch(Exception e){
            System.out.println("Erro ao excluir Produto: " + e.getMessage());
        }
    }
    
    public List<Estoque> getEstoques(){
        List<Estoque> estoques = new ArrayList<>();
        String sql = "SELECT * FROM estoque";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Estoque e = new Estoque();
                e.setId(rs.getInt("id"));
                e.setProduto(rs.getString("produto"));
                e.setQuantidade(rs.getString("quantidade"));
                
                estoques.add(e);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return estoques;
    }
}
