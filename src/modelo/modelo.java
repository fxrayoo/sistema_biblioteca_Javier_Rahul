package modelo;
import java.time.LocalDate;

public class prestamo {
    private libro libro;
    private usuario usuario;
    private LocalDate fecha_inicio;
    private LocalDate fecha_vencimiento;

    public prestamo(libro libro, usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fecha_inicio = LocalDate.now();
        this.fecha_vencimiento = this.fecha_inicio.plusDays(30);
    }

    public libro getlibro() { 
        return libro; 
    }

    public usuario getusuario() { 
        return usuario; 
    }

    public LocalDate getfecha_vencimiento() { 
        return fecha_vencimiento; 
    }
}