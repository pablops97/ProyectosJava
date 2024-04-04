package Controlador;



import java.sql.*;


public class ConexionBD {
    static Connection con=null;
    
    public static void abrir() throws MiExcepcion {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("JDBC driver falied to load.");
            throw new MiExcepcion(101);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull","root","pablo");
            System.out.println("Conexión OK");
        }
        catch (SQLException e) {
            System.out.println(e);
            System.out.println("Conexión ERROR");
            throw new MiExcepcion(102);            
        }        
    }
    
    public static Connection obtener(){
        return con;
    }
    
     public static boolean cerrar() throws MiExcepcion {
        try {
            con.close();
            //System.out.println("Conexión CERRADA");
            return true;
        }
        catch (SQLException e) {
            //Tomas: debug
            System.out.println(e.getMessage());
            System.out.println("Conexión ERROR AL CERRAR");
            //Tomas: aquí se guarda en el fichero de log: e.getMessge(), fecha y hora.
            throw new MiExcepcion(103);
        }        
    }
    
    
    
    

    
    
    
    
    
}
