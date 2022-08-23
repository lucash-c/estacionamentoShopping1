/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.helper.CadastroUsuarioHelper;
import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.CadastroUsuarioView;

/**
 *
 * @author lucas
 */
public class CadastroUsuarioController {
    
    private CadastroUsuarioView view;

    public CadastroUsuarioController(CadastroUsuarioView view) {
        this.view = view;
    }
    
    public void cadastrarUsuario() throws SQLException, ClassNotFoundException{
                   
                
        CadastroUsuarioHelper helper = new CadastroUsuarioHelper(view);
        Usuario usuario = helper.obterModelo();
                 
        
        Conexao conexao = new Conexao();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao.getConnection());
        
       
        
        if(usuarioDAO.existeNoBancoPorNomeESenha(usuario)!= null){
        
        JOptionPane.showMessageDialog(null, "Este usuario ja existe no banco.");
        
        }
        
        else
        {
        usuarioDAO.insert(usuario);
        
        JOptionPane.showMessageDialog(null, "Novo usuario cadastrado com sucesso!");
        helper.limparTela();
        view.dispose();
        
        }
        
        
        
        
    }
}
