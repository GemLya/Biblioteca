module biblioteca {
    // Se agregan las directivas de requerimientos del sistema JavaFX y SQL
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires transitive javafx.base;
    requires transitive javafx.graphics;

    // 1. Permite que JavaFX ejecute el ciclo de vida de tu aplicación desde Main
    exports edu.utng.app;
    opens edu.utng.app to javafx.graphics, javafx.fxml;

    // 2. Permite que TableView acceda a las propiedades del modelo de datos reactivo
    exports edu.utng.model;
    opens edu.utng.model to javafx.base, javafx.fxml;

    // 3. Abre los controladores a JavaFX para vincular los botones (@FXML) y eventos
    exports edu.utng.controller;
    opens edu.utng.controller to javafx.fxml;
    
    // 4. Exporta las interfaces y la capa de persistencia hacia el proyecto
    exports edu.utng.dao;
    exports edu.utng.dao.interfaces;
    exports edu.utng.dao.impl;
}