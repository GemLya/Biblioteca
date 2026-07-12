package edu.utng.controller;

import edu.utng.dao.interfaces.UsuarioDAO;
import edu.utng.dao.impl.UsuarioDAOImpl;
import edu.utng.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * 🧠 CONTROLADOR — ¿Qué hace esta clase?
 * Une la vista FXML con la lógica del negocio (DAO)[cite: 51]. Escucha las acciones 
 * del usuario en la pantalla, manipula los datos y actualiza el TableView reactivamente[cite: 52].
 */
public class UsuarioController {

    // Componentes de la UI mapeados por fx:id [cite: 48, 52]
    @FXML private TextField txtNombre;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtTelefono;
    
    @FXML private TableView<Usuario> tblUsuarios;
    @FXML private TableColumn<Usuario, Number> colId;
    @FXML private TableColumn<Usuario, String> colNombre;
    @FXML private TableColumn<Usuario, String> colCorreo;
    @FXML private TableColumn<Usuario, String> colTelefono;

    // Dependencias del backend [cite: 52]
    private final UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
    private final ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
    private Usuario usuarioSeleccionado = null; // Guarda el usuario que el usuario toque en la tabla

    @FXML
    public void initialize() {
        // 1. Mapear las columnas mediante setCellValueFactory apuntando al modelo [cite: 54, 55]
        colId.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        colNombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty()); // [cite: 56]
        colCorreo.setCellValueFactory(cellData -> cellData.getValue().correoProperty());
        colTelefono.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty());

        // 2. Cargar registros iniciales de la Base de Datos en la tabla
        actualizarTabla();

        // 3. Listener: Detecta qué fila toca el usuario para rellenar el formulario automáticamente [cite: 57]
        tblUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, antiguo, nuevo) -> {
            if (nuevo != null) {
                usuarioSeleccionado = nuevo;
                txtNombre.setText(nuevo.getNombre());
                txtCorreo.setText(nuevo.getCorreo());
                txtTelefono.setText(nuevo.getTelefono());
            }
        });
    }

    // Botón Guardar [cite: 49, 58]
    @FXML
    private void guardarUsuario() {
        if (txtNombre.getText().isEmpty() || txtCorreo.getText().isEmpty()) {
            mostrarAlerta("Campos obligatorios", "Por favor, llena el nombre y correo.");
            return;
        }

        Usuario nuevo = new Usuario(txtNombre.getText(), txtCorreo.getText(), txtTelefono.getText());
        if (usuarioDAO.insertar(nuevo)) {
            actualizarTabla();
            limpiarCampos();
        }
    }

    // Botón Modificar [cite: 58]
    @FXML
    private void modificarUsuario() {
        if (usuarioSeleccionado == null) {
            mostrarAlerta("Selección requerida", "Selecciona un usuario de la tabla para modificarlo.");
            return;
        }
        
        usuarioSeleccionado.setNombre(txtNombre.getText());
        usuarioSeleccionado.setCorreo(txtCorreo.getText());
        usuarioSeleccionado.setTelefono(txtTelefono.getText());
        
        if (usuarioDAO.actualizar(usuarioSeleccionado)) {
            actualizarTabla();
            limpiarCampos();
        }
    }

    // Botón Eliminar [cite: 58]
    @FXML
    private void eliminarUsuario() {
        if (usuarioSeleccionado == null) {
            mostrarAlerta("Selección requerida", "Selecciona un usuario de la tabla para eliminarlo.");
            return;
        }
        
        if (usuarioDAO.eliminar(usuarioSeleccionado.getId())) {
            actualizarTabla();
            limpiarCampos();
        }
    }

    // Botón Limpiar [cite: 58]
    @FXML
    private void limpiarCampos() {
        txtNombre.clear();
        txtCorreo.clear();
        txtTelefono.clear();
        tblUsuarios.getSelectionModel().clearSelection();
        usuarioSeleccionado = null;
    }

    // Refresca la lista reactiva desde SQLite
    private void actualizarTabla() {
        listaUsuarios.setAll(usuarioDAO.listar());
        tblUsuarios.setItems(listaUsuarios);
    }

    // Método utilitario para mandar mensajes de advertencia sencillos
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
