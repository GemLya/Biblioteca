package edu.utng.model;

import javafx.beans.property.*;

public class Usuario {
    // Propiedades reactivas para enlazar datos con la interfaz de JavaFX
    private final IntegerProperty id;
    private final StringProperty nombre;
    private final StringProperty correo;
    private final StringProperty telefono;

    // 1. Constructor CON ID: Se utiliza para mapear los registros que se leen desde la Base de Datos
    public Usuario(int id, String nombre, String correo, String telefono) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.correo = new SimpleStringProperty(correo);
        this.telefono = new SimpleStringProperty(telefono);
    }

    // 2. Constructor SIN ID: Se utiliza cuando creas un usuario nuevo en el formulario para insertarlo (la BD genera el ID)
    public Usuario(String nombre, String correo, String telefono) {
        this.id = new SimpleIntegerProperty(); // Se inicializa vacío (0)
        this.nombre = new SimpleStringProperty(nombre);
        this.correo = new SimpleStringProperty(correo);
        this.telefono = new SimpleStringProperty(telefono);
    }

    // --- Métodos Property (Requeridos por JavaFX para el TableView) ---
    public IntegerProperty idProperty() { 
        return id; 
    }
    
    public StringProperty nombreProperty() { 
        return nombre; 
    }
    
    public StringProperty correoProperty() { 
        return correo; 
    }
    
    public StringProperty telefonoProperty() { 
        return telefono; 
    }

    // --- Getters y Setters Tradicionales ---
    public int getId() { 
        return id.get(); 
    }
    
    public void setId(int id) { 
        this.id.set(id); 
    }

    public String getNombre() { 
        return nombre.get(); 
    }
    
    public void setNombre(String nombre) { 
        this.nombre.set(nombre); 
    }

    public String getCorreo() { 
        return correo.get(); 
    }
    
    public void setCorreo(String correo) { 
        this.correo.set(correo); 
    }

    public String getTelefono() { 
        return telefono.get(); 
    }
    
    public void setTelefono(String telefono) { 
        this.telefono.set(telefono); 
    }
}
