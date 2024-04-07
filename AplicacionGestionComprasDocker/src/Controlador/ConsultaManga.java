/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Manga;
import Modelo.MangaDB;
import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ConoMaster
 */
public class ConsultaManga {
    PreparedStatement stmt; 
    ResultSet rs;
    
    public ConsultaManga(){
        try {
            String consultaSQL="SELECT * FROM MANGA ";
            stmt = ConexionBD.obtener().prepareStatement(consultaSQL);    
            System.out.println(consultaSQL);
            rs = stmt.executeQuery(consultaSQL);            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public boolean isLast() throws SQLException
    {
            return rs.isLast();
        
    }
    
    public boolean isFirst() throws SQLException
    {
        return rs.isFirst();
    }
    
    public Manga inicial() throws SQLException{
        
        Manga m = new Manga();
               
            rs.first();
            m.setId(rs.getInt("ID"));
            m.setNombreManga(rs.getString("NOMBRE_MANGA"));
            m.setDescripcion(rs.getString("DESCRIPCION"));
            m.setPrecio(rs.getInt("PRECIO"));
            m.setDescuento(rs.getInt("DESCUENTO"));
            m.setFoto(rs.getString("FOTO"));
            
        
        return m;
    }
    
    public Manga siguiente() throws SQLException{
        
        Manga m = new Manga();
        if (!rs.isLast()) {
            rs.next();
            m.setId(rs.getInt("ID"));
            m.setNombreManga(rs.getString("NOMBRE_MANGA"));
            m.setDescripcion(rs.getString("DESCRIPCION"));
            m.setPrecio(rs.getInt("PRECIO"));
            m.setDescuento(rs.getInt("DESCUENTO"));
            m.setFoto(rs.getString("FOTO")); 
        }

        return m;
    }
    
    public Manga atras() throws SQLException{
        
        Manga m = new Manga();     
        if (!rs.isFirst()) {
            rs.previous();
            m.setId(rs.getInt("ID"));
            m.setNombreManga(rs.getString("NOMBRE_MANGA"));
            m.setDescripcion(rs.getString("DESCRIPCION"));
            m.setPrecio(rs.getInt("PRECIO"));
            m.setDescuento(rs.getInt("DESCUENTO"));
            m.setFoto(rs.getString("FOTO"));
            
        }

        return m;
    }
    
    public Manga ultimo() throws SQLException{
        Manga m = new Manga();
        
        if(!rs.isAfterLast()){
            rs.last();
            m.setId(rs.getInt("ID"));
            m.setNombreManga(rs.getString("NOMBRE_MANGA"));
            m.setDescripcion(rs.getString("DESCRIPCION"));
            m.setPrecio(rs.getInt("PRECIO"));
            m.setDescuento(rs.getInt("DESCUENTO"));
            m.setFoto(rs.getString("FOTO"));
            //rs.updateRow();
            rs.next();
            return m;
        }else{
            return null;
        }
        
    }

    public ResultSet getRs() {
        return rs;
    }
    
    public Manga seleccionarMangaExacto(int id) throws SQLException{
            String consultaSQL="SELECT * FROM MANGA WHERE ID = ?";
            stmt = ConexionBD.obtener().prepareStatement(consultaSQL); 
            stmt.setInt(1, id);
            System.out.println(consultaSQL);
            rs = stmt.executeQuery(consultaSQL);
            
            Manga m = new Manga();
            m.setId(rs.getInt("ID"));
            m.setNombreManga(rs.getString("NOMBRE_MANGA"));
            m.setDescripcion(rs.getString("DESCRIPCION"));
            m.setPrecio(rs.getInt("PRECIO"));
            m.setDescuento(rs.getInt("DESCUENTO"));
            m.setFoto(rs.getString("FOTO"));
            
            return m;
    }
    
}
