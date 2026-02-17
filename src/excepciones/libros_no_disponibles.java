package excepciones;
public class libros_no_disponibles extends Exception {
    public libros_no_disponibles(String mensaje) {
        super(mensaje);
    }
}