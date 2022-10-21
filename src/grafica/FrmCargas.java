package grafica;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.TimerTask;
import javax.swing.JLabel;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import logica.CargaFuente;
import logica.Cargas;
import logica.Vector;

/**
 *
 * @author Paña
 */
public class FrmCargas extends javax.swing.JFrame {

    public static Cargas cargas;
    private boolean menuAbierto;
    private boolean menuMoviendose;
    
    private PanelVector panel;
    private PanelCargas panel1;
    private JLabel lblCarga1;
    private JPanel panelImagenes;
    private int contador;

    private Point primerPunto;
    private Point segundoPunto;
    
    /**
     * Creates new form NewJFrame
     */
    public FrmCargas() {
        initComponents();
        iniciador();
    }
    
    private void crearPanelVector() {
        panel = new PanelVector(panel1.getBounds());
        add(panel, new AbsoluteConstraints(0, 0, panel1.getWidth(), panel1.getHeight()));
        setComponentZOrder(panel, 0);
    }

    private void eliminarPanelVector() {
        if (this.contador > 0) {
            remove(0);
        } else {
            this.contador++;
        }
    }
    
    private void iniciador() {
        URL icono = getClass().getResource("/grafica/img/Logo_Proyecto.png");
        ImageIcon imagenIcono = new ImageIcon(icono);
        this.setIconImage( imagenIcono.getImage());
        txtCarga.setBackground(new Color(0,0,0,0));
        txtCargaExp.setBackground(new Color(0,0,0,0));
        txtCampo.setBackground(new Color(0,0,0,0));
        lbtnAbrirMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.contador = 0;
        this.panelImagenes = new JPanel();
        this.panelImagenes.setBounds(40, 40, 700, 500);
        this.panelImagenes.setLayout((LayoutManager) null);
        this.panelImagenes.setOpaque(false);
        this.lblCarga1 = new JLabel();
        this.lblCarga1.setSize(16, 16);
        this.lblCarga1.setOpaque(false);
        this.panelImagenes.add(this.lblCarga1);
        this.lblFondo.add(this.panelImagenes);
        this.panel1 = new PanelCargas();
        this.lblCarga1.setLayout((LayoutManager) null);
        this.lblFondo.add(this.panel1);
        
        this.panel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(cbCargaPrueba.isSelected()){
                    try {
                        segundoPunto = e.getPoint();
                        System.out.println("primer punto: "+primerPunto);
                        System.out.println("segundo punto: "+segundoPunto);
                        double carga = Double.parseDouble(txtCarga.getText());
                        carga *= Math.pow(10.0D, Integer.parseInt(txtCargaExp.getText()));
                        Vector campo = cargas.sumarCampos(e.getX(), e.getY());
                        eliminarPanelVector();
                        crearPanelVector();
                        panel.representacion(campo, e.getPoint(), carga);
                        panel.repaint();
                    } catch (Exception ex) {
                       lblTips.setText("¡Debes ingresar al menos una carga!");
                       lblTips.setForeground(Color.red);
                    }
                }
            }
        });
        
        setTitle("PR: Cargas | Equipo Dinamita");
        txtCampo.setVisible(false);
        menuMoviendose = false;
        menuAbierto = false;
        setResizable(false);
        cargas = new Cargas();
        this.jPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int CLICK_IZQUIERDO = 1;
                if(e.getButton() == CLICK_IZQUIERDO){
                    try {
                        if(!cbCargaPrueba.isSelected()){
                            primerPunto = e.getPoint();
                            double valorCarga = Double.parseDouble(FrmCargas.this.txtCarga.getText());
                            valorCarga *= Math.pow(10.0D, Integer.parseInt(FrmCargas.this.txtCargaExp.getText()));
                            if (jPanel.getComponentAt(e.getPoint()).equals(jPanel)) {
                                int x = e.getX();
                                int y = e.getY();
                                /*
                                ImageIcon icon;
                                
                                if (valorCarga > 0.0D) {
                                    icon = new ImageIcon(FrmCargas.class.getResource("img/CargaPositiva.png"));
                                } else if (valorCarga < 0.0D) {
                                    icon = new ImageIcon(FrmCargas.class.getResource("img/CargaNegativa.png"));
                                } else {
                                
                                    icon = new ImageIcon(FrmCargas.class.getResource("img/CargaNula.png"));
                                }
                                
                                JLabel lbl = new JLabel();
                                lbl.setBounds(x - 24, y - 24, 48, 48);
                                lbl.setIcon(icon);
                                */
                                int xMenor = (int) (Math.floor((x / 50) + 0.5D) * 50.0D);
                                int xMayor = (int) (Math.floor((x / 50 + 1)) * 50.0D);
                                if (Math.abs(x - xMenor) > Math.abs(x - xMayor)) {
                                    x = xMayor;
                                } else {
                                    x = xMenor;
                                }
                                int yMenor = (int) (Math.floor((y / 50) + 0.5D) * 50.0D);
                                int yMayor = (int) (Math.floor((y / 50 + 1)) * 50.0D);
                                if (Math.abs(y - yMenor) > Math.abs(y - yMayor)) {
                                    y = yMayor;
                                } else {
                                    y = yMenor;
                                }
                                
                                cargas.agregar(new CargaFuente(valorCarga, x, y));
                                txtCarga.setText((String) null);
                                txtCargaExp.setText((String) null);
                                //FrmCargas.this.jPanel.add(lbl);
                                jPanel.repaint();
                            }
                            lblTips.setText("Puedes continuar colocando cargas o activar la opción CARGA DE PRUEBA.");
                            lblTips.setForeground(new Color(102, 102, 255));
                        }
                    } catch (Exception ex) {
                        lblTips.setText("¡Debes ingresar al menos una carga!");
                        lblTips.setForeground(Color.red);
                    }
                }else{
                    int x = e.getX();
                    int y = e.getY();
                    CargaFuente carga = new CargaFuente(1,x,y);
                    //Eliminar de la lista
                    cargas.eliminarPorPosicion(carga);

                    //Borrar
                    lblFondo.remove(panel1);
                    lblFondo.remove(panelImagenes);
                    lblFondo.setVisible(false);
                    lblFondo.setVisible(true);
                    
                    //Settear de nuevo
                    panelImagenes = new JPanel();
                    panelImagenes.setBounds(40, 40, 700, 500);
                    panelImagenes.setLayout((LayoutManager) null);
                    panelImagenes.setOpaque(false);
                    lblCarga1 = new JLabel();
                    lblCarga1.setSize(16, 16);
                    lblCarga1.setOpaque(false);
                    panelImagenes.add(lblCarga1);
                    lblFondo.add(panelImagenes);
                    panel1 = new PanelCargas();
                    lblCarga1.setLayout((LayoutManager) null);
                    lblFondo.add(panel1);
                    
                    if(cargas.tamano() == 0){
                        lblTips.setText("TIP: Primero escribe los valores de la carga");
                        lblTips.setForeground(new Color(102, 102, 255));
                    }
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
        lbtnIrPlacas = new javax.swing.JLabel();
        lbtnIrCreditos = new javax.swing.JLabel();
        lbtnSalir = new javax.swing.JLabel();
        lblMenuFondo = new javax.swing.JLabel();
        lbtnLimpiar = new javax.swing.JLabel();
        lblTips = new javax.swing.JLabel();
        jPanel = new javax.swing.JPanel();
        txtCarga = new javax.swing.JTextField();
        txtCargaExp = new javax.swing.JTextField();
        txtCampo = new javax.swing.JTextField();
        cbCargaPrueba = new javax.swing.JCheckBox();
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
        jPanelMenu.add(lbtnVolverAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 400, 50));

        lbtnIrPlacas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbtnIrPlacasMouseClicked(evt);
            }
        });
        jPanelMenu.add(lbtnIrPlacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 400, 70));

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

        lblMenuFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/menuDeslizableCarga.png"))); // NOI18N
        jPanelMenu.add(lblMenuFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 560));

        getContentPane().add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -560, 408, 560));

        lbtnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbtnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbtnLimpiarMouseClicked(evt);
            }
        });
        getContentPane().add(lbtnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 490, 180, 70));

        lblTips.setFont(new java.awt.Font("Dyuthi", 3, 24)); // NOI18N
        lblTips.setForeground(new java.awt.Color(102, 102, 255));
        lblTips.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTips.setText("TIP: Primero escribe los valores de la carga");
        getContentPane().add(lblTips, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 455, 1000, -1));

        jPanel.setBackground(new java.awt.Color(204, 204, 204));
        jPanel.setOpaque(false);
        jPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 670, 500));

        txtCarga.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCarga.setForeground(new java.awt.Color(255, 255, 255));
        txtCarga.setBorder(null);
        txtCarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCargaKeyReleased(evt);
            }
        });
        getContentPane().add(txtCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 150, 40, -1));

        txtCargaExp.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCargaExp.setForeground(new java.awt.Color(255, 255, 255));
        txtCargaExp.setBorder(null);
        txtCargaExp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCargaExpKeyReleased(evt);
            }
        });
        getContentPane().add(txtCargaExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 140, 30, -1));

        txtCampo.setEditable(false);
        txtCampo.setForeground(new java.awt.Color(255, 255, 255));
        txtCampo.setBorder(null);
        getContentPane().add(txtCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 390, 150, 30));

        cbCargaPrueba.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(cbCargaPrueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(767, 324, 20, -1));

        lblFondoDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/Fondo3.png"))); // NOI18N
        getContentPane().add(lblFondoDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 0, -1, -1));

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
    
    private void lbtnIrPlacasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbtnIrPlacasMouseClicked
        setVisible(false);
        new FrmPlaca().setVisible(true);
    }//GEN-LAST:event_lbtnIrPlacasMouseClicked

    private void lbtnVolverAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbtnVolverAtrasMouseClicked
        setVisible(false);
        new FrmMenu().setVisible(true);
    }//GEN-LAST:event_lbtnVolverAtrasMouseClicked

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

    private void jPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMouseClicked
        int CLICK_IZQUIERDO = 1;
        if(evt.getButton() == CLICK_IZQUIERDO){
            if(cbCargaPrueba.isSelected()){   
                if(cargas.tamano() > 0){
                    if(!menuAbierto){
                        try {
                            boolean bandera = true;
                            double carga = Double.parseDouble(txtCarga.getText());
                            carga *= Math.pow(10.0D, Integer.parseInt(txtCargaExp.getText()));
                            Vector campo = cargas.sumarCampos(evt.getX(), evt.getY());
                            double moduloCampo = Math.round(campo.getModulo());
                            double anguloCampo = Math.round(Math.toDegrees(-campo.getAngulo()));
                            eliminarPanelVector();
                            crearPanelVector();
                            panel.representacion(campo, evt.getPoint(), carga);
                            if (moduloCampo == 0) {
                                bandera = false;
                            }
                            String strCampo = String.format("%6.2e", new Object[]{ moduloCampo }) + "N/C   ";
                            if (bandera) {
                                strCampo = strCampo + anguloCampo + "°";
                            }
                            txtCampo.setVisible(true);
                            txtCampo.setText(strCampo);
                        } catch (Exception ex) {
                            lblTips.setText("¡Debes ingresar al menos una carga!");
                            lblTips.setForeground(Color.RED);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jPanelMouseClicked

    private void txtCargaExpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargaExpKeyReleased
        if(!txtCargaExp.getText().equals("") && !txtCarga.getText().equals("")){
            lblTips.setText("¡Bien hecho! Ahora haz click donde quieras colocar la misma.");
            lblTips.setForeground(Color.GREEN);
        }
    }//GEN-LAST:event_txtCargaExpKeyReleased

    private void txtCargaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargaKeyReleased
        if(!txtCargaExp.getText().equals("") && !txtCarga.getText().equals("")){
            lblTips.setText("¡Bien hecho! Ahora haz click donde quieras colocar la misma.");
            lblTips.setForeground(Color.GREEN);
        }
    }//GEN-LAST:event_txtCargaKeyReleased

    private void lbtnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbtnLimpiarMouseClicked
        cargas.limpiar();
        //Borrar
        lblFondo.remove(panel1);
        lblFondo.remove(panelImagenes);
        lblFondo.setVisible(false);
        lblFondo.setVisible(true);

        //Settear de nuevo
        panelImagenes = new JPanel();
        panelImagenes.setBounds(40, 40, 700, 500);
        panelImagenes.setLayout((LayoutManager) null);
        panelImagenes.setOpaque(false);
        lblCarga1 = new JLabel();
        lblCarga1.setSize(16, 16);
        lblCarga1.setOpaque(false);
        panelImagenes.add(lblCarga1);
        lblFondo.add(panelImagenes);
        panel1 = new PanelCargas();
        lblCarga1.setLayout((LayoutManager) null);
        lblFondo.add(panel1);
        lblTips.setText("TIP: Primero escribe los valores de la carga");
        lblTips.setForeground(new Color(102, 102, 255));
    }//GEN-LAST:event_lbtnLimpiarMouseClicked

    private void lbtnIrCreditosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbtnIrCreditosMouseClicked
        setVisible(false);
        new FrmCreditos().setVisible(true);
    }//GEN-LAST:event_lbtnIrCreditosMouseClicked

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
            java.util.logging.Logger.getLogger(FrmCargas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCargas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCargas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCargas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCargas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbCargaPrueba;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelPantallaNegra;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblFondoDatos;
    private javax.swing.JLabel lblMenuFondo;
    private javax.swing.JLabel lblTips;
    private logica.JLabelRotar lbtnAbrirMenu;
    private javax.swing.JLabel lbtnIrCreditos;
    private javax.swing.JLabel lbtnIrPlacas;
    private javax.swing.JLabel lbtnLimpiar;
    private javax.swing.JLabel lbtnSalir;
    private javax.swing.JLabel lbtnVolverAtras;
    private javax.swing.JTextField txtCampo;
    private javax.swing.JTextField txtCarga;
    private javax.swing.JTextField txtCargaExp;
    // End of variables declaration//GEN-END:variables
}
