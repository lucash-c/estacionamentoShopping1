/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class Fileira {
    
    private ArrayList<Vaga> vagas;
    private String descricao;
    private int id;

    public Fileira(ArrayList<Vaga> vagas, String descricao) {
        this.vagas = vagas;
        this.descricao = descricao;
     
    }

    public Fileira(ArrayList<Vaga> vagas, int id) {
        this.vagas = vagas;
        this.id = id;
    }

    public Fileira(ArrayList<Vaga> vagas, int id, String descricao) {
        this.vagas = vagas;
        this.descricao = descricao;
        this.id = id;
    }

  
   
    

    public Fileira(String descricao) {
        this.descricao = descricao;
    }

    
    
    
    public ArrayList<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(ArrayList<Vaga> vagas) {
        this.vagas = vagas;
    }
     


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

    
    
    
   
    
    
    }
    

