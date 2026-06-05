package util;

import java.util.Scanner;

/**
 * Clase utilitaria para lectura de datos desde teclado.
 *
 * Permite reutilizar un único Scanner en toda la aplicación.
 *
 * @author José de Jesús Eduardo Barrientos Avalos
 */
public class Consola {

    //Activa el lector y lo conecta al teclado de la computadora.

    private static final Scanner teclado = new Scanner(System.in);

    /**
     * Lee una cadena de texto.
     */
    public static String leerTexto(String mensaje) {

        System.out.print(mensaje);

        return teclado.nextLine();
    }

    /**
     * Lee un número entero.
     */
    public static int leerEntero(String mensaje) {

        System.out.print(mensaje);

        return Integer.parseInt(teclado.nextLine());
    }

    /**
     * Lee un número decimal.
     */
    public static double leerDouble(String mensaje) {

        System.out.print(mensaje);

        return Double.parseDouble(teclado.nextLine());
    }
}