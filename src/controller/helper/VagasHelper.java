/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.helper;

import dao.Conexao;
import dao.FileiraDAO;
import dao.VagaDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.Fileira;
import model.Vaga;
import view.VagasView;

/**
 *
 * @author lucas
 */
public class VagasHelper implements InterfaceHelper {
    
   private final VagasView view;

    public VagasHelper(VagasView view) {
        this.view = view;
    }

    @Override
    public Vaga  obterModelo()  {
       
      Conexao conexao = new Conexao();
         FileiraDAO fileiraDAO;
       try {
           fileiraDAO = new FileiraDAO (conexao.getConnection());
           
           
         String descricaoFileira = (String)view.getjComboBoxDescricaoFileira().getSelectedItem();
        int fileiraId = fileiraDAO.buscaIdFileiraPorDescricao(descricaoFileira);
        
          
        String tipoVaga = (String)view.getjComboBoxTipoVaga().getSelectedItem();
           
             Vaga vaga = new Vaga(tipoVaga, fileiraId);
      //retorna uma vaga com tipo e id da fileira
       return vaga;
           
       } catch (SQLException ex) {
           Logger.getLogger(VagasHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(VagasHelper.class.getName()).log(Level.SEVERE, null, ex);
           return null;
       }
         
       
         
         
            
          
          
             
     
       } 
         
     
    

    @Override
    public void limparTela() {
        view.getjTextFieldFileira().setText("");
        view.getjTextFieldQuantidadeVagas().setText("");
        
    }
   
    
    
    public Fileira obterFileira() {
        String descricao = view.getjTextFieldFileira().getText();
        return new Fileira(descricao);
        
    }
    public Fileira obterFileiraComboBox(){
        
        String descricao = (String) view.getjComboBoxDescricaoFileira().getSelectedItem();
        return new Fileira(descricao);
        
        
    }
    
    public void preencherComboBox(ArrayList<String> fileiras) {
        
        
        
        DefaultComboBoxModel comboBoxModelFileira = (DefaultComboBoxModel) view.getjComboBoxDescricaoFileira().getModel();
        
        comboBoxModelFileira.removeAllElements();
        
        for (String fileira : fileiras) {
            
            comboBoxModelFileira.addElement(fileira);
            
            
        }
    }

    public void preencherTabela(ArrayList<Vaga> vagas) throws SQLException, ClassNotFoundException {
       
    DefaultTableModel tableModel = (DefaultTableModel) view.getjTableCapacidadeTotal().getModel();
    DefaultTableModel tableModel1 = (DefaultTableModel) view.getjTableVagasDisponiveis().getModel();
        tableModel.setNumRows(0);
        tableModel1.setNumRows(0);
        
       Conexao conexao = new Conexao();
        
       VagaDAO vagaDAO = new VagaDAO(conexao.getConnection());
       FileiraDAO fileiraDAO = new FileiraDAO (conexao.getConnection());
       
             
       

         ArrayList<String> fileiras = new  ArrayList<>();       
        fileiras = fileiraDAO.buscaDescricaoDasFileiras();
        //percorrer a lista de agendamentos prenchendo a tabela
        
        
        int i = 0;
        
         for( String fileira : fileiras){
             
             
             
             tableModel.addRow(new Object[] {
                  
                 fileiras.get(i),
                 vagaDAO.selectVagasPorTipoEporId("COMUM", fileiraDAO.buscaIdFileiraPorDescricao(fileiras.get(i))).size(),
                 vagaDAO.selectVagasPorTipoEporId("PREFERENCIAL", fileiraDAO.buscaIdFileiraPorDescricao(fileiras.get(i))).size(),
                 vagaDAO.selectVagasPorTipoEporId("MENSALISTA", fileiraDAO.buscaIdFileiraPorDescricao(fileiras.get(i))).size(),
                 vagaDAO.selectVagasPorTipoEporId("COMUM", fileiraDAO.buscaIdFileiraPorDescricao(fileiras.get(i))).size()+vagaDAO.selectVagasPorTipoEporId("PREFERENCIAL", fileiraDAO.buscaIdFileiraPorDescricao(fileiras.get(i))).size()+vagaDAO.selectVagasPorTipoEporId("MENSALISTA", fileiraDAO.buscaIdFileiraPorDescricao(fileiras.get(i))).size()
                  
                  
                         });
             
              tableModel1.addRow(new Object[] {
               fileiras.get(i),
                vagaDAO.selectVagasPorTipoEporFileiraDisp("COMUM", fileiraDAO.buscaIdFileiraPorDescricao(fileiras.get(i))).size(),
                vagaDAO.selectVagasPorTipoEporFileiraDisp("PREFERENCIAL", fileiraDAO.buscaIdFileiraPorDescricao(fileiras.get(i))).size(),
                vagaDAO.selectVagasPorTipoEporFileiraDisp("MENSALISTA", fileiraDAO.buscaIdFileiraPorDescricao(fileiras.get(i))).size(),
                vagaDAO.selectVagasPorTipoEporFileiraDisp("COMUM", fileiraDAO.buscaIdFileiraPorDescricao(fileiras.get(i))).size()+vagaDAO.selectVagasPorTipoEporFileiraDisp("PREFERENCIAL", fileiraDAO.buscaIdFileiraPorDescricao(fileiras.get(i))).size()+vagaDAO.selectVagasPorTipoEporFileiraDisp("MENSALISTA", fileiraDAO.buscaIdFileiraPorDescricao(fileiras.get(i))).size()  
                  
              });
             
             i++;
             
         }
        
  
        }

   
      public int buscaQuantidadeDeVagas(){
          
          if("".equals(view.getjTextFieldQuantidadeVagas().getText())){
              
              
              return 0;
              
          }else{
              
              
           return   Integer.parseInt(view.getjTextFieldQuantidadeVagas().getText());  
        
              
              
          }
                    
              
          }
    
    
    
    
    
    
    }
   

