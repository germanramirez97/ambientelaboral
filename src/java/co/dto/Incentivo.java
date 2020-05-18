/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dto;

import java.sql.Date;


public class Incentivo {
    
    private  int id;
    private String incentivo;
    private  Date fechaincentivo;
    
    
    public Incentivo(){
        
    }

    public Incentivo(int id, String incentivo, Date fechaincentivo) {
        this.id = id;
        this.incentivo = incentivo;
        this.fechaincentivo = fechaincentivo;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIncentivo() {
        return incentivo;
    }

    public void setIncentivo(String incentivo) {
        this.incentivo = incentivo;
    }

    public Date getFechaincentivo() {
        return fechaincentivo;
    }

    public void setFechaincentivo(Date fechaincentivo) {
        this.fechaincentivo = fechaincentivo;
    }
    
}
