/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.helper;

import javax.swing.JTextField;
import model.Usuario;
import view.CadastroUsuarioView ;

/**
 *
 * @author lucas
 */
public class CadastroUsuarioHelper implements InterfaceHelper {
    
    private CadastroUsuarioView view;

    public CadastroUsuarioHelper(CadastroUsuarioView view) {
        this.view = view;
    }

    @Override
    public Usuario obterModelo() {
        
        String nome = view.getjTextFieldNomeUsuario().getText();
        String senha = view.getjPasswordFieldSenhaUsuario().getText();
        String rg = view.getjTextFieldRgUsuario().getText();
        String cargo = view.getjTextFieldCargoUsuario().getText();
        
     return new Usuario(nome,rg,senha,cargo);
                
                
        
   
        
    }

    @Override
    public void limparTela() {
        view.getjTextFieldNomeUsuario().setText("");
        view.getjPasswordFieldSenhaUsuario().setText("");
        view.getjTextFieldRgUsuario().setText("");
        view.getjTextFieldCargoUsuario().setText("");
    }
    
    
    
}
