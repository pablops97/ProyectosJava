/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.Manga;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ConoMaster
 */
public class ControladorManga {

    Connection conex = null;
    ResultSet rs = null;

    public ControladorManga() {
        try {
            conex = ConexionBD.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Manga> obtenerMangasPorUsuario(int idUsuario) throws SQLException {
        String SQLConsult = "SELECT * FROM MANGA WHERE id_usuario = ?";
        PreparedStatement ps = conex.prepareStatement(SQLConsult);
        ps.setInt(1, idUsuario);
        rs = ps.executeQuery();
        ArrayList<Manga> mangas = new ArrayList();
        while (rs.next()) {
            mangas.add(new Manga(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getDouble(11)));
        }
        close();
        return mangas;
    }

    public Manga obtenerMangaEsepecifico(int idManga) throws SQLException {
        Manga manga = null;
        String consultaSQL = "SELECT * FROM MANGA WHERE id = ?";
        PreparedStatement ps = conex.prepareStatement(consultaSQL);
        ps.setInt(1, idManga);
        rs = ps.executeQuery();
        while (rs.next()) {
            manga = new Manga(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getDouble(11));
        }

        return manga;
    }

    public void close() {
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarPrecioManga(double precioNuevo, int id) throws SQLException {

        String consultaUpdate = "UPDATE manga SET PRECIO = ? WHERE ID = ?";
        PreparedStatement ps = conex.prepareStatement(consultaUpdate);
        ps = conex.prepareStatement(consultaUpdate);
        ps.setDouble(1, precioNuevo);
        ps.setInt(2, id);
        int columnasModificadas = ps.executeUpdate();
        System.out.println("Han sido modificadas " + columnasModificadas + " columnas con exito");

    }
}
