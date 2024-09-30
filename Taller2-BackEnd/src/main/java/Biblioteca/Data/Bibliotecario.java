package Biblioteca.Data;


public class Bibliotecario extends Persona {

    // Constructores
    public Bibliotecario(int id, String nombre, String apellido) { super(id, nombre, apellido, "Bibliotecario");}

    @Override
    public String toString() {
        return "Bibliotecario{" +
                "ID: " + getId() +
                ", Nombre: " + getNombre() +
                ", Apellido: " + getApellido() +
                '}';
    }
}