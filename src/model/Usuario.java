/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lucas
 */
public class Usuario {
    
    private int id;
    private String nome;
    private String rg;
    private String senha;
    private String cargo;

    public Usuario(int id, String nome, String rg, String senha, String cargo) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.senha = senha;
        this.cargo = cargo;
    }

    
    
    
    
    
    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    
    public Usuario(String nome,  String rg, String senha, String cargo) {
        this.nome = nome;
        this.senha = senha;
        this.cargo = cargo;
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }
    
    
    
}
