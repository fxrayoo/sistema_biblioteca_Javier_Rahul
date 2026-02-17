package excepciones;

public class limite_prestamos_excedido extends Exception {
    public limite_prestamos_excedido(String mensaje) {
        super(mensaje);
    }
}