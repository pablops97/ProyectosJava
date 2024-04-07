/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author bosque
 */
public class MError {
    
    private static String mensaje;
    
    public static String getMensaje(int cod) {
        mensaje = "Error "+ cod + ": ";
        switch(cod) {
            case 101:
                mensaje = mensaje + "al cargar los drivers de la base de datos";
                break;
            case 102:
                mensaje = mensaje + "al abrir la base de datos";
                break;
            //Tomas: más casos
            case 103:
                mensaje = mensaje + "al cerrar la base de datos";
                break;
            case 104:
                mensaje = mensaje + "no hay ningun usuario en la base de datos";
                break;
            case 105:
                mensaje = mensaje + "El NIF es incorrecto";
                break;
            case 106:
                mensaje = mensaje + "El descuento debe ser un numero que comprenda entre 0 y 100";
                break;
            case 107:
                mensaje = mensaje + "No se pudo añadir el usuario a la base de datos";
                break;
            case 108:
                mensaje = mensaje + "No se ha eliminado ningun registro";
                break;
                
            case 109:
            mensaje = mensaje + "ha excedido el numero límite de articulos añadidos (10)";
            break;
            //Tomas: más casos
            default:
                mensaje = mensaje + "DESCONOCIDO";
        }
        return mensaje;
    }
    

//metodo para la creacion del archivo log de los errores, que sera implementado en cada catch que controla la excepcion
    public static void CreadorLog(String error) {
        // Obtener la fecha y hora actual
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = dateFormat.format(Utilidad.obtenerFechaActual());

        // Crear el mensaje a escribir en el archivo
        String mensaje = fechaHora + " - " + error;

        // Escribir en el archivo de registro de errores
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("registro_errores.txt", true)))) {
            writer.println(mensaje);
        } catch (IOException e) {
            // Manejar cualquier error al escribir en el archivo de registro
            e.printStackTrace();
        }
    }
    
}
