package gui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import modelo.negocio.SistemaVentas;
import modelo.personas.Vendedor;
import modelo.transacciones.Venta;

/**
 * Formulario NetBeans para mostrar las ventas del vendedor
 */
public class MisVentasFrame extends javax.swing.JFrame {
    
    private SistemaVentas sistema;
    private Vendedor vendedor;
    private javax.swing.JFrame framePadre;
    private DefaultTableModel modeloTabla;
    
    public MisVentasFrame(SistemaVentas sistema, Vendedor vendedor, javax.swing.JFrame padre) {
        this.sistema = sistema;
        this.vendedor = vendedor;
        this.framePadre = padre;
        initComponents();
        configurarTabla();
        cargarDatos();
        personalizarComponentes();
        actualizarEstadisticas();
    }
    
    private void configurarTabla() {
        String[] columnas = {"Código", "Fecha", "Cliente", "DNI Cliente", 
                           "Vehículo", "Monto Total", "Saldo Pendiente", "Estado Pago"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaVentas.setModel(modeloTabla);
        
        // Renderizador personalizado para la columna de estado
        DefaultTableCellRenderer rendererEstado = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, 
                                                                  isSelected, hasFocus, row, column);
                
                if (column == 7 && !isSelected) {
                    String estado = (String) value;
                    switch (estado) {
                        case "PAGADO":
                            c.setBackground(new Color(212, 239, 223));
                            c.setForeground(new Color(39, 174, 96));
                            break;
                        case "PAGO_PARCIAL":
                            c.setBackground(new Color(252, 243, 207));
                            c.setForeground(new Color(243, 156, 18));
                            break;
                        case "PENDIENTE":
                            c.setBackground(new Color(248, 215, 218));
                            c.setForeground(new Color(231, 76, 60));
                            break;
                        default:
                            c.setBackground(Color.WHITE);
                            c.setForeground(Color.BLACK);
                    }
                    setHorizontalAlignment(CENTER);
                } else if (!isSelected) {
                    c.setBackground(Color.WHITE);
                    c.setForeground(Color.BLACK);
                }
                
                return c;
            }
        };
        
        tablaVentas.getColumnModel().getColumn(7).setCellRenderer(rendererEstado);
    }
    
    private void personalizarComponentes() {
        panelSuperior.setBackground(new Color(46, 204, 113));
        lblTitulo.setForeground(Color.WHITE);
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setText("Vendedor: " + vendedor.getNombreCompleto());
        
        lblTotalVentas.setBackground(new Color(52, 152, 219));
        lblMontoTotal.setBackground(new Color(46, 204, 113));
        lblPendiente.setBackground(new Color(241, 196, 15));
        
        tablaVentas.getTableHeader().setBackground(new Color(46, 204, 113));
        tablaVentas.getTableHeader().setForeground(Color.WHITE);
    }
    
    private void cargarDatos() {
        modeloTabla.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        for (Venta venta : sistema.getVentas()) {
            if (venta.getVendedor().getUsuario().equals(vendedor.getUsuario())) {
                Object[] fila = {
                    venta.getCodigo(),
                    sdf.format(venta.getFecha()),
                    venta.getCliente().getNombreCompleto(),
                    venta.getCliente().getDni(),
                    venta.getVehiculo().getMarca() + " " + venta.getVehiculo().getModelo(),
                    String.format("S/. %.2f", venta.getMontoTotal()),
                    String.format("S/. %.2f", venta.getSaldoPendiente()),
                    venta.getEstadoPago()
                };
                modeloTabla.addRow(fila);
            }
        }
    }
    
    private void actualizarEstadisticas() {
        int totalVentas = 0;
        double montoTotal = 0.0;
        double saldoPendiente = 0.0;
        
        for (Venta venta : sistema.getVentas()) {
            if (venta.getVendedor().getUsuario().equals(vendedor.getUsuario())) {
                totalVentas++;
                montoTotal += venta.getMontoTotal();
                saldoPendiente += venta.getSaldoPendiente();
            }
        }
        
        lblTotalVentas.setText("📊 Total: " + totalVentas);
        lblMontoTotal.setText("💰 Monto: S/. " + String.format("%.2f", montoTotal));
        lblPendiente.setText("⏳ Pendiente: S/. " + String.format("%.2f", saldoPendiente));
    }
    
    private void verDetalle() {
        int filaSeleccionada = tablaVentas.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                "Por favor seleccione una venta para ver el detalle",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String codigo = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
        for (Venta venta : sistema.getVentas()) {
            if (venta.getCodigo().equals(codigo)) {
                // new DetalleVentaDialog(this, venta).setVisible(true);
                JOptionPane.showMessageDialog(this, 
                    "Detalle de Venta: " + codigo + "\n" +
                    "Cliente: " + venta.getCliente().getNombreCompleto() + "\n" +
                    "Vehículo: " + venta.getVehiculo().getMarca() + " " + venta.getVehiculo().getModelo() + "\n" +
                    "Total: S/. " + String.format("%.2f", venta.getMontoTotal()),
                    "Detalle de Venta",
                    JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        panelEstadisticas = new javax.swing.JPanel();
        lblTotalVentas = new javax.swing.JLabel();
        lblMontoTotal = new javax.swing.JLabel();
        lblPendiente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        btnVerDetalle = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mis Ventas");

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTitulo.setText("  MIS VENTAS REGISTRADAS");

        lblUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario.setText("Vendedor: Usuario  ");

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(lblUsuario))
                .addContainerGap())
        );

        panelEstadisticas.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelEstadisticas.setLayout(new java.awt.GridLayout(1, 3, 15, 15));

        lblTotalVentas.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTotalVentas.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalVentas.setText("📊 Total: 0");
        lblTotalVentas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblTotalVentas.setOpaque(true);
        panelEstadisticas.add(lblTotalVentas);

        lblMontoTotal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblMontoTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblMontoTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMontoTotal.setText("💰 Monto: S/. 0.00");
        lblMontoTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblMontoTotal.setOpaque(true);
        panelEstadisticas.add(lblMontoTotal);

        lblPendiente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblPendiente.setForeground(new java.awt.Color(255, 255, 255));
        lblPendiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPendiente.setText("⏳ Pendiente: S/. 0.00");
        lblPendiente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblPendiente.setOpaque(true);
        panelEstadisticas.add(lblPendiente);

        tablaVentas.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Fecha", "Cliente", "DNI", "Vehículo", "Monto Total", "Saldo", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaVentas.setRowHeight(30);
        jScrollPane1.setViewportView(tablaVentas);

        panelBotones.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        btnVerDetalle.setBackground(new java.awt.Color(52, 152, 219));
        btnVerDetalle.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnVerDetalle.setForeground(new java.awt.Color(255, 255, 255));
        btnVerDetalle.setText("🔍 Ver Detalle");
        btnVerDetalle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerDetalle.setFocusPainted(false);
        btnVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalleActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(46, 204, 113));
        btnActualizar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("🔄 Actualizar");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.setFocusPainted(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(231, 76, 60));
        btnCerrar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("✖ Cerrar");
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
                .addComponent(btnVerDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelEstadisticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void btnVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {                                              
        verDetalle();
    }                                             

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        cargarDatos();
        actualizarEstadisticas();
        JOptionPane.showMessageDialog(this,
            "Datos actualizados correctamente",
            "Actualización",
            JOptionPane.INFORMATION_MESSAGE);
    }                                             

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        dispose();
    }                                         

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SistemaVentas sistema = new SistemaVentas();
                Vendedor vendedor = new Vendedor("12345678", "Juan", "Pérez", "vendedor1", "123456");
                MisVentasFrame frame = new MisVentasFrame(sistema, vendedor, null);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnVerDetalle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMontoTotal;
    private javax.swing.JLabel lblPendiente;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotalVentas;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelEstadisticas;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTable tablaVentas;
    // End of variables declaration                   
}