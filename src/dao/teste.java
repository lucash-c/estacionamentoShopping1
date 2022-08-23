/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package dao;

import controller.EntradaController;
import static java.awt.PageAttributes.MediaType.A;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 import java.time.Duration;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import model.Fileira;
import model.Vaga;
import model.Ticket;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import view.CaixaView;

/**
 *
 * @author lucas
 */
public class teste {


  
    
    public static void main(String [] args) throws SQLException, ClassNotFoundException{ 
        
        
        
       /*
        Vaga vaga = new Vaga("COMUM", 1, 1);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime entrada= LocalDateTime.parse(ldt.format(f), f);
        LocalDateTime saida= LocalDateTime.parse("23-10-2021 22:00:00", f);
        long diferencaMili = Duration.between(entrada, saida).toMillis();
        long diferencaSeg = Duration.between(entrada, saida).getSeconds();
        long diferencaMin = Duration.between(entrada, saida).toMinutes();
        String chegada = ldt.format(f);
       // Ticket ticket = new Ticket(chegada,vaga);
        //System.out.println(diferencaMin);
       LocalDateTime teste = LocalDateTime.parse(chegada,f);
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        TicketDAO ticketDAO = new TicketDAO(connection);
   System.out.println(chegada +"  " +vaga.getId() );
        // ticketDAO.Insert(ticket);
         
   String s = "25/07/1981";
DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/uuuu");
// faz o parsing e setar o horário para meia-noite
LocalDateTime dateTime = LocalDate.parse(s, parser).atStartOfDay();
System.out.println(dateTime); // 1981-07-25T00:00
  
        
        FileiraDAO fileiraDAO = new FileiraDAO(connection);
        VagaDAO vagaDAO = new VagaDAO(connection);
        
        ArrayList<Fileira> fileiras = fileiraDAO.selectAll();
        
        
        ArrayList<Vaga> vagas = new ArrayList <>();
        
         for (Fileira fileira : fileiras) {
         int fileiraId = fileira.getId();
         
         
          //pesquisa vaga COMUM e retorna um array com todas as vagas comuns da fileira indicada
         vaga = vagaDAO.selectVagaPorTipoEporFileiraDisp("COMUM", fileiraId);
             
           
             //verifica no array vagas se existe alguma vaga disponivel e se houver retorna ela se nao retorna null
             
             
       
          }
          
        Vaga vaga1 = new Vaga(1);
        
        Ticket ticket = new Ticket(chegada, vaga,"27-10-2021 22:23:10");
        
        //System.out.println(ticket.getDataHoraChegadaFormatada());
        System.out.println(ticket.getDataHoraSaidaFormatada());
        
        
       
          Conexao conexao = new Conexao();
        ClienteDAO clienteDAO = new ClienteDAO(conexao.getConnection());
             System.out.println(clienteDAO.selectAll().isEmpty()); 

*/
       
       
       
        /*JOptionPane meuJOPane = new JOptionPane("corpo da mensagem");//instanciando o JOptionPane
        final JDialog dialog = meuJOPane.createDialog(null, "cabeçalho");//aqui uso um JDialog para manipular
                                                                    //meu JOptionPane
        dialog.setModal(true);  
        //Usando o javax.swing.Timer para poder gerar um evento em um tempo determinado
        //Veja o construtor da classe Timer para mais explicações
        Timer timer = new Timer(2 * 1000, new ActionListener() {  
            public void actionPerformed(ActionEvent ev) {  
                dialog.dispose();  //o evento(no caso fechar o meu JDialog)
            }  
        });  
        timer.start();
        dialog.setVisible(true);
        timer.stop();
           */
       
      /*CaixaView view = new CaixaView();
      
      if(view.getjTextFieldValorPago().getText().equals("") || view.getjTextFieldValorPago().getText().equals("0")){
             String textFieldValorPago = view.getjLabelValorAPagar1().getText();
       
             System.out.println(textFieldValorPago);
        }
       */
      
      
        
    }}
        
 
        
       

 
