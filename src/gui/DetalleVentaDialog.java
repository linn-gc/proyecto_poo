package gui;

import modelo.transacciones.Venta;
import java.awt.Color;
import java.awt.Font;

/**
 * Diálogo para mostrar detalle de venta
 */
public class DetalleVentaDialog extends javax.swing.JDialog {
    private Venta venta;

    public DetalleVentaDialog(java.awt.Frame parent, Venta venta) {
        super(parent, true);
        this.venta = venta;
        initComponents();
        cargarDetalle();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle de Venta");

        txtDetalle.setEditable(false);
        txtDetalle.setColumns(20);
        txtDetalle.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txtDetalle.setRows(5);
        jScrollPane1.setViewportView(txtDetalle);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        dispose();
    }                                         

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCerrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDetalle;
    // End of variables declaration                   

    private void cargarDetalle() {
        StringBuilder sb = new StringBuilder();
        sb.append("═══════════════════════════════════════\n");
        sb.append("         DETALLE DE VENTA\n");
        sb.append("═══════════════════════════════════════\n\n");
        sb.append("Código: ").append(venta.getCodigo()).append("\n");
        sb.append("Fecha: ").append(venta.getFecha()).append("\n\n");
        sb.append("CLIENTE:\n");
        sb.append("  Nombre: ").append(venta.getCliente().getNombreCompleto()).append("\n");
        sb.append("  DNI: ").append(venta.getCliente().getDni()).append("\n");
        sb.append("  Teléfono: ").append(venta.getCliente().getTelefono()).append("\n\n");
        sb.append("VENDEDOR:\n");
        sb.append("  Nombre: ").append(venta.getVendedor().getNombreCompleto()).append("\n\n");
        sb.append("VEHÍCULO:\n");
        sb.append("  Marca: ").append(venta.getVehiculo().getMarca()).append("\n");
        sb.append("  Modelo: ").append(venta.getVehiculo().getModelo()).append("\n");
        sb.append("  Año: ").append(venta.getVehiculo().getAnioFabricacion()).append("\n");
        sb.append("  Color: ").append(venta.getVehiculo().getColor()).append("\n\n");
        sb.append("MONTOS:\n");
        sb.append("  Total: S/. ").append(String.format("%.2f", venta.getMontoTotal())).append("\n");
        sb.append("  Saldo Pendiente: S/. ").append(String.format("%.2f", venta.getSaldoPendiente())).append("\n");
        sb.append("  Estado: ").append(venta.getEstadoPago()).append("\n");
        sb.append("\n═══════════════════════════════════════\n");
        
        txtDetalle.setText(sb.toString());
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Crear venta de prueba - reemplazar con datos reales
                DetalleVentaDialog dialog = new DetalleVentaDialog(new javax.swing.JFrame(), null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
}