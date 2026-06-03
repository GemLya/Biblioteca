package model;

public class Revista extends MaterialBibliografico {
    private int edicion;
    private String mesPub;
    private String categoria;

    public Revista(String codigo, String titulo, boolean disponible, int edicion, String mesPub, String categoria) {
        super(codigo, titulo, disponible);
        this.edicion = edicion;
        this.mesPub = mesPub;
        this.categoria = categoria;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Revista - Título: " + getTitulo() + ", Edición: " + edicion + ", Mes: " + mesPub + ", Categoría: " + categoria);
    }
}