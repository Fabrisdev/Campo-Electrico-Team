package grafica;

import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import logica.Vector;

/**
 *
 * @author Paña
 */
public class CargasSinMov extends javax.swing.JFrame {

    private PanelVector panel;
    private int contador;
    private JLabel lblCarga;
    private JPanel panelImagenes;
    private PanelCargas panel1;

    /**
     * Creates new form NewJFrame
     */
    public CargasSinMov() {
        initComponents();
        iniciador();
    }

    private void crearPanelVector() {
        this.panel = new PanelVector(this.panel1.getBounds());
        add(this.panel);
        setComponentZOrder(this.panel, 0);
    }

    private void eliminarPanelVector() {
        if (this.contador > 0) {
            remove(0);
        } else {
            this.contador++;
        }
    }

    private void iniciador() {
        setResizable(false);
        this.contador = 0;

        this.panelImagenes = new JPanel();
        this.panelImagenes.setBounds(80, 70, 700, 600);
        this.panelImagenes.setLayout((LayoutManager) null);
        this.panelImagenes.setOpaque(false);
        this.lblCarga = new JLabel();
        this.lblCarga.setSize(16, 16);
        this.lblCarga.setOpaque(false);
        this.panelImagenes.add(this.lblCarga);
        this.lblFondo.add(this.panelImagenes);
        

        this.panel1 = new PanelCargas();
        this.lblCarga.setLayout((LayoutManager) null);
        this.lblFondo.add(this.panel1);

        this.panel1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    boolean bandera = true;
                    boolean bandera2 = true;
                    double carga = Double.valueOf(CargasSinMov.this.txtCarga.getText()).doubleValue();
                    carga *= Math.pow(10.0D, Integer.valueOf(CargasSinMov.this.txtCargaExp.getText()).intValue());
                    Vector campo = FrmCargas.cargas.sumarCampos(e.getX(), e.getY());
                    double moduloCampo = Math.round(campo.getModulo());
                    double anguloCampo = Math.round(Math.toDegrees(-campo.getAngulo()));
                    double moduloFuerza = moduloCampo * Math.abs(carga);
                    double anguloFuerza = FrmCargas.cargas.anguloFuerza(anguloCampo, carga);

                    CargasSinMov.this.eliminarPanelVector();
                    CargasSinMov.this.crearPanelVector();
                    CargasSinMov.this.panel.representacion(campo, e.getPoint(), carga);
                    CargasSinMov.this.panel.repaint();

                    if (moduloCampo == 0.0D) {
                        bandera = false;
                    }
                    if (carga == 0.0D) {
                        bandera2 = false;
                    }
                    String strCampo = String.format("%6.2e", new Object[]{Double.valueOf(moduloCampo)}) + "N/C   ";
                    String strFuerza = String.format("%6.2e", new Object[]{Double.valueOf(moduloFuerza)}) + "N   ";
                    if (bandera) {
                        strCampo = strCampo + anguloCampo + "°";
                        if (bandera2) {
                            strFuerza = strFuerza + anguloFuerza + "°";
                        }
                    }

                    CargasSinMov.this.txtCampo.setText(strCampo);
                    CargasSinMov.this.txtFuerza.setText(strFuerza);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese el valor de la carga");
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblCargaPrueba = new javax.swing.JLabel();
        lblCampo = new javax.swing.JLabel();
        txtCarga = new javax.swing.JTextField();
        lblX10 = new javax.swing.JLabel();
        txtCargaExp = new javax.swing.JTextField();
        lblC = new javax.swing.JLabel();
        txtCampo = new javax.swing.JTextField();
        txtFuerza = new javax.swing.JTextField();
        lblFuerza = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 40)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(51, 51, 51));
        lblTitulo.setText("Datos");

        lblCargaPrueba.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblCargaPrueba.setForeground(new java.awt.Color(51, 51, 51));
        lblCargaPrueba.setText("Carga de prueba:");

        lblCampo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblCampo.setForeground(new java.awt.Color(51, 51, 51));
        lblCampo.setText("Campo:");

        txtCarga.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargaActionPerformed(evt);
            }
        });

        lblX10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblX10.setForeground(new java.awt.Color(51, 51, 51));
        lblX10.setText("X 10 ^");

        txtCargaExp.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCargaExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargaExpActionPerformed(evt);
            }
        });

        lblC.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblC.setForeground(new java.awt.Color(51, 51, 51));
        lblC.setText("C");

        txtCampo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampoActionPerformed(evt);
            }
        });

        txtFuerza.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtFuerza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFuerzaActionPerformed(evt);
            }
        });

        lblFuerza.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblFuerza.setForeground(new java.awt.Color(51, 51, 51));
        lblFuerza.setText("Fuerza:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblX10)
                        .addGap(7, 7, 7)
                        .addComponent(txtCargaExp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblC))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCampo)
                        .addGap(1, 1, 1)
                        .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFuerza)
                        .addGap(4, 4, 4)
                        .addComponent(txtFuerza, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCargaPrueba)
                    .addComponent(lblTitulo))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblTitulo)
                .addGap(32, 32, 32)
                .addComponent(lblCargaPrueba)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblX10)
                    .addComponent(txtCargaExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblC))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCampo)
                    .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFuerza)
                    .addComponent(txtFuerza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(254, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargaActionPerformed

    private void txtCargaExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargaExpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargaExpActionPerformed

    private void txtCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCampoActionPerformed

    private void txtFuerzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFuerzaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFuerzaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CargasSinMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargasSinMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargasSinMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargasSinMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargasSinMov().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblC;
    private javax.swing.JLabel lblCampo;
    private javax.swing.JLabel lblCargaPrueba;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblFuerza;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblX10;
    private javax.swing.JTextField txtCampo;
    private javax.swing.JTextField txtCarga;
    private javax.swing.JTextField txtCargaExp;
    private javax.swing.JTextField txtFuerza;
    // End of variables declaration//GEN-END:variables
}