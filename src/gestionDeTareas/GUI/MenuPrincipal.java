package gestionDeTareas.GUI;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class MenuPrincipal extends javax.swing.JFrame {

    
    public MenuPrincipal() {
        initComponents();
        mostrarLoginConDelay(); // Muestra el JInternalFrame de Login al iniciar
    }
    
    private void mostrarLoginConDelay() {
    // Crear un Timer para la pausa
    Timer timer = new Timer(500, e -> {
        mostrarLogin(); // Muestra el JInternalFrame de Login
        menuPrincipal.setEnabled(false); // Deshabilita el JMenuBar
    });
    timer.setRepeats(false); // Asegúrate de que el Timer no se repita
    timer.start(); // Inicia el Timer
    }
        
    private void mostrarLogin() {
        Login login = new Login();
        Dimension escritorioSize = Escritorio.getSize();
         // Calcular la posición para centrar el JInternalFrame
        int x = (escritorioSize.width - login.getWidth()) / 2;
        int y = (escritorioSize.height - login.getHeight()) / 2;
        login.setLocation(x, y);
        Escritorio.add(login);
        // bloque el menu para que no se pueda realizar ningun accion
        Menu.setEnabled(false);
        login.setVisible(true); // Muestra el JInternalFrame
        
          // Después de que se cierre el JInternalFrame, habilitar de nuevo la barra de menú
        login.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
                Menu.setEnabled(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        menuPrincipal = new javax.swing.JMenuBar();
        Menu = new javax.swing.JMenu();
        OpcionUsuarios = new javax.swing.JMenuItem();
        OpcionTareas = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        OpcionSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Tareas");
        setName("MainWindows"); // NOI18N

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );

        Menu.setText("Menu");

        OpcionUsuarios.setText("Usuarios");
        OpcionUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionUsuariosActionPerformed(evt);
            }
        });
        Menu.add(OpcionUsuarios);

        OpcionTareas.setText("Tareas");
        Menu.add(OpcionTareas);
        Menu.add(jSeparator1);

        OpcionSalir.setText("Salir");
        OpcionSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionSalirActionPerformed(evt);
            }
        });
        Menu.add(OpcionSalir);

        menuPrincipal.add(Menu);

        setJMenuBar(menuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpcionUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionUsuariosActionPerformed
        // TODO add your handling code here:
    Usuarios usuarios = new Usuarios();
    Dimension escritorioSize = Escritorio.getSize();//aca tomo las dimensions del escritorio
    //usuarios.setSize(desktopSize.width, desktopSize.height);
    usuarios.setSize(800,600);
    //usuarios.setLocation(0, 0);
    // Calcular la posición para centrar el JInternalFrame
    int x = (escritorioSize.width - usuarios.getWidth()) / 2;
    int y = (escritorioSize.height - usuarios.getHeight()) / 2;
    // Posicionar el JInternalFrame en el centro del Escritorio
    usuarios.setLocation(x, y);
    Escritorio.add(usuarios);
    usuarios.setVisible(true);
        
    }//GEN-LAST:event_OpcionUsuariosActionPerformed

    private void OpcionSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionSalirActionPerformed
        // TODO add your handling code here:
        // Cerrar la aplicación
        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0); // Cierra la aplicación
        }
    }//GEN-LAST:event_OpcionSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                MenuPrincipal menu = new MenuPrincipal();
                menu.setLocationRelativeTo(null); // Centra la ventana
                menu.setVisible(true); // Hacer visible el JFrame
           
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenu Menu;
    private javax.swing.JMenuItem OpcionSalir;
    private javax.swing.JMenuItem OpcionTareas;
    private javax.swing.JMenuItem OpcionUsuarios;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuBar menuPrincipal;
    // End of variables declaration//GEN-END:variables
}
