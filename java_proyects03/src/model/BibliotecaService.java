package model;

import java.util.ArrayList;

public class BibliotecaService {
    private ArrayList<MaterialBibliografico> materiales;
    private ArrayList<Alumno> alumnos;
    private ArrayList<Prestamo> prestamos;

    public BibliotecaService() {
        this.materiales = new ArrayList<>();
        this.alumnos = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public void mostrarInfo() {
        System.out.println("Biblioteca Service - Total Materiales: " + materiales.size() + ", Alumnos: " + alumnos.size() + ", Préstamos activos: " + prestamos.size());
    }

    public void agregarMaterial(MaterialBibliografico material) {
        materiales.add(material);
        System.out.println("Material agregado: " + material.getTitulo());
    }

    public void registrarAlumno(Alumno alumno) {
        alumnos.add(alumno);
        System.out.println("Alumno registrado: " + alumno.getNombre());
    }

    public void registrarPrestamo(Alumno alumno, MaterialBibliografico material) {
        if (material.puedePrestarse()) {
            // Se asume fechas estáticas o actuales para el ejemplo rápido
            Prestamo nuevoPrestamo = new Prestamo("02/06/2026", "16/06/2026", alumno, material);
            prestamos.add(nuevoPrestamo);
            material.setDisponible(false); // Al prestarse, ya no está disponible
            System.out.println("Préstamo registrado con éxito.");
        } else {
            System.out.println("No se puede registrar el préstamo. El material no está disponible.");
        }
    }

    public void mostrarMateriales() {
        System.out.println("--- Lista de Materiales ---");
        for (MaterialBibliografico mat : materiales) {
            mat.mostrarInfo();
        }
    }

    public void mostrarPrestamos() {
        System.out.println("--- Lista de Préstamos ---");
        for (Prestamo p : prestamos) {
            p.mostrarInfo();
        }
    }
}
