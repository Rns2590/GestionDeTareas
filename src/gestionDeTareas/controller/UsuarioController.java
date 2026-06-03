package gestionDeTareas.controller;

import gestionDeTareas.model.Usuario;
import gestionDeTareas.repository.UsuarioDAO;
import java.util.List;

public class UsuarioController {

    private final UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.obtenerTodosUsuarios();
    }

    public void crearUsuario(Usuario usuario) {
        usuarioDAO.agregarUsuario(usuario);
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioDAO.actualizarUsuario(usuario);
    }

    public void eliminarUsuario(int id) {
        usuarioDAO.eliminarUsuario(id);
    }
}
