/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Controlador.ConexionBD;
import Controlador.MiExcepcion;
import Modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioBD{
    
    ResultSet rs;
    
    public UsuarioBD(ResultSet rs) {
        /*try {
            stmt = ConexionBD.obtener().createStatement();    
            String inicioDatabase = "use proyecto6";
            rs = stmt.executeQuery(inicioDatabase);
            String consultaSQL="SELECT * FROM USUARIO "+ sWhere;
            System.out.println(consultaSQL);
            rs = stmt.executeQuery(consultaSQL);            
        } catch (SQLException e) {
            System.out.println(e);
        }*/
        this.rs = rs;
    }
        
    public ArrayList<Usuario> getUsuarios() throws MiExcepcion{
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            while (rs.next()) {
                usuarios.add(new Usuario (rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            return usuarios;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    
    public Usuario getUsuario() throws MiExcepcion{
        Usuario user;
        try {
            
               user = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                return user; 
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
       
    }
    
    public void cerrar(){
        try {
            rs.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}