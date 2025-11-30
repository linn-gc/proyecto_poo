package gui;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import modelo.negocio.SistemaVentas;
import modelo.personas.Vendedor;

/**
 * Menú principal del Vendedor - NetBeans Form
 */
public class MenuVendedorFrame extends javax.swing.JFrame {
    
    private SistemaVentas sistema;
    private Vendedor vendedor;
    
    public MenuVendedorFrame(SistemaVentas sistema, Vendedor vendedor) {
        this.sistema = sistema;
        this.vendedor = vendedor;
        initComponents();
        personalizarComponentes();
    }
    
    private void personalizarComponentes() {
        // Panel superior
        panelSuperior.setBackground(new Color(46, 204, 113));
        lblTitulo.setForeground(Color.WHITE);
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setText("Vendedor: " + vendedor.getNombreCompleto());
        
        // Botones
        btnClientes.setBackground(new Color(52, 152, 219));
        btnCotizaciones.setBackground(new Color(155, 89, 182));
        btnVentas.setBackground(new Color(46, 204, 113));
        btnVehiculos.setBackground(new Color(241, 196, 15));
        btnMisVentas.setBackground(new Color(230, 126, 34));
        btnCerrarSesion.setBackground(new Color(231, 76, 60));
        
        // Footer
        panelInferior.setBackground(new Color(236, 240, 241));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        panelCentral = new javax.swing.JPanel();
        btnClientes = new javax.swing.JButton();
        btnCotizaciones = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnVehiculos = new javax.swing.JButton();
        btnMisVentas = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        panelInferior = new javax.swing.JPanel();
        lblFooter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Concesionaria - Vendedor");

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTitulo.setText("  PANEL DE VENDEDOR");

        lblUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario.setText("Vendedor: Usuario  ");

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(lblUsuario))
                .addContainerGap())
        );

        panelCentral.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 40, 40, 40));
        panelCentral.setLayout(new java.awt.GridLayout(2, 3, 20, 20));

        btnClientes.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnClientes.setText("<html><center>Gestionar Clientes</center></html>");
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.setFocusPainted(false);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        panelCentral.add(btnClientes);

        btnCotizaciones.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnCotizaciones.setForeground(new java.awt.Color(255, 255, 255));
        btnCotizaciones.setText("<html><center>Crear Cotización</center></html>");
        btnCotizaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCotizaciones.setFocusPainted(false);
        btnCotizaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCotizacionesActionPerformed(evt);
            }
        });
        panelCentral.add(btnCotizaciones);

        btnVentas.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnVentas.setText("<html><center>Registrar Venta</center></html>");
        btnVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVentas.setFocusPainted(false);
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        panelCentral.add(btnVentas);

        btnVehiculos.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnVehiculos.setForeground(new java.awt.Color(255, 255, 255));
        btnVehiculos.setText("<html><center>Ver Vehículos</center></html>");
        btnVehiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVehiculos.setFocusPainted(false);
        btnVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVehiculosActionPerformed(evt);
            }
        });
        panelCentral.add(btnVehiculos);

        btnMisVentas.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnMisVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnMisVentas.setText("<html><center>Mis Ventas</center></html>");
        btnMisVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMisVentas.setFocusPainted(false);
        btnMisVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMisVentasActionPerformed(evt);
            }
        });
        panelCentral.add(btnMisVentas);

        btnCerrarSesion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("<html><center>Cerrar Sesión</center></html>");
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        panelCentral.add(btnCerrarSesion);

        lblFooter.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblFooter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFooter.setText("Sistema de Gestión de Concesionaria © 2025");

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFooter, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFooter, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {                                            
        new frmGestionClientes(sistema, this).setVisible(true);
    }                                           

    private void btnCotizacionesActionPerformed(java.awt.event.ActionEvent evt) {                                                
        new frmCrearCotizacion(sistema, vendedor).setVisible(true);
        JOptionPane.showMessageDialog(this, "Abrir Crear Cotización");
    }                                               

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {                                          
        new RegistrarVentaFrame(sistema, vendedor, this).setVisible(true);
    }                                         

    private void btnVehiculosActionPerformed(java.awt.event.ActionEvent evt) {                                             
        new ListaVehiculosFrame(sistema, this, true).setVisible(true);
    }                                            

    private void btnMisVentasActionPerformed(java.awt.event.ActionEvent evt) {                                             
        new MisVentasFrame(sistema, vendedor, this).setVisible(true);
    }                                            

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {                                                
        int opcion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de cerrar sesión?",
            "Confirmar Cierre de Sesión",
            JOptionPane.YES_NO_OPTION);
        
        if (opcion == JOptionPane.YES_OPTION) {
            this.dispose();
            // new LoginFrame(sistema).setVisible(true);
        }
    }                                               

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnCotizaciones;
    private javax.swing.JButton btnMisVentas;
    private javax.swing.JButton btnVehiculos;
    private javax.swing.JButton btnVentas;
    private javax.swing.JLabel lblFooter;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelSuperior;
    // End of variables declaration

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SistemaVentas sistema = new SistemaVentas();
                Vendedor vendedor = new Vendedor("VEN001", "Vendedor", "Test", "vendedor", "123456");
                new MenuVendedorFrame(sistema, vendedor).setVisible(true);
            }
        });
    }
}