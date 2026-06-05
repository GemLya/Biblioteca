package model;

/**
 * Representa un círculo.
 */
public class Circulo extends FiguraGeometrica {

    /**
     * dimension1 representa el radio.
     */
    public Circulo(double radio) {

        super("Círculo", radio, 0);

        calcularArea();
        calcularPerimetro();
    }

    @Override
    public void calcularArea() {

        area = Math.PI * Math.pow(dimension1, 2);
    }

    @Override
    public void calcularPerimetro() {

        perimetro = 2 * Math.PI * dimension1;
    }
}