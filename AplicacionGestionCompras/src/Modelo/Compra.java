/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author ConoMaster
 */
public class Compra {

    private int idFactura;
    private String nifUsuario;
    private int idManga;
    private GregorianCalendar fechaCompra;
    private int cantidad;

    public Compra(int idFactura, String nifUsuario, int idManga, GregorianCalendar fechaCompra, int cantidad) {
        this.idFactura = idFactura;
        this.nifUsuario = nifUsuario;
        this.idManga = idManga;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getNifUsuario() {
        return nifUsuario;
    }

    public void setNifUsuario(String nifUsuario) {
        this.nifUsuario = nifUsuario;
    }

    public int getIdManga() {
        return idManga;
    }

    public void setIdManga(int idManga) {
        this.idManga = idManga;
    }

    public Calendar getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(GregorianCalendar fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Compra{" + "idFactura=" + idFactura + ", nifUsuario=" + nifUsuario + ", idManga=" + idManga + ", fechaCompra=" + fechaCompra + ", cantidad=" + cantidad + '}';
    }
 
    
}
