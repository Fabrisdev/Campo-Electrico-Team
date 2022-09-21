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
public class PlacasConMov extends javax.swing.JPanel {

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

    /**
     * Creates new form PlacasConMov
     */
    public PlacasConMov() {
        initComponents();
        miInicializador();
    }
    
     private Icon iconoRedimensionado(String url, JLabel lbl) {
/* 177 */     ImageIcon imagen = new ImageIcon(getClass().getResource(url));
/* 178 */     Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), 1));
/* 179 */     return icono;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private double AGrados(double ang) {
/* 185 */     return Math.round(Math.toDegrees(ang));
/*     */   }
/*     */   
/*     */   private void eliminarAnimacion() {
/* 189 */     remove(0);
/* 190 */     repaint();
/*     */   }
/*     */   
/*     */   private void crearAnimacion(double vel) {
/* 194 */     this.animacion = new PanelAnimacion(this.puntoA, this.puntoB, this.valorCarga, vel);
/* 195 */     add(this.animacion);
/* 196 */     setComponentZOrder(this.animacion, 0);
/*     */   }
/*     */   
/*     */   private void miInicializador() {
/* 201 
/* 202 */     this.contador = 0;
   
/* 230 */     this.panelPuntos = new JPanel();
/* 231 */     this.panelPuntos.setBounds(55, 130, 720, 400);
/* 232 */     this.panelPuntos.setLayout((LayoutManager)null);
/* 233 */     this.panelPuntos.setOpaque(false);
/* 234 */     this.lblPuntoA = new JLabel();
/* 235 */     this.lblPuntoA.setSize(32, 32);
/* 236 */     this.panelPuntos.add(this.lblPuntoA);
/* 237 */     this.lblPuntoB = new JLabel();
/* 238 */     this.lblPuntoB.setSize(32, 32);
/* 239 */     this.panelPuntos.add(this.lblPuntoB);
/* 240 */     this.lblFondo.add(this.panelPuntos);
/*     */ 
/*     */     
/* 243 */     this.Panel1 = new PanelPlacas();
/* 244 */     this.lblFondo.add(this.Panel1);
/* 245 */     this.Panel1.addMouseListener(new MouseAdapter()
/*     */         {
/*     */           public void mouseClicked(MouseEvent e) {
/* 248 */             if (PlacasConMov.this.Panel1.getComponentAt(e.getPoint()).equals(PlacasConMov.this.Panel1)) {
/* 249 */               String st; switch (PlacasConMov.this.seleccionPunto) {
/*     */ 
/*     */                 
/*     */                 case 0:
/* 253 */                   PlacasConMov.this.eliminarAnimacion();
/* 254 */                   PlacasConMov.this.lblPuntoA.setIcon((Icon)null);
/* 255 */                   PlacasConMov.this.lblPuntoB.setIcon((Icon)null);
/* 256 */                   PlacasConMov.this.txtCarga.setEditable(true);
/* 257 */                   PlacasConMov.this.txtCargaExp.setEditable(true);
/* 258 */                   PlacasConMov.this.txtTiempo.setEditable(true);
/* 259 */                   PlacasConMov.this.txtTiempoExp.setEditable(true);
/* 260 */                   PlacasConMov.this.txtCampo.setText((String)null);
/* 261 */                   PlacasConMov.this.txtFuerza.setText((String)null);
/* 262 */                   PlacasConMov.this.txtTrabajo.setText((String)null);
/* 263 */                   PlacasConMov.this.txtDesp.setText((String)null);
/* 264 */                   PlacasConMov.this.txtVel.setText((String)null);
/* 265 */                   PlacasConMov.this.txtDdp.setText((String)null);
/* 266 */                   PlacasConMov.this.seleccionPunto = (byte)1;
/*     */                   break;
/*     */ 
/*     */ 
/*     */                 
/*     */                 case 1:
/*     */                   try {
/* 273 */                     PlacasConMov.this.valorCarga = Double.valueOf(PlacasConMov.this.txtCarga.getText()).doubleValue();
/* 274 */                     PlacasConMov.this.valorCarga = PlacasConMov.this.valorCarga * Math.pow(10.0D, Integer.valueOf(PlacasConMov.this.txtCargaExp.getText()).intValue());
/* 275 */                     PlacasConMov.this.tiempo = Math.abs(Double.valueOf(PlacasConMov.this.txtTiempo.getText()).doubleValue());
/* 276 */                     PlacasConMov.this.tiempo = PlacasConMov.this.tiempo * Math.pow(10.0D, Integer.valueOf(PlacasConMov.this.txtTiempoExp.getText()).intValue());
/* 277 */                     PlacasConMov.this.puntoA = e.getPoint();
/* 278 */                     PlacasConMov.this.lblPuntoB.setIcon((Icon)null);
/* 279 */                     int xPtoA = (int)PlacasConMov.this.puntoA.getX();
/* 280 */                     int yPtoA = (int)PlacasConMov.this.puntoA.getY();
/* 281 */                     ImageIcon imgA = new ImageIcon(PlacasSinMov.class.getResource("imgs/puntoA.png"));
/* 282 */                     PlacasConMov.this.lblPuntoA.setLocation(xPtoA - 16, yPtoA - 16);
/* 283 */                     PlacasConMov.this.lblPuntoA.setIcon(imgA);
/* 284 */                     PlacasConMov.this.txtCarga.setEditable(false);
/* 285 */                     PlacasConMov.this.txtCargaExp.setEditable(false);
/* 286 */                     PlacasConMov.this.txtTiempo.setEditable(false);
/* 287 */                     PlacasConMov.this.txtTiempoExp.setEditable(false);
/* 288 */                     PlacasConMov.this.seleccionPunto = (byte)2;
/*     */ 
/*     */                   
/*     */                   }
/* 292 */                   catch (Exception ex) {
/* 293 */                     String str = "Ingrese un valor para la carga y el tiempo";
/* 294 */                     JOptionPane.showMessageDialog(null, str);
/*     */                   } 
/*     */                   break;
/*     */                 
/*     */                 case 2:
/* 299 */                   PlacasConMov.this.puntoB = e.getPoint();
/*     */ 
/*     */                   
/* 302 */                   if (PlacasConMov.this.Panel1.placasEntrePuntos(PlacasConMov.this.puntoA, PlacasConMov.this.puntoB) == 0) {
/* 303 */                     boolean bandera = true;
/* 304 */                     boolean bandera2 = true;
/* 305 */                     Vector campo = new Vector(FrmPlaca.placas.sumarCampos(e.getX()), FrmPlaca.placas.anguloCampo(FrmPlaca.placas.sumarCampos(e.getX())));
/* 306 */                     Vector fuerza = new Vector(campo.getModulo() * PlacasConMov.this.valorCarga, FrmPlaca.placas.anguloFuerza(campo.getAngulo(), PlacasConMov.this.valorCarga));
/* 307 */                     Vector desplazamiento = new Vector(PlacasConMov.this.puntoA.distance(PlacasConMov.this.puntoB), -Placas.anguloDespl(PlacasConMov.this.puntoA, PlacasConMov.this.puntoB));
/* 308 */                     Vector velMedia = new Vector(desplazamiento.getModulo() / PlacasConMov.this.tiempo, desplazamiento.getAngulo());
/* 309 */                     double trabajo = fuerza.productoEscalar(desplazamiento);
/* 310 */                     double ddp = -campo.productoEscalar(desplazamiento);
/*     */                     
/* 312 */                     if (campo.getModulo() == 0.0D) {
/* 313 */                       bandera = false;
/* 314 */                       trabajo = 0.0D;
/* 315 */                       ddp = 0.0D;
/*     */                     } 
/*     */                     
/* 318 */                     if (PlacasConMov.this.valorCarga == 0.0D) {
/* 319 */                       bandera2 = false;
/*     */                     }
/*     */                     
/* 322 */                     if (Math.abs(desplazamiento.getAngulo()) == 1.5707963267948966D) {
/* 323 */                       trabajo = 0.0D;
/* 324 */                       ddp = 0.0D;
/*     */                     } 
/*     */                     
/* 327 */                     int xPtoB = (int)PlacasConMov.this.puntoB.getX();
/* 328 */                     int yPtoB = (int)PlacasConMov.this.puntoB.getY();
/* 329 */                     ImageIcon imgB = new ImageIcon(PlacasSinMov.class.getResource("imgs/puntoB.png"));
/* 330 */                     PlacasConMov.this.lblPuntoB.setLocation(xPtoB - 16, yPtoB - 16);
/* 331 */                     PlacasConMov.this.lblPuntoB.setIcon(imgB);
/*     */                     
/* 333 */                     PlacasConMov.this.crearAnimacion(velMedia.getModulo());
/*     */                     
/* 335 */                     String strCampo = String.format("%6.2e", new Object[] { Double.valueOf(campo.getModulo()) }) + "N/C   ";
/* 336 */                     String strFuerza = String.format("%6.2e", new Object[] { Double.valueOf(fuerza.getModulo()) }) + "N   ";
/* 337 */                     String strTrabajo = String.format("%6.2e", new Object[] { Double.valueOf(trabajo) }) + "J";
/* 338 */                     String strDesp = String.format("%6.2e", new Object[] { Double.valueOf(desplazamiento.getModulo()) }) + "m   " + PlacasConMov.this.AGrados(desplazamiento.getAngulo()) + "°";
/* 339 */                     String strVel = String.format("%6.2e", new Object[] { Double.valueOf(velMedia.getModulo()) }) + "m/s   " + PlacasConMov.this.AGrados(desplazamiento.getAngulo()) + "°";
/* 340 */                     String strDdp = String.format("%6.2e", new Object[] { Double.valueOf(ddp) }) + "V";
/*     */                     
/* 342 */                     if (bandera) {
/* 343 */                       strCampo = strCampo + PlacasConMov.this.AGrados(campo.getAngulo()) + "°";
/* 344 */                       if (bandera2) {
/* 345 */                         strFuerza = strFuerza + PlacasConMov.this.AGrados(fuerza.getAngulo()) + "°";
/*     */                       }
/*     */                     } 
/*     */                     
/* 349 */                     PlacasConMov.this.txtCampo.setText(strCampo);
/* 350 */                     PlacasConMov.this.txtFuerza.setText(strFuerza);
/* 351 */                     PlacasConMov.this.txtTrabajo.setText(strTrabajo);
/* 352 */                     PlacasConMov.this.txtVel.setText(strVel);
/* 353 */                     PlacasConMov.this.txtDesp.setText(strDesp);
/* 354 */                     PlacasConMov.this.txtDdp.setText(strDdp);
/* 355 */                     PlacasConMov.this.seleccionPunto = (byte)0;
/*     */ 
/*     */                     
/*     */                     break;
/*     */                   } 
/*     */                   
/* 361 */                   st = "Elija puntos dentro de la misma sección.";
/* 362 */                   JOptionPane.showMessageDialog(null, st);
/*     */                   break;
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        lblFondo = new javax.swing.JLabel();
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

        txtCampo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
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

        txtFuerza.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
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

        txtTrabajo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrabajoActionPerformed(evt);
            }
        });

        lblDesp.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblDesp.setForeground(new java.awt.Color(51, 51, 51));
        lblDesp.setText("Despl:");

        txtDesp.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtDesp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDespActionPerformed(evt);
            }
        });

        lblDdp.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblDdp.setForeground(new java.awt.Color(51, 51, 51));
        lblDdp.setText("d.d.p:");

        txtDdp.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtDdp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDdpActionPerformed(evt);
            }
        });

        lblVel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblVel.setForeground(new java.awt.Color(51, 51, 51));
        lblVel.setText("Vel. Med:");

        txtVel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtVel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTiempo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblX11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTiempoExp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblS, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblX10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCargaExp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblC, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFuerza, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDesp, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDdp, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFuerza, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDesp, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDdp, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblVel)
                                .addGap(18, 18, 18)
                                .addComponent(txtVel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(738, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblX10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCargaExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblX11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTiempoExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addComponent(lblCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFuerza, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDesp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFuerza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDesp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDdp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(128, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
