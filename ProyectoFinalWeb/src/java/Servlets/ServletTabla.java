/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.MangaDaoImplement;
import Model.Manga;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
            throws ServletException, IOException {
            HttpSession misesion = request.getSession();
            if(misesion.getAttribute("usuarioConectado") != null){
                MangaDaoImplement controlador = new MangaDaoImplement();
                Usuario user = (Usuario)misesion.getAttribute("usuarioConectado");
                int idUsuario = user.getId();
                ArrayList<Manga> mangasPorUsuario = controlador.obtenerMangaPorUsuario(idUsuario);
                misesion.setAttribute("mangas", mangasPorUsuario);
                response.sendRedirect("verTabla.jsp");
            }else{
                response.sendRedirect("index.html");
            }
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
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
