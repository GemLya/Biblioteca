package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CapturaController {
    private TextField txtNombre;

    @FXML
    private void saludar () throws IOException{
        String nombre= txtNombre.getText();


        System.out.println("Hola" + nombre);
        GeneradorSaludo saludo= new GeneradorSaludo();
        String mensaje = saludo.generar(nombre);
        SaludoController.setMesaje(mensaje);
        App.setRoot("secondary");
    }
}