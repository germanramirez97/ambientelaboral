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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Eduardo
 */

@ManagedBean
@ViewScoped
public class beanUsuario implements Serializable {
 static final Logger LOG = LogManager.getLogger(beanUsuario.class);    
    private String usuario;
    private String contra;
    private String nombre;
    private String apellido;
    private Integer cedula;
    private Integer nivel;

    public void guardaUsuario(){
        if (usuario == null || usuario.isEmpty() || contra == null || contra.isEmpty() || nombre == null || nombre.isEmpty()|| null == apellido || apellido.isEmpty()|| cedula == null || nivel == null ){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Algunos campos estan vacios ¡Llenalos!"));
            LOG.info("Algunos campos estan vacios ¡Llenalos!");
            return;
        }
    Usuario u = new Usuario();
    u.setUsuario(usuario);
    u.setContra(contra);
    u.setNombre(nombre);
    u.setApellido(apellido);
    u.setCedula(cedula);
    u.setNivel(nivel);
    
    Operaciones oper= new Operaciones();
    int rta=oper.guardaUsu(u);
    System.out.println("rta "+rta);
    if(rta==1){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "REGISTRO", "Se ha resgitrado correctamente."));
        LOG.info("Se ha resgitrado correctamente.");
        }
        if(rta==0){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "REGISTRO", "No se ha resgitrado correctamente."));
        LOG.info("No se ha resgitrado correctamente.");
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

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
    

    public String salir() {
        return "index";
    }
}
