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
public class Vaga {
    
    
    private int id;
    private int indexFileira;
    private int estado; //1 para ocupado - 0 para desocupado
    private String tipo;
    private int fileiraId;

    public Vaga(int fileiraId) {
        this.fileiraId = fileiraId;
    }

    public Vaga(int id, int indexFileira, int estado, String tipo, int fileiraId) {
        this.id = id;
        this.indexFileira = indexFileira;
        this.estado = estado;
        this.tipo = tipo;
        this.fileiraId = fileiraId;
    }
    

    public Vaga(int id, int indexFileira, String tipo, int fileiraId) {
        this.id = id;
        this.indexFileira = indexFileira;
        this.tipo = tipo;
        this.fileiraId = fileiraId;
    }

    public Vaga(int id, int fileiraId) {
        this.id = id;
        this.fileiraId = fileiraId;
    }
   

    public Vaga( String tipo, int fileiraId, int id) {
        this.id = id;
        this.tipo = tipo;
        this.fileiraId = fileiraId;
    }

    
    public Vaga(String tipo,int fileiraId) {
      
        this.tipo = tipo;
        this.fileiraId = fileiraId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFileiraId() {
        return fileiraId;
    }

    public int getIndexFileira() {
        return indexFileira;
    }

    public void setIndexFileira(int indexFileira) {
        this.indexFileira = indexFileira;
    }

  

   
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
}
