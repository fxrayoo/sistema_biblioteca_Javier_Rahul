package excepciones;

public class usuario_bloqueado extends Exception {
    public usuario_bloqueado(String mensaje) {
        super(mensaje);
    }
}