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

public class UsuariosController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtApellidoP;
    @FXML private TextField txtApellidoM;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtArea;
    @FXML private TextField txtGrupo;
    @FXML private TextField txtNoControl;
    @FXML private TextField txtCarrera;

    @FXML
    void guardarUsuario(ActionEvent event) {
        // 1. Validar que los campos esenciales no estén vacíos
        if (txtNombre.getText().isEmpty() || txtApellidoP.getText().isEmpty()) {
            System.out.println("Por favor llena los campos obligatorios.");
            return;
        }

        // 2. Crear una nueva instancia de Persona con los datos de las cajas de texto
        Persona nuevaPersona = new Persona(
            txtNombre.getText(),
            txtApellidoP.getText(),
            txtApellidoM.getText(),
            txtTelefono.getText(),
            txtCorreo.getText(),
            txtArea.getText(),
            txtGrupo.getText()
        );

        // 3. Agregar a la lista compartida que usa el TableView
        ListasController.getListaPersonas().add(nuevaPersona);
        System.out.println("¡Usuario registrado con éxito!");

        // 4. Regresar automáticamente a la pantalla de la tabla para ver el registro
        regresarAListas(event);
    }

    @FXML
    void irALista(ActionEvent event) {
        regresarAListas(event);
    }

    @FXML
    void irARegistroBibliotecario(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Pantalla Bibliotecarios.fxml"));
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
