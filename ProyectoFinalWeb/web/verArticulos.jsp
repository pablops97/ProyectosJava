<%-- 
    Document   : verArticulos
    Created on : 24-feb-2024, 14:22:29
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
        <title>Artículos</title>
        <link rel="stylesheet" href="CSS/style.css">

    </head>
    <body>
        <header>
            <nav>
                <ul>
                    <li><a href="paginaprincipal.jsp">Inicio</a></li>
                    <li><a href="ServletTabla">Ver tabla</a></li>
                    <li id="desconectarLink"><a>Desconectar</a></li>
                </ul>
            </nav>
            <script src="JavaScript/eventoDesconexion.js"></script>
        </header>
        <main>
            <section class="cards">
                <% ArrayList<Manga> mangas = (ArrayList<Manga>) request.getSession().getAttribute("mangas");
                    for (Manga m : mangas) {
                %>

                <article class="card" onclick="redirectToVerDetalle('<%=m.getId()%>')">
                    <img src="Imagenes/<%=m.getImagen()%>" alt="<%=m.getTitulo()%>">
                    <% System.out.println(m.getImagen());%>
                    <h2><%=m.getTitulo()%></h2>
                    <p>Autor: <%=m.getAutor()%></p>
                    <p>Genero: <%=m.getGenero()%></p>
                    <p>Fecha de salida: <%=m.getFechaPublicacion().toString()%></p>
                    <p>Precio: <%=m.getPrecio()%></p>
                </article>
                <%}%>
            </section>
            <script>
                //metodo para mandarle datos a la pagina detalle al hacer clic en el elemento div
                function redirectToVerDetalle(idManga) {
                    window.location.href = "ServletVerDetalle?idManga=" + idManga;
                }
            </script>
        </main>
    </body>
</html>
<%}%>
