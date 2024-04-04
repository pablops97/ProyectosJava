/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.ControladorManga;
import Model.Manga;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "ServletTabla", urlPatterns = {"/ServletTabla"})
public class ServletTabla extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
            HttpSession misesion = request.getSession();
            if(misesion.getAttribute("usuarioConectado") != null){
                ControladorManga controlador = new ControladorManga();
                Usuario user = (Usuario)misesion.getAttribute("usuarioConectado");
                int idUsuario = user.getId();
                ArrayList<Manga> mangasPorUsuario = controlador.obtenerMangasPorUsuario(idUsuario);
                misesion.setAttribute("mangas", mangasPorUsuario);
                response.sendRedirect("verTabla.jsp");
            }else{
                response.sendRedirect("index.html");
            }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
