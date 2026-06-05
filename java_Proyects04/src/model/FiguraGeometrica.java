package model;

/**
 * Clase abstracta que representa cualquier figura geométrica.
 *
 * Contiene los atributos comunes a todas las figuras y define
 * los métodos que deberán implementar las clases hijas.
 *
 * @author José de Jesús Eduardo Barrientos Avalos
 */
public abstract class FiguraGeometrica {

    /**
     * Nombre de la figura.
     */
    protected String nombre;

    /**
     * Primera dimensión.
     *
     * Puede representar:
     * - Radio en un círculo
     * - Lado en un cuadrado
     * - Base en un rectángulo o triángulo
     */
    protected double dimension1;

    /**
     * Segunda dimensión.
     *
     * Puede representar:
     * - Altura en rectángulos
     * - Altura en triángulos
     * - No utilizarse en círculos y cuadrados
     */
    protected double dimension2;

    /**
     * Área calculada de la figura.
     */
    protected double area;

    /**
     * Perímetro calculado de la figura.
     */
    protected double perimetro;

    /**
     * Constructor general.
     */
    public FiguraGeometrica(String nombre, double dimension1, double dimension2) {

        this.nombre = nombre;
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
    }

    /**
     * Cada figura implementará su propia fórmula.
     */
    public abstract void calcularArea();

    /**
     * Cada figura implementará su propia fórmula.
     */
    public abstract void calcularPerimetro();

    /**
     * Muestra la información general de la figura.
     */
    public void mostrarInfo() {

        System.out.println("\n========================");
        System.out.println("Figura: " + nombre);
        System.out.println("Área: " + area);
        System.out.println("Perímetro: " + perimetro);
        System.out.println("========================");
    }

    public String getNombre() {
        return nombre;
    }

    public double getArea() {
        return area;
    }

    public double getPerimetro() {
        return perimetro;
    }
}
