
package dao;

import beans.Login;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    
    public static Login validarLogin(Login login){
        String sql = "SELECT * FROM login WHERE email = ? AND senha = ?";
        
        Login loginEncontrado = null;
        
        try{
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/melepropolis", "root", "123");
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, login.getEmail());
            stmt.setString(2, login.getSenha());
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                loginEncontrado = new Login();
                loginEncontrado.setEmail(rs.getString("email"));
                loginEncontrado.setSenha(rs.getString("senha"));
                loginEncontrado.setTipo(rs.getString("tipo"));
            }
        }catch(SQLException ex){
            System.out.println("Erro ao validar usuário: " + ex.getMessage());
        }
        return loginEncontrado;
    }
}
