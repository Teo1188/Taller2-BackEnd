package Biblioteca.Transactions;
import Biblioteca.Conexion.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibreriaServicio {
    private DatabaseConnection databaseConnection;
    private Connection connection;

    public LibreriaServicio(Connection connection) {
        databaseConnection = new DatabaseConnection();
        this.connection = databaseConnection.getConnection();
    }

    public void agregarLibro(String titulo, String autor, String isbn, boolean disponible) {
        String query = "INSERT INTO Libro (titulo, autor, isbn, disponible) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, titulo);
            statement.setString(2, autor);
            statement.setString(3, isbn);
            statement.setBoolean(4, disponible);
            statement.executeUpdate();
            System.out.println("Libro agregado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarLibros() {
        String query = "SELECT * FROM Libro";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id_libro = resultSet.getInt("id_libro");
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");
                String isbn = resultSet.getString("isbn");
                boolean disponible = resultSet.getBoolean("disponible");
                System.out.println("ID: " + id_libro + ", Título: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn + ", Disponible: " + disponible);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarLibro(int id_libro, String nuevoTitulo, String nuevoAutor, String nuevoIsbn, boolean nuevoDisponible) {
        String query = "UPDATE Libro SET titulo = ?, autor = ?, isbn = ?, disponible = ? WHERE id_libro = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nuevoTitulo);
            statement.setString(2, nuevoAutor);
            statement.setString(3, nuevoIsbn);
            statement.setBoolean(4, nuevoDisponible);
            statement.setInt(5, id_libro);
            int filasActualizadas = statement.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Libro actualizado con éxito.");
            } else {
                System.out.println("No se encontró un libro con ese ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarLibro(int id_libro) {
        // Eliminar los préstamos de este libro
        String eliminarPrestamosSQL = "DELETE FROM Prestamo WHERE id_libro = ?";
        try (PreparedStatement stmt = connection.prepareStatement(eliminarPrestamosSQL)) {
            stmt.setInt(1, id_libro);
            stmt.executeUpdate();
            System.out.println("Préstamos asociados eliminados con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar préstamos asociados: " + e.getMessage());
            return;
        }

        // eliminar el libro
        String sql = "DELETE FROM Libro WHERE id_libro = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id_libro);
            stmt.executeUpdate();
            System.out.println("Libro eliminado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el libro: " + e.getMessage());
        }
    }

}
