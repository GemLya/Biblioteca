package view;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Persona;

public class Consola {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in); //Teclado

        //System.out.println("Escribe el nombre de la persona:");
        //String nombre = lector.nextLine();
        
        
        //Nombre Persona
        String nombre = JOptionPane.showInputDialog("Escribe el nombre de la persona: ");


        Persona per = new Persona(nombre);
        boolean errorEncontrado=false;
        double peso = 0;
        double est = 0;

        do{ 
            try{
                String entrada = JOptionPane.showInputDialog("Introduzca el peso de " + nombre);
                peso = Double.parseDouble(entrada);
                errorEncontrado=false;
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, 
                    "Ha ocurrido un error",
                     "Error",
                    JOptionPane.ERROR_MESSAGE);
                errorEncontrado=true;
            }
        }while(errorEncontrado == true);

        per.setPeso(peso);

        do{
            try{
                String entrada2 = JOptionPane.showInputDialog("Introduzca la estatura de " + nombre);
                est = Double.parseDouble(entrada2);
                errorEncontrado= false;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,
                    "Ha Ocurrido un error",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                errorEncontrado=true;
            }
        }while (errorEncontrado == true);
        
        per.setEst(est);

        per.defineEstastus();
        
        System.out.println(per); //Es para mostrar el resultsado (ShowMessage)
        
        JOptionPane.showMessageDialog(null, per);

    }
}