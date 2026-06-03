package gestionDeTareas.repository;

import java.sql.Connection;
import gestionDeTareas.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {
    
    public void agregarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, apellido, usuario, contraseña) VALUES (?, ?, ?, ?)";
        try (Connection conn = Util.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getUsuario());
            stmt.setString(4, usuario.getContraseña());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Usuario obtenerUsuarioPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = Util.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("usuario"),
                    rs.getString("contraseña")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Usuario> obtenerTodosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios ORDER BY id DESC";
        try (Connection conn = Util.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("usuario"),
                    rs.getString("contraseña")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    
    public void actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, apellido = ?, usuario = ?, contraseña = ? WHERE id = ?";
        try (Connection conn = Util.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getUsuario());
            stmt.setString(4, usuario.getContraseña());
            stmt.setInt(5, usuario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = Util.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean validarUsuario(Usuario usuario) {
        boolean esValido = false;
        String query = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?"; // Asegúrate de que los nombres de las columnas sean correctos.

        try (Connection conn = Util.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContraseña());

            try (ResultSet rs = ps.executeQuery()) {
                esValido = rs.next(); // Si hay resultados, el usuario es válido
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return esValido;
    }
    
}
