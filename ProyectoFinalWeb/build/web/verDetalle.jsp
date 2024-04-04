<%-- 
    Document   : verDetalle
    Created on : 26-feb-2024, 20:31:04
    Author     : ConoMaster
--%>

<%@page import="Model.Manga"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% HttpSession misesion = request.getSession();
    if (misesion.getAttribute("usuarioConectado") == null) {
        response.sendRedirect("index.html");
    } else {%>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Detalle del Artículo</title>
        <link rel="stylesheet" href="CSS/verDetalleStyle.css">
    </head>
    <body>
        <header>
            <h1>Detalle del Artículo</h1>
        </header>
        <main>
            <%Manga mangaSeleccionado = (Manga) request.getSession().getAttribute("mangaSeleccionado");%>
            <section class="contenedorDatosManga">
                <img src="Imagenes/<%= mangaSeleccionado.getImagen()%>" alt="<%= mangaSeleccionado.getTitulo()%>">
                <div class="card">
                    <div class="card2"></br></br>

                        <h2><%= mangaSeleccionado.getTitulo()%></h2>
                        <p>Autor: <%= mangaSeleccionado.getAutor()%></p>
                        <p>Género: <%= mangaSeleccionado.getGenero()%></p>
                        <p>Fecha de publicación: <%= mangaSeleccionado.getFechaPublicacion()%></p>
                        <p>Numero de volumenes: <%= mangaSeleccionado.getNumVolumenes()%></p>
                        <p>Estado <%= mangaSeleccionado.getEstado()%></p>
                        <p>Puntuacion <%= mangaSeleccionado.getPuntaje()%></p>
                        <p>Precio: <%= mangaSeleccionado.getPrecio()%>€</p>

                        <form class="form" action="calcularCampo" method="POST">
                            <div class="form-title"><span>Ingresa un nuevo</span></div>
                            <div class="title-2"><span>PRECIO</span></div>
                            <div class="input-container">
                                <input class="input-number" min="0" name="nuevoPrecio" type="number" placeholder="Introduce el nuevo precio">
                                <span> </span>
                            </div>

                            <section class="bg-stars">
                                <span class="star"></span>
                                <span class="star"></span>
                                <span class="star"></span>
                                <span class="star"></span>
                            </section>

                            <button type="submit" class="submit">
                                <span class="sign-text">Adelante!</span>
                            </button>


                        </form>
                    </div>
                </div>


            </section>
        </main>
    </body>
</html>
</html>
<%}%>