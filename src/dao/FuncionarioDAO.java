
package dao;

import beans.Endereco;
import beans.Funcionario;
import beans.Telefone;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    
    private Conexao conexao;
    private Connection conn;
    
    public FuncionarioDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void cadastrarFuncionario(Funcionario funcionario){
        String sqlUsuario = "INSERT INTO usuario (nome, cargo, cpf, data_nascimento) VALUES (?, ?, ?, ?)";
        String sqlEndereco = "INSERT INTO endereco (estado, cidade, rua, numero, id_usuario) VALUES (?, ?, ?, ?, ?)";
        String sqlTelefone = "INSERT INTO telefone (telefone, id_usuario) VALUES (?, ?)";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        
        try{
            conn.setAutoCommit(false);
            
            PreparedStatement stmtUsuario = conn.prepareStatement(sqlUsuario, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtUsuario.setString(1, funcionario.getNome());
            stmtUsuario.setString(2, funcionario.getCargo());
            stmtUsuario.setString(3, funcionario.getCpf());
            stmtUsuario.setString(4, sdf.format(funcionario.getNascimento()));
            stmtUsuario.executeUpdate();
            
            ResultSet rs = stmtUsuario.getGeneratedKeys();
            int idUsuario = 0;
            if(rs.next()){
                idUsuario = rs.getInt(1);
            }
            
            PreparedStatement stmtEndereco = conn.prepareStatement(sqlEndereco);
            stmtEndereco.setString(1, funcionario.getEndereco().getEstado());
            stmtEndereco.setString(2, funcionario.getEndereco().getCidade());
            stmtEndereco.setString(3, funcionario.getEndereco().getRua());
            stmtEndereco.setString(4, funcionario.getEndereco().getNumero());
            stmtEndereco.setInt(5, idUsuario);
            stmtEndereco.executeUpdate();
            
            PreparedStatement stmtTelefone = conn.prepareStatement(sqlTelefone);
            stmtTelefone.setString(1, funcionario.getTelefone().getTelefone());
            stmtTelefone.setInt(2, idUsuario);
            stmtTelefone.executeUpdate();
            
            conn.commit();
            System.out.println("Funcionário cadastrado com sucesso!");
            
        }catch(SQLException e){
            try{
                conn.rollback();
                System.out.println("Erro ao cadastrar funcionário. Cadastro desfeito");
                
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
    
    public List<Funcionario> getFuncionarios(){
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT u.id, u.nome, u.cargo, u.cpf, u.data_nascimento, \n" +
                     "e.rua, e.numero, e.cidade, e.estado, \n" +
                     "t.telefone\n" +
                     "FROM usuario u\n" +
                     "LEFT JOIN endereco e ON u.id = e.id_usuario\n" +
                     "LEFT JOIN telefone t ON u.id = t.id_usuario";
        
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCargo(rs.getString("cargo"));
                f.setCpf(rs.getString("cpf"));
                f.setNascimento(rs.getDate("data_nascimento"));
                
                Endereco endereco = new Endereco();
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                f.setEndereco(endereco);
                
                Telefone telefone = new Telefone();
                telefone.setTelefone(rs.getString("telefone"));
                f.setTelefone(telefone);
                
                funcionarios.add(f);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return funcionarios;
    }
    
    public void editar(Funcionario funcionario){
        String sqlUsuario = "UPDATE usuario SET nome = ?, cargo = ?, cpf = ?, data_nascimento = ? WHERE id = ?";
        String sqlEndereco = "UPDATE endereco SET estado = ?, cidade = ?, rua = ?, numero = ? WHERE id_usuario = ?";
        String sqlTelefone = "UPDATE telefone SET telefone = ? WHERE id_usuario = ?";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        
        try{
            conn.setAutoCommit(false);
            
            PreparedStatement stmtUsuario = conn.prepareStatement(sqlUsuario);
            stmtUsuario.setString(1, funcionario.getNome());
            stmtUsuario.setString(2, funcionario.getCargo());
            stmtUsuario.setString(3, funcionario.getCpf());
            stmtUsuario.setString(4, sdf.format(funcionario.getNascimento()));
            stmtUsuario.setInt(5, funcionario.getId());
            stmtUsuario.executeUpdate();
            stmtUsuario.close();
            
            
            PreparedStatement stmtEndereco = conn.prepareStatement(sqlEndereco);
            stmtEndereco.setString(1, funcionario.getEndereco().getEstado());
            stmtEndereco.setString(2, funcionario.getEndereco().getCidade());
            stmtEndereco.setString(3, funcionario.getEndereco().getRua());
            stmtEndereco.setString(4, funcionario.getEndereco().getNumero());
            stmtEndereco.setInt(5, funcionario.getId());
            stmtEndereco.executeUpdate();
            stmtEndereco.close();
            
            PreparedStatement stmtTelefone = conn.prepareStatement(sqlTelefone);
            stmtTelefone.setString(1, funcionario.getTelefone().getTelefone());
            stmtTelefone.setInt(2, funcionario.getId());
            stmtTelefone.executeUpdate();
            stmtTelefone.close();
            
            conn.commit();
            conn.setAutoCommit(true);
            
            System.out.println("Funcionário atualizado com sucesso!");
            
        }catch(Exception e){
            try{
                conn.rollback();
            }catch(Exception rollbackEx){
                System.out.println("Erro ao realizar rollback: " + rollbackEx.getMessage());
            }
            System.out.println("Erro ao editar funcionários: " + e.getMessage());
        }
    }
    
    public void excluir(int id){
        String sqlUsuario = "DELETE FROM endereco WHERE id_usuario = ?";
        String sqlEndereco = "DELETE FROM telefone WHERE id_usuario = ?";
        String sqlTelefone = "DELETE FROM usuario WHERE id = ?";
        
        try{
            conn.setAutoCommit(false);
            
            PreparedStatement stmtEndereco = conn.prepareStatement(sqlEndereco);
            stmtEndereco.setInt(1, id);
            stmtEndereco.executeUpdate();
            stmtEndereco.close();
            
            PreparedStatement stmtTelefone = conn.prepareStatement(sqlTelefone);
            stmtTelefone.setInt(1, id);
            stmtTelefone.executeUpdate();
            stmtTelefone.close();
            
            PreparedStatement stmtUsuario = conn.prepareStatement(sqlUsuario);
            stmtUsuario.setInt(1, id);
            stmtUsuario.executeUpdate();
            stmtUsuario.close();
            
            conn.commit();
            conn.setAutoCommit(true);
                       
            System.out.println("Usuário excluído com sucesso");
            
        }catch(Exception e){
            System.out.println("Erro ao excluir funcionário: " + e.getMessage());
        }
    }
    

}
