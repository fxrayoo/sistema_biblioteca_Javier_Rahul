package controlador;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import modelo.*;
import excepciones.*;

public class gestor_biblioteca {
    // Aquí guardamos los préstamos Lista donde guardamos todos los préstamos que se van haciendo
    private List<prestamo> prestamos_activos = new ArrayList<>();

    // Para el primer método crearemos el "hacer_prestamo" con 3 validaciones
    public void hacer_prestamo(usuario usuario, libro libro)
    throws libros_no_disponibles, limite_prestamos_excedido, usuario_bloqueado {
        // VALIDACIÓN 1
        if (usuario.getlibros_prestados().size() >= 3) {
            throw new limite_prestamos_excedido("Préstamo denegado, ya tiene 3 libros.");
        }

        // VALIDACIÓN 2
        if (libro.getcopias_disponibles() <= 0) {
            throw new libros_no_disponibles("No está disponible");
        }

        // VALIDACIÓN 3
        for (libro h : usuario.gethistorial()) {
            if (h.getIsbn().equals(libro.getIsbn())) {
                throw new usuario_bloqueado("Deberá esperar 7 días");
            }
        }

        // Si no hay problema se hará el prestamos del libro
        libro.setcopias_disponibles(libro.getcopias_disponibles() - 1);
        
        // Por último creamos el objeto préstamo
        prestamo nuevo_prestamo = new prestamo(libro, usuario);
        
        prestamos_activos.add(nuevo_prestamo);
        usuario.getlibros_prestados().add(libro);
        
        System.out.println("Se ha realizado el préstamo!");
    }

    // Para el segundo método, nos centraremos en la devolución
    public void devolver_libro(usuario usuario, libro libro) {
        prestamo prestamo_a_borrar = null;

        // Buscamos el préstamo en nuestra lista
        for (prestamo p : prestamos_activos) {
            if (p.getlibro().equals(libro) && p.getusuario().equals(usuario)) {
                prestamo_a_borrar = p;
                break;
            }
        }

        // Esto es para encontrarlo
        if (prestamo_a_borrar != null) {
            LocalDate hoy = LocalDate.now();

            if (hoy.isAfter(prestamo_a_borrar.getfecha_vencimiento())) {
                System.out.println("ALERTA: El usuario lo ha devuelto tarde. Bloqueado 7 días.");
            }
            
            // Y por último actualizamos los datos para que aparezcan los cambios
            libro.setcopias_disponibles(libro.getcopias_disponibles() + 1);
            usuario.getlibros_prestados().remove(libro);
            usuario.gethistorial().add(libro);
            prestamos_activos.remove(prestamo_a_borrar);
            
            System.out.println("Se ha devuelto el libro");
        } else {
            System.out.println("No hay ningún préstamo");
        }
    }
}