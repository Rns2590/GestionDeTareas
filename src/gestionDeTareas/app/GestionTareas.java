package gestionDeTareas.Logica;
import javax.swing.JFrame;
import gestionDeTareas.GUI.MenuPrincipal; // Importar la clase JFrame
/**
 * @author silva
 */
import java.sql.Connection;
import java.sql.SQLException;

public class GestionTareas {
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Intentar conectar a la base de datos
        try (Connection conn = Util.getConnection()) {
            if (conn != null) {
                System.out.println("Conexión exitosa a la base de datos!");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        
        UsuarioDAO  usuarioDAO = new UsuarioDAO();
        // Creación de un nuevo usuario
        //Usuario nuevoUsuario = new Usuario(null,"Pepe","Sapo","psapo","123456");
       //usuarioDAO.agregarUsuario(nuevoUsuario);
        // Traer todos los usuarios 
        System.out.println(usuarioDAO.obtenerTodosUsuarios());
        
        // Ejecutar el JFrame en el hilo de eventos
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            gestionDeTareas.GUI.MenuPrincipal menu = new gestionDeTareas.GUI.MenuPrincipal();
            menu.setExtendedState(JFrame.MAXIMIZED_BOTH); // Establecemos el tamaño de la ventana
            menu.setLocationRelativeTo(null); // Centra la ventana
            menu.setVisible(true); // Hace visible el JFrame
            }
    });
        //UsuarioDAO  usuarioDAO = new UsuarioDAO();
        // Creación de un nuevo usuario
        //Usuario nuevoUsuario = new Usuario(null,"Martin","Molina","mmolina","123456");
       //usuarioDAO.agregarUsuario(nuevoUsuario);
        // Traer todos los usuarios 
        //System.out.println(usuarioDAO.obtenerTodosUsuarios());
        
       
        
    }    
}
