/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import dao.Conexao;
import dao.FileiraDAO;
import dao.TicketDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import view.EntradaView;
import model.Fileira;
import model.Vaga;
import dao.VagaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import model.Cliente;
import model.Ticket;
import model.Usuario;

/**
 *
 * @author lucas
 */
public class EntradaController {
    
    private final EntradaView view;
    private Vaga vaga;

    public EntradaController(EntradaView view) {
        this.view = view;
    }
    
    public boolean alocarVagaComum() throws SQLException, ClassNotFoundException, InterruptedException{
        
        
        //buscar todas fileiras no banco 
        String tipo = "COMUM";
        Conexao conexao = new Conexao();
       Connection connection = conexao.getConnection();
       
       FileiraDAO fileiraDAO = new FileiraDAO(connection);
       ArrayList<Vaga> vagas;
       ArrayList<Fileira> fileiras = fileiraDAO.selectAll();
       VagaDAO vagaDAO= new VagaDAO(connection);
       
        //encontrar uma vaga COMUM livre em uma das  fileiras e retornar a vaga
        
        for (Fileira fileira : fileiras) {
         int fileiraId = fileira.getId();
         
         
          //pesquisa vaga COMUM disponivel e retorna ela, se nao houver nenhuma retorna null
         vaga = vagaDAO.selectVagaPorTipoEporFileiraDisp(tipo, fileiraId);
             
          if(vaga != null){
              
              break;
          }
          
             
        }
        if(vaga == null){
            
            // rodou todas as fileiras e nao encontrou nenhuma vaga COMUM disponivel entao retorna false
            return false;            
        }else{
            
            vaga.setEstado(1);
           
         
            ocuparVagaNoBanco(vaga);
        return criaTicket(vaga);
        
        
        } 
    }
    
     public boolean alocarVagaPreferencial() throws SQLException, ClassNotFoundException, InterruptedException{
         
         //buscar todas fileiras no banco 
        String tipo = "PREFERENCIAL";
        Conexao conexao = new Conexao();
       Connection connection = conexao.getConnection();
       
       FileiraDAO fileiraDAO = new FileiraDAO(connection);
       ArrayList<Vaga> vagas;
       ArrayList<Fileira> fileiras = fileiraDAO.selectAll();
       VagaDAO vagaDAO= new VagaDAO(connection);
       
        //encontrar uma vaga COMUM livre em uma das  fileiras e retornar a vaga
        
        for (Fileira fileira : fileiras) {
         int fileiraId = fileira.getId();
         
         
          //pesquisa vaga COMUM disponivel e retorna ela, se nao houver nenhuma retorna null
         vaga = vagaDAO.selectVagaPorTipoEporFileiraDisp(tipo, fileiraId);
             
          if(vaga != null){
              
              break;
          }
          
             
        }
        if(vaga == null){
            
            // rodou todas as fileiras e nao encontrou nenhuma vaga PREFERENCIAL disponivel entao procura vaga comum
          return alocarVagaComum();
                
              
        }else{
            
            vaga.setEstado(1);
           
         ocuparVagaNoBanco(vaga);
        return criaTicket(vaga); 
      
   
        
         
         
     }
   }
     
     public boolean criaTicket(Vaga vaga) throws SQLException, ClassNotFoundException, InterruptedException{
         
           //criando a chegada com data e hora atual
           Conexao conexao = new Conexao();
           FileiraDAO fileiraDAO = new FileiraDAO(conexao.getConnection());
           TicketDAO ticketDAO = new TicketDAO(conexao.getConnection());
           
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.now();
        String chegada = ldt.format(f);
        String saida = ldt.format(f);
        
        Usuario usuario = new Usuario(1,"sistema","000000","sistema","sistema");
        
        //criar um ticket usando como parametro: (chegada, vaga) , manda imprimir e retorna true
        Ticket ticket = new Ticket(vaga,usuario,chegada, saida);
        
        ticket.imprime(ticket);
         
       //busca fileira
    Fileira fileira = fileiraDAO.pesquisaFileiraPorId(ticket.getVaga().getFileiraId());
        
     
        
        String mensagem = "     Estacione na VAGA: "+fileira.getDescricao()+" "+ticket.getVaga().getIndexFileira();
      
     
               view.getjLabelMensagem().setText(mensagem);
         
                
                
                
       // registra ticket no banco de dados
        return registraTicketNoBanco(ticket);
       
 
        
       
        
         
     }
     
    
     
      public boolean alocarVagaMensalista(int codigo) throws SQLException, ClassNotFoundException{
          
          
         if( !liberado(codigo)){
             
     mensagem("VInteligent","Ola mensalista, o seu registro encontra-se bloqueado no momento. Pedimos para que escolha a opção de entrada comum e procure um de nossos funcionarios. ",6);
             
             return false;
             
             
         }else{
          
          
                    
          Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        ClienteDAO clienteDAO = new ClienteDAO(connection);
        Cliente cliente = clienteDAO.selectPorCod(codigo);
        
        String descricaoFileira="";
        
        if(cliente == null){
            
            return false;
            
        }
        else{
            
              //buscar todas fileiras no banco 
        String tipo = "MENSALISTA";
        
       FileiraDAO fileiraDAO = new FileiraDAO(connection);
       ArrayList<Vaga> vagas;
       ArrayList<Fileira> fileiras = fileiraDAO.selectAll();
       VagaDAO vagaDAO= new VagaDAO(connection);
       
       
        
        for (Fileira fileira : fileiras) {
         int fileiraId = fileira.getId();
         descricaoFileira=fileira.getDescricao();
         
          //pesquisa vaga MENSALISTA disponivel e retorna ela, se nao houver nenhuma retorna null
         vaga = vagaDAO.selectVagaPorTipoEporFileiraDisp(tipo, fileiraId);
             
          if(vaga != null){
              
              break;
          }
          
             
        }
        if(vaga == null){
            
            // rodou todas as fileiras e nao encontrou nenhuma vaga PREFERENCIAL disponivel entao procura vaga comum
         
            tipo = "COMUM";
    
      
        //encontrar uma vaga COMUM livre em uma das  fileiras e retornar a vaga
        
        for (Fileira fileira : fileiras) {
         int fileiraId = fileira.getId();
         descricaoFileira=fileira.getDescricao();
         
          //pesquisa vaga COMUM disponivel e retorna ela, se nao houver nenhuma retorna null
         vaga = vagaDAO.selectVagaPorTipoEporFileiraDisp(tipo, fileiraId);
             
          if(vaga != null){
              
              break;
          }
          
             
        }
        if(vaga == null){
            
            // rodou todas as fileiras e nao encontrou nenhuma vaga COMUM disponivel entao retorna false
            return false;            
        }else{
            
            vaga.setEstado(1);
           ocuparVagaNoBanco(vaga);
           
            String mensagem = "     Estacione na VAGA: "+descricaoFileira+" "+vaga.getIndexFileira();
            view.getjLabelMensagem().setText(mensagem);
           return true;
        }
            
                
              
        }else{
            
            vaga.setEstado(1);
    
        
        ocuparVagaNoBanco(vaga);
        //Obs: mensalista nao precisa imprimir ticket
        
   String mensagem = "     Estacione na VAGA: "+descricaoFileira+" "+vaga.getIndexFileira();
      
               view.getjLabelMensagem().setText(mensagem);
        return true;
      
            
        }
          
      }
      }
      
      }
   
    public boolean registraTicketNoBanco(Ticket ticket) throws SQLException, ClassNotFoundException {
        
         Conexao conexao = new Conexao();
         Connection connection = conexao.getConnection();
              
         
         
       TicketDAO ticketDAO = new TicketDAO(connection);
       
       
       ticketDAO.Insert(ticket);
       
       this.view.setMensagem("Bem vindo. Retire seu ticket.");
       
        
        return true;
        
    }
      
      public void ocuparVagaNoBanco(Vaga vaga) throws SQLException, ClassNotFoundException{
          
          
           Conexao conexao = new Conexao();
         Connection connection = conexao.getConnection();
          
          
            VagaDAO vagaDAO = new VagaDAO(connection);
            vagaDAO.update(vaga);
      
          
          
          
      }
      
      public boolean clienteExiste(int codigo) throws SQLException, ClassNotFoundException{
          Conexao conexao = new Conexao();
         Connection connection = conexao.getConnection();
         
         ClienteDAO clienteDAO = new ClienteDAO(connection);
          return clienteDAO.selectPorCod(codigo)!= null;
          
          
          
      }

    public boolean liberado(int codigo) throws SQLException, ClassNotFoundException {
        
        Conexao conexao = new Conexao();
         Connection connection = conexao.getConnection();
         
         ClienteDAO clienteDAO = new ClienteDAO(connection);
         Cliente cliente = clienteDAO.selectPorCod(codigo);
        return !cliente.getBloqueado();
        
        
    }
            
    
    public void estacionamentoLotado() throws SQLException, ClassNotFoundException{
        
        Conexao conexao = new Conexao();
         Connection connection = conexao.getConnection();
         
         TicketDAO ticketDAO = new TicketDAO(connection);
        
          DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.now();
        String chegada = ldt.format(f);
        String saida = ldt.format(f);
        int permanencia = 0;
        
         Ticket ticket = new Ticket (chegada,saida,permanencia);
        ticketDAO.Insert(ticket);
        ticket.imprime(ticket);
        mensagem("VInteligent",  "Desculpe. Nosso estacionamento esta lotado no momento." + "Retire o ticket e  Dirija-se para a saida", 5);
        
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
    

       
      
}
