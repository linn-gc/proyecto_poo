package gui;

import modelo.negocio.SistemaVentas;
import modelo.promociones.Promocion;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import java.util.Calendar;

/**
 * Formulario para gestión de promociones
 * NOTA: Requiere la librería JCalendar (jcalendar-1.4.jar)
 */
public class FormPromocionDialog extends javax.swing.JDialog {
    private SistemaVentas sistema;
    private Promocion promocion;

    public FormPromocionDialog(java.awt.Frame parent, SistemaVentas sistema, Promocion promocion) {
        super(parent, true);
        this.sistema = sistema;
        this.promocion = promocion;
        initComponents();
        configurarFechas();
        
        if (promocion != null) {
            cargarDatos();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dateInicio = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        dateFin = new com.toedter.calendar.JDateChooser();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulario Promoción");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Código:");

        txtCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Tipo:");

        cmbTipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PORCENTAJE", "MONTO_FIJO" }));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Valor:");

        txtValor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Fecha Inicio:");

        dateInicio.setDateFormatString("dd/MM/yyyy");
        dateInicio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Fecha Fin:");

        dateFin.setDateFormatString("dd/MM/yyyy");
        dateFin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnGuardar.setBackground(new java.awt.Color(46, 204, 113));
        btnGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setFocusPainted(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(231, 76, 60));
        btnCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigo)
                    .addComponent(txtNombre)
                    .addComponent(cmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtValor)
                    .addComponent(dateInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(dateFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(dateInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        guardar();
    }                                          

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        dispose();
    }                                           

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbTipo;
    private com.toedter.calendar.JDateChooser dateFin;
    private com.toedter.calendar.JDateChooser dateInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtValor;
    // End of variables declaration                   

    private void configurarFechas() {
        dateInicio.setDate(new Date());
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        dateFin.setDate(cal.getTime());
    }
    
    private void cargarDatos() {
        txtCodigo.setText(promocion.getCodigo());
        txtNombre.setText(promocion.getNombre());
        cmbTipo.setSelectedItem(promocion.getTipo());
        txtValor.setText(String.valueOf(promocion.getValor()));
        dateInicio.setDate(promocion.getFechaInicio());
        dateFin.setDate(promocion.getFechaFin());
        txtCodigo.setEditable(false);
        setTitle("Editar Promoción");
    }
    
    private void guardar() {
        if (validarCampos()) {
            try {
                if (promocion == null) {
                    promocion = new Promocion(
                        txtCodigo.getText().trim(),
                        txtNombre.getText().trim(),
                        (String) cmbTipo.getSelectedItem(),
                        Double.parseDouble(txtValor.getText().trim()),
                        dateInicio.getDate(),
                        dateFin.getDate()
                    );
                    sistema.registrarPromocion(promocion);
                } else {
                    promocion.setNombre(txtNombre.getText().trim());
                    promocion.setTipo((String) cmbTipo.getSelectedItem());
                    promocion.setValor(Double.parseDouble(txtValor.getText().trim()));
                }
                
                JOptionPane.showMessageDialog(this,
                    "Promoción guardada exitosamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                    "Error en formato de números",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private boolean validarCampos() {
        if (txtCodigo.getText().trim().isEmpty() ||
            txtNombre.getText().trim().isEmpty() ||
            txtValor.getText().trim().isEmpty() ||
            dateInicio.getDate() == null ||
            dateFin.getDate() == null) {
            
            JOptionPane.showMessageDialog(this,
                "Todos los campos son obligatorios",
                "Error de Validación",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (dateFin.getDate().before(dateInicio.getDate())) {
            JOptionPane.showMessageDialog(this,
                "La fecha fin debe ser posterior a la fecha inicio",
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
                FormPromocionDialog dialog = new FormPromocionDialog(new javax.swing.JFrame(), sistema, null);
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