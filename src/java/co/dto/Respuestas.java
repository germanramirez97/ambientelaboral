/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dto;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author German
 */
public class Respuestas {
   
    ArrayList<Respuestas>listarespuestas;
    private Date fecharespuestas;
    
    
    public Respuestas(){
        
    }
    

    public Respuestas(ArrayList<Respuestas> listarespuestas, Date fecharespuestas) {
        this.listarespuestas = new ArrayList<Respuestas>();
        this.fecharespuestas = fecharespuestas;
    }

    public ArrayList<Respuestas> getListarespuestas() {
        return listarespuestas;
    }

    public void setListarespuestas(ArrayList<Respuestas> listarespuestas) {
        this.listarespuestas = listarespuestas;
    }

    public Date getFecharespuestas() {
        return fecharespuestas;
    }

    public void setFecharespuestas(Date fecharespuestas) {
        this.fecharespuestas = fecharespuestas;
    }
    
    
    
}
