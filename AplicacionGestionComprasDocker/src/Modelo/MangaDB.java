/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ConexionBD;
import Controlador.MiExcepcion;
import Controlador.Utilidad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ConoMaster
 */
public class MangaDB {
    Statement stmt; 
    ResultSet rs;

    public MangaDB(ResultSet rs) {
        this.rs = rs;
    }
  
    public ArrayList<Manga> getMangas() throws MiExcepcion{
         ArrayList<Manga> mangas = new ArrayList<>();
        try {
            while (rs.next()) {
                mangas.add(new Manga (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getString(6)));
            }
            return mangas;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    public Manga getManga() throws MiExcepcion{
        Manga manga;
        try {
            manga = new Manga (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getString(6));
            return manga;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Manga obtenerManga(Manga m) throws SQLException, MiExcepcion{
        Manga manga;
        rs.first();
        while(rs.next()){
            if(rs.equals(m)){
                return new Manga(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getString(6));
            }
        }
        return null;
        
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
    
    
    public void cerrar(){
        try {
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
