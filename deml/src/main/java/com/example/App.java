package com.example;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Vehiculo> pista = new ArrayList<>();

        pista.add(new Auto("ABC-123", "Ferrari", 140));
        pista.add(new Moto("XYZ-987", "Yamaha", 95));
        pista.add(new Camion("MNO-555", "Volvo", 70));

        System.out.println("=== REVISIÓN DE RADAR DE VELOCIDAD ===");

        for (Vehiculo v : pista) {
            if (v.comprobarExcesoVelocidad()) {
                System.out.println("🚨 ALERTA: " + v.getClass().getSimpleName() +
                        " [" + v.getPatente() + "] excede el límite. Vel: " + v.getVelocidadActual() + " km/h");
            } else {
                System.out.println("✅ OK: " + v.getClass().getSimpleName() +
                        " [" + v.getPatente() + "] velocidad bajo control.");
            }
        }
    }
}
