package model;

public class Persona{
    private String nombre;
    private double peso;
    private double est;
    private double imc;
    private String estatus;


    public Persona(String nombre){
        this.nombre = nombre;
    }


    public Persona(String nombre, double peso, double est){
        this.nombre = nombre;
        this.peso = peso;
        this.est = est;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public void setEst(double est){
        this.est = est;
    }

    public void calcularIMC(){
        this.imc = this.peso/(this.est*this.est);
    }

    public void defineEstastus(){
        this.calcularIMC();
        if (imc <= 18.5)
            this.estatus = "Bajo Peso";
        else if (imc < 25)
            this.estatus = "Peso Normal";
        else if (imc < 30)
            this.estatus ="Sobrepeso";
    }


    public String getNombre() {
        return nombre;
    }

    public double getImc() {
        return imc;
    }
    
    public String getEstatus() {
        return estatus;
    }

    @Override
    public String toString() {
        return "Nombre" + this.nombre + "\n"+
            "Peso" + this.peso + "\n"+
            "Estatura" + this.est + "\n"+
            "IMC:" + this.imc + "\n"+
            "Estatus: " + this.estatus;

    }
}
