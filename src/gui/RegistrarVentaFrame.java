package gui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import modelo.negocio.SistemaVentas;
import modelo.personas.Vendedor;
import modelo.transacciones.Cotizacion;
import modelo.transacciones.Venta;

/**
 * Formulario NetBeans para registrar ventas
 */
public class RegistrarVentaFrame extends javax.swing.JFrame {
    
    private SistemaVentas sistema;
    private Vendedor vendedor;
    private javax.swing.JFrame framePadre;
    private DefaultTableModel modeloTabla;
    
    public RegistrarVentaFrame(SistemaVentas sistema, Vendedor vendedor, javax.swing.JFrame padre) {
        this.sistema = sistema;
        this.vendedor = vendedor;
        this.framePadre = padre;
        initComponents();
        configurarTabla();
        cargarCotizaciones();
        personalizarComponentes();
    }
    
    private void configurarTabla() {
        String[] columnas = {"Código", "Cliente", "Vehículo", "Monto", "Fecha", "Estado"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaCotizaciones.setModel(modeloTabla);
    }
    
    private void personalizarComponentes() {
        panelTitulo.setBackground(new Color(46, 204, 113));
        lblTitulo.setForeground(Color.WHITE);
        tablaCotizaciones.getTableHeader().setBackground(new Color(46, 204, 113));
        tablaCotizaciones.getTableHeader().setForeground(Color.WHITE);
    }
    
    private void cargarCotizaciones() {
        modeloTabla.setRowCount(0);
        for (Cotizacion cot : sistema.getCotizaciones()) {
            if (cot.getEstado().equals("PENDIENTE")) {
                Object[] fila = {
                    cot.getCodigo(),
                    cot.getCliente().getNombreCompleto(),
                    cot.getVehiculo().getMarca() + " " + cot.getVehiculo().getModelo(),
                    String.format("S/. %.2f", cot.getMontoTotal()),
                    cot.getFecha(),
                    cot.getEstado()
                };
                modeloTabla.addRow(fila);
            }
        }
    }
    
    private void aprobarVenta() {
        int filaSeleccionada = tablaCotizaciones.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                "Por favor seleccione una cotización",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String codigo = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
        Cotizacion cotizacion = buscarCotizacion(codigo);
        
        if (cotizacion != null) {
            cotizacion.setEstado("APROBADA");
            Venta venta = vendedor.registrarVenta(cotizacion);
            
            if (venta != null) {
                sistema.registrarVenta(venta);
                venta.actualizarEstadoVehiculo();
                
                JOptionPane.showMessageDialog(this,
                    "Venta registrada exitosamente\nCódigo: " + venta.getCodigo(),
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
                
                cargarCotizaciones();
            }
        }
    }
    
    private void rechazarCotizacion() {
        int filaSeleccionada = tablaCotizaciones.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                "Por favor seleccione una cotización",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String codigo = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
        Cotizacion cotizacion = buscarCotizacion(codigo);
        
        if (cotizacion != null) {
            cotizacion.rechazar();
            JOptionPane.showMessageDialog(this,
                "Cotización rechazada",
                "Información",
                JOptionPane.INFORMATION_MESSAGE);
            cargarCotizaciones();
        }
    }
    
    private Cotizacion buscarCotizacion(String codigo) {
        for (Cotizacion cot : sistema.getCotizaciones()) {
            if (cot.getCodigo().equals(codigo)) {
                return cot;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCotizaciones = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        btnAprobar = new javax.swing.JButton();
        btnRechazar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Venta");

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("COTIZACIONES PENDIENTES");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaCotizaciones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablaCotizaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cliente", "Vehículo", "Monto", "Fecha", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCotizaciones.setRowHeight(25);
        jScrollPane1.setViewportView(tablaCotizaciones);

        btnAprobar.setBackground(new java.awt.Color(46, 204, 113));
        btnAprobar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAprobar.setForeground(new java.awt.Color(255, 255, 255));
        btnAprobar.setText("Aprobar y Vender");
        btnAprobar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAprobar.setFocusPainted(false);
        btnAprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAprobarActionPerformed(evt);
            }
        });

        btnRechazar.setBackground(new java.awt.Color(231, 76, 60));
        btnRechazar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRechazar.setForeground(new java.awt.Color(255, 255, 255));
        btnRechazar.setText("Rechazar");
        btnRechazar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRechazar.setFocusPainted(false);
        btnRechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(52, 152, 219));
        btnActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.setFocusPainted(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(149, 165, 166));
        btnCerrar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("Cerrar");
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.setFocusPainted(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRechazar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRechazar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void btnAprobarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        aprobarVenta();
    }                                          

    private void btnRechazarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        rechazarCotizacion();
    }                                           

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        cargarCotizaciones();
    }                                             

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        dispose();
    }                                         

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SistemaVentas sistema = new SistemaVentas();
                Vendedor vendedor = new Vendedor("12345678", "Juan", "Pérez", "vendedor1", "123456");
                RegistrarVentaFrame frame = new RegistrarVentaFrame(sistema, vendedor, null);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAprobar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnRechazar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTable tablaCotizaciones;
    // End of variables declaration                   
}