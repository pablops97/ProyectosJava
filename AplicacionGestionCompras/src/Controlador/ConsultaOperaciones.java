/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Compra;
import Modelo.CompraBD;
import Modelo.Manga;
import Modelo.Usuario;
import Vista.FramePrincipal;
import java.sql.Date;
import java.sql.PreparedStatement;
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
public class ConsultaOperaciones {
        
    PreparedStatement pr;
    ResultSet rs;
    
    /*Clases para la gestión de las operaciones select, insert y update. Sus métodos reciben una cadena y
devuelven un objeto o una collection de objetos. En los insert o update, reciben una cadena y devuelven
un entero con el número de filas afectadas.*/
    public ConsultaOperaciones() {
        try {
            ConexionBD.abrir();
        } catch (MiExcepcion ex) {
            Logger.getLogger(ConsultaOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        String inicioBaseDatos = "use proyecto6";
        try {
            pr = ConexionBD.obtener().prepareStatement(inicioBaseDatos);
            rs = pr.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    //metodo select general
    public ResultSet operacionSelectGeneral(String consulta){
        PreparedStatement prepared;
        try {
            prepared = ConexionBD.obtener().prepareStatement(consulta);
            ResultSet resultSet = prepared.executeQuery();
            return resultSet;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaOperaciones.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    
    
    //RETORNAR TODAS LAS COMPRAS DE UN USUARIO
    public ArrayList<Compra> operacionSelectCompra(String consulta) throws SQLException{
        ArrayList<Compra> historialCompras = new ArrayList<>();
        pr = ConexionBD.obtener().prepareStatement(consulta);
        rs = pr.executeQuery();
        while(rs.next()){
            historialCompras.add(new Compra(rs.getInt(1), rs.getString(2), rs.getInt(3), Utilidad.dateToGCalendar(rs.getDate(4)), rs.getInt(5)));
        }
        
        return historialCompras;
        
    }
    
    //RETORNAR TODOS LOS USUARIOS DE LA BASE DE DATOS
    public ArrayList<Usuario> operacionSelectUsuario(String consulta) throws SQLException{
        ArrayList<Usuario> usuarios = null;
        pr = ConexionBD.obtener().prepareStatement(consulta);
        rs = pr.executeQuery();
        while(rs.next()){
            try {
                usuarios.add(new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            } catch (MiExcepcion ex) {
                Logger.getLogger(ConsultaOperaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return usuarios;
        
    }
    
    //INSERTAR DATOS EN CUALQUIER TABLA
    public int operacionInsert(String consulta){
        
        try {
            pr = ConexionBD.obtener().prepareStatement(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return pr.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaOperaciones.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } 
    }
    
    //ELIMINAR DATOS EN LA TABLA USUARIO
    
    public int operacionDeleteUsuario(String nifUsuario){
      
        try {
            // Eliminar registros de la tabla COMPRA relacionados con el usuario
            String consultaEliminarCompra = "DELETE FROM COMPRA WHERE USUNIF = ?";
            PreparedStatement statementCompra;
            statementCompra = ConexionBD.obtener().prepareStatement(consultaEliminarCompra);
            statementCompra.setString(1, nifUsuario);
            int comprasEliminadas = statementCompra.executeUpdate();

            // Eliminar el usuario de la tabla USUARIO
            String consultaEliminarUsuario = "DELETE FROM USUARIO WHERE NIF = ?";
            PreparedStatement statementUsuario = ConexionBD.obtener().prepareStatement(consultaEliminarUsuario);
            statementUsuario.setString(1, nifUsuario);
            int usuariosEliminados = statementUsuario.executeUpdate();
            
            
            return comprasEliminadas + usuariosEliminados;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaOperaciones.class.getName()).log(Level.SEVERE, null, ex);
            
            try {
                // Deshacer la transacción en caso de error
                if (ConexionBD.obtener() != null) {
                    ConexionBD.obtener().rollback();
                }
            } catch (SQLException ex2) {
                ex2.printStackTrace();
                // Manejar la excepción apropiadamente según tus necesidades
            }

            ex.printStackTrace();
            return -1;
        }
            
        
    }
    
    //MODIFICACION DE LA CANTIDAD DE MANGAS QUE SE PUEDE AÑADIR, HACE REFERENCIA AL CAMPO CALCULADO
    public int updateTablaCompra(int cantidad, int manid, String usunif, Date fecha) throws MiExcepcion{
        String consultaEliminarCompra = "UPDATE COMPRA SET CANTIDAD = CANTIDAD + 1, FECHACOMPRA = ? WHERE MANID = ? AND USUNIF = ?";
            PreparedStatement statementCompra;
        try {
            ResultSet cantidadRs = this.operacionSelectGeneral("SELECT CANTIDAD FROM COMPRA WHERE MANID = '" + manid + "' AND USUNIF = '" + usunif + "'");
            if (cantidadRs.next()) {
                int cantidadObtenida = cantidadRs.getInt(1);
                if (cantidadObtenida >= 10) {
                    cantidadRs.close();
                    throw new MiExcepcion(109);
                } else {
                    statementCompra = ConexionBD.obtener().prepareStatement(consultaEliminarCompra);
                    statementCompra.setDate(1, fecha);
                    statementCompra.setInt(2, manid);
                    statementCompra.setString(3, usunif);
                    int registros = statementCompra.executeUpdate();
                    statementCompra.close();
                    cantidadRs.close();
                    return registros;
                }
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaOperaciones.class.getName()).log(Level.SEVERE, null, ex);
            
            return -1;
        }
        
         return-1;   
    }

    public ResultSet getRs() {
        return rs;
    }
    
    
    //METODO USADO PARA MODIFICAR LOS VALORES DEL USUARIO CONECTADO
    public void operacionModificarUsuario(Usuario user, String NIF){
        
        try {

            // Actualiza la tabla principal (USUARIO)
            String consultaModificacion = "UPDATE USUARIO SET NOMBRE = ?, NOMBRE_USUARIO = ?, FOTO = ? WHERE NIF = ?";
            PreparedStatement st = ConexionBD.obtener().prepareStatement(consultaModificacion);
            st.setString(1, user.getNombre());
            st.setString(2, user.getUsuario());
            st.setString(3, user.getFoto());
            st.setString(4, NIF);

            st.executeUpdate();

            System.out.println("Consulta realizada con éxito");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaOperaciones.class.getName()).log(Level.SEVERE, null, ex);
            }



        }   
    
    
    public boolean comprobarUsuarioExiste(String NIF){
        String consultaComprobar = "SELECT NIF FROM USUARIO WHERE NIF = ?";
        PreparedStatement pr;
        try{
            pr = ConexionBD.obtener().prepareStatement(consultaComprobar);
            pr.setString(1, NIF);
            if(pr.getMoreResults()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaOperaciones.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return false;
    }
    
    //METODO USADO PARA ELIMINAR UN REGISTRO DE LA TABLA COMPRA
    public int operacionBorrarElementoCompra(String nif, int mangaid){
        String consultaEliminacion = "DELETE FROM COMPRA WHERE USUNIF = ? AND MANID = ?";
        PreparedStatement pr;
        try{
            pr = ConexionBD.obtener().prepareStatement(consultaEliminacion);
            pr.setString(1, nif);
            pr.setInt(2, mangaid);
            int eliminaciones = pr.executeUpdate();           
            return eliminaciones;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaOperaciones.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return 0;
    }
    
    
    private boolean existeUsuario(String nif) throws SQLException {
        String consultaExistencia = "SELECT COUNT(*) FROM USUARIO WHERE NIF = ?";
        try (PreparedStatement stExistencia = ConexionBD.obtener().prepareStatement(consultaExistencia)) {
            stExistencia.setString(1, nif);
            try (ResultSet resultado = stExistencia.executeQuery()) {
                if (resultado.next()) {
                    return resultado.getInt(1) > 0;
                }
            }
        }
        return false;
    }
    
    
        
    }
    

    

