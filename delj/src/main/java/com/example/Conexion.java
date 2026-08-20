package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    private static final String HOST = "localhost";
    private static final String PUERTO = "1433";
    private static final String BASE_DATOS = "biblioteca";
    private static final String USUARIO = "sa";
    
    private static final String PASSWORD = "fts123"; 

    private static final String URL = "jdbc:sqlserver://" + HOST + ":" + PUERTO + ";"
            + "databaseName=" + BASE_DATOS + ";"
            + "user=" + USUARIO + ";"
            + "password=" + PASSWORD + ";"
            + "encrypt=true;"
            + "trustServerCertificate=true;";

    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private Conexion() {}

    public static Connection conectar() throws SQLException {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver de SQL Server (mssql-jdbc).", e);
        }
        return DriverManager.getConnection(URL);
    }

    public static void inicializarBaseDatos() {
        String sql = "IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='libro' AND xtype='U') "
                + "CREATE TABLE libro ("
                + "    id INT IDENTITY(1,1) PRIMARY KEY, "
                + "    titulo NVARCHAR(255) NOT NULL, "
                + "    autor NVARCHAR(255) NOT NULL, "
                + "    disponible BIT DEFAULT 1"
                + ");";

        try (Connection con = conectar();
             Statement stmt = con.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Error al inicializar la base de datos en SQL Server", e);
        }
    }
}