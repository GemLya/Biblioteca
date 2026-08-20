module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;

    opens com.example to javafx.fxml, javafx.base;
    exports com.example;
}