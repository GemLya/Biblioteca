package service;


import model.FiguraGeometrica;

import java.util.ArrayList;

/**
 * Servicio encargado de administrar las figuras geométricas.
 *
 * @author José de Jesús Eduardo Barrientos Avalos
 */
public class FiguraService {

    /**
     * Colección de figuras registradas.
     */
    private ArrayList<FiguraGeometrica> figuras;

    /**
     * Constructor.
     */
    public FiguraService() {

        figuras = new ArrayList<>();
    }

    /**
     * Agrega una figura a la colección.
     */
    public void agregarFigura(FiguraGeometrica figura) {

        figuras.add(figura);

        System.out.println("\nFigura registrada correctamente.");
    }

    /**
     * Muestra todas las figuras almacenadas.
     */
    public void mostrarFiguras() {

        if (figuras.isEmpty()) {

            System.out.println("\nNo existen figuras registradas.");
            return;
        }

        System.out.println("\n===== FIGURAS REGISTRADAS =====");

        for (FiguraGeometrica figura : figuras) {

            figura.mostrarInfo();
        }
    }

    /**
     * Muestra estadísticas generales.
     */
    public void mostrarResumen() {

        if (figuras.isEmpty()) {

            System.out.println("\nNo existen figuras registradas.");
            return;
        }

        double totalAreas = 0;
        double totalPerimetros = 0;

        for (FiguraGeometrica figura : figuras) {

            totalAreas += figura.getArea();
            totalPerimetros += figura.getPerimetro();
        }

        System.out.println("\n===== RESUMEN =====");

        System.out.println("Figuras registradas: " + figuras.size());
        System.out.println("Suma de áreas: " + totalAreas);
        System.out.println("Suma de perímetros: " + totalPerimetros);
    }
}