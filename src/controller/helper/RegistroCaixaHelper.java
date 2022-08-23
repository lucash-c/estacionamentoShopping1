/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.helper;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Ticket;
import view.RegistroCaixaView;

/**
 *
 * @author lucas
 */
public class RegistroCaixaHelper {
    
       private final RegistroCaixaView view ;

    public RegistroCaixaHelper(RegistroCaixaView view) {
        this.view = view;
    }



    public void preencherTabela(ArrayList<Ticket> tickets) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTable1().getModel();
        tableModel.setNumRows(0);
        
             String coluna1 = "";
             String coluna2 = "";
             String coluna3 = "";
             double coluna4 = 0;
        
         for( Ticket ticket : tickets){
             
             
             
        if(ticket.getSaida()==null){
            
             coluna1 = ticket.getDataHoraChegadaFormatada();
             coluna2 ="--";
             coluna3 =ticket.getVaga().getTipo();
             coluna4 =ticket.getValor();
        }else{
             
             coluna1 = ticket.getDataHoraChegadaFormatada();
             coluna2 =ticket.getDataHoraSaidaFormatada();
             coluna3 =ticket.getVaga().getTipo();
             coluna4 =ticket.getValor();
             
        }
          
                     
             tableModel.addRow(new Object[] {
                  
                 coluna1,
                 coluna2,
                 coluna3,
                 coluna4
             
                 
                 
                
                  
                         });
        
        
    }
    
    }
}
    

