/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ConoMaster
 */
public class ControladorUsuario {
    
    Connection conex = null;
    ResultSet rs = null;
    
    public ControladorUsuario() {
        try {
            conex = ConexionBD.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    public Usuario validarUsuario(String usuario, String contrasenia) throws SQLException{
        
        String consultaSQL = "SELECT * FROM USUARIO WHERE NOMBRE_USUARIO LIKE ? AND CONTRASENA LIKE ?";
        Usuario user = null;
        try {
            PreparedStatement ps = conex.prepareStatement(consultaSQL);
            ps.setString(1, usuario);
            ps.setString(2, contrasenia);
            rs = ps.executeQuery();
            // Verificar si se encontraron resultados
            while(rs.next()){
                //int id, String nombreUsuario, String contrasena, String correoElectronico, Date fechaIngreso, String fotografia, Double precioTotal
                user = new Usuario(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getDouble(7));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        this.close();
        return user;
        
    }
    
    public void campoCalculado(int idUsuario) throws SQLException{


        
        double precioTotal = 0;
        String consultaTotalPrecio = "SELECT SUM(precio) FROM Manga AS m WHERE id_usuario = ?";
        PreparedStatement ps = conex.prepareStatement(consultaTotalPrecio);
        ps.setInt(1, idUsuario);
        rs = ps.executeQuery();
        while(rs.next()){
            precioTotal = rs.getDouble(1);
        }
        
        String consultaUpdate = "UPDATE USUARIO SET PRECIOTOTAL = ? WHERE ID = ?";
        ps = conex.prepareStatement(consultaUpdate);
        ps.setDouble(1, precioTotal);
        ps.setInt(2, idUsuario);
        int columnasModificadas = ps.executeUpdate(); 
        System.out.println("Han sido modificadas " + columnasModificadas + " columnas con exito");
        
    }
    
    public void close(){
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
    
}
