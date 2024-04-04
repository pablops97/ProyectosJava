/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.MangaDaoImplement;
import Dao.UsuarioDaoImplement;
import Model.Manga;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ConoMaster
 */
@WebServlet(name = "ServletCampoCalculado", urlPatterns = {"/calcularCampo"})
public class ServletCampoCalculado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession misesion = request.getSession();
        //este servlet es para la ventana de detalles, donde puedo modificar el precio del manga y eso afecta al precio total del usuario
        //aqui tengo que modificar el usuario con el metodo para cambiarlo de la base de datos y luego redireccionar al servlet de articulos para que se actualice el precio
        if (misesion.getAttribute("usuarioConectado") != null) {
            //Seleccionamos el usuario logueado y el manga seleccionado
            Usuario usuario = (Usuario)misesion.getAttribute("usuarioConectado");
            Manga mangaSeleccionado = (Manga)misesion.getAttribute("mangaSeleccionado");
              
            int idUsuario = usuario.getId();
            double precioNuevo = Double.parseDouble(request.getParameter("nuevoPrecio"));
            
            //Modificamos el precio del manga
            MangaDaoImplement controladorManga = new MangaDaoImplement();
            controladorManga.modificarPrecioManga(precioNuevo, mangaSeleccionado.getId());
            
            //Modificamos el precio total del usuario
            UsuarioDaoImplement controlador = new UsuarioDaoImplement();
            controlador.campoCalculado(idUsuario);
            //Actualizamos el usuario para que se vea modificado el precio cuando accedo al apartado de la pagina principal
            usuario = controlador.obtenerUsuario(usuario.getNombreUsuario(), usuario.getContrasena());
            misesion.setAttribute("usuarioConectado", usuario);
            
            //redireccionamos al servlet de articulos
            response.sendRedirect("ServletArticulos");

        }else{
            response.sendRedirect("index.html");
        }


    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
