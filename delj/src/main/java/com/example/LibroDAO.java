package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    public List<Libro> listarTodos() {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT id, titulo, autor, disponible FROM libro";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Libro libro = new Libro();
                libro.setId(rs.getInt("id"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setDisponible(rs.getBoolean("disponible"));
                libros.add(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar libros", e);
        }
        return libros;
    }

    public void insertar(Libro libro) {
        String sql = "INSERT INTO libro (titulo, autor, disponible) VALUES (?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setBoolean(3, libro.isDisponible());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar libro", e);
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM libro WHERE id = ?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar libro", e);
        }
    }
}
