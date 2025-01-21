
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    
    public Connection getConexao(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/melepropolis","root","123");
            return conn;
            
        }catch(Exception e){
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
}
