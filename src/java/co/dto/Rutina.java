/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dto;


public class Rutina {
    
    private String tiporutina;
    private  int id;
    
    
    
    public   Rutina(){
        
    }

    public Rutina(String tiporutina, int id) {
        this.tiporutina = tiporutina;
        this.id = id;
    }

    public String getTiporutina() {
        return tiporutina;
    }

    public void setTiporutina(String tiporutina) {
        this.tiporutina = tiporutina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
