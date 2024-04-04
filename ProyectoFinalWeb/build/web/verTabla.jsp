<%-- 
    Document   : verTabla
    Created on : 24-feb-2024, 14:22:41
    Author     : ConoMaster
--%>

<%@page import="Model.Manga"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% HttpSession misesion = request.getSession();
    if (misesion.getAttribute("usuarioConectado") == null) {
        response.sendRedirect("index.html");
    } else {%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabla</title>
        <link rel="stylesheet" href="CSS/style.css">
    </head>
    <body>
        <header>
            <nav>
                <ul>
                    <li><a href="paginaprincipal.jsp">Inicio</a></li>
                    <li><a href="ServletArticulos">Ver Articulos</a></li>
                    <li id="desconectarLink"><a>Desconectar</a></li>
                </ul>
            </nav>
            <script src="JavaScript/eventoDesconexion.js"></script>
        </header>
        <main>
            <section class="contenedorTabla">
                <table class="tabla">
                    <thead>
                    <th>Nombre</th>
                    <th>Autor</th>
                    <th>Genero</th>
                    <th>Numero de volumenes</th>
                    <th>Estado</th>
                    <th>Fecha de publicacion</th>
                    </thead>
                    <tbody>
                        <% ArrayList<Manga> mangas = (ArrayList<Manga>) request.getSession().getAttribute("mangas");
                            for (Manga m : mangas) {
                        %>
                        <tr>
                            <td> <%=m.getTitulo()%></td>
                            <td> <%=m.getAutor()%></td>
                            <td> <%=m.getGenero()%></td>
                            <td> <%=m.getNumVolumenes()%></td>
                            <td><%=m.getEstado()%></td>
                            <td> <%=m.getFechaPublicacion().toString()%></td>  
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </section>
        </main>

    </body>
</html>
<%}%>