/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;



/**
 *
 * @author lucas
 */

public class ClienteDAO {
    
    private final Connection connection;
    private ResultSet resultSet;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }
    
      public void insert(Cliente cliente) throws SQLException{
          
       
            String nome= cliente.getNome();  
            String telefone = cliente.getTelefone();
            String rg = cliente.getRg();
            double mensalidade = cliente.getMensalidade();
            String vencimento = cliente.getVencimento();
            String observacao = cliente.getObservacao();
          
           
            
            String sql = "INSERT INTO cliente(nome,telefone,rg,mensalidade,vencimento,observacao) VALUES(?,?,?,?,?,?);";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            
             //tecnica para evitar  ataques de Sql Inject   exemplo:('or 1+1--)
        
        statement.setString(1, nome);  
        statement.setString(2, telefone);
        statement.setString(3, rg);
        statement.setDouble(4, mensalidade);
        statement.setString(5, vencimento);
        statement.setString(6, observacao);
        
            statement.execute();
      }
            
        public void update(Cliente cliente) throws SQLException{
       
      
            int codigo= cliente.getCodigo();     
            String nome= cliente.getNome();  
            String telefone = cliente.getTelefone();
            String rg = cliente.getRg();
            double mensalidade = cliente.getMensalidade();
            String vencimento = cliente.getVencimento();
            boolean bloqueado = cliente.getBloqueado();
            String observacao = cliente.getObservacao();
           
       String sql = "UPDATE cliente SET codigo= ? , nome= ?, telefone = ? , rg = ? , mensalidade = ? , vencimento = ? , bloqueado = ?, observacao = ? WHERE codigo = ? ";
       
        PreparedStatement statement = connection.prepareStatement(sql);
        
        
       //tecnica para evitar  ataques de Sql Inject     exemplo:('or 1=1--)
        
       statement.setInt(1, codigo);   
        statement.setString(2, nome);  
        statement.setString(3, telefone);
        statement.setString(4, rg);
        statement.setDouble(5, mensalidade);
        statement.setString(6, vencimento);
        statement.setBoolean(7, bloqueado);
        statement.setString(8, observacao);
        statement.setInt(9, codigo);
        
       statement.execute();
          
          
          
      }
 
    
    public void delete(Cliente cliente) throws SQLException{
        
      
       String rg= cliente.getRg();
       String sql = "DELETE FROM cliente  WHERE rg = ? ";
       
        PreparedStatement statement = connection.prepareStatement(sql);
        
       //tecnica para evitar  ataques de Sql Inject     exemplo:('or 1=1--)
        
       statement.setString(1, rg); //Este metodo troca interrogação da string "sql" pelo inteiro da variavel "rg"
       
       statement.execute();
             
                
    }
    
  
    
   
    
     public Cliente selectPorCod(int codigo) throws SQLException{
      
         String sql = "SELECT * FROM cliente  WHERE codigo = ? LIMIT 1;";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, codigo); 
        
         statement.execute();
      ResultSet resultSet = statement.getResultSet();
        if (resultSet.next()){
              
            codigo= resultSet.getInt("codigo");     
            String nome= resultSet.getString("nome");     
            String telefone = resultSet.getString("telefone");     
            String rg = resultSet.getString("rg");     
            double mensalidade = resultSet.getDouble("mensalidade");     
            String vencimento = resultSet.getString("vencimento"); 
            boolean bloqueado = resultSet.getBoolean("bloqueado");        //0 = bloqueado este mensalista esta bloqueado por falta de pagamento / 1 = liberdo, o pagamento desse mensalista esta em dia
            String observacao = resultSet.getString("observacao");  
         
           return new Cliente(codigo, nome, telefone, rg, mensalidade, vencimento, bloqueado);
            
         }else{
            
            return null;
            
        }
        
    }

    public ArrayList<Cliente> selectAll() throws SQLException {
        String sql = "SELECT * FROM cliente ";
        
        
        PreparedStatement statement = connection.prepareStatement(sql);
       
        
        statement.execute();
        
        resultSet = statement.getResultSet(); //retorna um resultado do banco de dados na variavel do ripo ResultSet
                 ArrayList<Cliente> clientes = new ArrayList<>();
                 
              
                 
            while(resultSet.next()){
                
              String nome= resultSet.getString("nome");  
              int codigo= resultSet.getInt("codigo");  
              boolean bloqueado= resultSet.getBoolean("bloqueado");
              String telefone= resultSet.getString("telefone");
              String rg= resultSet.getString("rg");
              String observacao= resultSet.getString("observacao");
              double mensalidade = resultSet.getDouble("mensalidade");
              String vencimento = resultSet.getString("vencimento");
              
              clientes.add(new Cliente(codigo, nome, telefone, rg, mensalidade, vencimento, bloqueado, observacao));

      
            }
              
                return clientes;
            
    }
    public Cliente selectPorNome(String nomeCliente) throws SQLException {
        
        
        String sql = "SELECT * FROM cliente WHERE nome= ? ";
        
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        //tecnica para evitar  ataques de Sql Inject     exemplo:('or 1+1--)
        statement.setString(1, nomeCliente);   //Este metodo troca a primeira interrogação da string "sql" pela string da variavel "nome"
        
        
        
        statement.execute();
        
        resultSet = statement.getResultSet(); //retorna um resultado do banco de dados na variavel do ripo ResultSet
             
            if(resultSet.next()){
              
                
          
              int codigo= resultSet.getInt("codigo");  
              boolean bloqueado= resultSet.getBoolean("bloqueado");
              String telefone= resultSet.getString("telefone");
              String rg= resultSet.getString("rg");
              String observacao= resultSet.getString("observacao");
              double mensalidade = resultSet.getDouble("mensalidade");
              String vencimento = resultSet.getString("vencimento");
              
              return new Cliente(codigo,nomeCliente,telefone,rg,mensalidade,vencimento,bloqueado,observacao);
                

            }
            else{
                
                
                return null;
                
            }
        
        
        
        
    }

    public void deletePorNome(String nomeCliente) throws SQLException {
        String sql = "DELETE FROM cliente WHERE nome= ? ";
        
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        //tecnica para evitar  ataques de Sql Inject     exemplo:('or 1+1--)
        statement.setString(1, nomeCliente);   //Este metodo troca a primeira interrogação da string "sql" pela string da variavel "nome"
        
        
        
        statement.execute();
    }
           
                
                
          
                
            }


    
    

