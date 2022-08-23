/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.helper.EditarExcluirUsuarioHelper;
import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Usuario;
import view.EditarExcluirUsuarioView;

/**
 *
 * @author lucas
 */
public class EditarExcluirUsuarioController {
    EditarExcluirUsuarioView view;
 Conexao conexao = new Conexao();
 
 
    public EditarExcluirUsuarioController(EditarExcluirUsuarioView view) {
        this.view = view;
    }
    
    public void preencherComboBox() throws SQLException, ClassNotFoundException{
        
        EditarExcluirUsuarioHelper helper = new EditarExcluirUsuarioHelper(view);
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao.getConnection());
        ArrayList<Usuario> usuarios =usuarioDAO.selectAll();
        
        ArrayList<String> nomeUsuario = new ArrayList<>();
        
        for (Usuario usuario : usuarios) {
            
            
            nomeUsuario.add(usuario.getNome());
            
        }
        
        helper.preenchercomboBox(nomeUsuario);
        
        
        
        
        
        
    }
    public void preencherCampos() throws SQLException, ClassNotFoundException{
         EditarExcluirUsuarioHelper helper = new EditarExcluirUsuarioHelper(view);
         String nomeUsuario = helper.obterNomeUsuario();
        
          UsuarioDAO usuarioDAO = new UsuarioDAO(conexao.getConnection());
        Usuario usuario = usuarioDAO.selectPorNome(nomeUsuario);
        
        helper.preencherCampos(usuario);
        
        
        
    }

    public void excluirUsuario() throws SQLException, ClassNotFoundException {
        EditarExcluirUsuarioHelper helper = new EditarExcluirUsuarioHelper(view);
         String nomeUsuario = helper.obterNomeUsuario();
         
         UsuarioDAO usuarioDAO = new UsuarioDAO(conexao.getConnection());
        usuarioDAO.deletePorNome(nomeUsuario);
        JOptionPane.showMessageDialog(null, "O Usuario foi excluido com sucesso.");
       view.dispose();
         
        
    }

    public void editaUsuario() throws SQLException, ClassNotFoundException {
         EditarExcluirUsuarioHelper helper = new EditarExcluirUsuarioHelper(view);
         Usuario usuario = helper.buscaCampos();
         
         UsuarioDAO usuarioDAO = new UsuarioDAO(conexao.getConnection());
        usuarioDAO.update(usuario);
        
        JOptionPane.showMessageDialog(null, "Os dados do Usuario foram atualizados com sucessso.");
       view.dispose();
         
         
    }
    
    
}
