package com.example;

public class Auto extends Vehiculo {
    public Auto(String patente, String marca, double velocidadActual) {
        super(patente, marca, velocidadActual);
    }

    @Override
    public boolean comprobarExcesoVelocidad() {
        // Límite de velocidad para autos: 120 km/h
        return this.getVelocidadActual() > 120;
    }
}
