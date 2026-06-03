package model;
public class Libro extends MaterialBibliografico {
    private String autor;
    private int isbn;
    private String editorial;
    private int paginas;

    public Libro(String codigo, String titulo, boolean disponible, String autor, int isbn, String editorial, int paginas) {
        super(codigo, titulo, disponible);
        this.autor = autor;
        this.isbn = isbn;
        this.editorial = editorial;
        this.paginas = paginas;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Libro - Título: " + getTitulo() + ", Autor: " + autor + ", ISBN: " + isbn + ", Disponible: " + isDisponible());
    }
}