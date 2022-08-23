/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import controller.helper.VagasHelper;
import dao.Conexao;
import dao.FileiraDAO;
import dao.VagaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Fileira;
import model.Vaga;
import view.VagasView;

/**
 *
 * @author lucas
 */
public class VagasController {
    
   private final VagasView view;
   VagasHelper helper;
    


    public VagasController(VagasView view) {
        this.view = view;
    }
    
    
    
    public void buscaFileiras() throws SQLException, ClassNotFoundException {
        
        Conexao conexao = new Conexao();
       Connection connection = conexao.getConnection();
       
       FileiraDAO fileiraDAO = new FileiraDAO(connection);
        
        helper = new VagasHelper(view);
        helper.preencherComboBox(fileiraDAO.buscaDescricaoDasFileiras());
        
       
        
        
    }
    
    
    
    
    public void addVagas() throws SQLException, ClassNotFoundException{
       
        Conexao conexao = new Conexao();
       Connection connection = conexao.getConnection();
       VagaDAO vagaDAO = new VagaDAO(connection);
       FileiraDAO fileiraDAO = new FileiraDAO(connection);
       
        helper = new VagasHelper(view);
        
      int qtd = helper.buscaQuantidadeDeVagas();
        
       
       int fileiraId = helper.obterModelo().getFileiraId();
       ArrayList<Vaga> vagasParaAdd = new ArrayList<> ();
      
        for (int i = 0; i < qtd; i++) {
            
            vagasParaAdd.add(helper.obterModelo());
        }
     
        
        
      
       Fileira fileira = helper.obterFileiraComboBox();
               
       
       
     
       
       fileira = fileiraDAO.pesquisaFileiraPorDescricao(fileira.getDescricao());
       
       
       // fazer um select no banco com as vagas existentes nessa fileira
       
        ArrayList<Vaga> vagasQueVieramDoBanco = fileiraDAO.buscaVagasDoBancoPorFileira(fileira);
       ArrayList<Vaga> vagasAtualizadas = new ArrayList<>();
       fileira.setVagas(vagasQueVieramDoBanco);
       
       
           vagasAtualizadas =  fileira.getVagas();
           
            
       for (Vaga vag : vagasParaAdd) {
           
          
            vag.setEstado(0);
            
          vagasAtualizadas.add(vag);
         
          
        }
   

     fileira.setDescricao(fileira.getDescricao());
     fileira.setVagas(vagasAtualizadas);
     vagaDAO.insertVagas(vagasParaAdd);
       vagaDAO.atualizaIdVagas(fileira.getId());
      
     helper.limparTela();
     
    }
    
    public void addNovaFileira() throws SQLException, ClassNotFoundException{
        
         helper = new VagasHelper(view);
       Fileira fileira = helper.obterFileira();
        
       Conexao conexao = new Conexao();
       Connection connection = conexao.getConnection();
       
       FileiraDAO fileiraDAO = new FileiraDAO(connection);
       fileiraDAO.insert(fileira);
       
         helper.limparTela();
        
    }
    
    public void atualizaTabela() throws SQLException, ClassNotFoundException{
    
        //Buscar Lista com as vagas do banco de dados
      Conexao conexao = new Conexao();
       Connection connection = conexao.getConnection();
       
       VagaDAO vagaDAO = new VagaDAO(connection);
        
        
    
    ArrayList<Vaga> vagas = vagaDAO.selectAll();
    
        // Exibir lista na view
        helper.preencherTabela(vagas);
    }

    public boolean excluirVagas() throws SQLException, ClassNotFoundException {
        
          helper = new VagasHelper(view);
        Vaga vaga = helper.obterModelo();
        
        int qtd= helper.buscaQuantidadeDeVagas();
    
      Conexao conexao = new Conexao();
       Connection connection = conexao.getConnection();
       
       VagaDAO vagaDAO = new VagaDAO(connection);
        if(vagaDAO.delete(vaga,qtd)){
            
            
           
             vagaDAO.atualizaIdVagas(vaga.getFileiraId());
             atualizaTabela();
             helper.limparTela();
            return true;
      
            
        }else{
            return false;
        }
      
    }
    
    
    public boolean excluirFileira() throws SQLException, ClassNotFoundException{
        helper = new VagasHelper(view);
        String descricaoFileira = helper.obterFileira().getDescricao();
        
              
        if("".equals(descricaoFileira)){
            
            return false;
        }else{
        
        Conexao conexao = new Conexao();
       Connection connection = conexao.getConnection();
       
       VagaDAO vagaDAO = new VagaDAO(connection);
       FileiraDAO fileiraDAO = new FileiraDAO(connection);
        atualizaTabela();
        helper.limparTela();
        return vagaDAO.deleteFileira(fileiraDAO.buscaIdFileiraPorDescricao(descricaoFileira));
            
            
           
            
        }
            
        }
        
    
    
    
    
}
