/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.helper;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import model.Usuario;
import view.EditarExcluirUsuarioView;

/**
 *
 * @author lucas
 */
public class EditarExcluirUsuarioHelper implements InterfaceHelper {
    
     private EditarExcluirUsuarioView view;

    public EditarExcluirUsuarioHelper(EditarExcluirUsuarioView view) {
        this.view = view;
    }
    
    public void preenchercomboBox(ArrayList<String> usuarios){
        
        DefaultComboBoxModel comboBoxModelUsuarios = (DefaultComboBoxModel) view.getjComboBoxUsuarios().getModel();
        
        comboBoxModelUsuarios.removeAllElements();
        
        for (String usuario : usuarios) {
            
            comboBoxModelUsuarios.addElement(usuario);
            
        
        
        
    }
    
    
}

    public String obterNomeUsuario() {
       return (String) view.getjComboBoxUsuarios().getSelectedItem();
        
    }

    public void preencherCampos(Usuario usuario) {
        view.getjTextFieldRg().setText(usuario.getRg());
        view.getjTextFieldNome().setText(usuario.getNome());
        view.getjTextFieldCargo().setText(usuario.getCargo());
        view.getjPasswordFieldSenha().setText(usuario.getSenha());
        




    }

    public Usuario buscaCampos() {
        
      String rg =  view.getjTextFieldRg().getText();
      String nome = view.getjTextFieldNome().getText();
      String cargo = view.getjTextFieldCargo().getText();
      String senha= view.getjPasswordFieldSenha().getText();
      
      return new Usuario (nome, rg, senha, cargo);
                
        
        
        
        
        
    }

    @Override
    public Object obterModelo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limparTela() {
    }
}
