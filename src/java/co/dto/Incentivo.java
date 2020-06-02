/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dto;

import java.sql.Date;


public class Incentivo {
    
    private  int id;
    private  String incentivo;
    private  Date fechaincentivo;
    private Date fechafinal;
    
    
    public Incentivo(){
        
    }

    public Incentivo(int id, String incentivo, Date fechaincentivo, Date fechafinal) {
        this.id = id;
        this.incentivo = incentivo;
        this.fechaincentivo = fechaincentivo;
        this.fechafinal = fechafinal;
    }

    public Incentivo(int id, String nombre, Date date, java.util.Date fechafinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
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

    @Override
    public String toString() {
        return "Incentivo{" + "id=" + id + ", incentivo=" + incentivo + ", fechaincentivo=" + fechaincentivo + '}';
    }
    
    
}
