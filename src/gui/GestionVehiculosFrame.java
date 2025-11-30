package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import modelo.negocio.SistemaVentas;
import modelo.vehiculos.Vehiculo;

public class GestionVehiculosFrame extends javax.swing.JFrame {
    
    private SistemaVentas sistema;
    private JFrame framePadre;
    
    public GestionVehiculosFrame(SistemaVentas sistema, JFrame padre) {
        this.sistema = sistema;
        this.framePadre = padre;
        initComponents();
        configuracionAdicional();
        cargarDatos();
    }
    
    private void configuracionAdicional() {
        setLocationRelativeTo(framePadre);
        modeloTabla.setColumnIdentifiers(new String[]{"Código", "Marca", "Modelo", "Color", "Año", "Tipo", "Precio", "Stock", "Estado"});
        personalizarTabla();
    }
    
    private void personalizarTabla() {
        // Personalizar encabezado
        JTableHeader tableHeader = tablaVehiculos.getTableHeader();
        tableHeader.setBackground(new Color(46, 204, 113));
        tableHeader.setForeground(Color.WHITE);
        
        // Crear renderer personalizado para el encabezado
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setBackground(new Color(46, 204, 113));
                setForeground(Color.WHITE);
                setHorizontalAlignment(CENTER);
                return this;
            }
        };
        
        // Aplicar renderer a todas las columnas del encabezado
        for (int i = 0; i < tablaVehiculos.getColumnCount(); i++) {
            tablaVehiculos.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
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
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Vehículos");
        setPreferredSize(new java.awt.Dimension(1000, 600));

        panelPrincipal.setLayout(new java.awt.BorderLayout(10, 10));

        panelTitulo.setBackground(new java.awt.Color(46, 204, 113));

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("GESTIÓN DE VEHÍCULOS");
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
        tablaVehiculos.getTableHeader().setBackground(new java.awt.Color(46, 204, 113));
        tablaVehiculos.getTableHeader().setForeground(java.awt.Color.WHITE);
        scrollPane.setViewportView(tablaVehiculos);

        panelPrincipal.add(scrollPane, java.awt.BorderLayout.CENTER);

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        btnNuevo.setBackground(new java.awt.Color(46, 204, 113));
        btnNuevo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("Nuevo Vehículo");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setFocusPainted(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        panelBotones.add(btnNuevo);

        btnEditar.setBackground(new java.awt.Color(241, 196, 15));
        btnEditar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setFocusPainted(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        panelBotones.add(btnEditar);

        btnEliminar.setBackground(new java.awt.Color(231, 76, 60));
        btnEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setFocusPainted(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panelBotones.add(btnEliminar);

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

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {                                         
        nuevoVehiculo();
    }                                        

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        editarVehiculo();
    }                                         

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        eliminarVehiculo();
    }                                           

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
    
    private void nuevoVehiculo() {
        new FormVehiculoDialog(this, sistema, null).setVisible(true);
        cargarDatos();
    }
    
    private void editarVehiculo() {
        int filaSeleccionada = tablaVehiculos.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                "Por favor seleccione un vehículo para editar",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String codigo = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
        Vehiculo vehiculo = sistema.buscarVehiculo(codigo);
        
        if (vehiculo != null) {
            new FormVehiculoDialog(this, sistema, vehiculo).setVisible(true);
            cargarDatos();
        }
    }
    
    private void eliminarVehiculo() {
        int filaSeleccionada = tablaVehiculos.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                "Por favor seleccione un vehículo para eliminar",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int opcion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de eliminar este vehículo?",
            "Confirmar Eliminación",
            JOptionPane.YES_NO_OPTION);
        
        if (opcion == JOptionPane.YES_OPTION) {
            String codigo = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
            Vehiculo vehiculo = sistema.buscarVehiculo(codigo);
            
            if (vehiculo != null) {
                sistema.getVehiculos().remove(vehiculo);
                JOptionPane.showMessageDialog(this,
                    "Vehículo eliminado exitosamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
                cargarDatos();
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SistemaVentas sistema = new SistemaVentas();
                new GestionVehiculosFrame(sistema, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel lblTitulo;
    private DefaultTableModel modeloTabla;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tablaVehiculos;
    // End of variables declaration                   
}