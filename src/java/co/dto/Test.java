/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dto;

import co.dto.Pregunta;
import java.util.ArrayList;

/**
 *
 * @author German
 */
public class Test {
    private int idTest;
    private String nombre;
    ArrayList<Pregunta>Listapreguntas;
    
    
 
    public Test(){
        
    }

    public Test(int idTest, String nombre, ArrayList<Pregunta> Listapreguntas) {
        this.idTest = idTest;
        this.nombre = nombre;
        this.Listapreguntas =  new ArrayList<Pregunta>();
    }

    public ArrayList<Pregunta> getListapreguntas() {
        return Listapreguntas;
    }

    public void setListapreguntas(ArrayList<Pregunta> Listapreguntas) {
        this.Listapreguntas = Listapreguntas;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }
   
}
