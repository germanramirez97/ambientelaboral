/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.bean;

import co.dao.Operaciones;
import co.dto.Incentivo;
import co.dto.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author German
 */
@ManagedBean
@ViewScoped
public class ListasBean implements Serializable {

    private List<Usuario> usuario;
    private List<Incentivo> incentivos;

    private Operaciones inc;
    private Operaciones usu;

    public ListasBean() {
        inc = new Operaciones();
        usu = new Operaciones();

    }

    @PostConstruct
    public void init() {
        incentivos = cargIncentivo();
        usuario=cargUsuarios();

    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    public List<Incentivo> getIncentivos() {
        return incentivos;
    }

    public void setIncentivos(List<Incentivo> incentivos) {
        this.incentivos = incentivos;
    }

    public Operaciones getInc() {
        return inc;
    }

    public void setInc(Operaciones inc) {
        this.inc = inc;
    }

    public Operaciones getUsu() {
        return usu;
    }

    public void setUsu(Operaciones usu) {
        this.usu = usu;
    }

   private List<Usuario>cargUsuarios(){
      
       return usu.ListarUsuario();
}
   
   private List<Incentivo>cargIncentivo(){
      
       return inc.ListarIncentivo();
}
   
   public String salir(){
       return "PaginaAdministrador";
    }
}