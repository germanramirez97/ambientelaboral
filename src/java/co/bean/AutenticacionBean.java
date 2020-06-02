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
 * @author German
 */
@ManagedBean
@ViewScoped
public class AutenticacionBean implements Serializable {

    
    private String usuario;
    private String contraseña;

    public AutenticacionBean() {

    }

    public String ingresar() {
        if (usuario == null || usuario.isEmpty() || contraseña == null || contraseña.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Algunos campos estan vacios ¡Llenalos!"));
          
        }
        int valor;
        if (!"".equals(usuario) && !"".equals(contraseña)) {
            Operaciones op = new Operaciones();
            valor = op.loguear(usuario, contraseña);
            Usuario usu = new Usuario();
            usu.setNombre(usuario);
            usu.setContra(contraseña);
            usu.setNivel(valor);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usu);
            switch (valor) {
                case 1:
                    
                    return "PaginaUsuario";
                case 2:
                    
                    return "PaginaAdministrador";
            }
        }
        return "";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String registrar() {
        return "Usuario";
    }
}
