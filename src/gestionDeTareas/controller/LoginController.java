package gestionDeTareas.controller;

import gestionDeTareas.model.Usuario;
import gestionDeTareas.repository.UsuarioDAO;

public class LoginController {

    private final UsuarioDAO usuarioDAO;

    public LoginController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public boolean authenticate(String username, String password) {
        Usuario usuario = new Usuario(null, null, null, username, password);
        return usuarioDAO.validarUsuario(usuario);
    }
}
