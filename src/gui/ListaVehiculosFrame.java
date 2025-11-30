// ==========================================
// ListaVehiculosFrame.java - FORMATO NETBEANS
// ==========================================
package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import modelo.negocio.SistemaVentas;
import modelo.vehiculos.Vehiculo;

public class ListaVehiculosFrame extends javax.swing.JFrame {
    
    private SistemaVentas sistema;
    private JFrame framePadre;
    private boolean soloConsulta;
    
    public ListaVehiculosFrame(SistemaVentas sistema, JFrame padre, boolean soloConsulta) {
        this.sistema = sistema;
        this.framePadre = padre;
        this.soloConsulta = soloConsulta;
        initComponents();
        configuracionAdicional();
        cargarDatos();
    }
    
    private void configuracionAdicional() {
        setLocationRelativeTo(framePadre);
        modeloTabla.setColumnIdentifiers(new String[]{"Código", "Marca", "Modelo", "Color", "Año", "Tipo", "Precio", "Stock", "Estado"});
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        tablaVehiculos = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Vehículos");
        setPreferredSize(new java.awt.Dimension(1000, 600));

        panelPrincipal.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.setLayout(new java.awt.BorderLayout(10, 10));

        panelTitulo.setBackground(new java.awt.Color(241, 196, 15));

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("LISTADO DE VEHÍCULOS");
        panelTitulo.add(lblTitulo);

        panelPrincipal.add(panelTitulo, java.awt.BorderLayout.PAGE_START);

        modeloTabla = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaVehiculos.setModel(modeloTabla);
        tablaVehiculos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablaVehiculos.setRowHeight(25);
        tablaVehiculos.getTableHeader().setFont(new java.awt.Font("Arial", 1, 12));
        tablaVehiculos.getTableHeader().setBackground(new java.awt.Color(241, 196, 15));
        tablaVehiculos.getTableHeader().setForeground(java.awt.Color.WHITE);
        scrollPane.setViewportView(tablaVehiculos);

        panelPrincipal.add(scrollPane, java.awt.BorderLayout.CENTER);

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

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
        panelBotones.add(btnActualizar);

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
        panelBotones.add(btnCerrar);

        panelPrincipal.add(panelBotones, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(panelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        cargarDatos();
    }                                             

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        dispose();
    }                                         
    
    private void cargarDatos() {
        modeloTabla.setRowCount(0);
        for (Vehiculo veh : sistema.getVehiculos()) {
            Object[] fila = {
                veh.getCodigo(),
                veh.getMarca(),
                veh.getModelo(),
                veh.getColor(),
                veh.getAnioFabricacion(),
                veh.getTipo(),
                String.format("S/. %.2f", veh.getPrecioBase()),
                veh.obtenerStock(),
                veh.getEstado()
            };
            modeloTabla.addRow(fila);
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaVehiculosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaVehiculosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaVehiculosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaVehiculosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SistemaVentas sistema = new SistemaVentas();
                new ListaVehiculosFrame(sistema, null, true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel lblTitulo;
    private DefaultTableModel modeloTabla;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tablaVehiculos;
    // End of variables declaration                   
}