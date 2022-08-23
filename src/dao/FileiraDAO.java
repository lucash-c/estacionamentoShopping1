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
import model.Fileira;
import model.Vaga;


/**
 *
 * @author lucas
 */
public class FileiraDAO {
    
    private final Connection connection;
    private ResultSet resultSet;

    public FileiraDAO(Connection connection) {
        this.connection = connection;
    }
    
    public Fileira pesquisaFileiraPorId(int fileiraId) throws SQLException{
    //fazer um select no banco por id da fileira
        String sql = "SELECT * FROM fileira";
         PreparedStatement statement = connection.prepareStatement(sql);
       
        statement.execute();
         String descricao="";
         
        ResultSet resultSet = statement.getResultSet();
        if(resultSet.next()){
                descricao = resultSet.getString("descricao");
        }
      
        
         sql = "SELECT * FROM vaga  WHERE fileira_id = ?";
        
            statement = connection.prepareStatement(sql);
        
        statement.setInt(1, fileiraId); //Este metodo troca interrogação da string "sql" pelo inteiro da variavel "rg"
        
        statement.execute();
       resultSet = statement.getResultSet();
        
        ArrayList<Vaga> vagas = new ArrayList<>();
        
          while( resultSet.next()){  // o metodo resultSet.next() retornara a proxima linha e um true ou false
                                
            String tipo = resultSet.getString("tipo");
            int id = resultSet.getInt("id");
            int indexFileira = resultSet.getInt("index_fileira");
            int estado = resultSet.getInt("estado");
            
            
            vagas.add(new Vaga(id,indexFileira,estado,tipo,fileiraId));
            
                   
    }
         
          
       
        return  new Fileira(vagas, fileiraId, descricao);
          
              
    }
        

    public void insert(Fileira fileira) throws SQLException {
       
        String descricao= fileira.getDescricao();
            
            String sql = "INSERT INTO fileira (descricao) VALUES(?);";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            
             //tecnica para evitar  ataques de Sql Inject   exemplo:('or 1+1--)
        statement.setString(1, descricao);   //Este metodo troca a primeira interrogação da string "sql" pela string da variavel "nome"
        
            statement.execute();
        
    }

    public ArrayList<String> buscaDescricaoDasFileiras() throws SQLException {
        
          String sql = "SELECT descricao FROM fileira ";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
       
        
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        
        
         ArrayList<String> fileiras = new ArrayList<String>();
        
     
        
        while( resultSet.next()){  // o metodo resultSet.next() retornara a proxima linha e um true ou false
            
            String descricao = resultSet.getString("descricao");
           
            fileiras.add(descricao);
        }
        
        return fileiras;
    }
       
        public ArrayList<Vaga> buscaVagasDoBancoPorFileira(Fileira fileira) throws SQLException{
            
            
             String sql = "SELECT * FROM vaga WHERE fileira_id = ? ";
             
                     
        PreparedStatement statement = connection.prepareStatement(sql);
        
       statement.setInt(1, buscaIdFileiraPorDescricao(fileira.getDescricao()));
        
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        
        
         ArrayList<Vaga> vagas = new ArrayList<>();
        
     
        
        while( resultSet.next()){  // o metodo resultSet.next() retornara a proxima linha e um true ou false
            
            String tipo = resultSet.getString("tipo");
            int indexdFileira = resultSet.getInt("index_fileira");
                 int id = resultSet.getInt("id");
                 int estado = resultSet.getInt("estado");
                 int fileiraId = resultSet.getInt("fileira_id");
                 Vaga vaga = new Vaga(id, indexdFileira, estado, tipo, fileiraId);
            vagas.add(vaga);
        }
        
            
            return vagas;
        }

    
    public void update(Fileira fileira) throws SQLException, ClassNotFoundException {
        
        
      
        
        String sql = "UPDATE fileira SET id= ? WHERE id = ?; ";
       
        PreparedStatement statement = connection.prepareStatement(sql);
        
       //tecnica para evitar  ataques de Sql Inject     exemplo:('or 1=1--)
        statement.setInt(1, fileira.getId());  
        
        statement.setInt(2, fileira.getId()); 
       
       statement.execute();
       
        Conexao conexao = new Conexao();
        
        VagaDAO vagaDAO = new VagaDAO(conexao.getConnection());
        vagaDAO.insertVagas(fileira.getVagas());
        
          vagaDAO.atualizaIdVagas(fileira.getId());
        
    }

    public ArrayList<Fileira> selectAll() throws SQLException {
       
         String sql = "SELECT * FROM fileira ;";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
         statement.execute();     
   
        ResultSet resultSet = statement.getResultSet();
        
        ArrayList<Fileira> fileiras = new ArrayList<>();
        
          while( resultSet.next()){
             int id = resultSet.getInt("id");
              String descricao = resultSet.getString("descricao");
              
              Fileira fileira = new Fileira(descricao);
              fileira.setId(id);
              fileiras.add(fileira);
              
              
          } 
        
        
        return fileiras;
        
        
        
        
    }
    
    public int buscaIdFileiraPorDescricao(String descricao) throws SQLException{
        
        String sql = "SELECT * FROM fileira  WHERE descricao = ?;";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, descricao); //Este metodo troca interrogação da string "sql" pelo inteiro da variavel "rg"
        
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
       if( resultSet.next()){
       return resultSet.getInt("id");
       }else{
       
       return 0;
       }
    }

    public Fileira pesquisaFileiraPorDescricao(String descricao) throws SQLException {
        
        int fileiraId = buscaIdFileiraPorDescricao(descricao);
             
         String sql = "SELECT * FROM vaga  WHERE fileira_id = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, fileiraId); //Este metodo troca interrogação da string "sql" pelo inteiro da variavel "rg"
        
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        ArrayList<Vaga> vagas = new ArrayList<>();
        
          while( resultSet.next()){  // o metodo resultSet.next() retornara a proxima linha e um true ou false
                                
            String tipo = resultSet.getString("tipo");
            int id = resultSet.getInt("id");
            int indexFileira = resultSet.getInt("index_fileira");
            int estado = resultSet.getInt("estado");
            
            vagas.add(new Vaga(id,indexFileira,estado,tipo,fileiraId));
            
                   
    }
         
          
       
        return new Fileira(vagas, fileiraId);
          
              
    }
 }
    
    
    
    
    


 
