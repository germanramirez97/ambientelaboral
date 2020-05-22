/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.bean;

import co.dao.Operaciones;
import co.dto.Pregunta;
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
public class BeanPregunta implements Serializable{
    static final Logger LOG = LogManager.getLogger(beanUsuario.class);
    private String textoPregunta;
   
    
    public void guardaPregunta(){
        if (textoPregunta == null || textoPregunta.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Algunos campos estan vacios ¡Llenalos!"));
            LOG.info("Algunos campos de pregunta estan vacios ¡Llenalos!");
            return;
        }
    Pregunta p = new Pregunta();
    p.setTextoPregunta(textoPregunta);
    
    
    Operaciones oper= new Operaciones();
    int rta=oper.guardaPregunta(p);
    System.out.println("rta "+rta);
    if(rta==1){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "REGISTRO", "Se ha resgitrado la pregunta y respuestas correctamente."));
        LOG.info("Se ha resgitrado correctamente.");
        }
        if(rta==0){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "REGISTRO", "No se ha resgitrado la pregunta y respuestas correctamente."));
        LOG.info("No se ha resgitrado correctamente.");
        }
    }

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }    
}
