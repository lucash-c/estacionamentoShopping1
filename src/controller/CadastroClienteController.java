/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.helper.CadastroClienteHelper;
import dao.ClienteDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Cliente;
import view.CadastroClienteView;

/**
 *
 * @author lucas
 */
public class CadastroClienteController {
    private CadastroClienteView view;
    private CadastroClienteHelper helper;

    public CadastroClienteController(CadastroClienteView view) {
        this.view = view;
    }
    
    public void cadastraCliente() throws SQLException, ClassNotFoundException{
        
       
        String nome = view.getjTextFieldNome().getText();
        String telefone = view.getjTextFieldTelefone().getText();
        String rg = view.getjTextFieldRg().getText();        
        float mensalidade = Float.parseFloat(view.getjTextFieldMensalidade().getText());
        String vencimento = view.getjTextFieldVencimento().getText();
       
        
             if( nome == "" ){
            
           JOptionPane.showMessageDialog(null, "Digite o nome do cliente"); 
            
                }  
             else
                
              if( telefone == "" ){
            
           JOptionPane.showMessageDialog(null, "Digite o telefone do cliente"); 
            
                } 
              else
                  if( rg == "" ){
            
           JOptionPane.showMessageDialog(null, "Digite o rg do cliente"); 
            
                } 
              else
                      if( mensalidade == 0 ){
            
           JOptionPane.showMessageDialog(null, "Digite o valor da mensalidade do cliente"); 
            
                } 
                
                else
                          if( vencimento == "" ){
            
           JOptionPane.showMessageDialog(null, "Digite o dia de vencimento da mensalidade do cliente"); 
            
                } 
             else
                              
             helper =   new CadastroClienteHelper(view);
             Cliente cliente = helper.obterModelo();
             
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        
        ClienteDAO clienteDAO = new ClienteDAO(connection);
             clienteDAO.insert(cliente);
                
             helper.limparTela();
             JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso.");
             view.dispose();
             
    }
    
}
