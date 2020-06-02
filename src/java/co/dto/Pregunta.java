/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dto;




public class Pregunta {
    private String textoPregunta;
    private String respuestaPregunta;
    private boolean tipoPregunta;
    private String contenidoPregunta;
    private OpcionPregunta opcionpregunta;
    
    
    
    public Pregunta(){
        
    }

    public Pregunta(String textoPregunta, String respuestaPregunta, boolean tipoPregunta, String contenidoPregunta, OpcionPregunta opcionpregunta) {
        this.textoPregunta = textoPregunta;
        this.respuestaPregunta = respuestaPregunta;
        this.tipoPregunta = tipoPregunta;
        this.contenidoPregunta = contenidoPregunta;
        this.opcionpregunta = opcionpregunta;
    }

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

    public String getRespuestaPregunta() {
        return respuestaPregunta;
    }

    public void setRespuestaPregunta(String respuestaPregunta) {
        this.respuestaPregunta = respuestaPregunta;
    }

    public boolean isTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(boolean tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public String getContenidoPregunta() {
        return contenidoPregunta;
    }

    public void setContenidoPregunta(String contenidoPregunta) {
        this.contenidoPregunta = contenidoPregunta;
    }

    public OpcionPregunta getOpcionpregunta() {
        return opcionpregunta;
    }

    public void setOpcionpregunta(OpcionPregunta opcionpregunta) {
        this.opcionpregunta = opcionpregunta;
    }
    
}
