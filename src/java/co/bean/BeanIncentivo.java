/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.bean;

import co.dao.Operaciones;
import co.dto.Incentivo;
import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;
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
public class BeanIncentivo implements Serializable {

    private Integer id;
    private String incentivo;
    private Date fechaincentivo;
    private Date fechafinal;

    public void guardaIncentivo() {
        if (incentivo == null || incentivo.isEmpty() || id == null || fechaincentivo == null || fechafinal==null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Algunos campos estan vacios ¡Llenalos!"));

            return;
        }

        Incentivo i = new Incentivo();
        i.setId(id);
        i.setIncentivo(incentivo);
        i.setFechaincentivo(new java.sql.Date(fechaincentivo.getTime()));
        i.setFechafinal(new java.sql.Date(fechafinal.getTime()));

        Operaciones oper = new Operaciones();
        int rta = oper.guardIncentivo(i);
        System.out.println("rta " + rta);
        if (rta == 1) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "REGISTRO", "Se ha resgitrado el incentivo correctamente."));

        } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "REGISTRO", "No se ha resgitrado el incentivo correctamente."));

        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }
    
    

    public void onclick(Date date) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        System.out.println(dateFormat.format(date));
    }
}
