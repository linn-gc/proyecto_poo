package gui;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import modelo.negocio.SistemaVentas;

/**
 * Clase principal del sistema
 * Punto de entrada de la aplicación
 */
public class Main {
    
    public static void main(String[] args) {
        // Configurar Look and Feel del sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Iniciar la aplicación en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            // Crear instancia del sistema
            SistemaVentas sistema = new SistemaVentas();
            
            // Cargar datos de prueba
            cargarDatosPrueba(sistema);
            
            // Mostrar pantalla de login
            frmLogin loginFrame = new frmLogin(sistema);
            loginFrame.setVisible(true);
        });
    }
    
    /**
     * Carga datos de prueba en el sistema
     */
    private static void cargarDatosPrueba(SistemaVentas sistema) {
        System.out.println("Cargando datos de prueba...");
        
        // Aquí puedes agregar datos de prueba si lo necesitas
        // Por ejemplo:
        // sistema.registrarEmpleado(...);
        // sistema.registrarVehiculo(...);
        // etc.
        
        System.out.println("Sistema inicializado correctamente");
    }
}