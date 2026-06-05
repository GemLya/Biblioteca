package model;

public class Pentagono extends FiguraGeometrica {

    private double lado;
    private double apotema;

    public Pentagono(String nombre, double lado, double apotema) {
        super("Pentagono", lado, apotema);
        this.lado = lado;
        this.apotema = apotema;
       

        calcularArea();
        calcularPerimetro();
    }

    @Override
    public void calcularArea() {

        area = ((5 * lado) * apotema) / 2;
    }

    @Override
    public void calcularPerimetro() {

        perimetro = 5 * lado;
    }

    @Override
    public void mostrarInfo() {

        System.out.println("\nPentágono");
        System.out.println("Lado: " + lado);
        System.out.println("Apotema: " + apotema);
        System.out.println("Área: " + area);
        System.out.println("Perímetro: " + perimetro);
    }
}