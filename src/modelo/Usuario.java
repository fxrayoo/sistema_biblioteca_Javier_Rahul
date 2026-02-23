package modelo;

import java.util.ArrayList;
import java.util.List; 

public class Usuario {
    private string id; 
    private string nombre;
    //Lista de libros actual (máximo 3) 
    private List<Libro> librosPrestados;
    public Usuario(String id, String nombre) {
this.id = id;
this.nombre = nombre;
this.librosPrestados = new Arraylist<>();
}
//--- Métodos de lógica ---
public boolean puedePedirPrestado() { 
    //Restricción de máximo 3 libros
    return librosPrestados.size() < 3;
}

public void agregarLibro(Libro libro) { 
    if (puedePedirPrestado()) { 
        librosPrestados.add(libro); 
    }
}

public void devolverLibro(Libro libro) { 
    if (librosPrestados.remove(libro)) { 
        historialPrestamos.add(libro); 
    }
}
//Getters 
public String getNombre() { return nombre; }
public String getId() { return id; }
public List<Libro> getLibrosPrestados() { return librosPrestados; }

}
