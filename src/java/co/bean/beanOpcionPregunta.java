
package co.bean;


import co.dao.Operaciones;
import co.dto.OpcionPregunta;
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
public class beanOpcionPregunta implements  Serializable{
     private String opcionunica;
     
     public void guardaOpcionPregunta(){
     if (opcionunica == null || opcionunica.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "El campo OpcPregunta esta vacio ¡Llenalo!"));
            
            return;
        }
     OpcionPregunta o = new OpcionPregunta();
    o.setOpcionunica(opcionunica);
    
    
    Operaciones oper= new Operaciones();
    int rta=oper.guardaOpcionPregunta(o);
    System.out.println("rta "+rta);
    if(rta==1){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "REGISTRO", "Se ha resgitrado la pregunta y respuestas correctamente."));
       
        }
        if(rta==0){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "REGISTRO", "No se ha resgitrado la pregunta y respuestas correctamente."));
        
        }
     }

    public String getOpcionunica() {
        return opcionunica;
    }

    public void setOpcionunica(String opcionunica) {
        this.opcionunica = opcionunica;
    }
     
     
}
