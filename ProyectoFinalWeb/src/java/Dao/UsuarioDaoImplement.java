/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Usuario;
import Persistence.NewHibernateUtil;
import java.util.ArrayList;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static org.hibernate.type.TypeFactory.serializable;

/**
 *
 * @author ConoMaster
 */
public class UsuarioDaoImplement implements UsuarioDao{

    @Override
    public Usuario obtenerUsuario(String nombreUsuario, String contrasenia) {
        Usuario user = null;
        Session sesion = null;
        try {
            sesion = NewHibernateUtil.getSessionFactory().openSession(); // abre la base de datos
            Query query = sesion.createQuery("FROM Usuario WHERE nombreUsuario = :nombreUsuario AND contrasena = :contrasena");
            query.setParameter("nombreUsuario", nombreUsuario);
            query.setParameter("contrasena", contrasenia);
            user = (Usuario) query.uniqueResult(); // Se espera que solo haya un usuario con ese nombre de usuario y contraseña
        } catch (HibernateException HE) {
            System.err.println("Error al obtener el usuario: " + HE.getMessage());
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
        return user;
    }


    @Override
    public void modificarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void campoCalculado(int idUsuario) {
        Session sesion = null;
        Transaction tx = null;

        try {
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            //extraemos el precio total de los mangas
            
            Query query = sesion.createQuery("SELECT SUM(precio) FROM Manga AS m WHERE id_usuario = " + idUsuario);
            
            double precioTotal = (double)query.uniqueResult();
            System.out.println("PRECIO TOTAL: "+precioTotal);

            tx = sesion.beginTransaction();
            
            Usuario usuario = (Usuario) sesion.get(Usuario.class, idUsuario);
            
            usuario.setPrecioTotal(precioTotal);
            
            // Guardar los cambios en la base de datos
            sesion.update(usuario);
            
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
