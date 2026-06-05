package model;

/**
 * Representa un rectángulo.
 */
public class Rectangulo extends FiguraGeometrica {

    /**
     * dimension1 = base
     * dimension2 = altura
     */
    public Rectangulo(double base, double altura) {

        super("Rectángulo", base, altura);

        calcularArea();
        calcularPerimetro();
    }

    @Override
    public void calcularArea() {

        area = dimension1 * dimension2;
    }

    @Override
    public void calcularPerimetro() {

        perimetro = (2 * dimension1) + (2 * dimension2);
    }
}