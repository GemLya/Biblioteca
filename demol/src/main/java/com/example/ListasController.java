package com.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class ListasController {

    @FXML private TableView<Persona> tblPersonas;
    @FXML private TableColumn<Persona, String> colNombre;
    @FXML private TableColumn<Persona, String> colApellidoP;
    @FXML private TableColumn<Persona, String> colApellidoM;
    @FXML private TableColumn<Persona, String> colTelefono;
    @FXML private TableColumn<Persona, String> colCorreo;
    @FXML private TableColumn<Persona, String> colArea;
    @FXML private TableColumn<Persona, String> colGrupo;

    // Esta lista almacena de forma global todos los registros del sistema
    private static ObservableList<Persona> listaPersonas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidoP.setCellValueFactory(new PropertyValueFactory<>("apellidoP"));
        colApellidoM.setCellValueFactory(new PropertyValueFactory<>("apellidoM"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colArea.setCellValueFactory(new PropertyValueFactory<>("area"));
        colGrupo.setCellValueFactory(new PropertyValueFactory<>("grupo"));

        // Asignamos la lista a la tabla
        tblPersonas.setItems(listaPersonas);
    }

    // Método estático para que los otros controladores puedan añadir registros aquí
    public static ObservableList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    @FXML
    void irARegistroUsuarios(ActionEvent event) {
        cambiarPantalla(event, "Pantalla registro.fxml", "Registro de Usuarios");
    }

    @FXML
    void irARegistroBibliotecario(ActionEvent event) {
        cambiarPantalla(event, "Pantalla Bibliotecarios.fxml", "Registro de Bibliotecarios");
    }

    @FXML void irALista(ActionEvent event) {}
    @FXML void confirmarSeleccion(ActionEvent event) { System.out.println("Registros confirmados."); }

    // Función auxiliar para cambiar de ventana dinámicamente
    private void cambiarPantalla(ActionEvent event, String fxmlFile, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
