/*



 */
package controller;

import controller.helper.CaixaHelper;
import dao.Conexao;
import dao.TicketDAO;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import model.Ticket;
import model.Usuario;
import view.CaixaView;

/**
 *
 * @author lucas
 */
public class CaixaController {
    private CaixaView view;
Conexao conexao = new Conexao();

        
    public CaixaController(CaixaView view) {
        this.view = view;
    }
    
    public void atualizaView() throws SQLException, ClassNotFoundException{
        
        Connection connection = conexao.getConnection();
         CaixaHelper helper = new CaixaHelper(view);
         String cod = view.getjTextFieldCodigo().getText();
         int codigo = Integer.parseInt(cod);
     
        Ticket ticket = new Ticket(codigo);
        
        
        
       
        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
         TicketDAO ticketDAO = new TicketDAO(connection);
         ticket = ticketDAO.BuscaDadosDeCaixaPorCodigo(ticket);
        
      
       int permanencia = calculaPermanencia(ticket);
       
        
       
       ticket.setPermanencia(permanencia);

      
        double valorHora= Double.parseDouble(view.getjTextFieldValorPorHora().getText());
     
        String chegada = ticket.getHoraChegadaFormatada();
   
       
       //seta no ticket o valor a ser cobrado
        ticket.setValorHora(valorHora);
        
   
        
        //calcula valor a cobrar e seta no ticket
        NumberFormat formatter = new DecimalFormat("0.00");
        
        double valorPagar =(valorHora/60)* ticket.getPermanencia();
       ticket.setValor(valorPagar);
       
     

       
       //seta as labels: horaEntrada, valorAPagar 
       view.getjLabelHoraEntrada().setText(chegada);
       
        String total = formatter.format(valorPagar);
        
        view.getjLabelValorAPagar1().setText(total);
      
      
      
      
      
      
            
             ticketDAO.update(ticket);
            
        }
        
        
    public int calculaPermanencia(Ticket ticket) throws SQLException, ClassNotFoundException{
        
        
         //buscar ticket com todos os dados no banco e pegar horario de saida
       
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
        public boolean ticketExiste(int cod) throws SQLException, ClassNotFoundException{
            
          
       Connection connection = conexao.getConnection();
       TicketDAO ticketDAO = new TicketDAO(connection);
       return ticketDAO.selectExistePorCodigo(cod);
           
        
        
    }
    public String buscaNomeUsuarioLogado() throws SQLException, ClassNotFoundException{
        
         Connection connection = conexao.getConnection();
        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
       return  usuarioDAO.selectUsuarioLogado().getNome();
        
    }

    public void receber() throws SQLException, ClassNotFoundException {
            CaixaHelper helper = new CaixaHelper(view);
            String textFieldValorPago = "";
            double valorPagar =0;
            
            if(view.getjTextFieldValorPago().getText().equals("")|| view.getjLabelValorAPagar().getText() == null || view.getjTextFieldValorPago().getText().equals("0")){
                
                textFieldValorPago = view.getjLabelValorAPagar1().getText().replace(",", ".");
                
                
            }else{
                
                  textFieldValorPago = view.getjTextFieldValorPago().getText();
                
                
            }
            
            
        if ("".equals(view.getjTextFieldCodigo().getText())){
            
            JOptionPane.showMessageDialog(null, "Informe o codigo do ticket.");
            
             }else{
            
            if ("0".equals(view.getjTextFieldCodigo().getText())){
                
                  JOptionPane.showMessageDialog(null, "Informe o codigo do ticket.");
                
            }else{
             Ticket ticket = helper.obterModelo();
                
        Connection connection = conexao.getConnection();
        TicketDAO ticketDAO = new TicketDAO(connection);
         ticket = ticketDAO.selectPorCod(ticket.getCod());
         
       if(ticket == null){
           JOptionPane.showMessageDialog(null, "Ticket invalido.");
           
           
       }else{
        
        double valorPago;
        double troco;
        double valorHora= Double.parseDouble(view.getjTextFieldValorPorHora().getText());
         valorPagar = (valorHora/60)* ticket.getPermanencia();
         
         if(ticket.getPermanencia()<20){
             valorPagar=0;
             valorPago=0;
             troco=0;
         }else{
         
         
         valorPago= Double.parseDouble(textFieldValorPago);
         troco =  valorPago - valorPagar ;
        
         }
        
        
        
        
        if(troco <0){
            
            JOptionPane.showMessageDialog(null, "ERRO: O valor pago é inferior ao valor total!");
           
            
        }else{
            
        
        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
        Usuario usuario = usuarioDAO.selectUsuarioLogado();
        
         NumberFormat formatter = new DecimalFormat("0.00");
        String total = formatter.format(valorPago);
        String sTroco= formatter.format(troco);
        String vPagar= formatter.format(valorPagar);
        
        ticket.setValorHora(valorHora);
        ticket.setValor(valorPagar);
        ticketDAO.updateSemUsuario(ticket);
        String mensagem = "Confirmar pagamento de Ticket  N° "+ticket.getCod()+"?\n"+"VALOR R$"+
                vPagar+"\n"+"Valor pago: R$"+total+"\nTROCO: R$"+sTroco+"\nRECEBIDO POR:"+usuario.getNome();
                
                
                
                
    
        
        if(JOptionPane.showConfirmDialog(null, mensagem,"Confirmação:", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==  JOptionPane.YES_OPTION){
         
            //registra usuario no ticket
            ticket.setUsuario(usuario);
       
             //zerar permanencia 
             ticket.setPermanencia(0);
             
             // setar a chegada para o momento do pagamento do ticket
             DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            LocalDateTime agora = LocalDateTime.now();
            LocalDateTime entrada= LocalDateTime.parse(agora.format(f), f);
            String chegada = entrada.format(f);
             ticket.setChegada(chegada);
            
            ticketDAO.update(ticket);
        
             
             
                JOptionPane.showMessageDialog(null, "Ticket recebido com sucesso.");
               
        helper.limparTela();
        
            }else{
        
        
            JOptionPane.showMessageDialog(null, "Pagamento cancelado.");
            
            
        }
        
        
    }
   }
 }
}
    }    
}
    
    

