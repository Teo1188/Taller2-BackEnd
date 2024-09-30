package Biblioteca.Data;

import java.util.Date;

public class Prestamo {


    private int id;
    private int libroId;
    private int usuarioId;
    private Date fechaPrestamo;
    private Date fechaDevolucion;


    // Constructores
    public Prestamo(int id, int libroId, int usuarioId, Date fechaPrestamo, Date fechaDevolucion) {
        this.id = id;
        this.libroId = libroId;
        this.usuarioId = usuarioId;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
    }

    public int getLibroId() {
        return libroId;
    }

    public void setLibroId(int libroId) {
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {

    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {

    }
}
