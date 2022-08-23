/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import model.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


/**
 *
 * @author lucas
 */
public class UsuarioDAO {

  private final Connection connection;
    private ResultSet resultSet;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

   
    
    public void insert(Usuario usuario) throws SQLException{
            String nomeUsuario= usuario.getNome();
            String senha= usuario.getSenha();
            String rg = usuario.getRg();
            String cargo = usuario.getCargo();
            String sql = "INSERT INTO usuario(nome,senha,rg,cargo) VALUES(?,?,?,?);";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            
             //tecnica para evitar  ataques de Sql Inject   exemplo:('or 1+1--)
        statement.setString(1, nomeUsuario);   //Este metodo troca a primeira interrogação da string "sql" pela string da variavel "nome"
        statement.setString(2, senha);  //Este metodo troca a segunda interrogação da string "sql" pela string da variavel "senha"
        statement.setString(3, rg);
        statement.setString(4, cargo);
            statement.execute();
                      
       
        
        
    }
    
    public void update(Usuario usuario) throws SQLException{
       
      int id = usuario.getId();
       String nomeUsuario = usuario.getNome();
       String senha= usuario.getSenha();
       String rg= usuario.getRg();
       String cargo= usuario.getCargo();
       String sql = "UPDATE usuario SET nome= ? , senha= ?, cargo = ? ,  rg = ? WHERE nome = ? ";
       
        PreparedStatement statement = connection.prepareStatement(sql);
        
       //tecnica para evitar  ataques de Sql Inject     exemplo:('or 1=1--)
        statement.setString(1, nomeUsuario);   //Este metodo troca a primeira interrogação da string "sql" pela string da variavel "nome"
        statement.setString(2, senha); 
        statement.setString(3, cargo);
        statement.setString(4, rg); 
       statement.setString(5,nomeUsuario);
       statement.execute();
       
   }
    
    public void insertOrUpdate(Usuario usuario) throws SQLException{
        
        if(usuario.getNome()!= null){
           insert(usuario);
                   
            
        }
        else
            
            update(usuario);
        
    }
    
    public void delete(Usuario usuario) throws SQLException{
        
      
       int id= usuario.getId();
       String sql = "DELETE FROM usuario  WHERE id = ? ";
       
        PreparedStatement statement = connection.prepareStatement(sql);
        
       //tecnica para evitar  ataques de Sql Inject     exemplo:('or 1=1--)
        
       statement.setInt(1, id); //Este metodo troca interrogação da string "sql" pelo inteiro da variavel "rg"
       
       statement.execute();
             
                
    }
    
  
       
    public Usuario selectPorId(int id) throws SQLException{
      
         String sql = "SELECT * FROM usuario  WHERE id = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, id); //Este metodo troca interrogação da string "sql" pelo inteiro da variavel "rg"
        statement.execute();
         resultSet = statement.getResultSet();
        if(resultSet.next()){
            
           
            String nome =resultSet.getString("nome");
            String senha = resultSet.getString("senha");
            String rg = resultSet.getString("rg");
            String cargo = resultSet.getString("cargo");
            
           return new Usuario(id, nome, rg, senha, cargo);
            
            
            
            
        }else{
            
            return null;
        }
        
    }
            

    public Usuario existeNoBancoPorNomeESenha(Usuario usuario) throws SQLException {
       
        String nomeUsuario= usuario.getNome();
        String senha= usuario.getSenha();
        String sql = "SELECT * FROM usuario WHERE nome= ? AND senha= ? ";
        
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        //tecnica para evitar  ataques de Sql Inject     exemplo:('or 1+1--)
        statement.setString(1, nomeUsuario);   //Este metodo troca a primeira interrogação da string "sql" pela string da variavel "nome"
        statement.setString(2, senha);  //Este metodo troca a segunda interrogação da string "sql" pela string da variavel "senha"
        
        
        statement.execute();
        
        resultSet = statement.getResultSet(); //retorna um resultado do banco de dados na variavel do ripo ResultSet
             
            if(resultSet.next()){
                
              int id= resultSet.getInt("id");
              String cargo= resultSet.getString("cargo");
              String rg= resultSet.getString("rg");
                
                return new Usuario(id, nomeUsuario, rg, senha, cargo);
            }
            else{
                
                
                return null;
                
            }
        
            
        
    }

   

    public void insertHistoricoLogin(Usuario usuario) throws SQLException {
        
        
          DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
      LocalDateTime ldt = LocalDateTime.now();
        
        String logon = ldt.format(f);
        
        
        
        
        String sql = "INSERT INTO login(usuario_id,logon) VALUES(?,?);";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, usuario.getId());
            statement.setString(2, logon);
            statement.execute();
    
        
        
    }
    
    public Usuario selectUsuarioLogado() throws SQLException{
        
        String sql = "SELECT LG.id, LG.usuario_id, US.nome, US.rg, US.senha, US.cargo  FROM login AS LG \n" +
"INNER JOIN usuario AS US\n" +
"ON LG.usuario_id = US.id ORDER BY LG.id DESC LIMIT 1";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        
        resultSet = statement.getResultSet(); //retorna um resultado do banco de dados na variavel do ripo ResultSet
             
            if(resultSet.next()){
                
              int id= resultSet.getInt("usuario_id");
              String nome= resultSet.getString("nome");
              String cargo= resultSet.getString("cargo");
              String rg= resultSet.getString("rg");
              String senha= resultSet.getString("senha");
                
                return new Usuario(id, nome, rg, senha, cargo);
            }
        
            else{
                
                
                
                return null;
            }
        
        
        
        
        
        
        
        
    }

    public ArrayList<Usuario> selectAll() throws SQLException {

 String sql = "SELECT * FROM usuario ";
        
        
        PreparedStatement statement = connection.prepareStatement(sql);
       
        
        statement.execute();
        
        resultSet = statement.getResultSet(); //retorna um resultado do banco de dados na variavel do ripo ResultSet
                 ArrayList<Usuario> usuarios = new ArrayList<>();
            while(resultSet.next()){
                
              String nome= resultSet.getString("nome");  
              String senha= resultSet.getString("senha");  
              int id= resultSet.getInt("id");
              String cargo= resultSet.getString("cargo");
              String rg= resultSet.getString("rg");
              
              usuarios.add(new Usuario(id, nome, rg, senha, cargo));
                
      
                }
              
                return usuarios;
            }

    public Usuario selectPorNome(String nomeUsuario) throws SQLException {
        
        
       
        String sql = "SELECT * FROM usuario WHERE nome= ? ";
        
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        //tecnica para evitar  ataques de Sql Inject     exemplo:('or 1+1--)
        statement.setString(1, nomeUsuario);   //Este metodo troca a primeira interrogação da string "sql" pela string da variavel "nome"
        
        
        
        statement.execute();
        
        resultSet = statement.getResultSet(); //retorna um resultado do banco de dados na variavel do ripo ResultSet
             
            if(resultSet.next()){
              
                
              String senha =resultSet.getString("senha");   
              int id= resultSet.getInt("id");
              String cargo= resultSet.getString("cargo");
              String rg= resultSet.getString("rg");
                
                return new Usuario(id, nomeUsuario, rg, senha, cargo);
            }
            else{
                
                
                return null;
                
            }
        
        
    }

    public void deletePorNome(String nomeUsuario) throws SQLException {
        String sql = "DELETE FROM usuario WHERE nome= ? ";
        
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        //tecnica para evitar  ataques de Sql Inject     exemplo:('or 1+1--)
        statement.setString(1, nomeUsuario);   //Este metodo troca a primeira interrogação da string "sql" pela string da variavel "nome"
        
        
        
        statement.execute();
    }
           
                
                
          
                
            }




 
    

   
    
    

