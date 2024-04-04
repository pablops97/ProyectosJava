<%-- 
    Document   : validacionerronea
    Created on : 23-feb-2024, 18:47:32
    Author     : ConoMaster
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error: Usuario no existe</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body class="cuerpoValidacionErronea">
    <div class="mensajeError">
        <h1>Error: Usuario no existe</h1>
        <p>Lo sentimos, el usuario que has ingresado no existe en nuestro sistema.</p>
        <button onclick="window.location.href = 'index.html';">Volver a la página de inicio de sesión</button>
    </div>

</body>
</html>
