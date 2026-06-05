package model;

/**
 * Representa un triángulo.
 */
public class Triangulo extends FiguraGeometrica {

    private double lado2;
    private double lado3;

    /**
     * dimension1 = base
     * dimension2 = altura
     */
    public Triangulo(double base, double altura, double lado2, double lado3) {

        super("Triángulo", base, altura);

        this.lado2 = lado2;
        this.lado3 = lado3;

        calcularArea();
        calcularPerimetro();
    }

    @Override
    public void calcularArea() {

        area = (dimension1 * dimension2) / 2;
    }

    @Override
    public void calcularPerimetro() {

        perimetro = dimension1 + lado2 + lado3;
    }
}