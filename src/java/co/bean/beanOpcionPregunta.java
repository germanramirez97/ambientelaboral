
package co.bean;

import static co.bean.BeanPregunta.LOG;
import co.dao.Operaciones;
import co.dto.OpcionPregunta;
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
public class beanOpcionPregunta {
     private String opcionunica;
     
     public void guardaOpcionPregunta(){
     if (opcionunica == null || opcionunica.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "El campo OpcPregunta esta vacio ¡Llenalo!"));
            LOG.info("El campo opcPregunta esta vacio ¡Llenalo!");
            return;
        }
     OpcionPregunta o = new OpcionPregunta();
    o.setOpcionunica(opcionunica);
    
    
    Operaciones oper= new Operaciones();
    int rta=oper.guardaOpcionPregunta(o);
    System.out.println("rta "+rta);
    if(rta==1){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "REGISTRO", "Se ha resgitrado la pregunta y respuestas correctamente."));
        LOG.info("Se ha resgitrado correctamente la Opcion de pregunta.");
        }
        if(rta==0){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "REGISTRO", "No se ha resgitrado la pregunta y respuestas correctamente."));
        LOG.info("No se ha resgitrado correctamente la Opcion de pregunta.");
        }
     }

    public String getOpcionunica() {
        return opcionunica;
    }

    public void setOpcionunica(String opcionunica) {
        this.opcionunica = opcionunica;
    }
     
     
}
