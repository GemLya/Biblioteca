import model.Circulo;
import model.Cuadrado;
import model.Rectangulo;
import model.Triangulo;
import model.Pentagono;

import service.FiguraService;
import util.Consola;

/**
 * Sistema de cálculo de figuras geométricas.
 *
 * Demuestra:
 * - Herencia
 * - Polimorfismo
 * - Clases abstractas
 * - Encapsulamiento
 *
 * @author José de Jesús Eduardo Barrientos Avalos
 */
public class Main {

    public static void main(String[] args) {

        FiguraService service = new FiguraService();

        int opcion;

        do {

            mostrarMenu();

            opcion = Consola.leerEntero("\nSeleccione una opción: ");

            switch (opcion) {

                case 1:

                    registrarCirculo(service);
                    break;

                case 2:

                    registrarCuadrado(service);
                    break;

                case 3:

                    registrarRectangulo(service);
                    break;

                case 4:

                    registrarTriangulo(service);
                    break;
                
                case 5:
                    registrarPentagono(service);
                    break;

                case 6:

                    service.mostrarFiguras();
                    break;

                case 7:

                    service.mostrarResumen();
                    break;

                case 8:

                    System.out.println("\n👋 Programa finalizado.");
                    break;

                default:

                    System.out.println("\n❌ Opción inválida.");
            }

        } while (opcion != 8);
    }

    /**
     * Muestra el menú principal.
     */
    private static void mostrarMenu() {

        System.out.println("\n===============================");
        System.out.println(" SISTEMA DE FIGURAS GEOMÉTRICAS");
        System.out.println("===============================");
        System.out.println("1. Registrar círculo");
        System.out.println("2. Registrar cuadrado");
        System.out.println("3. Registrar rectángulo");
        System.out.println("4. Registrar triángulo");
        System.out.println("5: Registrar Pentágono:");
        System.out.println("6. Mostrar figuras");
        System.out.println("7. Mostrar resumen");
        System.out.println("8. Salir");
    }

    /**
     * Registrar círculo.
     */
    private static void registrarCirculo(FiguraService service) {

        double radio = Consola.leerDouble("Ingrese el radio: ");

        service.agregarFigura(new Circulo(radio));
    }

    /**
     * Registrar cuadrado.
     */
    private static void registrarCuadrado(FiguraService service) {

        double lado = Consola.leerDouble("Ingrese el lado: ");

        service.agregarFigura(new Cuadrado(lado));
    }

    /**
     * Registrar rectángulo.
     */
    private static void registrarRectangulo(FiguraService service) {

        double base = Consola.leerDouble("Ingrese la base: ");

        double altura = Consola.leerDouble("Ingrese la altura: ");

        service.agregarFigura(new Rectangulo(base, altura));
    }

    /**
     * Registrar triángulo.
     */
    private static void registrarTriangulo(FiguraService service) {

        double base = Consola.leerDouble("Ingrese la base: ");

        double altura = Consola.leerDouble("Ingrese la altura: ");

        double lado2 = Consola.leerDouble("Ingrese el lado 2: ");

        double lado3 = Consola.leerDouble("Ingrese el lado 3: ");

        service.agregarFigura( new Triangulo(base, altura, lado2, lado3));
    }

    /**
 *  Pentágono.
 */
private static void registrarPentagono(FiguraService service) {

    double lado = Consola.leerDouble("Ingrese la medida del lado: ");

    double apotema = Consola.leerDouble("Ingrese la apotema: ");

    service.agregarFigura(new Pentagono("Pentagono",lado, apotema));
}

}