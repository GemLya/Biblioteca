package com.example;

public class Moto extends Vehiculo {
    public Moto(String patente, String marca, double velocidadActual) {
        super(patente, marca, velocidadActual);
    }

    @Override
    public boolean comprobarExcesoVelocidad() {
        // Límite de velocidad para motos: 110 km/h
        return this.getVelocidadActual() > 110;
    }
}
