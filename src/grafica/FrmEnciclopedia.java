/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package grafica;

import java.awt.Color;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;

/**
 *
 * @author Fabri
 */
public class FrmEnciclopedia extends javax.swing.JFrame {

    /**
     * Creates new form FrmOpcionesCargas
     */
     private boolean menuAbierto;
    private boolean menuMoviendose;
    
    public FrmEnciclopedia() {
        initComponents();
        setTitle("PR: Enciclopedia | Equipo Dinamita");
        URL icono = getClass().getResource("/grafica/img/Logo_Proyecto.png");
        ImageIcon imagenIcono = new ImageIcon(icono);
        this.setIconImage( imagenIcono.getImage());
        this.setResizable(false);
        setLocationRelativeTo(null);
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
        lbtnIrLinea = new javax.swing.JLabel();
        lblMenuFondo = new javax.swing.JLabel();
        lblLeerCargaElectrica = new javax.swing.JLabel();
        lblLeerClasificacion = new javax.swing.JLabel();
        lblLeerLey = new javax.swing.JLabel();
        lblLeerEcuacionesCampoElectrico = new javax.swing.JLabel();
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

        lbtnIrLinea.setText("jLabel1");
        lbtnIrLinea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbtnIrLineaMouseClicked(evt);
            }
        });
        jPanelMenu.add(lbtnIrLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 400, 60));

        lblMenuFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/menuDeslizablePlaca.png"))); // NOI18N
        jPanelMenu.add(lblMenuFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 560));

        getContentPane().add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -560, 408, 560));

        lblLeerCargaElectrica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLeerCargaElectricaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLeerCargaElectricaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLeerCargaElectricaMouseExited(evt);
            }
        });
        getContentPane().add(lblLeerCargaElectrica, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 420, 30));

        lblLeerClasificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLeerClasificacionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLeerClasificacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLeerClasificacionMouseExited(evt);
            }
        });
        getContentPane().add(lblLeerClasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 410, 60));

        lblLeerLey.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLeerLeyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLeerLeyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLeerLeyMouseExited(evt);
            }
        });
        getContentPane().add(lblLeerLey, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 420, 40));

        lblLeerEcuacionesCampoElectrico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLeerEcuacionesCampoElectricoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLeerEcuacionesCampoElectricoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLeerEcuacionesCampoElectricoMouseExited(evt);
            }
        });
        getContentPane().add(lblLeerEcuacionesCampoElectrico, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 400, 30));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/EnciclopediaSeleccionar.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 560));

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
        new FrmOpcionesCargas().setVisible(true);
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

    private void lbtnIrLineaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbtnIrLineaMouseClicked
        setVisible(false);
        new FrmOpcionesLineas().setVisible(true);
    }//GEN-LAST:event_lbtnIrLineaMouseClicked

    private void lblLeerCargaElectricaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeerCargaElectricaMouseClicked
        setVisible(false);
        new FrmLeerLey().setVisible(true);
    }//GEN-LAST:event_lblLeerCargaElectricaMouseClicked

    private void lblLeerEcuacionesCampoElectricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeerEcuacionesCampoElectricoMouseClicked
        setVisible(false);
        new FrmLeerEcucacionesCampoElectrico().setVisible(true);
    }//GEN-LAST:event_lblLeerEcuacionesCampoElectricoMouseClicked

    private void lblLeerLeyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeerLeyMouseClicked
        setVisible(false);
        new FrmLeerLey().setVisible(true);
    }//GEN-LAST:event_lblLeerLeyMouseClicked

    private void lblLeerClasificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeerClasificacionMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new FrmLeerClas().setVisible(true);
    }//GEN-LAST:event_lblLeerClasificacionMouseClicked

    private void lblLeerLeyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeerLeyMouseEntered
        ImageIcon icon = new ImageIcon(FrmMenu.class.getResource("/grafica/img/EnciclopediaLeyHover.png"));
        lblFondo.setIcon(icon);
    }//GEN-LAST:event_lblLeerLeyMouseEntered

    private void lblLeerLeyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeerLeyMouseExited
        ImageIcon icon = new ImageIcon(FrmMenu.class.getResource("/grafica/img/EnciclopediaSeleccionar.png"));
        lblFondo.setIcon(icon);
    }//GEN-LAST:event_lblLeerLeyMouseExited

    private void lblLeerClasificacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeerClasificacionMouseEntered
        ImageIcon icon = new ImageIcon(FrmMenu.class.getResource("/grafica/img/EnciclopediaClasHover.png"));
        lblFondo.setIcon(icon);
    }//GEN-LAST:event_lblLeerClasificacionMouseEntered

    private void lblLeerClasificacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeerClasificacionMouseExited
        ImageIcon icon = new ImageIcon(FrmMenu.class.getResource("/grafica/img/EnciclopediaSeleccionar.png"));
        lblFondo.setIcon(icon);
    }//GEN-LAST:event_lblLeerClasificacionMouseExited

    private void lblLeerEcuacionesCampoElectricoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeerEcuacionesCampoElectricoMouseEntered
        ImageIcon icon = new ImageIcon(FrmMenu.class.getResource("/grafica/img/EnciclopediaEcuacionesHover.png"));
        lblFondo.setIcon(icon);
    }//GEN-LAST:event_lblLeerEcuacionesCampoElectricoMouseEntered

    private void lblLeerEcuacionesCampoElectricoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeerEcuacionesCampoElectricoMouseExited
        ImageIcon icon = new ImageIcon(FrmMenu.class.getResource("/grafica/img/EnciclopediaSeleccionar.png"));
        lblFondo.setIcon(icon);
    }//GEN-LAST:event_lblLeerEcuacionesCampoElectricoMouseExited

    private void lblLeerCargaElectricaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeerCargaElectricaMouseEntered
        ImageIcon icon = new ImageIcon(FrmMenu.class.getResource("/grafica/img/EnciclopediaCargaHover.png"));
        lblFondo.setIcon(icon);
    }//GEN-LAST:event_lblLeerCargaElectricaMouseEntered

    private void lblLeerCargaElectricaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeerCargaElectricaMouseExited
        ImageIcon icon = new ImageIcon(FrmMenu.class.getResource("/grafica/img/EnciclopediaSeleccionar.png"));
        lblFondo.setIcon(icon);
    }//GEN-LAST:event_lblLeerCargaElectricaMouseExited

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
            java.util.logging.Logger.getLogger(FrmEnciclopedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEnciclopedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEnciclopedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEnciclopedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEnciclopedia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelPantallaNegra;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblLeerCargaElectrica;
    private javax.swing.JLabel lblLeerClasificacion;
    private javax.swing.JLabel lblLeerEcuacionesCampoElectrico;
    private javax.swing.JLabel lblLeerLey;
    private javax.swing.JLabel lblMenuFondo;
    private logica.JLabelRotar lbtnAbrirMenu;
    private javax.swing.JLabel lbtnIrCargas;
    private javax.swing.JLabel lbtnIrCreditos;
    private javax.swing.JLabel lbtnIrLinea;
    private javax.swing.JLabel lbtnSalir;
    private javax.swing.JLabel lbtnVolverAtras;
    // End of variables declaration//GEN-END:variables
}
