package gui;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import modelo.negocio.SistemaVentas;
import modelo.personas.Administrador;

/**
 * Menú principal del Administrador - NetBeans Form
 */
public class MenuAdministradorFrame extends javax.swing.JFrame {
    
    private SistemaVentas sistema;
    private Administrador administrador;
    
    public MenuAdministradorFrame(SistemaVentas sistema, Administrador admin) {
        this.sistema = sistema;
        this.administrador = admin;
        initComponents();
        personalizarComponentes();
        actualizarEstadisticas();
    }
    
    private void personalizarComponentes() {
        // Panel superior
        panelSuperior.setBackground(new Color(41, 128, 185));
        lblTituloPrincipal.setForeground(Color.WHITE);
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setText(administrador.getNombreCompleto() + " (" + administrador.getRol() + ")");
        
        // Estadísticas
        lblEmpleados.setBackground(new Color(52, 152, 219));
        lblVehiculos.setBackground(new Color(46, 204, 113));
        lblClientes.setBackground(new Color(155, 89, 182));
        lblVentas.setBackground(new Color(230, 126, 34));
        
        // Botones
        btnEmpleados.setBackground(new Color(52, 152, 219));
        btnVehiculos.setBackground(new Color(46, 204, 113));
        btnPromociones.setBackground(new Color(155, 89, 182));
        btnClientes.setBackground(new Color(241, 196, 15));
        btnVentas.setBackground(new Color(230, 126, 34));
        btnReportes.setBackground(new Color(26, 188, 156));
        btnInventario.setBackground(new Color(52, 73, 94));
        btnConfiguracion.setBackground(new Color(127, 140, 141));
        btnCerrarSesion.setBackground(new Color(231, 76, 60));
        
        // Footer
        panelInferior.setBackground(new Color(236, 240, 241));
    }
    
    private void actualizarEstadisticas() {
        lblEmpleados.setText("👥 Empleados: " + sistema.getEmpleados().size());
        lblVehiculos.setText("🚗 Vehículos: " + sistema.getVehiculos().size());
        lblClientes.setText("👨‍💼 Clientes: " + sistema.getClientes().size());
        lblVentas.setText("💰 Ventas: " + sistema.getVentas().size());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        lblTituloPrincipal = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        panelEstadisticas = new javax.swing.JPanel();
        lblEmpleados = new javax.swing.JLabel();
        lblVehiculos = new javax.swing.JLabel();
        lblClientes = new javax.swing.JLabel();
        lblVentas = new javax.swing.JLabel();
        panelBotones = new javax.swing.JPanel();
        btnEmpleados = new javax.swing.JButton();
        btnVehiculos = new javax.swing.JButton();
        btnPromociones = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnConfiguracion = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        panelInferior = new javax.swing.JPanel();
        lblFooter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Concesionaria - Administrador");

        lblTituloPrincipal.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        lblTituloPrincipal.setText("  PANEL DE ADMINISTRADOR");

        lblUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario.setText("Usuario  ");

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(lblUsuario))
                .addContainerGap())
        );

        panelEstadisticas.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 40, 20, 40));
        panelEstadisticas.setLayout(new java.awt.GridLayout(1, 4, 15, 15));

        lblEmpleados.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        lblEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmpleados.setText("👥 Empleados: 0");
        lblEmpleados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblEmpleados.setOpaque(true);
        panelEstadisticas.add(lblEmpleados);

        lblVehiculos.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblVehiculos.setForeground(new java.awt.Color(255, 255, 255));
        lblVehiculos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVehiculos.setText("🚗 Vehículos: 0");
        lblVehiculos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblVehiculos.setOpaque(true);
        panelEstadisticas.add(lblVehiculos);

        lblClientes.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblClientes.setForeground(new java.awt.Color(255, 255, 255));
        lblClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClientes.setText("👨‍💼 Clientes: 0");
        lblClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblClientes.setOpaque(true);
        panelEstadisticas.add(lblClientes);

        lblVentas.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblVentas.setForeground(new java.awt.Color(255, 255, 255));
        lblVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVentas.setText("💰 Ventas: 0");
        lblVentas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblVentas.setOpaque(true);
        panelEstadisticas.add(lblVentas);

        panelBotones.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 40, 20, 40));
        panelBotones.setLayout(new java.awt.GridLayout(3, 3, 20, 20));

        btnEmpleados.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        btnEmpleados.setText("<html><center>👥 Gestionar<br>Empleados</center></html>");
        btnEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmpleados.setFocusPainted(false);
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });
        panelBotones.add(btnEmpleados);

        btnVehiculos.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnVehiculos.setForeground(new java.awt.Color(255, 255, 255));
        btnVehiculos.setText("<html><center>🚗 Gestionar<br>Vehículos</center></html>");
        btnVehiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVehiculos.setFocusPainted(false);
        btnVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVehiculosActionPerformed(evt);
            }
        });
        panelBotones.add(btnVehiculos);

        btnPromociones.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnPromociones.setForeground(new java.awt.Color(255, 255, 255));
        btnPromociones.setText("<html><center>🎁 Gestionar<br>Promociones</center></html>");
        btnPromociones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPromociones.setFocusPainted(false);
        btnPromociones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromocionesActionPerformed(evt);
            }
        });
        panelBotones.add(btnPromociones);

        btnClientes.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnClientes.setText("<html><center>👨‍💼 Ver<br>Clientes</center></html>");
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.setFocusPainted(false);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        panelBotones.add(btnClientes);

        btnVentas.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnVentas.setText("<html><center>💰 Ver<br>Ventas</center></html>");
        btnVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVentas.setFocusPainted(false);
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        panelBotones.add(btnVentas);

        btnReportes.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setText("<html><center>📊 Generar<br>Reportes</center></html>");
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.setFocusPainted(false);
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        panelBotones.add(btnReportes);

        btnInventario.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnInventario.setForeground(new java.awt.Color(255, 255, 255));
        btnInventario.setText("<html><center>📦 Ver<br>Inventario</center></html>");
        btnInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInventario.setFocusPainted(false);
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });
        panelBotones.add(btnInventario);

        btnConfiguracion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnConfiguracion.setForeground(new java.awt.Color(255, 255, 255));
        btnConfiguracion.setText("<html><center>⚙️ Configuración</center></html>");
        btnConfiguracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfiguracion.setFocusPainted(false);
        btnConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracionActionPerformed(evt);
            }
        });
        panelBotones.add(btnConfiguracion);

        btnCerrarSesion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("<html><center>🚪 Cerrar<br>Sesión</center></html>");
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        panelBotones.add(btnCerrarSesion);

        lblFooter.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblFooter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFooter.setText("Sistema de Gestión de Concesionaria © 2025 - v1.0");

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFooter, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelEstadisticas, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {                                             
        new GestionEmpleadosFrame(sistema).setVisible(true);
     }                                            

     private void btnVehiculosActionPerformed(java.awt.event.ActionEvent evt) {                                             
        new GestionVehiculosFrame(sistema, this).setVisible(true);
     }                                            

     private void btnPromocionesActionPerformed(java.awt.event.ActionEvent evt) {                                               
        new GestionPromocionesFrame(sistema).setVisible(true);
     }                                              

     private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {                                            
        new ListaClientesFrame(sistema, this).setVisible(true);
    }                                           

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {                                          
        new frmListaVentas(sistema, this).setVisible(true);
    }                                         

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {                                            
        new GenerarReportesFrame(sistema, administrador).setVisible(true);
    }                                           

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {                                              
         new InventarioFrame(sistema, this).setVisible(true);
     }                                             

     private void btnConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {                                                 
         JOptionPane.showMessageDialog(this,
             "Configuración del sistema\n\n" +
             "• Cambiar contraseña\n" +
             "• Preferencias de interfaz\n" +
             "• Gestión de respaldos\n\n" +
             "(Funcionalidad en desarrollo)",
             "Configuración",
             JOptionPane.INFORMATION_MESSAGE);
     }                                                

     private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {                                                
         int opcion = JOptionPane.showConfirmDialog(this,
             "¿Está seguro de cerrar sesión?",
             "Confirmar Cierre de Sesión",
             JOptionPane.YES_NO_OPTION);
         
         if (opcion == JOptionPane.YES_OPTION) {
             this.dispose();
             new frmLogin(sistema).setVisible(true);
         }
     }                                               

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnConfiguracion;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnPromociones;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnVehiculos;
    private javax.swing.JButton btnVentas;
    private javax.swing.JLabel lblClientes;
    private javax.swing.JLabel lblEmpleados;
    private javax.swing.JLabel lblFooter;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblVehiculos;
    private javax.swing.JLabel lblVentas;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelEstadisticas;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelSuperior;
    // End of variables declaration

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SistemaVentas sistema = new SistemaVentas();
                Administrador admin = new Administrador("ADM001", "Administrador", "admin@concesionaria.com", "123456", "Administrador");
                new MenuAdministradorFrame(sistema, admin).setVisible(true);
            }
        });
    }
}