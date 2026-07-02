package com.example;

public class Persona {
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String telefono;
    private String correo;
    private String area;
    private String grupo;

    public Persona(String nombre, String apellidoP, String apellidoM, String telefono, String correo, String area, String grupo) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.correo = correo;
        this.area = area;
        this.grupo = grupo;
    }

    // Getters necesarios para que el TableView acceda a los datos
    public String getNombre() { return nombre; }
    public String getApellidoP() { return apellidoP; }
    public String getApellidoM() { return apellidoM; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
    public String getArea() { return area; }
    public String getGrupo() { return grupo; }
}
