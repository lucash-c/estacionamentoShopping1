/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.helper;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import model.Ticket;
import view.CaixaView;

/**
 *
 * @author lucas
 */
public class CaixaHelper implements InterfaceHelper {
     private final CaixaView view;

    public CaixaHelper(CaixaView view) {
        this.view = view;
    }

    @Override
    public Ticket obterModelo() {
    String cod = view.getjTextFieldCodigo().getText();
    int codigo = Integer.parseInt(cod);
     
      return  new Ticket(codigo);
          
          
      }
      
      
      
    

    @Override
    public void limparTela() {
        view.getjLabelHoraEntrada().setText("");
        view.getjLabelValorAPagar().setText("");
        view.getjTextFieldValorPago().setText("0");
        view.getjTextFieldCodigo().setText("");
        view.getjLabelValorAPagar1().setText("");
    }

   
    
   /* public boolean receber(Ticket ticket){
        
        double valorPago= 0; 
        
       if("".equals(view.getjTextFieldValorPago().getText())|| view.getjTextFieldValorPago().getText()=="0"){
           
           valorPago = Double.parseDouble(view.getjLabelValorAPagar1().getText().replace(",", "."));
       }else
        
        valorPago = Double.parseDouble(view.getjTextFieldValorPago().getText());
        double troco = valorPago - ticket.getValor();
               
        
        
        
        String mensagem = "Confirmar pagamento de Ticket N°"+ticket.getCod()+"/n"+"VALOR R$"+
                ticket.getValor()+"/n"+" RECEBIDO POR:"+ticket.getUsuario().getNome();
                
                
                
                
    
        
        if(JOptionPane.showConfirmDialog(null, mensagem,"Confirmação:", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==  JOptionPane.YES_OPTION){
               
                
                JOptionPane.showMessageDialog(null, "Ticket recebido com sucesso.");
                
                return true;
            }else{
            
            
            
            return false;
            
            
            
        }
        */
        
       
        
    }
    


    

  
     
     
     
     
     
     

