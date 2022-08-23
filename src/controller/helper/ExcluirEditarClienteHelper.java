/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.helper;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import model.Cliente;
import view.ExcluirEditarClienteView;

/**
 *
 * @author lucas
 */
public class ExcluirEditarClienteHelper implements InterfaceHelper {
  
    private final ExcluirEditarClienteView view;

    public ExcluirEditarClienteHelper(ExcluirEditarClienteView view) {
        this.view = view;
    }
    
     public void preencherComboBox(ArrayList<String> clientes){
        
        DefaultComboBoxModel comboBoxModelClientes = (DefaultComboBoxModel) view.getjComboBoxClientes().getModel();
        
        comboBoxModelClientes.removeAllElements();
        
        for (String cliente : clientes) {
            
            comboBoxModelClientes.addElement(cliente);
            
        
        
        
    }
    
    
}

    @Override
    public Object obterModelo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limparTela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String obterNomeCliente() {
 return (String) view.getjComboBoxClientes().getSelectedItem();   
    
    }
    
    public void preencherCampos(Cliente cliente){
       
        view.getjTextFieldCodigo().setText(cliente.getCodigo()+"");
        view.getjTextFieldMensalidade().setText(cliente.getMensalidade()+"");
        view.getjTextFieldNome().setText(cliente.getNome());
        view.getjTextFieldRg().setText(cliente.getRg());
        view.getjTextFieldTelefone().setText(cliente.getTelefone());
        view.getjTextFieldVencimento().setText(cliente.getVencimento());
        view.getjRadioButtonBloquearCliente().getModel().setSelected(cliente.getBloqueado());
        view.getjTextAreaObservacao().setText(cliente.getObservacao());
        
    }

    public Cliente buscaCampos() {
        
String vencimento = view.getjTextFieldVencimento().getText();
String telefone = view.getjTextFieldTelefone().getText();
String rg = view.getjTextFieldRg().getText();
String nome = view.getjTextFieldNome().getText();
double mensalidade = Double.parseDouble(view.getjTextFieldMensalidade().getText());
int codigo = Integer.parseInt(view.getjTextFieldCodigo().getText());
boolean bloqueado = view.getjRadioButtonBloquearCliente().getModel().isSelected();
String observacao = view.getjTextAreaObservacao().getText();

return new Cliente(codigo, nome, telefone, rg, mensalidade, vencimento, bloqueado, observacao);

    }



}
    
    
    


    
    
    
    
    
    
    

