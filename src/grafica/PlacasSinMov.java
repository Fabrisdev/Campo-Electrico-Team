package grafica;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import logica.Vector;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author Paña
 */
public class PlacasSinMov extends javax.swing.JFrame {

    private PanelPlacas panel1;
    private JPanel panelImagenes;
    private JLabel lblCarga;
    private PanelVector panelVector;
    private int contador;
    private boolean menuAbierto;
    private boolean menuMoviendose;


    public PlacasSinMov() {
        initComponents();
        miInicializador();
    }

    private double AGrados(double ang) {
        return Math.round(Math.toDegrees(ang));
    }

    private void eliminarPanelVector() {
        if (this.contador > 0) {
            remove(0);
        } else {

            this.contador++;
        }
    }

    private void crearPanelVector() {
        this.panelVector = new PanelVector(this.panel1.getBounds());
        add(this.panelVector, new AbsoluteConstraints(0, 0, panelVector.getWidth(), panelVector.getHeight()));
        setComponentZOrder(this.panelVector, 0);
    }

    private void mostrarMenu(){
        Timer cronometro = new Timer();
        TimerTask mostrarMenuTimer = new TimerTask(){
            @Override
            public void run() {
                if(jPanelMenu.getY() < 0){
                    if(lbtnAbrirMenu.getRotation() < 7.83){
                        lbtnAbrirMenu.setRotation(lbtnAbrirMenu.getRotation() + 0.15);
                    }else{
                        lbtnAbrirMenu.setRotation(7.83);
                    }
                    menuMoviendose = true;
                    int nuevaY = jPanelMenu.getY() + 8;
                    jPanelMenu.setLocation(0, nuevaY);
                }else{
                    menuMoviendose = false;
                    cancel();
                }
            }   
        };
        cronometro.scheduleAtFixedRate(mostrarMenuTimer, 0, 5);
    }
    
    private void ocultarMenu(){
        Timer cronometro = new Timer();
        TimerTask mostrarMenuTimer = new TimerTask(){
            @Override
            public void run() {
                if(lbtnAbrirMenu.getRotation() > 0){
                        lbtnAbrirMenu.setRotation(lbtnAbrirMenu.getRotation() - 0.15);
                }else{
                        lbtnAbrirMenu.setRotation(0);
                }
                if(jPanelMenu.getY() > -jPanelMenu.getHeight()){
                    menuMoviendose = true;
                    int nuevaY = jPanelMenu.getY() - 8;
                    jPanelMenu.setLocation(0, nuevaY);
                }else{
                    menuMoviendose = false;
                    cancel();
                }
            }   
        };
        cronometro.scheduleAtFixedRate(mostrarMenuTimer, 0, 8);
    }
    
    private void miInicializador() {
        menuAbierto = false;
        menuMoviendose = false;
        txtCampo.setBackground(new Color(0,0,0,0));
        txtFuerza.setBackground(new Color(0,0,0,0));
        txtCarga.setBackground(new Color(0,0,0,0));
        txtCargaExp.setBackground(new Color(0,0,0,0));
        setTitle("PR: Placas sin movimiento | Equipo Dinamita");
        URL icono = getClass().getResource("/grafica/img/Logo_Proyecto.png");
        ImageIcon imagenIcono = new ImageIcon(icono);
        this.setIconImage( imagenIcono.getImage());
        setResizable(false);
        this.txtCampo.setEditable(false);
        this.txtFuerza.setEditable(false);
        this.contador = 0;

        this.panelImagenes = new JPanel();
        this.panelImagenes.setBounds(0, 40, 700, 500);
        this.panelImagenes.setLayout((LayoutManager) null);
        this.panelImagenes.setOpaque(false);
        this.lblCarga = new JLabel();
        this.lblCarga.setSize(16, 16);
        this.panelImagenes.add(this.lblCarga);
        this.lblFondo.add(this.panelImagenes);

        this.panel1 = new PanelPlacas();
        this.lblFondo.add(this.panel1);
        this.panel1.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                try {
                    if (PlacasSinMov.this.panel1.getComponentAt(e.getPoint()).equals(PlacasSinMov.this.panel1)) {
                        boolean bandera = true;
                        boolean bandera2 = true;
                        int xCarga = e.getX();
                        int yCarga = e.getY();
                        double valorCarga = Double.valueOf(PlacasSinMov.this.txtCarga.getText()).doubleValue();
                        valorCarga *= Math.pow(10.0D, Integer.valueOf(PlacasSinMov.this.txtCargaExp.getText()).intValue());
                        double campo = FrmPlaca.placas.sumarCampos(xCarga);
                        double fuerza = campo * valorCarga;
                        double anguloCampo = FrmPlaca.placas.anguloCampo(campo);
                        double anguloFuerza = FrmPlaca.placas.anguloFuerza(anguloCampo, valorCarga);
                        PlacasSinMov.this.eliminarPanelVector();
                        PlacasSinMov.this.crearPanelVector();
                        PlacasSinMov.this.panelVector.representacion(new Vector(campo, anguloCampo), e.getPoint(), valorCarga);
                        PlacasSinMov.this.panelVector.repaint();
                        if (campo == 0.0D) {
                            bandera = false;
                        }

                        if (valorCarga == 0.0D) {
                            bandera2 = false;
                        }

                        String strCampo = String.format("%6.2e", new Object[]{Double.valueOf(Math.abs(campo))}) + "N/C   ";
                        String strFuerza = String.format("%6.2e", new Object[]{Double.valueOf(Math.abs(fuerza))}) + "N   ";
                        if (bandera) {
                            strCampo = strCampo + PlacasSinMov.this.AGrados(anguloCampo) + "°";
                            if (bandera2) {
                                strFuerza = strFuerza + PlacasSinMov.this.AGrados(anguloFuerza) + "°";
                            }
                        }
                        PlacasSinMov.this.txtCampo.setText(strCampo);
                        PlacasSinMov.this.txtFuerza.setText(strFuerza);
                    }

                } catch (Exception ex) {
                    String st = "Ingrese un valor para la carga";
                    JOptionPane.showMessageDialog(null, st);
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

        lbtnAbrirMenu = new logica.JLabelRotar();
        jPanelMenu = new javax.swing.JPanel();
        lbtnVolverAtras = new javax.swing.JLabel();
        lbtnIrCargas = new javax.swing.JLabel();
        lbtnIrCreditos = new javax.swing.JLabel();
        lbtnSalir = new javax.swing.JLabel();
        lblMenuFondo = new javax.swing.JLabel();
        txtCarga = new javax.swing.JTextField();
        txtCampo = new javax.swing.JTextField();
        txtCargaExp = new javax.swing.JTextField();
        txtFuerza = new javax.swing.JTextField();
        lblFondoDatos = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();
        jPanelPantallaNegra = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbtnAbrirMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/botonAbrirMenu.png"))); // NOI18N
        lbtnAbrirMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbtnAbrirMenuMouseClicked(evt);
            }
        });
        getContentPane().add(lbtnAbrirMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 60, 60));

        jPanelMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMenu.setFocusable(false);
        jPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbtnVolverAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbtnVolverAtrasMouseClicked(evt);
            }
        });
        jPanelMenu.add(lbtnVolverAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 400, 50));

        lbtnIrCargas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbtnIrCargasMouseClicked(evt);
            }
        });
        jPanelMenu.add(lbtnIrCargas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 400, 60));

        lbtnIrCreditos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbtnIrCreditosMouseClicked(evt);
            }
        });
        jPanelMenu.add(lbtnIrCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 400, 60));

        lbtnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbtnSalirMouseClicked(evt);
            }
        });
        jPanelMenu.add(lbtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 400, 60));

        lblMenuFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/menuDeslizablePlaca.png"))); // NOI18N
        jPanelMenu.add(lblMenuFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 560));

        getContentPane().add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -560, 408, 560));

        txtCarga.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCarga.setForeground(new java.awt.Color(255, 255, 255));
        txtCarga.setBorder(null);
        txtCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargaActionPerformed(evt);
            }
        });
        getContentPane().add(txtCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 130, 38, -1));

        txtCampo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCampo.setForeground(new java.awt.Color(255, 255, 255));
        txtCampo.setBorder(null);
        txtCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 290, 133, -1));

        txtCargaExp.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCargaExp.setForeground(new java.awt.Color(255, 255, 255));
        txtCargaExp.setBorder(null);
        txtCargaExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargaExpActionPerformed(evt);
            }
        });
        getContentPane().add(txtCargaExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(923, 113, 30, -1));

        txtFuerza.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtFuerza.setForeground(new java.awt.Color(255, 255, 255));
        txtFuerza.setBorder(null);
        txtFuerza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFuerzaActionPerformed(evt);
            }
        });
        getContentPane().add(txtFuerza, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 323, 130, -1));

        lblFondoDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/Wea.png"))); // NOI18N
        getContentPane().add(lblFondoDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/fondo-hoja.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanelPantallaNegra.setOpaque(false);

        javax.swing.GroupLayout jPanelPantallaNegraLayout = new javax.swing.GroupLayout(jPanelPantallaNegra);
        jPanelPantallaNegra.setLayout(jPanelPantallaNegraLayout);
        jPanelPantallaNegraLayout.setHorizontalGroup(
            jPanelPantallaNegraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanelPantallaNegraLayout.setVerticalGroup(
            jPanelPantallaNegraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelPantallaNegra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 560));

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

    private void lbtnAbrirMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbtnAbrirMenuMouseClicked
        if(!menuMoviendose){
            if(menuAbierto){
                menuAbierto = false;
                ocultarMenu();
            }else{
                menuAbierto = true;
                mostrarMenu();
            }
        }
    }//GEN-LAST:event_lbtnAbrirMenuMouseClicked

    private void lbtnVolverAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbtnVolverAtrasMouseClicked
        setVisible(false);
        new FrmMenu().setVisible(true);
    }//GEN-LAST:event_lbtnVolverAtrasMouseClicked

    private void lbtnIrCargasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbtnIrCargasMouseClicked
        setVisible(false);
        new FrmCargas().setVisible(true);
    }//GEN-LAST:event_lbtnIrCargasMouseClicked

    private void lbtnIrCreditosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbtnIrCreditosMouseClicked
        setVisible(false);
        new FrmCreditos().setVisible(true);
    }//GEN-LAST:event_lbtnIrCreditosMouseClicked

    private void lbtnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbtnSalirMouseClicked
        jPanelPantallaNegra.setOpaque(true);
        jPanelPantallaNegra.setBackground(new Color(0,0,0,0));
        Timer cronometro = new Timer();
        TimerTask ajustarOpacidad = new TimerTask(){
            @Override
            public void run() {
                if(jPanelPantallaNegra.getBackground().getAlpha() < 50){
                    jPanelPantallaNegra.setBackground(new Color(0,0,0,jPanelPantallaNegra.getBackground().getAlpha() + 1));
                }else{
                    System.exit(0);
                    cancel();
                }
            }
        };
        cronometro.scheduleAtFixedRate(ajustarOpacidad, 0, 50);
    }//GEN-LAST:event_lbtnSalirMouseClicked

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
            java.util.logging.Logger.getLogger(PlacasSinMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlacasSinMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlacasSinMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlacasSinMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new PlacasSinMov().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelPantallaNegra;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblFondoDatos;
    private javax.swing.JLabel lblMenuFondo;
    private logica.JLabelRotar lbtnAbrirMenu;
    private javax.swing.JLabel lbtnIrCargas;
    private javax.swing.JLabel lbtnIrCreditos;
    private javax.swing.JLabel lbtnSalir;
    private javax.swing.JLabel lbtnVolverAtras;
    private javax.swing.JTextField txtCampo;
    private javax.swing.JTextField txtCarga;
    private javax.swing.JTextField txtCargaExp;
    private javax.swing.JTextField txtFuerza;
    // End of variables declaration//GEN-END:variables
}
