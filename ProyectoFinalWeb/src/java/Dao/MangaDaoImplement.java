/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Manga;
import Model.Usuario;
import Persistence.NewHibernateUtil;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ConoMaster
 */
public class MangaDaoImplement implements MangaDao{

    @Override
    public ArrayList<Manga> obtenerMangas() {
        Session sesion = null;
        ArrayList<Manga> mangas = new ArrayList();
        try {
            sesion = NewHibernateUtil.getSessionFactory().openSession(); //abre la base de datos
            Query query = sesion.createQuery("from Manga"); //crea un cursor con todos los datos
            mangas = (ArrayList<Manga>) query.list(); //y los añade al array automaticamente
        } catch (HibernateException HE) {
            System.err.println(HE.getCause());
            System.err.println("Error doing a manga select.");
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
        
        return mangas;
    }
    
        @Override
    public ArrayList<Manga> obtenerMangaPorUsuario(int idUsuario) {
        Session sesion = null;
        ArrayList<Manga> mangas = new ArrayList();
        try {
            sesion = NewHibernateUtil.getSessionFactory().openSession(); //abre la base de datos
            Query query = sesion.createQuery("from Manga where id_usuario = " + idUsuario); //crea un cursor con todos los datos
            mangas = (ArrayList<Manga>) query.list(); //y los añade al array automaticamente
        } catch (HibernateException HE) {
            System.err.println(HE.getCause());
            System.err.println("Error doing a manga select.");
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
        
        return mangas;
    }

    @Override
    public void insertarManga() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarManga() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarManga() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Manga obtenerMangaEsepecifico(int idManga) {
        Manga manga = null;
        Session sesion = null;
        try {
            sesion = NewHibernateUtil.getSessionFactory().openSession(); // abre la base de datos
            Query query = sesion.createQuery("FROM Manga WHERE id = :idManga");
            query.setParameter("idManga", idManga);
            manga = (Manga) query.uniqueResult(); // Se espera que solo haya un usuario con ese nombre de usuario y contraseña
        } catch (HibernateException HE) {
            System.err.println("Error al obtener el manga: " + HE.getMessage());
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
        return manga;
    }

    @Override
    public void modificarPrecioManga(double nuevoPrecio, int idManga) {
         Session sesion = null;
        Transaction tx = null;

        try {
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            //extraemos el precio total de los mangas
  
            tx = sesion.beginTransaction();
            
            Manga manga = (Manga) sesion.get(Manga.class, idManga);
            
            manga.setPrecio(nuevoPrecio);
            
            // Guardar los cambios en la base de datos
            sesion.update(manga);
            
            // Commit de la transacción
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            // Cerrar la sesión de Hibernate
            sesion.close();
        }
    }


    
}
