package model;

public class Alumno {
    private String matricula;
    private String nombre;
    private String carrera;
    private int cuatrimestre;
    private String correo;

    public Alumno(String matricula, String nombre, String carrera, int cuatrimestre, String correo) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.carrera = carrera;
        this.cuatrimestre = cuatrimestre;
        this.correo = correo;
    }

    public void mostrarInfo() {
        System.out.println("Alumno - Matrícula: " + matricula + ", Nombre: " + nombre + ", Carrera: " + carrera);
    }

    // Getters
    public String getMatricula() { return matricula; }
    public String getNombre() { return nombre; }
}
