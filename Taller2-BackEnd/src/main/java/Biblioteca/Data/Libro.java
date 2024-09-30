package Biblioteca.Data;


public class Libro {


    private int id_libro;
    private String autor;
    private String titulo;
    private String isbn;
    private boolean disponible;


    // Constructores
    public Libro(int id_libro, String autor, String titulo, String isbn, boolean disponible) {
        this.id_libro = id_libro;
        this.autor = autor;
        this.titulo = titulo;
        this.isbn = isbn;
        this.disponible = disponible;
    }

    // Getters y Setters

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}