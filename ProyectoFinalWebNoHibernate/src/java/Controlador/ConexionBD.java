/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author usuario
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexionBD {
     
    private Connection miConexion;
    
    public ConexionBD() throws SQLException{
        
    }
    
    public static Connection getConnection() throws SQLException {
        Connection miConexion = DriverManager.getConnection("jdbc:derby://localhost:1527/BaseDatosP10","pablo","pablo");
        System.out.println("Conexion realizada con exito");
    return miConexion;
  } 

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ignored) {
        }
        
        
    }

    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException ignored) {
        }
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ignored) {
        }
    }
    
    
}
