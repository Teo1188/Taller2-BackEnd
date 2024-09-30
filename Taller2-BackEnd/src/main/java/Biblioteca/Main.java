package Biblioteca;
import Biblioteca.Transactions.UsuarioServicio;
import Biblioteca.Transactions.LibreriaServicio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_taller2", "aduser", "password");
            System.out.println("Conexión establecida.");

            // Crear instancias de servicios
            LibreriaServicio LibreriaServicio = new LibreriaServicio(connection);
            UsuarioServicio UsuarioServicio = new UsuarioServicio(connection);

            // Pruebas con libros
            // Agregar libros
            LibreriaServicio.agregarLibro("El Resplandor", "Stephen King", "467-3-16-148910-7", true);
            LibreriaServicio.agregarLibro("El Extrangero", "Albert Kamus", "555-3-14-448410-8", true);

            // Mostrar todos los libros
            System.out.println("\nLista de libros:");
            LibreriaServicio.mostrarLibros();

            // Actualizar un libro
            LibreriaServicio.actualizarLibro(1, "Cien Años de Soledad (Edición Especial volumen 5)", "Gabriel García Márquez", "978-3-16-148410-0", true);

            // Mostrar lista de libros actualizado
            System.out.println("\nLista de libros después de la actualización:");
            LibreriaServicio.mostrarLibros();

            // Eliminar un libro con ID
            LibreriaServicio.eliminarLibro(7);

            // Mostrar lista de libros después de la eliminación
            System.out.println("\nLista de libros después de la eliminación:");
            LibreriaServicio.mostrarLibros();

            // Pruebas con usuarios
            // Registrar usuarios (ajusta la llamada eliminando el email)
            UsuarioServicio.registrarUsuario("Falcao", "Garcia", "password789");
            UsuarioServicio.registrarUsuario("Avril", "Lavigne", "password012");

            // Mostrar todos los usuarios
            System.out.println("\nLista de usuarios:");
            UsuarioServicio.mostrarUsuarios();

            // Actualizar un usuario (suponiendo que el ID del usuario a actualizar es 1)
            UsuarioServicio.actualizarUsuario(1, "Maria", "Sharapova Actualizado 2");

            // Mostrar lista de usuarios después de la actualización
            System.out.println("\nLista de usuarios después de la actualización:");
            UsuarioServicio.mostrarUsuarios();

            // Eliminar un usuario con ID
            UsuarioServicio.eliminarUsuario(4);

            // Mostrar lista de usuarios después de la eliminación
            System.out.println("\nLista de usuarios después de la eliminación:");
            UsuarioServicio.mostrarUsuarios();

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        } finally {
            // Cerrar la conexión
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Conexión cerrada.");
                } catch (SQLException e) {
                    System.err.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }
}