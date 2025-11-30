package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import modelo.negocio.SistemaVentas;
import modelo.personas.Cliente;

public class frmGestionClientes extends javax.swing.JFrame {
    
    private SistemaVentas sistema;
    private JFrame framePadre;
    
    public frmGestionClientes(SistemaVentas sistema, JFrame padre) {
        this.sistema = sistema;
        this.framePadre = padre;
        initComponents();
        configuracionAdicional();
        cargarDatos();
    }
    
    private void configuracionAdicional() {
        setLocationRelativeTo(framePadre);
        modeloTabla.setColumnIdentifiers(new String[]{"DNI", "Nombres", "Ap. Paterno", "Ap. Materno", "Teléfono", "Email", "Tipo", "Estado"});
        // Asegurar que la tabla use todo el viewport y ajuste columnas
        tablaClientes.setFillsViewportHeight(true);
        tablaClientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPane.setViewportView(tablaClientes);
        // Opcional: ajustar ancho de columnas inicial
        if (tablaClientes.getColumnModel().getColumnCount() > 0) {
            tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(100); // DNI
            tablaClientes.getColumnModel().getColumn(1).setPreferredWidth(200); // Nombres
            tablaClientes.getColumnModel().getColumn(2).setPreferredWidth(120);
            tablaClientes.getColumnModel().getColumn(3).setPreferredWidth(120);
            tablaClientes.getColumnModel().getColumn(4).setPreferredWidth(120);
            tablaClientes.getColumnModel().getColumn(5).setPreferredWidth(180);
            tablaClientes.getColumnModel().getColumn(6).setPreferredWidth(80);
            tablaClientes.getColumnModel().getColumn(7).setPreferredWidth(80);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Clientes");
        setPreferredSize(new java.awt.Dimension(1000, 600));

        panelPrincipal.setLayout(new java.awt.BorderLayout(10, 10));

        panelTitulo.setBackground(new java.awt.Color(52, 152, 219));

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("GESTIÓN DE CLIENTES");
        panelTitulo.add(lblTitulo);

        panelPrincipal.add(panelTitulo, java.awt.BorderLayout.PAGE_START);

        modeloTabla = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaClientes.setModel(modeloTabla);
        tablaClientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablaClientes.setRowHeight(25);
        tablaClientes.getTableHeader().setFont(new java.awt.Font("Arial", 1, 12));
        tablaClientes.getTableHeader().setBackground(new java.awt.Color(52, 152, 219));
        tablaClientes.getTableHeader().setForeground(java.awt.Color.WHITE);
        scrollPane.setViewportView(tablaClientes);

        panelPrincipal.add(scrollPane, java.awt.BorderLayout.CENTER);

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        btnNuevo.setBackground(new java.awt.Color(46, 204, 113));
        btnNuevo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("Nuevo Cliente");
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
        nuevoCliente();
    }                                        

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        editarCliente();
    }                                         

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        eliminarCliente();
    }                                           

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        cargarDatos();
    }                                             

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        dispose();
    }                                         
    
    private void cargarDatos() {
        modeloTabla.setRowCount(0);
        for (Cliente cli : sistema.getClientes()) {
            Object[] fila = {
                cli.getDni(),
                cli.getNombres(),
                cli.getApPaterno(),
                cli.getApMaterno(),
                cli.getTelefono(),
                cli.getEmail(),
                cli.getTipoCliente(),
                cli.isActivo() ? "ACTIVO" : "INACTIVO"
            };
            modeloTabla.addRow(fila);
        }
    }
    
    private void nuevoCliente() {
        new FormClienteDialog(this, sistema, null).setVisible(true);
        cargarDatos();
    }
    
    private void editarCliente() {
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                "Por favor seleccione un cliente para editar",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String dni = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
        Cliente cliente = sistema.buscarCliente(dni);
        
        if (cliente != null) {
            new FormClienteDialog(this, sistema, cliente).setVisible(true);
            cargarDatos();
        }
    }
    
    private void eliminarCliente() {
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                "Por favor seleccione un cliente para eliminar",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int opcion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de eliminar este cliente?",
            "Confirmar Eliminación",
            JOptionPane.YES_NO_OPTION);
        
        if (opcion == JOptionPane.YES_OPTION) {
            String dni = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
            Cliente cliente = sistema.buscarCliente(dni);
            
            if (cliente != null) {
                sistema.getClientes().remove(cliente);
                JOptionPane.showMessageDialog(this,
                    "Cliente eliminado exitosamente",
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
                new frmGestionClientes(sistema, null).setVisible(true);
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
    private javax.swing.JTable tablaClientes;
    // End of variables declaration                   
}
