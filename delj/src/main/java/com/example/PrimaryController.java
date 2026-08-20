package com.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {

    @FXML private TextField txtTitulo;
    @FXML private TextField txtAutor;
    @FXML private CheckBox chkDisponible;
    
    @FXML private TableView<Libro> tablaLibros;
    @FXML private TableColumn<Libro, Integer> colId;
    @FXML private TableColumn<Libro, String> colTitulo;
    @FXML private TableColumn<Libro, String> colAutor;
    @FXML private TableColumn<Libro, Boolean> colDisponible;

    // Se instancia directamente la clase LibroDAO que ya tienes creada
    private final LibroDAO libroDAO = new LibroDAO();
    private final ObservableList<Libro> listaLibros = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colDisponible.setCellValueFactory(new PropertyValueFactory<>("disponible"));

        cargarLibros();
    }

    private void cargarLibros() {
        listaLibros.clear();
        // Usamos el método 'listarTodos()' que aparece en tu archivo LibroDAO.java
        listaLibros.addAll(libroDAO.listarTodos());
        tablaLibros.setItems(listaLibros);
    }

    @FXML
    private void guardarLibro(ActionEvent event) {
        String titulo = txtTitulo.getText().trim();
        String autor = txtAutor.getText().trim();

        if (titulo.isEmpty() || autor.isEmpty()) {
            mostrarAlerta("Campos vacíos", "Por favor ingresa el título y el autor.");
            return;
        }

        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setDisponible(chkDisponible.isSelected());

        libroDAO.insertar(libro);
        
        limpiarFormulario();
        cargarLibros();
    }

    @FXML
    private void eliminarLibro(ActionEvent event) {
        Libro libroSeleccionado = tablaLibros.getSelectionModel().getSelectedItem();
        if (libroSeleccionado != null) {
            libroDAO.eliminar(libroSeleccionado.getId());
            cargarLibros();
        } else {
            mostrarAlerta("Selección requerida", "Selecciona un libro de la tabla para eliminar.");
        }
    }

    private void limpiarFormulario() {
        txtTitulo.clear();
        txtAutor.clear();
        chkDisponible.setSelected(true);
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}