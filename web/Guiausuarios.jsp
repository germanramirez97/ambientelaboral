<%-- 
    Document   : Guiausuarios
    Created on : 29/05/2020, 05:29:27 PM
    Author     : Nubia
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
        <h1 style="color: #ffffff"> Tus Guias</h1>
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
                            if (guia.getArchivoguia() != null) {
                        %>
                        <a href="Guias?id=<%=guia.getCodigoguia()%>" target="_blank"><img src="images/mpdf.png" title="Guias"/></a>
                            <%
                                } else {
                                    out.print("");
                                }
                            %>
                    </td>

                </tr>
                <%}
                    }%>
            </tbody>
        </table>
    </div>

            <a   href="app/PaginaUsuario.xhtml" style="color: #ffffff">Volver </a>
</body>
</html>
