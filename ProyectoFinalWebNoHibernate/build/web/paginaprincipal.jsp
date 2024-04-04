<%-- 
    Document   : paginaprincipal
    Created on : 23-feb-2024, 18:46:20
    Author     : ConoMaster
--%>

<%@page import="Model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página principal</title>
        <link rel="stylesheet" href="CSS/style.css">
    </head>
    <body>
        <header>
            <nav>
                <ul>
                    <li><a href="ServletArticulos">Ver Articulos</a></li>
                    <li><a href="ServletTabla">Ver tabla</a></li>
                    <li id="desconectarLink"><a>Desconectar</a></li>
                </ul>
            </nav>
            <script src="JavaScript/eventoDesconexion.js"></script>
        </header>
        <main>
            <%Usuario user = (Usuario)request.getSession().getAttribute("usuarioConectado");%>
            <h1>Bienvenido <%= user.getNombreUsuario()%></h1>
            <div class="contenedorUsuario">
                <h1>En este apartado verás los datos de usuario</h1>
                
                <section class="datosUsuario">
                    <article>Nombre: <%=user.getNombreUsuario() %></article>
                    <article>Correo: <%=user.getCorreoElectronico() %></article>
                    <article>Fecha de ingreso: <%=user.getFechaIngreso().toString()%></article>
                    <article>Precio de todos los mangas(campo autocalculado): <%=user.getPrecioTotal()%></article>
                </section>
            </div>
        </main>

    </body>
</html>
