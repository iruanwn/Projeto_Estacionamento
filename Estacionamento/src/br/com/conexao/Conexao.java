
package br.com.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
   public Connection getconexao(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ Estacionamento","root","8numeros");
            return conn;
        }
        catch(SQLException e){
            System.out.println("Erro"+ e.getMessage());
            return null;
            
        }
    }   
}
