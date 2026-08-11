public abstract class Vehiculo {
    private String patente;
    private String marca;
    private double velocidadActual;

    // Generado con Alt + Shift + S -> Generate Constructors
    public Vehiculo(String patente, String marca, double velocidadActual) {
        this.patente = patente;
        this.marca = marca;
        this.velocidadActual = velocidadActual;
    }

    // Generado con Alt + Shift + S -> Generate Getters and Setters
    public String getPatente() { return patente; }
    public String getMarca() { return marca; }
    public double getVelocidadActual() { return velocidadActual; }

    // Método abstracto que implementará cada subclase
    public abstract boolean comprobarExcesoVelocidad();
}
