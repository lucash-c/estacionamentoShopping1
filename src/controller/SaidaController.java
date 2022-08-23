/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import dao.Conexao;
import dao.TicketDAO;
import dao.VagaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import model.Cliente;
import model.Ticket;
import view.SaidaView;

/**
 *
 * @author lucas
 */
public class SaidaController {
    
   private final SaidaView view ;

    public SaidaController(SaidaView view) {
        this.view = view;
    }

    public void autenticaTicket() throws SQLException, ClassNotFoundException {
      
        int cod = Integer.parseInt(view.getjTextFieldCodigo().getText());
        view.getjTextFieldCodigo().setText("");
       Conexao conexao = new Conexao();
       TicketDAO ticketDAO = new TicketDAO (conexao.getConnection());
       ClienteDAO clienteDAO = new ClienteDAO(conexao.getConnection());
       Ticket ticket = ticketDAO.selectPorCod(cod);
    
               
       
       // se ticket for nulo = codigo informado esta errado ou é de mensalista... se for <0 o ticket ja foi utilizado uma vez enao vale mais
       if(ticket == null || ticket.getCod()<0){
           
           Cliente cliente = clienteDAO.selectPorCod(cod);
           if(cliente== null){
           //JOptionPane.showMessageDialog(null, "Ticket não encontrado ou invalido");
            mensagem("VInteligent","Ticket não encontrado ou invalido",5);
           
                            }else{
            
              
           mensagem("VInteligent","Obrigado pela sua visita. Volte Sempre.",5);
             
            
               
           }
           }
           else{
       
           
            
           DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime ldtSaida= LocalDateTime.parse(agora.format(f), f);
    
        String saida = ldtSaida.format(f);
       ticket.setSaida(saida);
       ticketDAO.update(ticket);
       int permanencia = calculaPermanencia(ticket);
          ticket.setPermanencia(permanencia);
         
           
           
           if(  ticket.getPermanencia() <20 ){
               
             ticket.getVaga().setEstado(0);
            
              VagaDAO vagaDAO = new VagaDAO(conexao.getConnection());
              vagaDAO.update(ticket.getVaga());
               
               mensagem("VInteligent","Obrigado pela sua visita. Volte Sempre.",5);
             
               ticketDAO.update(ticket);
         /*  }else
           if(ticket.getUsuario().getId() > 1){
          
             ticket.getVaga().setEstado(0);
            
              VagaDAO vagaDAO = new VagaDAO(conexao.getConnection());
        
              vagaDAO.update(ticket.getVaga());
              
              ticketDAO.update(ticket);
              mensagem("VInteligent","Obrigado pela sua visita. Volte Sempre.",5);
        */
           }else{
               
               
               
                mensagem("VInteligent","Por Favor dirija-se ao caixa para fazer a liberação de seu ticket.",5);
               
           
           
           
       }
       
        
        
    }
   
   
    }
   
    public void mensagem(String cabecalho, String corpo, int segundos){
        
        
         JOptionPane meuJOPane = new JOptionPane(corpo);//instanciando o JOptionPane
        final JDialog dialog = meuJOPane.createDialog(null, cabecalho);//aqui uso um JDialog para manipular
                                                                    //meu JOptionPane
        dialog.setModal(true);  
        //Usando o javax.swing.Timer para poder gerar um evento em um tempo determinado
        //Veja o construtor da classe Timer para mais explicações
        Timer timer = new Timer(segundos * 1000, new ActionListener() {  
            public void actionPerformed(ActionEvent ev) {  
                dialog.dispose();  //o evento(no caso fechar o meu JDialog)
            }  
        });  
        timer.start();
        dialog.setVisible(true);
        timer.stop();
             
    }
        public int calculaPermanencia(Ticket ticket) throws SQLException, ClassNotFoundException{
        
        
       //buscar ticket com todos os dados no banco e pegar horario de saida
       Conexao conexao = new Conexao();
       Connection connection = conexao.getConnection();
       
       TicketDAO ticketDAO = new TicketDAO(connection);
       ticketDAO.BuscaDadosDeCaixaPorCodigo(ticket);
   
        String chegada = ticket.getDataHoraChegadaFormatada();
       
       DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime ldtSaida= LocalDateTime.parse(agora.format(f), f);
        LocalDateTime entrada= LocalDateTime.parse(chegada, f); 
        String saida = ldtSaida.format(f);
       
        ticket.setSaida(saida);
      
       
       return (int)Duration.between(entrada, ldtSaida).toMinutes();
        
        
        
    }
    
    
    
   
    }
