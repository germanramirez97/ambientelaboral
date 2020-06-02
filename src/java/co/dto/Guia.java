/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dto;

import java.io.InputStream;

/**
 *
 * @author German
 */
public class Guia {
    
    int codigoguia;
    String nombreguia;
    InputStream archivoguias;
    private byte[] archivoguia;
    
    
    public Guia(){
        
    }
    
    public Guia(int id, String name, byte[] archivo) {
        this.codigoguia = id;
        this.nombreguia = name;
        this.archivoguia = archivo;
        
        
        
    }

    public int getCodigoguia() {
        return codigoguia;
    }

    public void setCodigoguia(int codigoguia) {
        this.codigoguia = codigoguia;
    }

    public String getNombreguia() {
        return nombreguia;
    }

    public void setNombreguia(String nombreguia) {
        this.nombreguia = nombreguia;
    }

    public InputStream getArchivoguias() {
        return archivoguias;
    }

    public void setArchivoguias(InputStream archivoguias) {
        this.archivoguias = archivoguias;
    }

    public byte[] getArchivoguia() {
        return archivoguia;
    }

    public void setArchivoguia(byte[] archivoguia) {
        this.archivoguia = archivoguia;
    }
    
    
    
}


