package grafica;

import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import logica.Placas;
import logica.Vector;

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
        add(this.animacion);
        setComponentZOrder(this.animacion, 0);
    }

    private void miInicializador() {
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

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        txtCarga = new javax.swing.JTextField();
        lblX10 = new javax.swing.JLabel();
        txtCargaExp = new javax.swing.JTextField();
        lblC = new javax.swing.JLabel();
        lblCampo = new javax.swing.JLabel();
        txtCampo = new javax.swing.JTextField();
        lblFuerza = new javax.swing.JLabel();
        lblCarga = new javax.swing.JLabel();
        txtFuerza = new javax.swing.JTextField();
        txtTiempo = new javax.swing.JTextField();
        lblX11 = new javax.swing.JLabel();
        txtTiempoExp = new javax.swing.JTextField();
        lblS = new javax.swing.JLabel();
        lblTrabajo = new javax.swing.JLabel();
        txtTrabajo = new javax.swing.JTextField();
        lblDesp = new javax.swing.JLabel();
        txtDesp = new javax.swing.JTextField();
        lblDdp = new javax.swing.JLabel();
        txtDdp = new javax.swing.JTextField();
        lblVel = new javax.swing.JLabel();
        txtVel = new javax.swing.JTextField();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 40)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(51, 51, 51));
        lblTitulo.setText("Datos");

        lblTiempo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTiempo.setForeground(new java.awt.Color(51, 51, 51));
        lblTiempo.setText("Tiempo:");

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

        lblCampo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblCampo.setForeground(new java.awt.Color(51, 51, 51));
        lblCampo.setText("Campo:");

        txtCampo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCampo.setEnabled(false);
        txtCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampoActionPerformed(evt);
            }
        });

        lblFuerza.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblFuerza.setForeground(new java.awt.Color(51, 51, 51));
        lblFuerza.setText("Fuerza:");

        lblCarga.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblCarga.setForeground(new java.awt.Color(51, 51, 51));
        lblCarga.setText("Carga:");

        txtFuerza.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtFuerza.setEnabled(false);
        txtFuerza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFuerzaActionPerformed(evt);
            }
        });

        txtTiempo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiempoActionPerformed(evt);
            }
        });

        lblX11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblX11.setForeground(new java.awt.Color(51, 51, 51));
        lblX11.setText("X 10 ^");

        txtTiempoExp.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtTiempoExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiempoExpActionPerformed(evt);
            }
        });

        lblS.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblS.setForeground(new java.awt.Color(51, 51, 51));
        lblS.setText("S");

        lblTrabajo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTrabajo.setForeground(new java.awt.Color(51, 51, 51));
        lblTrabajo.setText("Trabajo:");

        txtTrabajo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTrabajo.setEnabled(false);
        txtTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrabajoActionPerformed(evt);
            }
        });

        lblDesp.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblDesp.setForeground(new java.awt.Color(51, 51, 51));
        lblDesp.setText("Despl:");

        txtDesp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDesp.setEnabled(false);
        txtDesp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDespActionPerformed(evt);
            }
        });

        lblDdp.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblDdp.setForeground(new java.awt.Color(51, 51, 51));
        lblDdp.setText("d.d.p:");

        txtDdp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDdp.setEnabled(false);
        txtDdp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDdpActionPerformed(evt);
            }
        });

        lblVel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblVel.setForeground(new java.awt.Color(51, 51, 51));
        lblVel.setText("Vel. Med:");

        txtVel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtVel.setEnabled(false);
        txtVel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblX10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCargaExp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblC, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblTiempo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblX11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTiempoExp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblS, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblVel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtVel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(lblDdp)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDdp, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(lblDesp, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDesp, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFuerza, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFuerza, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblX10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCargaExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblX11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTiempoExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuerza, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFuerza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDesp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDdp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/FondoConHoja.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 780, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblFondo)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(lblFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblC;
    private javax.swing.JLabel lblCampo;
    private javax.swing.JLabel lblCarga;
    private javax.swing.JLabel lblDdp;
    private javax.swing.JLabel lblDesp;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblFuerza;
    private javax.swing.JLabel lblS;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTrabajo;
    private javax.swing.JLabel lblVel;
    private javax.swing.JLabel lblX10;
    private javax.swing.JLabel lblX11;
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
