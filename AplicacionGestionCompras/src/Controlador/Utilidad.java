/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author ConoMaster
 */
public class Utilidad {
    
    public Utilidad(){
        
    }
    
    public static GregorianCalendar dateToGCalendar (java.util.Date d){
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(d);
        return cal;        
    }
    
    public static ImageIcon obtenerIconoPorNombre(String nombreImagen, String directorio) {
        File carpeta = new File(directorio);
        File[] archivos = carpeta.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().equals(nombreImagen)) {
                    try {
                        BufferedImage imagen = ImageIO.read(archivo);
                        return new ImageIcon(imagen);
                    } catch (IOException e) {
                        System.err.println("Error al cargar la imagen: " + archivo.getName());
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.err.println("El directorio no contiene archivos.");
        }

        System.err.println("Imagen no encontrada: " + nombreImagen);
        return null;
    }
    
        public static Date obtenerFechaActual() {
        // Obtener la fecha actual en milisegundos
        long currentTimeMillis = System.currentTimeMillis();

        // Crear un objeto Date a partir de la fecha actual en milisegundos
        Date fechaActual = new Date(currentTimeMillis);

        return fechaActual;
    }
     /*   
    private Image loadImageAndScale(JPanel panel, String path, int width, int height) {
        try {
            Image originalImage = ImageIO.read(PanelAcercaDe.class.getClassLoader().getResource(path));
            return originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }*/
      
        
}
