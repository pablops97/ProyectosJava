/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Manga;
import java.util.ArrayList;

/**
 *
 * @author ConoMaster
 */
public interface MangaDao {
    public ArrayList<Manga> obtenerMangas();
    public ArrayList<Manga> obtenerMangaPorUsuario(int idUsuario);
    public Manga obtenerMangaEsepecifico(int idManga);
    public void insertarManga();
    public void eliminarManga();
    public void modificarManga();
    public void modificarPrecioManga(double nuevoPrecio, int idManga);
}
