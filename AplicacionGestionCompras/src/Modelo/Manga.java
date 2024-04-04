/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.MiExcepcion;

/**
 *
 * @author ConoMaster
 */
public class Manga {
    
    private int id;
    private String nombreManga;
    private String descripcion;
    private float precio;
    private int descuento;
    private String foto;

    //Al final el descuento no lo uso
    public Manga(int id, String nombreManga, String descripcion, float precio, int descuento, String foto) throws MiExcepcion {
        if(descuento < 0 || descuento > 100){
            throw new MiExcepcion(106);
        }
        this.id = id;
        this.nombreManga = nombreManga;
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuento = descuento;
        this.foto = foto;
    }

    public Manga() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreManga() {
        return nombreManga;
    }

    public void setNombreManga(String nombreManga) {
        this.nombreManga = nombreManga;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return nombreManga + " " + precio + " €";
    }
    
    
    
}
