package gui;

import javax.swing.*;
import java.awt.*;
import modelo.negocio.SistemaVentas;
import modelo.abstracto.Empleado;
import modelo.personas.Vendedor;
import modelo.personas.Administrador;

public class FormEmpleadoDialog extends javax.swing.JDialog {
    
    private SistemaVentas sistema;
    private Empleado empleado;
    
    public FormEmpleadoDialog(java.awt.Frame parent, SistemaVentas sistema, Empleado empleado) {
        super(parent, true);
        this.sistema = sistema;
        this.empleado = empleado;
        initComponents();
        configuracionAdicional();
        
        if (empleado != null) {
            cargarDatos();
        }
    }
    
    private void configuracionAdicional() {
        setLocationRelativeTo(getParent());
        setTitle(empleado == null ? "Nuevo Empleado" : "Editar Empleado");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        lblDni = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        lblNombres = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblClave = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();
        lblRol = new javax.swing.JLabel();
        cmbRol = new javax.swing.JComboBox<>();
        lblActivo = new javax.swing.JLabel();
        chkActivo = new javax.swing.JCheckBox();
        panelBotones = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(450, 400));

        panelPrincipal.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        lblDni.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDni.setText("DNI:");

        txtDni.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblNombres.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNombres.setText("Nombres:");

        txtNombres.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblApellidos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblApellidos.setText("Apellidos:");

        txtApellidos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblUsuario.setText("Usuario:");

        txtUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblClave.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblClave.setText("Contraseña:");

        txtClave.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblRol.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblRol.setText("Rol:");

        cmbRol.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VENDEDOR", "ADMINISTRADOR" }));

        lblActivo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblActivo.setText("Activo:");

        chkActivo.setSelected(true);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblActivo)
                    .addComponent(lblRol)
                    .addComponent(lblClave)
                    .addComponent(lblUsuario)
                    .addComponent(lblApellidos)
                    .addComponent(lblNombres)
                    .addComponent(lblDni))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDni)
                    .addComponent(txtNombres)
                    .addComponent(txtApellidos)
                    .addComponent(txtUsuario)
                    .addComponent(txtClave)
                    .addComponent(cmbRol, 0, 250, Short.MAX_VALUE)
                    .addComponent(chkActivo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDni)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombres)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidos)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClave)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRol)
                    .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblActivo)
                    .addComponent(chkActivo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelPrincipal, java.awt.BorderLayout.CENTER);

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        btnGuardar.setBackground(new java.awt.Color(46, 204, 113));
        btnGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setFocusPainted(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelBotones.add(btnGuardar);

        btnCancelar.setBackground(new java.awt.Color(231, 76, 60));
        btnCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelBotones.add(btnCancelar);

        getContentPane().add(panelBotones, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>                        

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        guardar();
    }                                          

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        dispose();
    }                                           
    
    private void cargarDatos() {
        txtDni.setText(empleado.getDni());
        txtNombres.setText(empleado.getNombres());
        txtApellidos.setText(empleado.getApellidos());
        txtUsuario.setText(empleado.getUsuario());
        cmbRol.setSelectedItem(empleado.getRol());
        chkActivo.setSelected(empleado.isActivo());
        txtDni.setEditable(false);
        txtUsuario.setEditable(false);
    }
    
    private void guardar() {
        if (validarCampos()) {
            if (empleado == null) {
                // Crear nuevo
                String rol = (String) cmbRol.getSelectedItem();
                if (rol.equals("VENDEDOR")) {
                    empleado = new Vendedor(
                        txtDni.getText().trim(),
                        txtNombres.getText().trim(),
                        txtApellidos.getText().trim(),
                        txtUsuario.getText().trim(),
                        new String(txtClave.getPassword())
                    );
                } else {
                    empleado = new Administrador(
                        txtDni.getText().trim(),
                        txtNombres.getText().trim(),
                        txtApellidos.getText().trim(),
                        txtUsuario.getText().trim(),
                        new String(txtClave.getPassword())
                    );
                }
                empleado.setActivo(chkActivo.isSelected());
                sistema.registrarEmpleado(empleado);
            } else {
                // Actualizar existente
                empleado.setNombres(txtNombres.getText().trim());
                empleado.setApellidos(txtApellidos.getText().trim());
                if (txtClave.getPassword().length > 0) {
                    empleado.setClave(new String(txtClave.getPassword()));
                }
                empleado.setActivo(chkActivo.isSelected());
            }
            
            JOptionPane.showMessageDialog(this,
                "Empleado guardado exitosamente",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }
    
    private boolean validarCampos() {
        if (txtDni.getText().trim().isEmpty() ||
            txtNombres.getText().trim().isEmpty() ||
            txtApellidos.getText().trim().isEmpty() ||
            txtUsuario.getText().trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(this,
                "Todos los campos son obligatorios",
                "Error de Validación",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (empleado == null && txtClave.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this,
                "Debe ingresar una contraseña",
                "Error de Validación",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SistemaVentas sistema = new SistemaVentas();
                FormEmpleadoDialog dialog = new FormEmpleadoDialog(new javax.swing.JFrame(), sistema, null);
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

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox chkActivo;
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JLabel lblActivo;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration                   
}