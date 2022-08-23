/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.helper;

import model.Usuario;
import view.LoginView;

/**
 *
 * @author lucas
 */
public class LoginHelper implements InterfaceHelper {
    
   private LoginView view;

    public LoginHelper(LoginView view) {
        this.view = view;
    }
    
    @Override
    public Usuario obterModelo(){
        
        String nome = view.getjTextFieldUsuario().getText();
     String senha = view.getjPasswordFieldSenha().getText();
        
        
        return new Usuario (nome,senha);
        
    }

    @Override
    public void limparTela() {
        
    }
    
}
