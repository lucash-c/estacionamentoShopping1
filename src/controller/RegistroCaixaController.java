/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.helper.RegistroCaixaHelper;
import dao.Conexao;
import dao.TicketDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.Ticket;
import view.RegistroCaixaView;

/**
 *
 * @author lucas
 */
public class RegistroCaixaController {
    
   private final RegistroCaixaView view ;

    public RegistroCaixaController(RegistroCaixaView view) {
        this.view = view;
    }
    
    public void preencherTabela() throws SQLException, ClassNotFoundException{
        
       Conexao conexao = new Conexao();
       TicketDAO ticketDAO = new TicketDAO(conexao.getConnection());
       ArrayList<Ticket> tickets = ticketDAO.selectRegistraHistorico();
        
       if(tickets.isEmpty()){
           
           
           JOptionPane.showMessageDialog(null, "Registro vazio.");
           
       }
       RegistroCaixaHelper helper = new RegistroCaixaHelper(view);
      helper.preencherTabela(tickets);
        
        
    }

    
   
 

   

    
    
    
    
    
}
