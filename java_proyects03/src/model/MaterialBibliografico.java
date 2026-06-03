package model;

public abstract class MaterialBibliografico {
    private String codigo;
    private String titulo;
    private boolean disponible;

    public MaterialBibliografico(String codigo, String titulo, boolean disponible) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponible = disponible;
    }

    public abstract void mostrarInfo();

    public boolean puedePrestarse() {
        return disponible;
    }

    // Getters y Setters necesarios para la gestión
    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}