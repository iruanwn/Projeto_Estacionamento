
package br.com.conexao;

import estacionamento.Carro;
import estacionamento.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EstacionamentoDAO {
     private Conexao conexao;
    private Connection conn;
    
    public EstacionamentoDAO (){
        this.conexao = new Conexao();
        this.conn = conexao.getconexao();
    }
    
    public void inserir(Cliente c){
        String sql = "INSERT INTO  Cliente (nome,cpf,id_V) VALUES(?,?,?)";
        try {
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,c.getNome());
            stmt.setString(2,c.getCpf());
            stmt.setString(3,c.carro.getPlaca());
        stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro"+ e.getMessage()); 
        }
        }
    
     public void inserirVeiculo(Cliente cliente){
        String sql = "INSERT INTO Veiculo(modelo,placa) VALUES(?,?)";
        try {
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,cliente.carro.getModelo());
            stmt.setString(2,cliente.carro.getPlaca());
       
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro"+ e.getMessage()); 
        }
        }
 
    public void excluir(String cpf){
        String sql = "DELETE FROM Cliente WHERE cpf = ? ";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,cpf);
            stmt.execute();
        }
        catch(SQLException e){
            System.out.println("Erro"+ e.getMessage());
            
        }
    }
    
     public void excluirV(String placa){
        String sql = "DELETE FROM Veiculo WHERE placa = ? ";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,placa);
            stmt.execute();
        }
        catch(SQLException e){
            System.out.println("Erro"+ e.getMessage());
}
     }
     
      public List<Cliente> getClienet(String cpf){
        
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM  Cliente WHERE cpf LIKE ?");
            stmt.setString(1,"%" + cpf + "%");
            ResultSet rs = stmt.executeQuery();
            
            List<Cliente> listaCliente = new ArrayList<>();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                
                cliente.setNome(rs.getString("nome"));
                cliente.setIdade(rs.getInt("idade"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.carro.setPlaca(rs.getString("id_V"));
   
                listaCliente.add(cliente);
                System.out.println(cliente.getNome());
                System.out.println(cliente.getIdade());
                System.out.println(cliente.getCpf());
                System.out.println(cliente.carro.getPlaca());
                
                listaCliente.add(cliente);
            }

            return listaCliente;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

}
}
