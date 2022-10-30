/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Fabri
 */
public class Frm3CargaOpcion1 extends javax.swing.JFrame {

    /**
     * Creates new form FrmOpcionesCargas
     */
    public Frm3CargaOpcion1() {
        initComponents();
        setTitle("PR: Una carga | Equipo Dinamita");
        URL icono = getClass().getResource("/grafica/img/Logo_Proyecto.png");
        ImageIcon imagenIcono = new ImageIcon(icono);
        this.setIconImage( imagenIcono.getImage());
        this.setResizable(false);
        setLocationRelativeTo(null);
        txtCargaQ1.setBackground(new Color(0,0,0,0));
        txtCargaQ1.setSelectionColor(new Color(0,0,0,0));
        txtDistancia.setBackground(new Color(0,0,0,0));
        txtExponente.setBackground(new Color(0,0,0,0));
        try {
            URL urlFont = getClass().getResource("/fonts/pristina.ttf");
            String urlFontConverted = urlFont.toString().replaceAll("%20", " ");
            urlFontConverted = urlFontConverted.replaceAll("file:", "");
            urlFontConverted = urlFontConverted.replaceAll("Proyecto_Campo_Electrico.jar!/", "");
            urlFontConverted = urlFontConverted.replaceAll("jar:", "");
            Font pristinaFont = Font.createFont(Font.TRUETYPE_FONT, new File(urlFontConverted)).deriveFont(30f);
            Map<TextAttribute, Object> attributes = new HashMap<>();
            attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
            pristinaFont = pristinaFont.deriveFont(attributes);
            txtCargaQ1.setFont(pristinaFont);
            txtDistancia.setFont(pristinaFont);
            txtExponente.setFont(pristinaFont);
        } catch (FontFormatException | IOException ex) {
            System.out.println("No se pudo crear o cargar la font");
        }
        try {
            URL urlFont = getClass().getResource("/fonts/pristina.ttf");
            String urlFontConverted = urlFont.toString().replaceAll("%20", " ");
            urlFontConverted = urlFontConverted.replaceAll("file:", "");
            urlFontConverted = urlFontConverted.replaceAll("Proyecto_Campo_Electrico.jar!/", "");
            urlFontConverted = urlFontConverted.replaceAll("jar:", "");
            Font pristinaFont = Font.createFont(Font.TRUETYPE_FONT, new File(urlFontConverted)).deriveFont(43f);
            Map<TextAttribute, Object> attributes = new HashMap<>();
            attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
            pristinaFont = pristinaFont.deriveFont(attributes);
            lblCampo.setFont(pristinaFont);
        } catch (FontFormatException | IOException ex) {
            System.out.println("No se pudo crear o cargar la font");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCargaQ1 = new javax.swing.JTextField();
        txtDistancia = new javax.swing.JTextField();
        txtExponente = new javax.swing.JTextField();
        lblCampo = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCargaQ1.setBorder(null);
        txtCargaQ1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCargaQ1KeyReleased(evt);
            }
        });
        getContentPane().add(txtCargaQ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 42, 130, 40));

        txtDistancia.setBorder(null);
        txtDistancia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDistanciaKeyReleased(evt);
            }
        });
        getContentPane().add(txtDistancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 102, 130, 40));

        txtExponente.setBorder(null);
        txtExponente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtExponenteKeyReleased(evt);
            }
        });
        getContentPane().add(txtExponente, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 12, 40, 40));
        getContentPane().add(lblCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 170, 50));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/1CargaFondo.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    boolean esNumero(String text){
        try{
            Double.valueOf(text);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    
    void actualizarCampo(){
        if(esNumero(txtCargaQ1.getText())){
            double cargaQ1 = Double.parseDouble(txtCargaQ1.getText());
            if(esNumero(txtExponente.getText())){
                double exponente = Double.parseDouble(txtExponente.getText());
                double cargaCompleta = cargaQ1 * Math.pow(10, exponente);
                if(esNumero(txtDistancia.getText())){
                    double distancia = Double.parseDouble(txtDistancia.getText());
                    double k = 9e9;
                    double campoResultante = (k * Math.abs(cargaCompleta)) / Math.pow(distancia, 2);
                    DecimalFormat f = new DecimalFormat("0.##E0");
                    lblCampo.setText(String.valueOf(f.format(campoResultante)));
                }  
            }
            
            if(cargaQ1 > 0){
                ImageIcon icon = new ImageIcon(FrmMenu.class.getResource("/grafica/img/1CargaFondoPositivo.png"));
                lblFondo.setIcon(icon);
                return;
            }
            if(cargaQ1 < 0){
                ImageIcon icon = new ImageIcon(FrmMenu.class.getResource("/grafica/img/1CargaFondoNegativo.png"));
                lblFondo.setIcon(icon);
                return;
            }
            ImageIcon icon = new ImageIcon(FrmMenu.class.getResource("/grafica/img/1CargaFondo.png"));
            lblFondo.setIcon(icon);
        }
    }
    
    private void txtCargaQ1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargaQ1KeyReleased
        if(esNumero(txtCargaQ1.getText())){
            actualizarCampo();
            txtCargaQ1.setBackground(new Color(0,0,0,0));
            return;
        }
        if(txtCargaQ1.getText().equals("")){
            lblCampo.setText(null);
            txtCargaQ1.setBackground(new Color(0,0,0,0));
            return;
        }
        txtCargaQ1.setBackground(new Color(100,0,0,100));
        lblCampo.setText(null);
    }//GEN-LAST:event_txtCargaQ1KeyReleased

    private void txtDistanciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDistanciaKeyReleased
        if(esNumero(txtDistancia.getText())){
            actualizarCampo();
            txtDistancia.setBackground(new Color(0,0,0,0));
            return;
        }
        if(txtDistancia.getText().equals("")){
            lblCampo.setText(null);
            txtDistancia.setBackground(new Color(0,0,0,0));
            return;
        }
        txtDistancia.setBackground(new Color(100,0,0,100));
        lblCampo.setText(null);
    }//GEN-LAST:event_txtDistanciaKeyReleased

    private void txtExponenteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExponenteKeyReleased
        if(txtExponente.getText().equals("")){
            txtExponente.setBackground(new Color(0,0,0,0));
            lblCampo.setText(null);
            return;
        }
        if(esNumero(txtExponente.getText())){
            double exponente = Double.parseDouble(txtExponente.getText());
            if(exponente >= -12 && exponente <= 12){
                actualizarCampo();
                txtExponente.setBackground(new Color(0,0,0,0));
                return;
            }
        }
        txtExponente.setBackground(new Color(100,0,0,100));
        lblCampo.setText(null);
    }//GEN-LAST:event_txtExponenteKeyReleased

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
            java.util.logging.Logger.getLogger(Frm3CargaOpcion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm3CargaOpcion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm3CargaOpcion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm3CargaOpcion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Frm3CargaOpcion1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCampo;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JTextField txtCargaQ1;
    private javax.swing.JTextField txtDistancia;
    private javax.swing.JTextField txtExponente;
    // End of variables declaration//GEN-END:variables
}
