package Biblioteca.Data;


public class Usuario extends Persona {

    private String email;
    private String contraseña;
    private int prestamos;



    // Constructores
    public Usuario(int id, String nombre, String apellido, int prestamos, String email, String contraseña) {
        super(id, nombre, apellido, "Usuario");

        this.email = email;
        this.contraseña = contraseña;
        this.prestamos = prestamos;
    }


    // Getters y Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(int prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "ID: " + getId() +
                ", Nombre: " + getNombre() +
                ", Apellido: " + getApellido() +
                ", Préstamos: " + prestamos +
                ", Email: " + email +
                '}';
    }

}
