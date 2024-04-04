/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Usuario;

/**
 *
 * @author ConoMaster
 */
public interface UsuarioDao {
    public Usuario obtenerUsuario(String nombreUsuario, String contrasenia);
    public void modificarUsuario();
    public void campoCalculado(int idUsuario);
}
