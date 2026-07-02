package com.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class BibliotecariosController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtApellidoP;
    @FXML private TextField txtApellidoM;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtArea;

    @FXML
    void guardarBibliotecario(ActionEvent event) {
        if (txtNombre.getText().isEmpty() || txtApellidoP.getText().isEmpty()) {
            return;
        }

        // El grupo se manda vacío o como "N/A" ya que es un bibliotecario y no un alumno
        Persona nuevoBibliotecario = new Persona(
            txtNombre.getText(),
            txtApellidoP.getText(),
            txtApellidoM.getText(),
            txtTelefono.getText(),
            txtCorreo.getText(),
            txtArea.getText(),
            "N/A" 
        );

        ListasController.getListaPersonas().add(nuevoBibliotecario);
        System.out.println("¡Bibliotecario registrado con éxito!");

        regresarAListas(event);
    }

    @FXML void irALista(ActionEvent event) { regresarAListas(event); }

    @FXML
    void irARegistroUsuarios(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Pantalla registro.fxml"));
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) { e.printStackTrace(); }
    }

    private void regresarAListas(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Listas.fxml"));
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) { e.printStackTrace(); }
    }
}
