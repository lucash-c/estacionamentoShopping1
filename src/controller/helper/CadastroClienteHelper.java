/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.helper;

import model.Cliente;

import view.CadastroClienteView;

/**
 *
 * @author lucas
 */
public class CadastroClienteHelper implements InterfaceHelper {
    
    private CadastroClienteView view;

    public CadastroClienteHelper(CadastroClienteView view) {
        this.view = view;
    }
    
    
    
    
    

    @Override
    public Cliente obterModelo() {
        
       
        String nome = view.getjTextFieldNome().getText();
        String telefone = view.getjTextFieldTelefone().getText();
        String rg = view.getjTextFieldRg().getText();        
        float mensalidade = Float.parseFloat(view.getjTextFieldMensalidade().getText());
        String vencimento = view.getjTextFieldVencimento().getText();
        String observacao = view.getjTextAreaObservacao().getText();
      
        return new Cliente(nome, telefone, rg, mensalidade, vencimento, observacao);
        
    }

    
    @Override
    public void limparTela() {
        view.getjTextFieldVencimento().setText("");
        view.getjTextFieldTelefone().setText("");
        view.getjTextFieldRg().setText("");
        view.getjTextFieldNome().setText("");
        view.getjTextFieldMensalidade().setText("");
      
        view.getjTextAreaObservacao().setText("");
        
    }
    
    
    
}
