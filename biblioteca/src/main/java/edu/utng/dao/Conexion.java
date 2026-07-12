package edu.utng.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 💡 NOTA PARA JUNIOR — ¿Qué hace esta clase?
 * Es el puente de comunicación entre tu aplicación de Java y el motor de Base de Datos.
 * En este caso estás usando SQLite, una base de datos embebida muy ligera que no requiere 
 * instalar un servidor externo (como MySQL o Postgres); se guarda todo en un simple archivo de texto.
 */
public class Conexion {
    
    /**
     * URL de conexión (Connection String): Es la dirección que le dice a Java qué motor usar y dónde está el archivo.
     * "jdbc:sqlite:" -> Especifica que el driver/conector es para SQLite.
     * "biblioteca.db" -> Es el nombre del archivo físico que se creará automáticamente en la raíz de tu proyecto.
     */
    private static final String URL = "jdbc:sqlite:biblioteca.db";

    /**
     * Abre una conexión activa con el archivo de la base de datos.
     * * static: Permite invocar este método desde cualquier parte de tu código sin necesidad de hacer un 'new Conexion()'. 
     * Ejemplo de uso: Connection c = Conexion.getConexion();
     * throws错 SQLException: Le avisas a quien sea que llame a este método que debe estar preparado para manejar un posible error.
     * @return Un objeto de tipo Connection listo para ejecutar consultas SQL.
     */
    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    /**
     * Método de inicialización (Setup). 
     * Se debe ejecutar una sola vez al arrancar tu aplicación (normalmente desde la clase Main) 
     * para asegurar que la base de datos y las tablas existan antes de que el usuario intente guardar algo.
     */
    public static void inicializarBaseDatos() {
        // 1. Definición de las sentencias SQL
        String sqlUsuarios = "CREATE TABLE IF NOT EXISTS usuarios ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nombre TEXT NOT NULL, "
                + "correo TEXT UNIQUE NOT NULL, "
                + "telefono TEXT"
                + ");";
                
        String sqlLibros = "CREATE TABLE IF NOT EXISTS libros ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "titulo TEXT NOT NULL, "
                + "autor TEXT NOT NULL"
                + ");";

        /**
         * 🔄 TRY-WITH-RESOURCES (Súper importante para un Junior):
         * Al declarar 'conn' y 'stmt' dentro de los paréntesis del try, Java se encarga AUTOMÁTICAMENTE 
         * de cerrarlos al terminar el bloque, incluso si ocurre un error inesperado.
         * Si olvidas cerrar las conexiones, provocarás una fuga de memoria (Memory Leak) y tu archivo .db se bloqueará.
         */
        try (Connection conn = getConexion(); 
             Statement stmt = conn.createStatement()) {
            
            // Ejecución de tabla Usuarios
            stmt.execute(sqlUsuarios);
            System.out.println("Tabla 'usuarios' verificada/creada con éxito.");
            
            // Ejecución de tabla Libros
            stmt.execute(sqlLibros);
            System.out.println("Base de datos y tabla 'libros' verificadas/creadas con éxito.");

        } catch (SQLException e) {
            System.err.println("Error al inicializar la base de datos: " + e.getMessage());
        }
    }
}