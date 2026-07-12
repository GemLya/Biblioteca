package edu.utng.app;

import edu.utng.dao.Conexion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Inicializa automáticamente tus tablas en SQLite al arrancar [cite: 4]
        Conexion.inicializarBaseDatos(); 
        
       URL fxmlLocation = Main.class.getResource("/edu/utng/usuario_view.fxml");
        
        if (fxmlLocation == null) {
            throw new IllegalArgumentException("¡Error Crítico! No se encontró el archivo usuario_view.fxml en resources/edu/utng/");
        }
        
        Parent root = FXMLLoader.load(fxmlLocation);
        primaryStage.setTitle("Gestión de Biblioteca - Usuarios");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}