package Model;
// Generated 20-feb-2024 13:46:17 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Manga generated by hbm2java
 */
public class Manga  implements java.io.Serializable {


     private int id;
     private String titulo;
     private String autor;
     private String genero;
     private double puntaje;
     private int numVolumenes;
     private String estado;
     private Date fechaPublicacion;
     private Integer idUsuario;
     private String imagen;
     private double precio;

    public Manga() {
    }

	
    public Manga(int id) {
        this.id = id;
    }
    public Manga(int id, String titulo, String autor, String genero, double puntaje, int numVolumenes, String estado, Date fechaPublicacion, int idUsuario, String imagen, double precio) {
       this.id = id;
       this.titulo = titulo;
       this.autor = autor;
       this.genero = genero;
       this.puntaje = puntaje;
       this.numVolumenes = numVolumenes;
       this.estado = estado;
       this.fechaPublicacion = fechaPublicacion;
       this.idUsuario = idUsuario;
       this.imagen = imagen;
       this.precio = precio;
    }  

   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return this.autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getGenero() {
        return this.genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public double getPuntaje() {
        return this.puntaje;
    }
    
    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }
    public int getNumVolumenes() {
        return this.numVolumenes;
    }
    
    public void setNumVolumenes(Integer numVolumenes) {
        this.numVolumenes = numVolumenes;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Date getFechaPublicacion() {
        return this.fechaPublicacion;
    }
    
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    




}


