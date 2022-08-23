/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.helper.LoginHelper;
import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;

import view.LoginView;
import view.MenuPrincipalView;

/**
 *
 * @author lucas
 */
public class LoginController {
    
private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

       
 
    
    public void entrarNoSistema() throws SQLException, ClassNotFoundException{
      
   
    //busca modelo
    LoginHelper loginHelper = new LoginHelper(view);
    Usuario modelo = loginHelper.obterModelo();
    
    
    
    //verificar se existe no banco de dados
        Connection conexao = new Conexao().getConnection();
       
    
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
             modelo = usuarioDAO.existeNoBancoPorNomeESenha(modelo);
             
             
             
          
            
        
        if(modelo!= null){
                //se existir direciona para menu
       MenuPrincipalView menuPrincipalView = new MenuPrincipalView();
        menuPrincipalView.setVisible(true);
            view.dispose();
            usuarioDAO.insertHistoricoLogin(modelo);
        }
        else{
        JOptionPane.showMessageDialog(view, "Usuario ou senha invalidos!");
        }
    }
}
