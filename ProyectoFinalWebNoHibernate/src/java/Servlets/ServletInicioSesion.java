/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;


import Controlador.ControladorUsuario;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        HttpSession misesion = request.getSession();
               
        
        ControladorUsuario gestionUsuario = new ControladorUsuario();
        Usuario usuarioConectado;
        try {
            usuarioConectado = gestionUsuario.validarUsuario(nombreUsuario, contrasenia);
            if(usuarioConectado != null){

            misesion.setAttribute("usuarioConectado", usuarioConectado);
            response.sendRedirect("paginaprincipal.jsp");
        }else{
            response.sendRedirect("validacionerronea.jsp");
        }
        } catch (SQLException ex) {
            Logger.getLogger(ServletInicioSesion.class.getName()).log(Level.SEVERE, null, ex);
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
