/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dto;

/**
 *
 * @author Eduardo
 */
public class Usuario {
    
    private String usuario;
    private String contra;
    private String nombre;
    private String apellido;
    private int cedula;

    public Usuario() {
    }

    public Usuario(String usuario, String contra, String nombre, String apellido, int cedula) {
        this.usuario = usuario;
        this.contra = contra;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", contra=" + contra + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + '}';
    }
}
