package grafica;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import logica.Placas;
import logica.Vector;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author Paña
 */
public class FrmPlacasConMov extends javax.swing.JFrame {

    private Point puntoA;
    private Point puntoB;
    private byte seleccionPunto;
    private double valorCarga;
    private double tiempo;
    private PanelPlacas Panel1;
    private PanelAnimacion animacion;
    private JPanel panelPuntos;
    private JLabel lblPuntoA;
    private JLabel lblPuntoB;
    private int contador;
    private boolean menuAbierto;
    private boolean menuMoviendose;

    public FrmPlacasConMov() {
        initComponents();
        miInicializador();
    }

    private Icon iconoRedimensionado(String url, JLabel lbl) {
        ImageIcon imagen = new ImageIcon(getClass().getResource(url));
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), 1));
        return icono;
    }

    private double AGrados(double ang) {
        return Math.round(Math.toDegrees(ang));
    }

    private void eliminarAnimacion() {
        remove(0);
        repaint();
    }

    private void crearAnimacion(double vel) {
        this.animacion = new PanelAnimacion(this.puntoA, this.puntoB, this.valorCarga, vel);
        add(this.animacion, new AbsoluteConstraints(0, 0, animacion.getWidth(), animacion.getHeight()));
        setComponentZOrder(this.animacion, 0);
    }

    private void miInicializador() {
        menuAbierto = false;
        menuMoviendose = false;
        txtCampo.setBackground(new Color(0,0,0,0));
        txtFuerza.setBackground(new Color(0,0,0,0));
        txtTrabajo.setBackground(new Color(0,0,0,0));
        txtVel.setBackground(new Color(0,0,0,0));
        txtDesp.setBackground(new Color(0,0,0,0));
        txtDdp.setBackground(new Color(0,0,0,0));
        setTitle("ES: Placas con movimiento | Equipo Dinamita");
        URL icono = getClass().getResource("/grafica/img/Logo_Proyecto.png");
        ImageIcon imagenIcono = new ImageIcon(icono);
        this.setIconImage( imagenIcono.getImage());
        setResizable(false);
        this.contador = 0;
        this.seleccionPunto = 1;
        this.txtCampo.setEditable(false);
        this.txtFuerza.setEditable(false);
        this.txtTrabajo.setEditable(false);
        this.txtDesp.setEditable(false);
        this.txtVel.setEditable(false);
        this.txtDdp.setEditable(false);

        this.panelPuntos = new JPanel();
        this.panelPuntos.setBounds(40, 40, 700, 500);
        this.panelPuntos.setLayout((LayoutManager) null);
        this.panelPuntos.setOpaque(false);
        this.lblPuntoA = new JLabel();
        this.lblPuntoA.setSize(32, 32);
        this.panelPuntos.add(this.lblPuntoA);
        this.lblPuntoB = new JLabel();
        this.lblPuntoB.setSize(32, 32);
        this.panelPuntos.add(this.lblPuntoB);
        this.lblFondo.add(this.panelPuntos);

        this.Panel1 = new PanelPlacas();
        this.lblFondo.add(this.Panel1);
        this.Panel1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (FrmPlacasConMov.this.Panel1.getComponentAt(e.getPoint()).equals(FrmPlacasConMov.this.Panel1)) {
                    String st;
                    switch (FrmPlacasConMov.this.seleccionPunto) {

                        case 0:
                            FrmPlacasConMov.this.eliminarAnimacion();
                            FrmPlacasConMov.this.lblPuntoA.setIcon((Icon) null);
                            FrmPlacasConMov.this.lblPuntoB.setIcon((Icon) null);
                            FrmPlacasConMov.this.txtCarga.setEditable(true);
                            FrmPlacasConMov.this.txtCargaExp.setEditable(true);
                            FrmPlacasConMov.this.txtTiempo.setEditable(true);
                            FrmPlacasConMov.this.txtTiempoExp.setEditable(true);
                            FrmPlacasConMov.this.txtCampo.setText((String) null);
                            FrmPlacasConMov.this.txtFuerza.setText((String) null);
                            FrmPlacasConMov.this.txtTrabajo.setText((String) null);
                            FrmPlacasConMov.this.txtDesp.setText((String) null);
                            FrmPlacasConMov.this.txtVel.setText((String) null);
                            FrmPlacasConMov.this.txtDdp.setText((String) null);
                            FrmPlacasConMov.this.seleccionPunto = (byte)1;
                            break;

                        case 1:
                            try {
                            FrmPlacasConMov.this.valorCarga = Double.valueOf(FrmPlacasConMov.this.txtCarga.getText()).doubleValue();
                            FrmPlacasConMov.this.valorCarga = FrmPlacasConMov.this.valorCarga * Math.pow(10.0D, Integer.valueOf(FrmPlacasConMov.this.txtCargaExp.getText()).intValue());
                            FrmPlacasConMov.this.tiempo = Math.abs(Double.valueOf(FrmPlacasConMov.this.txtTiempo.getText()).doubleValue());
                            FrmPlacasConMov.this.tiempo = FrmPlacasConMov.this.tiempo * Math.pow(10.0D, Integer.valueOf(FrmPlacasConMov.this.txtTiempoExp.getText()).intValue());
                            FrmPlacasConMov.this.puntoA = e.getPoint();
                            FrmPlacasConMov.this.lblPuntoB.setIcon((Icon) null);
                            int xPtoA = (int) FrmPlacasConMov.this.puntoA.getX();
                            int yPtoA = (int) FrmPlacasConMov.this.puntoA.getY();
                            ImageIcon imgA = new ImageIcon(PlacasSinMov.class.getResource("img/puntoA.png"));
                            FrmPlacasConMov.this.lblPuntoA.setLocation(xPtoA - 16, yPtoA - 16);
                            FrmPlacasConMov.this.lblPuntoA.setIcon(imgA);
                            FrmPlacasConMov.this.txtCarga.setEditable(false);
                            FrmPlacasConMov.this.txtCargaExp.setEditable(false);
                            FrmPlacasConMov.this.txtTiempo.setEditable(false);
                            FrmPlacasConMov.this.txtTiempoExp.setEditable(false);
                            FrmPlacasConMov.this.seleccionPunto = (byte)2;

                        } catch (Exception ex) {
                            String str = "Ingrese un valor para la carga y el tiempo";
                            JOptionPane.showMessageDialog(null, str);
                        }
                        break;

                        case 2:
                            FrmPlacasConMov.this.puntoB = e.getPoint();

                            if (FrmPlacasConMov.this.Panel1.placasEntrePuntos(FrmPlacasConMov.this.puntoA, FrmPlacasConMov.this.puntoB) == 0) {
                                boolean bandera = true;
                                boolean bandera2 = true;
                                Vector campo = new Vector(FrmPlaca.placas.sumarCampos(e.getX()), FrmPlaca.placas.anguloCampo(FrmPlaca.placas.sumarCampos(e.getX())));
                                Vector fuerza = new Vector(campo.getModulo() * FrmPlacasConMov.this.valorCarga, FrmPlaca.placas.anguloFuerza(campo.getAngulo(), FrmPlacasConMov.this.valorCarga));
                                Vector desplazamiento = new Vector(FrmPlacasConMov.this.puntoA.distance(FrmPlacasConMov.this.puntoB), -Placas.anguloDespl(FrmPlacasConMov.this.puntoA, FrmPlacasConMov.this.puntoB));
                                Vector velMedia = new Vector(desplazamiento.getModulo() / FrmPlacasConMov.this.tiempo, desplazamiento.getAngulo());
                                double trabajo = fuerza.productoEscalar(desplazamiento);
                                double ddp = -campo.productoEscalar(desplazamiento);

                                if (campo.getModulo() == 0.0D) {
                                    bandera = false;
                                    trabajo = 0.0D;
                                    ddp = 0.0D;
                                }

                                if (FrmPlacasConMov.this.valorCarga == 0.0D) {
                                    bandera2 = false;
                                }

                                if (Math.abs(desplazamiento.getAngulo()) == 1.5707963267948966D) {
                                    trabajo = 0.0D;
                                    ddp = 0.0D;
                                }

                                int xPtoB = (int)FrmPlacasConMov.this.puntoB.getX();
                                int yPtoB = (int)FrmPlacasConMov.this.puntoB.getY();
                                ImageIcon imgB = new ImageIcon(PlacasSinMov.class.getResource("img/puntoB.png"));
                                FrmPlacasConMov.this.lblPuntoB.setLocation(xPtoB - 16, yPtoB - 16);
                                FrmPlacasConMov.this.lblPuntoB.setIcon(imgB);

                                FrmPlacasConMov.this.crearAnimacion(velMedia.getModulo());

                                String strCampo = String.format("%6.2e", new Object[]{Double.valueOf(campo.getModulo())}) + "N/C   ";
                                String strFuerza = String.format("%6.2e", new Object[]{Double.valueOf(fuerza.getModulo())}) + "N   ";
                                String strTrabajo = String.format("%6.2e", new Object[]{Double.valueOf(trabajo)}) + "J";
                                String strDesp = String.format("%6.2e", new Object[]{Double.valueOf(desplazamiento.getModulo())}) + "m   " + FrmPlacasConMov.this.AGrados(desplazamiento.getAngulo()) + "°";
                                String strVel = String.format("%6.2e", new Object[]{Double.valueOf(velMedia.getModulo())}) + "m/s   " + FrmPlacasConMov.this.AGrados(desplazamiento.getAngulo()) + "°";
                                String strDdp = String.format("%6.2e", new Object[]{Double.valueOf(ddp)}) + "V";

                                if (bandera) {
                                    strCampo = strCampo + FrmPlacasConMov.this.AGrados(campo.getAngulo()) + "°";
                                    if (bandera2) {
                                        strFuerza = strFuerza + FrmPlacasConMov.this.AGrados(fuerza.getAngulo()) + "°";
                                    }
                                }

                                FrmPlacasConMov.this.txtCampo.setText(strCampo);
                                FrmPlacasConMov.this.txtFuerza.setText(strFuerza);
                                FrmPlacasConMov.this.txtTrabajo.setText(strTrabajo);
                                FrmPlacasConMov.this.txtVel.setText(strVel);
                                FrmPlacasConMov.this.txtDesp.setText(strDesp);
                                FrmPlacasConMov.this.txtDdp.setText(strDdp);
                                FrmPlacasConMov.this.seleccionPunto = (byte) 0;

                                break;
                            }

                            st = "Elija puntos dentro de la misma sección.";
                            JOptionPane.showMessageDialog(null, st);
                            break;
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
        lbtnIrCargas = new javax.swing.JLabel();
        lbtnIrCreditos = new javax.swing.JLabel();
        lbtnSalir = new javax.swing.JLabel();
        lblMenuFondo = new javax.swing.JLabel();
        txtCarga = new javax.swing.JTextField();
        txtCargaExp = new javax.swing.JTextField();
        txtTiempo = new javax.swing.JTextField();
        txtTiempoExp = new javax.swing.JTextField();
        txtCampo = new javax.swing.JTextField();
        txtFuerza = new javax.swing.JTextField();
        txtTrabajo = new javax.swing.JTextField();
        txtDesp = new javax.swing.JTextField();
        txtDdp = new javax.swing.JTextField();
        txtVel = new javax.swing.JTextField();
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

        txtCarga.setBackground(new java.awt.Color(0, 0, 0));
        txtCarga.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCarga.setForeground(new java.awt.Color(255, 255, 255));
        txtCarga.setBorder(null);
        txtCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargaActionPerformed(evt);
            }
        });
        getContentPane().add(txtCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 127, 34, -1));

        txtCargaExp.setBackground(new java.awt.Color(0, 0, 0));
        txtCargaExp.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCargaExp.setForeground(new java.awt.Color(255, 255, 255));
        txtCargaExp.setBorder(null);
        txtCargaExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargaExpActionPerformed(evt);
            }
        });
        getContentPane().add(txtCargaExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 113, 30, -1));

        txtTiempo.setBackground(new java.awt.Color(0, 0, 0));
        txtTiempo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtTiempo.setForeground(new java.awt.Color(255, 255, 255));
        txtTiempo.setBorder(null);
        txtTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiempoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 174, 34, -1));

        txtTiempoExp.setBackground(new java.awt.Color(0, 0, 0));
        txtTiempoExp.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtTiempoExp.setForeground(new java.awt.Color(255, 255, 255));
        txtTiempoExp.setBorder(null);
        txtTiempoExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiempoExpActionPerformed(evt);
            }
        });
        getContentPane().add(txtTiempoExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 160, 30, -1));

        txtCampo.setBackground(new java.awt.Color(0, 0, 0));
        txtCampo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCampo.setForeground(new java.awt.Color(255, 255, 255));
        txtCampo.setBorder(null);
        txtCampo.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtCampo.setEnabled(false);
        txtCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 257, 120, -1));

        txtFuerza.setBackground(new java.awt.Color(0, 0, 0));
        txtFuerza.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtFuerza.setForeground(new java.awt.Color(255, 255, 255));
        txtFuerza.setBorder(null);
        txtFuerza.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtFuerza.setEnabled(false);
        txtFuerza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFuerzaActionPerformed(evt);
            }
        });
        getContentPane().add(txtFuerza, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 290, 120, -1));

        txtTrabajo.setBackground(new java.awt.Color(0, 0, 0));
        txtTrabajo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTrabajo.setForeground(new java.awt.Color(255, 255, 255));
        txtTrabajo.setBorder(null);
        txtTrabajo.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtTrabajo.setEnabled(false);
        txtTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrabajoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 326, 120, -1));

        txtDesp.setBackground(new java.awt.Color(0, 0, 0));
        txtDesp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDesp.setForeground(new java.awt.Color(255, 255, 255));
        txtDesp.setBorder(null);
        txtDesp.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtDesp.setEnabled(false);
        txtDesp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDespActionPerformed(evt);
            }
        });
        getContentPane().add(txtDesp, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 356, 120, -1));

        txtDdp.setBackground(new java.awt.Color(0, 0, 0));
        txtDdp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDdp.setForeground(new java.awt.Color(255, 255, 255));
        txtDdp.setBorder(null);
        txtDdp.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtDdp.setEnabled(false);
        txtDdp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDdpActionPerformed(evt);
            }
        });
        getContentPane().add(txtDdp, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 389, 120, -1));

        txtVel.setBackground(new java.awt.Color(0, 0, 0));
        txtVel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtVel.setForeground(new java.awt.Color(255, 255, 255));
        txtVel.setBorder(null);
        txtVel.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtVel.setEnabled(false);
        txtVel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVelActionPerformed(evt);
            }
        });
        getContentPane().add(txtVel, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 427, 120, -1));

        lblFondoDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/FondoDatosPlacasNuevo.png"))); // NOI18N
        getContentPane().add(lblFondoDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 290, 560));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/fondo-hoja.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 560));

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

    private void txtTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiempoActionPerformed

    private void txtTiempoExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiempoExpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiempoExpActionPerformed

    private void txtTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrabajoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrabajoActionPerformed

    private void txtDespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDespActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDespActionPerformed

    private void txtDdpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDdpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDdpActionPerformed

    private void txtVelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVelActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPlacasConMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPlacasConMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPlacasConMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPlacasConMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FrmPlacasConMov().setVisible(true);
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
    private javax.swing.JTextField txtDdp;
    private javax.swing.JTextField txtDesp;
    private javax.swing.JTextField txtFuerza;
    private javax.swing.JTextField txtTiempo;
    private javax.swing.JTextField txtTiempoExp;
    private javax.swing.JTextField txtTrabajo;
    private javax.swing.JTextField txtVel;
    // End of variables declaration//GEN-END:variables
}
