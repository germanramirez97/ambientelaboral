<%-- 
    Document   : Guiaguar
    Created on : 26/05/2020, 11:21:40 AM
    Author     : German
--%>


<%@page import="co.dto.Guia"%>
<%@page import="co.dao.Operaciones"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
        <title>JSP Page</title>
    </head>
    <body style="background-image:url(images/bg.jpg)">
    <center>
        <h1 style="color: #ffffff">Guias y Rutinas Ambiente Laboral</h1>
    </center>

    <%
        Operaciones op = new Operaciones();
        Guia guia = new Guia();
        ArrayList<Guia> listar = op.ListarGuias();
    %>

    <div class="datagrid">
        <table>
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Guia</th>
                    <th></th>
                </tr>
            </thead>
            <tfoot>
                <tr>
                    <td colspan="4">

                </tr>
            </tfoot>
            <tbody>
                <%if (listar.size() > 0) {
                        for (Guia listar2 : listar) {
                            guia = listar2;
                %>
                <tr>
                    <td><%=guia.getCodigoguia()%></td>
                    <td><%=guia.getNombreguia()%></td>
                    <td>
                        <%
                            if (guia.getArchivoguia()!= null) {
                        %>
                        <a href="Guias?id=<%=guia.getCodigoguia()%>" target="_blank"><img src="images/mpdf.png" title="Guias"/></a>
                            <%
                                } else {
                                    out.print("");
                                }
                            %>
                    </td>
                    <td>
                        <a id="mostrar" href="GuiaControlador?action=insert&id=<%=guia.getCodigoguia()%>"> <img src="images/nuevo.png" title="Nuevo registro"/></a>-
                        <a href="GuiaControlador?action=edit&id=<%=guia.getCodigoguia()%>"> <img src="images/editar.png" title="Modificar"/></a>-
                        <a href="GuiaControlador?action=delete&id=<%=guia.getCodigoguia()%>"> <img src="images/delete.png" title="Eliminar"/></a>
                    </td>
                </tr>
                <%}
                    }%>
            </tbody>
        </table>
    </div>
            
            <a href="app/PaginaAdministrador.xhtml" style="color: #ffffff">Volver </a>
</body>
</html>
