package model;
import java.time.LocalDate;

public class Persona {
    private String apellidos;
    private String nombre;
    private String sexo;
    private String rfc;
    private LocalDate fechaNacimiento;
    private String escolaridad;
    private String telefono;
    private String correo;

    // Constructor
    public Persona(String apellidos, String nombre, String sexo, String rfc, 
                   LocalDate fechaNacimiento, String escolaridad, String telefono, String correo) {
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.sexo = sexo;
        this.rfc = rfc;
        this.fechaNacimiento = fechaNacimiento;
        this.escolaridad = escolaridad;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Método para mostrar los datos (útil para la prueba)
    @Override
    public String toString() {
        return "Persona{" +
                "Nombre='" + nombre + " " + apellidos + '\'' +
                ", Sexo='" + sexo + '\'' +
                ", RFC='" + rfc + '\'' +
                ", Fecha Nac.=" + fechaNacimiento +
                ", Escolaridad='" + escolaridad + '\'' +
                ", Teléfono='" + telefono + '\'' +
                ", Correo='" + correo + '\'' +
                '}';
    }
}