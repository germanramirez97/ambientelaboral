package co.bean;

import co.dao.Operaciones;
import co.dto.Administrador;
import co.dto.Usuario;
import java.io.Serializable;
import java.util.Map;
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
public class beanAdministrador implements Serializable {

    private String usuarioadm;
    private String contraadm;
    private String nombreadm;
    private String apellidoadm;
    private int cedula;
    private Map sesion = (Map) FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

//    public beanAdministrador() {
//    this.cedula=0;
//    this.usuarioadm=null; 
//    this.contraadm=null;
//    this.nombreadm=null;
//    this.apellidoadm=null;
//    }
    public void guardaAdministrador() {
        Administrador a = new Administrador();
        a.setUsuarioadm(usuarioadm);
        a.setContraadm(contraadm);
        a.setNombreadm(nombreadm);
        a.setApellidoadm(apellidoadm);
        a.setCedula(cedula);

        Operaciones oper = new Operaciones();
        int rta = oper.guardaAdm(a);
        System.out.println("rta " + rta);
        if (rta == 1) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "REGISTRO", "Se ha resgitrado correctamente."));
        }
        if (rta == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "REGISTRO", "No se ha resgitrado correctamente."));
        }
    }

    public String getUsuarioadm() {
        return usuarioadm;
    }

    public void setUsuarioadm(String usuarioadm) {
        this.usuarioadm = usuarioadm;
    }

    public String getContraadm() {
        return contraadm;
    }

    public void setContraadm(String contraadm) {
        this.contraadm = contraadm;
    }

    public String getNombreadm() {
        return nombreadm;
    }

    public void setNombreadm(String nombreadm) {
        this.nombreadm = nombreadm;
    }

    public String getApellidoadm() {
        return apellidoadm;
    }

    public void setApellidoadm(String apellidoadm) {
        this.apellidoadm = apellidoadm;
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

    public void verificarsesion() {
        try {
            Usuario usu = (Usuario) sesion.get("user");
            if (usu.getNivel() != 2) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("Sinpermisos.xhtml");
            } 
        } catch (Exception e) {
            
        }
    }
}
