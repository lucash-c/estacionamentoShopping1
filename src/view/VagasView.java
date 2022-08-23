/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.VagasController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author lucas
 */
public class VagasView extends javax.swing.JFrame {
    
 VagasController controller = new VagasController(this);
    /**
     * Creates new form Vagas
     */
    public VagasView()  {
        initComponents();
        atualiza();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldQuantidadeVagas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxTipoVaga = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVagasDisponiveis = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCapacidadeTotal = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldFileira = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jComboBoxDescricaoFileira = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VInteligent - Gerenciar Vagas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldQuantidadeVagas.setText("0");
        jTextFieldQuantidadeVagas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQuantidadeVagasActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldQuantidadeVagas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 100, -1));

        jLabel1.setText("Descrição da fileira:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel2.setText("Quantidade de vagas:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        jLabel3.setText("Tipo de vaga:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        jComboBoxTipoVaga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COMUM", "PREFERENCIAL", "MENSALISTA" }));
        getContentPane().add(jComboBoxTipoVaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 100, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 10, 570));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel4.setText("Vagas Disponiveis:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, -1));

        jTableVagasDisponiveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fileira", "Comum", "Preferencial", "Mensalista", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableVagasDisponiveis);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 540, 200));

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add Vagas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 220, 30));

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel5.setText("Adicionar Vagas");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        jTableCapacidadeTotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fileira", "Comum", "Preferencial", "Mensalista", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableCapacidadeTotal);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 540, 200));

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel6.setText("Capacidade Atual:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        jLabel7.setText("Adicionar/Excluir Fileira");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 270, -1));

        jLabel8.setText("Descrição da fileira:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jTextFieldFileira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFileiraActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldFileira, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 70, 30));

        jButton2.setBackground(new java.awt.Color(51, 51, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Add Fileira");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 220, 30));

        getContentPane().add(jComboBoxDescricaoFileira, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 100, -1));

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Excluir Vagas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 220, 30));

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Excluir Fileira");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 220, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldQuantidadeVagasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeVagasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQuantidadeVagasActionPerformed

    private void jTextFieldFileiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFileiraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFileiraActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
        if( !"".equals(this.getjTextFieldFileira().getText())) {
      try {
         controller.addNovaFileira();
           atualiza();
            JOptionPane.showMessageDialog(null, "Fileira adicionada com sucesso.");
     } catch (SQLException ex) {
         Logger.getLogger(VagasView.class.getName()).log(Level.SEVERE, null, ex);
     }      catch (ClassNotFoundException ex) {
                Logger.getLogger(VagasView.class.getName()).log(Level.SEVERE, null, ex);
            }

}else{
        JOptionPane.showMessageDialog(null, "Digite uma descrição para a fileira.");
}
        
        
           

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if( "".equals(this.getjTextFieldQuantidadeVagas().getText()) ) {  
    JOptionPane.showMessageDialog(null, "Digite a quantidade de vagas que deseja adicionar.");
         
       }else
            
          if("0".equals(this.getjTextFieldQuantidadeVagas().getText())){
              
              JOptionPane.showMessageDialog(null, "Digite a quantidade de vagas que deseja adicionar.");
              
              
              
          }else{
        
            try {
                controller.addVagas();
            } catch (SQLException ex) {
                Logger.getLogger(VagasView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VagasView.class.getName()).log(Level.SEVERE, null, ex);
            }
           atualiza();
           JOptionPane.showMessageDialog(null, "Vagas adicionadas com sucesso.");
       
        
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

      
        
           if(JOptionPane.showConfirmDialog(null, "Deseja excluir as vagas selecionadas?","Confirmação:", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==  JOptionPane.YES_OPTION){
           
           
        
         
         
               try {
                   if(controller.excluirVagas()){
                       
                       JOptionPane.showMessageDialog(null, "As vagas indicadas foram excluidas com sucesso.");
                       
                       atualiza();
                   }else{
                       
                       JOptionPane.showMessageDialog(null, "ERRO: A quantidade indicada é nula ou superior a quantidade de vagas existentes.");
                       
                       
                   }     } catch (SQLException ex) {
                   Logger.getLogger(VagasView.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(VagasView.class.getName()).log(Level.SEVERE, null, ex);
               }
         
         
         
         

           
           
           
           
           }
        
        
    
        
        
    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

          if(JOptionPane.showConfirmDialog(null, "Deseja excluir a fileira selecionada?","Confirmação:", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==  JOptionPane.YES_OPTION){
        
              try {
                  if(controller.excluirFileira()){
                      
                      JOptionPane.showMessageDialog(null, "A fileira indicada foi excluida com sucesso.");
                      atualiza();
                  }
                  else{
                      
                      
                      JOptionPane.showMessageDialog(null, "A fileira indicada não existe.");
                      
                      
                  }     } catch (SQLException ex) {
                  Logger.getLogger(VagasView.class.getName()).log(Level.SEVERE, null, ex);
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(VagasView.class.getName()).log(Level.SEVERE, null, ex);
              }

          }
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(VagasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VagasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VagasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VagasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VagasView().setVisible(true);
            }
        });
        
    }

    public JTextField getjTextFieldFileira() {
        return jTextFieldFileira;
    }

    public void setjTextFieldFileira(JTextField jTextFieldFileira) {
        this.jTextFieldFileira = jTextFieldFileira;
    }

    public JComboBox<String> getjComboBoxDescricaoFileira() {
        return jComboBoxDescricaoFileira;
    }

    public void setjComboBoxDescricaoFileira(JComboBox<String> jComboBoxDescricaoFileira) {
        this.jComboBoxDescricaoFileira = jComboBoxDescricaoFileira;
    }

    public JComboBox<String> getjComboBoxTipoVaga() {
        return jComboBoxTipoVaga;
    }

    public void setjComboBoxTipoVaga(JComboBox<String> jComboBoxTipoVaga) {
        this.jComboBoxTipoVaga = jComboBoxTipoVaga;
    }

    public JTextField getjTextFieldQuantidadeVagas() {
        return jTextFieldQuantidadeVagas;
    }

    public void setjTextFieldQuantidadeVagas(JTextField jTextFieldQuantidadeVagas) {
        this.jTextFieldQuantidadeVagas = jTextFieldQuantidadeVagas;
    }

    public JTable getjTableCapacidadeTotal() {
        return jTableCapacidadeTotal;
    }

    public void setjTableCapacidadeTotal(JTable jTableCapacidadeTotal) {
        this.jTableCapacidadeTotal = jTableCapacidadeTotal;
    }

    public JTable getjTableVagasDisponiveis() {
        return jTableVagasDisponiveis;
    }

    public void setjTableVagasDisponiveis(JTable jTableVagasDisponiveis) {
        this.jTableVagasDisponiveis = jTableVagasDisponiveis;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBoxDescricaoFileira;
    private javax.swing.JComboBox<String> jComboBoxTipoVaga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableCapacidadeTotal;
    private javax.swing.JTable jTableVagasDisponiveis;
    private javax.swing.JTextField jTextFieldFileira;
    private javax.swing.JTextField jTextFieldQuantidadeVagas;
    // End of variables declaration//GEN-END:variables

    private void atualiza()   {
        
     
     try {
           
         controller.buscaFileiras();
          controller.atualizaTabela();
     } catch (SQLException ex) {
         Logger.getLogger(VagasView.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(VagasView.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
}
