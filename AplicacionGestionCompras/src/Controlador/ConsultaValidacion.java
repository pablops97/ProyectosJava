/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ConoMaster
 */
public class ConsultaValidacion {

    ResultSet rs;
    
    public ConsultaValidacion() {
    }
    
    public boolean validarUsuario(String usuario, String contrasenia){
        String consultaSQL = "SELECT * FROM USUARIO WHERE NOMBRE_USUARIO LIKE ? AND CONTRASENIA LIKE ?";
        try {
            ConexionBD.abrir();
        } catch (MiExcepcion ex) {
            Logger.getLogger(ConsultaValidacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement ps = ConexionBD.obtener().prepareStatement(consultaSQL);
            ps.setString(1, usuario);
            ps.setString(2, contrasenia);
            rs = ps.executeQuery("use proyecto6");
            rs = ps.executeQuery();
            // Verificar si se encontraron resultados
            return rs.next();
   
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaValidacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void close(){
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaValidacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
    
    
}
