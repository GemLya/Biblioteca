package model;

public class Tesis extends MaterialBibliografico {
    private String carrera;
    private String director;
    private int anio;

    public Tesis(String codigo, String titulo, boolean disponible, String carrera, String director, int anio) {
        super(codigo, titulo, disponible);
        this.carrera = carrera;
        this.director = director;
        this.anio = anio;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Tesis - Título: " + getTitulo() + ", Carrera: " + carrera + ", Director: " + director + ", Año: " + anio);
    }
}