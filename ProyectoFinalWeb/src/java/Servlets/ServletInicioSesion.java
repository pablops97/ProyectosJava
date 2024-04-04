/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.UsuarioDaoImplement;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
@WebServlet(name = "ServletInicioSesion", urlPatterns = {"/ServletInicioSesion"})
public class ServletInicioSesion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombreUsuario = request.getParameter("nombre");
        String contrasenia = request.getParameter("contrasenia");
        
        System.out.println(nombreUsuario + ":" + contrasenia);
               
        
        UsuarioDaoImplement gestionUsuario = new UsuarioDaoImplement();
        Usuario usuarioConectado = gestionUsuario.obtenerUsuario(nombreUsuario, contrasenia);
        HttpSession misesion = request.getSession();

        if(usuarioConectado != null){
//            misesion.setAttribute("nombreUsuario", nombreUsuario);
//            misesion.setAttribute("idUsuario", usuarioConectado.getId());
            misesion.setAttribute("usuarioConectado", usuarioConectado);
            response.sendRedirect("paginaprincipal.jsp");
            System.out.println(usuarioConectado);
        }else{
            response.sendRedirect("validacionerronea.jsp");
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
