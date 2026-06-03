package model;

import java.util.Date;

public class Periodico extends MaterialBibliografico {
    private Date fechaPub;
    private String nombre;
    private String seccion;

    public Periodico(String codigo, String titulo, boolean disponible, Date fechaPub, String nombre, String seccion) {
        super(codigo, titulo, disponible);
        this.fechaPub = fechaPub;
        this.nombre = nombre;
        this.seccion = seccion;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Periódico - Nombre: " + nombre + ", Título: " + getTitulo() + ", Fecha: " + fechaPub + ", Sección: " + seccion);
    }
}