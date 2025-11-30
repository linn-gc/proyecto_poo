package gui;

import modelo.negocio.SistemaVentas;
import modelo.promociones.Promocion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;

/**
 * Frame para gestión de promociones
 */
public class GestionPromocionesFrame extends javax.swing.JFrame {
    private SistemaVentas sistema;
    private DefaultTableModel modeloTabla;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public GestionPromocionesFrame(SistemaVentas sistema) {
        this.sistema = sistema;
        initComponents();
        personalizarTabla();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPromociones = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        btnNueva = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Promociones");

        panelTitulo.setBackground(new java.awt.Color(155, 89, 182));

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("GESTIÓN DE PROMOCIONES");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitulo)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tablaPromociones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablaPromociones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Tipo", "Valor", "Fecha Inicio", "Fecha Fin", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPromociones.setRowHeight(25);
        jScrollPane1.setViewportView(tablaPromociones);

        btnNueva.setBackground(new java.awt.Color(46, 204, 113));
        btnNueva.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNueva.setForeground(new java.awt.Color(255, 255, 255));
        btnNueva.setText("Nueva Promoción");
        btnNueva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNueva.setFocusPainted(false);
        btnNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaActionPerformed(evt);
            }
        });

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
                .addGap(150, 150, 150)
                .addComponent(btnNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void btnNuevaActionPerformed(java.awt.event.ActionEvent evt) {                                         
        nuevaPromocion();
    }                                        

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        editarPromocion();
    }                                         

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        eliminarPromocion();
    }                                           

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        cargarDatos();
    }                                             

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        dispose();
    }                                         

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNueva;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTable tablaPromociones;
    // End of variables declaration                   

    private void personalizarTabla() {
        modeloTabla = (DefaultTableModel) tablaPromociones.getModel();
        
        // Personalizar encabezado
        JTableHeader tableHeader = tablaPromociones.getTableHeader();
        tableHeader.setBackground(new Color(155, 89, 182));
        tableHeader.setForeground(Color.WHITE);
        
        // Crear renderer personalizado para el encabezado
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setBackground(new Color(155, 89, 182));
                setForeground(Color.WHITE);
                setHorizontalAlignment(CENTER);
                return this;
            }
        };
        
        // Aplicar renderer a todas las columnas del encabezado
        for (int i = 0; i < tablaPromociones.getColumnCount(); i++) {
            tablaPromociones.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }
    
    private void cargarDatos() {
        modeloTabla.setRowCount(0);
        try {
            // Intenta obtener las promociones usando reflexión
            java.lang.reflect.Method method = sistema.getClass().getMethod("getPromociones");
            java.util.ArrayList<?> promociones = (java.util.ArrayList<?>) method.invoke(sistema);
            
            for (Object obj : promociones) {
                Promocion promo = (Promocion) obj;
                Object[] fila = {
                    promo.getCodigo(),
                    promo.getNombre(),
                    promo.getTipo(),
                    promo.getTipo().equals("PORCENTAJE") ? 
                        promo.getValor() + "%" : "S/. " + promo.getValor(),
                    sdf.format(promo.getFechaInicio()),
                    sdf.format(promo.getFechaFin()),
                    promo.estaVigente() ? "VIGENTE" : "VENCIDA"
                };
                modeloTabla.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "No se puede cargar promociones.\nVerifique que el método getPromociones() exista en SistemaVentas.",
                "Información",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void nuevaPromocion() {
        new FormPromocionDialog(this, sistema, null).setVisible(true);
        cargarDatos();
    }
    
    private void editarPromocion() {
        int filaSeleccionada = tablaPromociones.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                "Por favor seleccione una promoción para editar",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            String codigo = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
            
            // Buscar la promoción
            java.lang.reflect.Method method = sistema.getClass().getMethod("getPromociones");
            java.util.ArrayList<?> promociones = (java.util.ArrayList<?>) method.invoke(sistema);
            
            Promocion promocion = null;
            for (Object obj : promociones) {
                Promocion p = (Promocion) obj;
                if (p.getCodigo().equals(codigo)) {
                    promocion = p;
                    break;
                }
            }
            
            if (promocion != null) {
                new FormPromocionDialog(this, sistema, promocion).setVisible(true);
                cargarDatos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error al editar promoción: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void eliminarPromocion() {
        int filaSeleccionada = tablaPromociones.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                "Por favor seleccione una promoción para eliminar",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int opcion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de eliminar esta promoción?",
            "Confirmar Eliminación",
            JOptionPane.YES_NO_OPTION);
        
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                String codigo = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
                
                // Buscar y eliminar la promoción
                java.lang.reflect.Method method = sistema.getClass().getMethod("getPromociones");
                java.util.ArrayList<?> promociones = (java.util.ArrayList<?>) method.invoke(sistema);
                
                for (Object obj : promociones) {
                    Promocion p = (Promocion) obj;
                    if (p.getCodigo().equals(codigo)) {
                        promociones.remove(p);
                        JOptionPane.showMessageDialog(this,
                            "Promoción eliminada exitosamente",
                            "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                        cargarDatos();
                        break;
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                    "Error al eliminar promoción: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SistemaVentas sistema = new SistemaVentas();
                new GestionPromocionesFrame(sistema).setVisible(true);
            }
        });
    }
}