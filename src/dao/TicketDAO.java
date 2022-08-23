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

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Ticket;
import model.Usuario;
import model.Vaga;


/**
 *
 * @author lucas
 */
public class TicketDAO {
    
     private final Connection connection;
    private ResultSet resultSet;

    public TicketDAO(Connection connection) {
        this.connection = connection;
    }

    public void Insert(Ticket ticket) throws SQLException {
        
        
        String chegada = ticket.getDataHoraChegadaFormatada();
//        String saida = ticket.getDataHoraSaidaFormatada();
        int vagaId = ticket.getVagaId();
        int usuarioId = ticket.getUsuarioId();
        //cria um ticket no banco
        
          String sql = "INSERT INTO ticket (chegada,vaga_id,usuario_id) VALUES(?,?,?);";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            
           
        statement.setString(1, chegada);  

        statement.setInt(2, vagaId);
        
        statement.setInt(3, usuarioId);
     
         
            statement.execute();
            
            
        
    }
    
    public Ticket BuscaDadosDeCaixaPorCodigo(Ticket ticket) throws SQLException{
        
        
        String sql = "SELECT * FROM ticket  WHERE cod = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, ticket.getCod());
        
         statement.execute();
        
        resultSet = statement.getResultSet();
        
             
        if(resultSet.next()){
       int cod = resultSet.getInt("cod");
String chegada = resultSet.getString("chegada");

int usuario_id = resultSet.getInt("usuario_id");
int vaga_id = resultSet.getInt("vaga_id");

         UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
         VagaDAO vagaDAO = new VagaDAO(connection);
         
       DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime ldtSaida= LocalDateTime.parse(agora.format(f), f);
        LocalDateTime entrada= LocalDateTime.parse(chegada, f); 
        String saida = ldtSaida.format(f);
        
        
        
        
        int permanencia = (int)Duration.between(entrada, ldtSaida).toMinutes();
        double valor = 0;
        double valorHora = 0;
     
          
        
      
      return new Ticket(cod, chegada, saida , permanencia,valor,valorHora,vagaDAO.selectPorId(vaga_id), usuarioDAO.selectPorId(usuario_id));
        }else{
            return null;
        }
    }

   

    public void update(Ticket ticket) throws SQLException {
       
         String sql = "UPDATE ticket SET chegada= ? , saida= ?, usuario_id = ? , permanencia = ?, valor = ?, valor_hora = ?  WHERE cod = ? ";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
   
        statement.setString(1, ticket.getDataHoraChegadaFormatada());
        statement.setString(2, ticket.getDataHoraSaidaFormatada());
        statement.setInt(3, ticket.getUsuarioId());
      
        statement.setLong(4, ticket.getPermanencia());
        statement.setDouble(5, ticket.getValor());
        statement.setDouble(6, ticket.getValorHora());
        
        statement.setInt(7, ticket.getCod());
         
         statement.execute();
        
         
         
         
         
      
  
    }

    public boolean selectExistePorCodigo(int cod) throws SQLException {
        String sql = "SELECT * FROM ticket  WHERE cod = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, cod);
        
         statement.execute();
        
        resultSet = statement.getResultSet();
        
        return resultSet.next();
    }
    
    public Ticket selectPorCod(int cod) throws SQLException{
        
         String sql = "SELECT * FROM ticket  WHERE cod = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, cod);
        
         statement.execute();
        
        resultSet = statement.getResultSet();
        
        if(resultSet.next()){
            
            Ticket ticket = new Ticket(cod);
            
            
             return BuscaDadosDeCaixaPorCodigo(ticket);
        }
        else{
        
     
            return null;
            
            
            
        }
              }
    
     public void updateSemUsuario(Ticket ticket) throws SQLException{
         
          String sql = "UPDATE ticket SET chegada= ? , saida= ? WHERE cod = ? ";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
   
        statement.setString(1, ticket.getDataHoraChegadaFormatada());
        statement.setString(2, ticket.getDataHoraSaidaFormatada());
      
     
        statement.setInt(3, ticket.getCod());
        
         statement.execute();
        
      
         
         
         
         
         
     } 

    public ArrayList<Ticket> selectAll() throws SQLException {
        
        String sql = "SELECT * FROM ticket ";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
         statement.execute();
        
        resultSet = statement.getResultSet();
        
        ArrayList<Ticket> tickets = new ArrayList<>();
        
        while(resultSet.next()){
            
           int cod = resultSet.getInt("cod");
           String chegada = resultSet.getString("chegada");
           String saida = resultSet.getString("saida");
           int permanencia= resultSet.getInt("permanencia");
           double valor = resultSet.getDouble("valor");
           double valorHora = resultSet.getDouble("valor_hora");
           int usuarioId = resultSet.getInt("usuario_id");
           int vagaId= resultSet.getInt("vaga_id");
            
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            VagaDAO vagaDAO = new VagaDAO(connection);
            
            Usuario usuario= usuarioDAO.selectPorId(usuarioId);
           Vaga vaga = vagaDAO.selectPorId(vagaId);
           
           if(saida == null || "".equals(saida)){
               
                tickets.add( new Ticket(cod, chegada, permanencia, valor, valorHora, vaga, usuario));
               
           }else{
           
            tickets.add( new Ticket(cod, chegada, saida, permanencia, valor, valorHora, vaga, usuario));
            
           }
    }
    return tickets;
    
    
}

    public ArrayList<Ticket> selectRegistraHistorico() throws SQLException {
       
        
         String sql = "SELECT * FROM ticket WHERE usuario_id > 1";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
         statement.execute();
        
        resultSet = statement.getResultSet();
        
        ArrayList<Ticket> tickets = new ArrayList<>();
        
        while(resultSet.next()){
            
           int cod = resultSet.getInt("cod");
           String chegada = resultSet.getString("chegada");
           String saida = resultSet.getString("saida");
           int permanencia= resultSet.getInt("permanencia");
           double valor = resultSet.getDouble("valor");
           double valorHora = resultSet.getDouble("valor_hora");
           int usuarioId = resultSet.getInt("usuario_id");
           int vagaId= resultSet.getInt("vaga_id");
            
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            VagaDAO vagaDAO = new VagaDAO(connection);
            
            Usuario usuario= usuarioDAO.selectPorId(usuarioId);
           Vaga vaga = vagaDAO.selectPorId(vagaId);
           
           if(saida == null || saida == ""){
               
                tickets.add( new Ticket(cod, chegada, permanencia, valor, valorHora, vaga, usuario));
               
           }else{
           
            tickets.add( new Ticket(cod, chegada, saida, permanencia, valor, valorHora, vaga, usuario));
            
           }
    }
    return tickets;
    
        
        
        
        
    }
}



