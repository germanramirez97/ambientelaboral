/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.servlet;

import co.dao.Operaciones;
import co.dao.sql;
import co.dto.Guia;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author German
 */
@WebServlet(name = "GuiaControlador", urlPatterns = {"/GuiaControlador"})
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB

public class GuiaControlador extends HttpServlet {

    public static final String lIST_GUIA = "/Guiaguar.jsp";
    public static final String INSERT_OR_EDIT = "/Enviaguia.jsp";

    String estado = null;
    Operaciones operaciones;
    int id_guia = -1;

    public GuiaControlador() {
        operaciones = new Operaciones();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            forward = lIST_GUIA;
            int GuiaId = Integer.parseInt(request.getParameter("id"));
            operaciones.Eliminarguia(GuiaId);
        }
        if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int GuiasId = Integer.parseInt(request.getParameter("id"));
            id_guia = GuiasId;
            Guia o = operaciones.getguiaId(GuiasId);
            request.setAttribute("row", o);
            boolean boo = false;
            if (o.getArchivoguia() != null) {
                boo = true;
            }
            request.setAttribute("row2", boo);
            estado = "edit";
        } else if (action.equalsIgnoreCase("insert")) {
            forward = INSERT_OR_EDIT;
            estado = "insert";
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Guia guia = new Guia();
        sql auto = new sql();
        int nuevoid = auto.auto_increm("SELECT MAX(codigoguia) FROM guias");
        
        try{
            String name = request.getParameter("txtname");
            guia.setNombreguia(name);
        }catch(Exception ex){
            System.out.println("nombre de la guia: "+ex.getMessage());
        }

        InputStream inputStream = null;
        try {
            Part filePart = request.getPart("fichero");
            if (filePart.getSize() > 0) {
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());
                inputStream = filePart.getInputStream();
            }
        } catch (Exception ex) {
            System.out.println("fichero: "+ex.getMessage());
        }

        try {
            
            if (estado.equalsIgnoreCase("insert")) {
                guia.setCodigoguia(nuevoid);
                if (inputStream != null) {
                    guia.setArchivoguias(inputStream);
                }
                operaciones.AgregarGuias(guia);
            } else {
                guia.setCodigoguia(id_guia);
                if (inputStream != null) {
                    guia.setArchivoguias(inputStream);
                    operaciones.ModificaRGUIA(guia);
                } else {
                    operaciones.Modificar2(guia);
                }
            }
        } catch (Exception ex) {
            System.out.println("textos: "+ex.getMessage());
        }

        RequestDispatcher view = request.getRequestDispatcher("/Guiaguar.jsp");
        view.forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
