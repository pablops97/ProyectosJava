/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.MError;
import Controlador.MiExcepcion;
import com.aeat.valida.*;


/**
 *
 * @author ConoMaster
 */
public class Usuario {
    private String nif;
    private String usuario;
    private String contrasenia;
    private String nombre;
    private String foto;

    public Usuario(String nif, String usuario, String contrasenia, String nombre, String foto) throws MiExcepcion {
        Validador validador = new Validador();
        if(validador.checkNif(nif) > 0){
            this.nif = nif;
            this.usuario = usuario;
            this.contrasenia = contrasenia;
            this.nombre = nombre;
            this.foto = foto;
        }else{
            throw new MiExcepcion(105);
        }
        
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nif=" + nif + ", usuario=" + usuario + ", contrasenia=" + contrasenia + ", nombre=" + nombre + ", foto=" + foto + '}';
    }
    
    
}
