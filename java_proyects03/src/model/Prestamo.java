package model;

public class Prestamo {
    private String fechaPrestamo;
    private String fechaDevolucion;
    private Alumno alumno;
    private MaterialBibliografico material;

    public Prestamo(String fechaPrestamo, String fechaDevolucion, Alumno alumno, MaterialBibliografico material) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.alumno = alumno;
        this.material = material;
    }

    public void mostrarInfo() {
        System.out.println("Préstamo - Material: " + material.getTitulo() + " prestado a: " + alumno.getNombre() + " el " + fechaPrestamo);
    }

    public Alumno getAlumno() {
        return this.alumno;
    }

    public MaterialBibliografico getMaterial() {
        return this.material;
    }
}