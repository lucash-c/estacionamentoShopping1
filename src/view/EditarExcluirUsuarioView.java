/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EditarExcluirUsuarioController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author lucas
 */
public class EditarExcluirUsuarioView extends javax.swing.JFrame {
EditarExcluirUsuarioController controller= new EditarExcluirUsuarioController(this);
    /**
     * Creates new form EditarExcluirUsuario
     */
    public EditarExcluirUsuarioView() {
        initComponents();
        iniciar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxUsuarios = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldRg = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCargo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jButtonExcluir = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VInteligent - Editar Usuarios");

        jComboBoxUsuarios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxUsuariosItemStateChanged(evt);
            }
        });
        jComboBoxUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUsuariosActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario:");

        jLabel2.setText("Nome");

        jTextFieldRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRgActionPerformed(evt);
            }
        });

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jLabel3.setText("RG");

        jLabel4.setText("Cargo");

        jTextFieldCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCargoActionPerformed(evt);
            }
        });

        jLabel5.setText("Senha");

        jPasswordFieldSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldSenhaActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20)
                        .addComponent(jComboBoxUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jButtonEditar)
                        .addGap(39, 39, 39)
                        .addComponent(jButtonExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldRg, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(243, 243, 243))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(jTextFieldRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonExcluir)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRgActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jTextFieldCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCargoActionPerformed

    private void jPasswordFieldSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldSenhaActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed

           if(JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o usuario selecionado?","Confirmação:", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==  JOptionPane.YES_OPTION){
           
    try {
        controller.excluirUsuario();
    } catch (SQLException ex) {
        Logger.getLogger(EditarExcluirUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(EditarExcluirUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
    }



    }//GEN-LAST:event_jButtonExcluirActionPerformed
    }
    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed

           if(JOptionPane.showConfirmDialog(null, "Deseja realmente atualizar as informações deste usuario?","Confirmação:", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==  JOptionPane.YES_OPTION){
           
    try {
        controller.editaUsuario();
        
        
        // TODO add your handling code here:
    } catch (SQLException ex) {
        Logger.getLogger(EditarExcluirUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(EditarExcluirUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
    }}
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jComboBoxUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUsuariosActionPerformed

    }//GEN-LAST:event_jComboBoxUsuariosActionPerformed

    private void jComboBoxUsuariosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxUsuariosItemStateChanged
    try {
        controller.preencherCampos();
    } catch (SQLException ex) {
        Logger.getLogger(EditarExcluirUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(EditarExcluirUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
    }

    }//GEN-LAST:event_jComboBoxUsuariosItemStateChanged
    
    public JPasswordField getjPasswordFieldSenha() {
        return jPasswordFieldSenha;
    }

    public JComboBox<String> getjComboBoxUsuarios() {
        return jComboBoxUsuarios;
    }

    public void setjComboBoxUsuarios(JComboBox<String> jComboBoxUsuarios) {
        this.jComboBoxUsuarios = jComboBoxUsuarios;
    }

    public void setjPasswordFieldSenha(JPasswordField jPasswordFieldSenha) {
        this.jPasswordFieldSenha = jPasswordFieldSenha;
    }

    public JTextField getjTextFieldCargo() {
        return jTextFieldCargo;
    }

    public void setjTextFieldCargo(JTextField jTextFieldCargo) {
        this.jTextFieldCargo = jTextFieldCargo;
    }

    public JTextField getjTextFieldNome() {
        return jTextFieldNome;
    }

    public void setjTextFieldNome(JTextField jTextFieldNome) {
        this.jTextFieldNome = jTextFieldNome;
    }

    public JTextField getjTextFieldRg() {
        return jTextFieldRg;
    }

    public void setjTextFieldRg(JTextField jTextFieldRg) {
        this.jTextFieldRg = jTextFieldRg;
    }

    /**
     * @param args the command line arguments
     */
   
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarExcluirUsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarExcluirUsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarExcluirUsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarExcluirUsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarExcluirUsuarioView().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JComboBox<String> jComboBoxUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldCargo;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldRg;
    // End of variables declaration//GEN-END:variables

 public void iniciar() {
    try {
        
     
        controller.preencherComboBox();
        controller.preencherCampos();
        
        
        
        
    } catch (SQLException ex) {
        Logger.getLogger(EditarExcluirUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(EditarExcluirUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
        
    }


}