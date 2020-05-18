/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.bean;

import co.dao.Operaciones;
import co.dto.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Eduardo
 */

@ManagedBean
@ViewScoped
public class beanUsuario implements Serializable {

    private String usuario;
    private String contra;
    private String nombre;
    private String apellido;
    private int cedula;

    public void guardaUsuario(){
    Usuario u = new Usuario();
    u.setUsuario(usuario);
    u.setContra(contra);
    u.setNombre(nombre);
    u.setApellido(apellido);
    u.setCedula(cedula);
    
    Operaciones oper= new Operaciones();
    int rta=oper.guardaUsu(u);
    System.out.println("rta "+rta);
    if(rta==1){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "REGISTRO", "Se ha resgitrado correctamente."));
        }
        if(rta==0){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "REGISTRO", "No se ha resgitrado correctamente."));
        }
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

    public String salir() {
        return "index";
    }
}
