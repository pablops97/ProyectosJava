/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ConexionBD;
import Controlador.Utilidad;
import Modelo.Compra;
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
public class CompraBD {
    Statement stmt; 
    ResultSet rs;

    public CompraBD(ResultSet rs) {
        this.rs = rs;
    }
  
    public ArrayList<Compra> getCompras(){
         ArrayList<Compra> facturas = new ArrayList<>();
        try {
            while (rs.next()) {
                facturas.add(new Compra (rs.getInt(1),rs.getString(2),rs.getInt(3),Utilidad.dateToGCalendar(rs.getDate(4)), rs.getInt(5)));
            }
            return facturas;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    
    public Compra getFactura(){
        Compra factura;
        try {
            factura = new Compra (rs.getInt(1),rs.getString(2),rs.getInt(3),Utilidad.dateToGCalendar(rs.getDate(4)), rs.getInt(5));
            return factura;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
      
    }
    
    public boolean comprobarExistencias(int id){
        Compra compra;
        try {
            while(rs.next()){
                System.out.println(rs.getInt(3));
                if(rs.getInt(3) == id){
                    rs.close();
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompraBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
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
