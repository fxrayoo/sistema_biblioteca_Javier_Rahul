package modelo;
import java.util.ArrayList; 
import java.util.List; 

public class Biblioteca { 

    private List<Libro> listaLibros; 
    private List<Usuario> listaUsuarios;

    public Biblioteca() { 
        this.listaLibros = new ArrayList<>(); 
        this.listaUsuarios = new ArrayList<>();
    }
    // ... Métodos de Búsqueda ---
    public Libro buscarPorIsbn(String isbn) { 
        for (Libro l : listaLibros) {
            If (l.getIsbn().equals(isbn)) { 
                return l; 
             }
        }
        return null; 
    }
    public List<Libro> buscarPorTitulo(String titulo) { 
        List<Libro> resultados = new ArrayList<>(); 
        for (Libro l : listaLibros) {
            If (l.getTitulo().equalsIgnoreCase(titulo)) { 
                resultados.add(l); 
            }
        }
        return resultados
    } 
    // --- Métodos de resumen ---
    public void mostrarResumenLibros() { 
        System.out.println(" --- Resumen de Libros ---");
        for (Libro l : listaLibros) {
            System.out.println("Título: "+ l.getTitulo() +
                               " | Estado: " + l.getEstado()); 
         }
    }
    Public void mostrarResumenUsuarios() { 
        System.out.println(" --- Resumen de Usuarios ---");
        for (Usuario u : listaUsuarios) {
            System.out.println("Nombre: " + u.getNombre() + 
                               " | Prestados: " + u.getLibrosPrestados().size());
        }
    }
    // --- Métodos para añadir datos ---
    public void agregarLibro(Libro l) { 
        listaLibros.add(l); 
    }
    public void registrarUsuario(Usuario u) { 
        listaUsuarios.add(u); 
    }
}
