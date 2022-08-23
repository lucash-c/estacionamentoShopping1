/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author lucas
 */



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Vaga;

public class VagaDAO {
    
    private final Connection connection;
    private ResultSet resultSet;

    public VagaDAO(Connection connection) {
        this.connection = connection;
    }
    
    
    
    public void insertVagas(ArrayList<Vaga> vagas) throws SQLException{
        
         String sql = "INSERT INTO vaga (tipo,fileira_id) VALUES(?,?);";
          PreparedStatement statement = connection.prepareStatement(sql);
          
        for (Vaga vaga : vagas) {
                                            
            
      
        statement.setString(1, vaga.getTipo());  
        statement.setInt(2, vaga.getFileiraId());
     
            statement.execute();
            
            
        }
           
    }
    
    public void atualizaIdVagas(int fileira_id) throws SQLException{
        
      
         String sql = "SELECT * FROM vaga  WHERE fileira_id = ? ORDER BY id ASC";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, fileira_id);
        
         statement.execute();
        
        resultSet = statement.getResultSet();
        
         sql = "UPDATE vaga SET index_fileira= ?  WHERE id= ? ;";
       
        statement = connection.prepareStatement(sql);
        int i = 1;
                
        while (resultSet.next()){
            
            
            
            statement.setInt(1, i); 
            statement.setInt(2, resultSet.getInt("id"));
            i++;
              statement.execute();
            
        }
        
        
        
    }

    public ArrayList<Vaga> selectAll() throws SQLException {
        
          String sql = "SELECT * FROM vaga ";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        
         statement.execute();
        
        resultSet = statement.getResultSet();
        ArrayList<Vaga> vagas = new ArrayList<Vaga>();
        
   
        while (resultSet.next()){
            
           String tipo = resultSet.getString("tipo");
           int fileiraId= resultSet.getInt("fileira_id");
           int indexFileira= resultSet.getInt("index_fileira");
           int id= resultSet.getInt("id");
           int estado = resultSet.getInt("estado");
           
          Vaga vaga =  new Vaga(tipo, fileiraId);
          vaga.setId(id);
          vaga.setEstado(estado);
          vaga.setIndexFileira(indexFileira);
          
          vagas.add(vaga);
          
           }
  return vagas;
    }
    
    public ArrayList<Vaga> selectVagasPorTipoEporId(String tipo, int fileiraId) throws SQLException{
        
         String sql = "SELECT * FROM vaga WHERE tipo = ? AND fileira_id = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, tipo);
         statement.setInt(2, fileiraId);
         statement.execute();
        
        resultSet = statement.getResultSet();
        ArrayList<Vaga> vagas = new ArrayList<>();
        
   
        while (resultSet.next()){
            
           tipo = resultSet.getString("tipo");
           fileiraId= resultSet.getInt("fileira_id");
           int indexFileira= resultSet.getInt("index_fileira");
           int id= resultSet.getInt("id");
           int estado = resultSet.getInt("estado");
           
          Vaga vaga =  new Vaga(tipo, fileiraId);
          vaga.setId(id);
          vaga.setEstado(estado);
          vaga.setIndexFileira(indexFileira);
          
          vagas.add(vaga);
          
           }
  return vagas;
        
        
        
        
        
        
    }

    public Vaga selectVagaPorTipoEporFileiraDisp(String tipo, int fileiraId) throws SQLException {
        int estado = 0;
         String sql = "SELECT * FROM vaga WHERE tipo = ? AND fileira_id= ? AND estado =? LIMIT 1;";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, tipo);
         statement.setInt(2, fileiraId);
          statement.setInt(3, estado);
         statement.execute();
        
        resultSet = statement.getResultSet();
      
   
        if(resultSet.next())
        {
           tipo = resultSet.getString("tipo");
           fileiraId= resultSet.getInt("fileira_id");
           int indexFileira= resultSet.getInt("index_fileira");
           int id= resultSet.getInt("id");
          estado = 1;
           
          Vaga vaga =  new Vaga(id, indexFileira, estado, tipo, fileiraId);
         
          
            return vaga;
          
        }
        else {
                return null;
                }
           }

        
        
        
        
        
    

    public boolean delete(Vaga vaga, int qtd) throws SQLException {
       
        
         String sql = "SELECT * FROM vaga WHERE tipo = ? AND fileira_id = ?;";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, vaga.getTipo());
         statement.setInt(2, vaga.getFileiraId());
       
         statement.execute();
        ArrayList<Vaga> vagas = new ArrayList<>();
        
        resultSet = statement.getResultSet();
        while (resultSet.next()){
            
            Vaga vagaQueVemDoBanco = new Vaga(resultSet.getString("tipo"),resultSet.getInt("fileira_id"), resultSet.getInt("id"));
            
            vagas.add(vagaQueVemDoBanco);
            
        }
        if (vagas.size()<qtd || qtd == 0){
            
            return false;
            
            
            
        }else{
            
         sql = "DELETE  FROM vaga WHERE tipo = ? AND fileira_id = ? LIMIT ?;";
            
          statement = connection.prepareStatement(sql);
        statement.setString(1, vaga.getTipo());
         statement.setInt(2, vaga.getFileiraId());
        statement.setInt(3, qtd);
         statement.execute();
         return true;
            
        }
        
    }

    public boolean deleteFileira(int fileiraId) throws SQLException {
        
        String sql = "SELECT * FROM fileira WHERE id = ? ";
        
         PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, fileiraId);
         statement.execute();
        resultSet = statement.getResultSet();
        
        if(resultSet.next()){
            
           sql=  "DELETE  FROM vaga WHERE fileira_id = ? ;";
              statement = connection.prepareStatement(sql);
              statement.setInt(1, fileiraId);
              statement.execute();
              
              sql=  "DELETE  FROM fileira WHERE id = ? ;";
              statement = connection.prepareStatement(sql);
              statement.setInt(1, fileiraId);
              statement.execute();
   
         return true;
 
        
        
            }else{
            return false;
        }
        }

    public ArrayList<Vaga> selectVagasPorTipoEporFileiraDisp(String tipo, int fileiraId) throws SQLException {
        int estado = 0;
         String sql = "SELECT * FROM vaga WHERE tipo = ? AND fileira_id= ? AND estado =? ;";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, tipo);
         statement.setInt(2, fileiraId);
          statement.setInt(3, estado);
         statement.execute();
        
        resultSet = statement.getResultSet();
        ArrayList<Vaga> vagas = new ArrayList<>();
   
        while (resultSet.next()){
            
            tipo = resultSet.getString("tipo");
           fileiraId= resultSet.getInt("fileira_id");
           int indexFileira= resultSet.getInt("index_fileira");
           int id= resultSet.getInt("id");
            Vaga vaga =  new Vaga(id, indexFileira, estado, tipo, fileiraId);
            vagas.add(vaga);
            
        }      
          
            return vagas;
          
          
    }

   

    public void update(Vaga vaga) throws SQLException {
        int id = vaga.getId();
        int indexFileira = vaga.getIndexFileira();
        int estado = vaga.getEstado();
        String tipo = vaga.getTipo();
        int fileiraId = vaga.getFileiraId();
        
        String sql = "UPDATE vaga SET id = ? , index_fileira= ? , estado = ? , tipo = ? , fileira_id = ? WHERE id= ? ;";
                
       PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setInt(2, indexFileira);
        statement.setInt(3, estado);
        statement.setString(4, tipo);
        statement.setInt(5, fileiraId);
        statement.setInt(6, id);
        
         statement.execute();
          
          
         
    }

    public Vaga selectPorId(int vaga_id) throws SQLException {
        
    
       
         String sql = "SELECT * FROM vaga WHERE id = ? ";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, vaga_id);
         
         statement.execute();
         resultSet = statement.getResultSet();
         
         if(resultSet.next()){
             
             int indexFileira = resultSet.getInt("index_fileira");
             int estado = resultSet.getInt("estado"); 
             String tipo = resultSet.getString("tipo");
             int fileiraId = resultSet.getInt("fileira_id");
                     
             
             return new Vaga(estado, indexFileira, estado, tipo, fileiraId);
             
             
             
         }
         
         else{
             
             return null;
         }
         
    }
    
    
      
    
    
    
    
    
}


