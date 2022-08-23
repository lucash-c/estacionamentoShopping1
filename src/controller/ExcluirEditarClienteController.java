/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import controller.helper.ExcluirEditarClienteHelper;
import dao.ClienteDAO;
import dao.Conexao;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cliente;

import view.ExcluirEditarClienteView;

/**
 *
 * @author lucas
 */
public class ExcluirEditarClienteController {
    
    ExcluirEditarClienteView view;
    ExcluirEditarClienteHelper helper= new ExcluirEditarClienteHelper(view);
    
   Conexao conexao =  new Conexao();

    public ExcluirEditarClienteController(ExcluirEditarClienteView view) {
        this.view = view;
    }
    
    public void preencherComboBox() throws SQLException, ClassNotFoundException{
        
        
        
        
        ClienteDAO clienteDAO = new ClienteDAO(conexao.getConnection());
        ArrayList<Cliente> clientes =clienteDAO.selectAll();
        
        if( clientes == null){
            
             JOptionPane.showMessageDialog(null, "Não existe nenhum cliente cadastrado");
            
        }else{
        
         ExcluirEditarClienteHelper helper= new ExcluirEditarClienteHelper(view);
        ArrayList<String> nomeCliente = new ArrayList<>();
        
        for (Cliente cliente : clientes) {
            
            
            nomeCliente.add(cliente.getNome());
            
        }
        
        helper.preencherComboBox(nomeCliente);
        
        
        
        
        
        
    }
    }
    public void preencherCampos() throws SQLException, ClassNotFoundException{
        
       
      
        ClienteDAO clienteDAO = new ClienteDAO(conexao.getConnection());
         ExcluirEditarClienteHelper helper = new ExcluirEditarClienteHelper(view);
         String nomeCliente = helper.obterNomeCliente();
        
         
         Cliente cliente = clienteDAO.selectPorNome(nomeCliente);
        
          
         helper.preencherCampos(cliente);
    }

        
    public void excluirCliente() throws SQLException, ClassNotFoundException {
        ExcluirEditarClienteHelper helper = new ExcluirEditarClienteHelper(view);
        String nomeCliente = helper.obterNomeCliente();
        
          ClienteDAO clienteDAO = new ClienteDAO(conexao.getConnection());
          clienteDAO.deletePorNome(nomeCliente);
          JOptionPane.showMessageDialog(null, "O Cliente foi excluido com sucesso.");
          view.dispose();
             
             
    }

    public void editaCliente() throws SQLException, ClassNotFoundException {
       ExcluirEditarClienteHelper helper = new ExcluirEditarClienteHelper(view);
         Cliente cliente = helper.buscaCampos();
         
          ClienteDAO clienteDAO = new ClienteDAO(conexao.getConnection());
             clienteDAO.update(cliente);
             
              JOptionPane.showMessageDialog(null, "Os dados do Cliente foram atualizados com sucessso.");
       view.dispose();
         
         
    }
    public boolean isNull() throws SQLException, ClassNotFoundException{
        
         ClienteDAO clienteDAO = new ClienteDAO(conexao.getConnection());
             return clienteDAO.selectAll().isEmpty();
                 
            
        
        
        
    }
    
}