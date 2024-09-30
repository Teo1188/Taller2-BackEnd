package Biblioteca.Conexion;

import java.sql.Connection;

public class DatabaseConfig {
    private Connection connection;
    public static final String URL = "jdbc:mysql://localhost:3306/jdbc_taller2";
    public static final String USER = "aduser";
    public static final String PASSWORD = "password";
}
