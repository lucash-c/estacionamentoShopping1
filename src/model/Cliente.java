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


public class Cliente {
            int codigo;
            String nome; 
            String telefone ;
            String rg ;
            double mensalidade ;
            String vencimento ;
            boolean bloqueado;
            String observacao;

    public Cliente(String nome, String telefone, String rg, double mensalidade, String vencimento, boolean bloqueado, String observacao) {
        this.nome = nome;
        this.telefone = telefone;
        this.rg = rg;
        this.mensalidade = mensalidade;
        this.vencimento = vencimento;
        this.bloqueado = bloqueado;
        this.observacao = observacao;
    }
            
            

    public Cliente(int codigo, String nome, String telefone, String rg, double mensalidade, String vencimento, boolean bloqueado, String observacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.rg = rg;
        this.mensalidade = mensalidade;
        this.vencimento = vencimento;
        this.bloqueado = bloqueado;
        this.observacao = observacao;
    }

    public Cliente(int codigo, String nome, String telefone, String rg, double mensalidade, String vencimento, boolean bloqueado) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.rg = rg;
        this.mensalidade = mensalidade;
        this.vencimento = vencimento;
        this.bloqueado = bloqueado;
    }

    public Cliente(String nome, String telefone, String rg, double mensalidade, String vencimento, String observacao) {
        this.nome = nome;
        this.telefone = telefone;
        this.rg = rg;
        this.mensalidade = mensalidade;
        this.vencimento = vencimento;
        this.observacao = observacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

  
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
            
            
            
            
            
            
            
}
