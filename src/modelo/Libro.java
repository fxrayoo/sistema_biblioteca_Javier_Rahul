package modelo;

public class Libro {
    private String isbn; 
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String editorial; 
    private Genero genero;
    private int cantidadTotal;
    private int cantidadDisponible, 
    private EstadoLibro estado;

    public Libro(String isbn, String titulo, String autor, int anio, String editorial, int total, Genero genero) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anio;
        this.editorial = editorial;
        this.cantidadTotal = total;
        this.cantidadDisponible = total; 
        this.genero = genero;
        this.estado = EstadoLibro.Disponible;
    }
//Getters y Setters 
public String getIsbn () { return isbn; }
public String getTitulo() { return titulo; }
public EstadoLibro getEstado() { return estado; }
public void setEstado(EstadoLibro estado) { this.estado = estado; }
public int getCantidadDisponible() { return cantidadDisponible; }
public void setCantidadDisponible(int cantidadDisponible) { this.cantidadDisponible = cantidadDisponible; }

}
