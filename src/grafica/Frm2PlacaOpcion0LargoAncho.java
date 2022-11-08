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
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

/**
 *
 * @author Fabri
 */
public class Frm2PlacaOpcion0LargoAncho extends javax.swing.JFrame {

    /**
     * Creates new form FrmOpcionesCargas
     */
     private boolean menuAbierto;
    private boolean menuMoviendose;
    
    public Frm2PlacaOpcion0LargoAncho() {
        initComponents();
        flechaIzq.setVisible(false);
        flechaDer.setVisible(false);
        setTitle("PR: Dos placas | Equipo Dinamita");
        URL icono = getClass().getResource("/grafica/img/Logo_Proyecto.png");
        ImageIcon imagenIcono = new ImageIcon(icono);
        this.setIconImage( imagenIcono.getImage());
        this.setResizable(false);
        setLocationRelativeTo(null);
        txtCargaQ1.setBackground(new Color(0,0,0,0));
        txtLargoQ1.setBackground(new Color(0,0,0,0));
        txtExponenteQ1.setBackground(new Color(0,0,0,0));
        txtCargaQ2.setBackground(new Color(0,0,0,0));
        txtAnchoQ1.setBackground(new Color(0,0,0,0));
        txtExponenteQ2.setBackground(new Color(0,0,0,0));
        txtAnchoQ2.setBackground(new Color(0,0,0,0));
        txtLargoQ2.setBackground(new Color(0,0,0,0));
        positivoQ1.setVisible(false);
        positivoQ2.setVisible(false);
        negativoQ1.setVisible(false);
        negativoQ2.setVisible(false);
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
            txtLargoQ1.setFont(pristinaFont);
            txtExponenteQ1.setFont(pristinaFont);
            txtCargaQ2.setFont(pristinaFont);
            txtExponenteQ2.setFont(pristinaFont);
            txtAnchoQ1.setFont(pristinaFont);
            txtAnchoQ2.setFont(pristinaFont);
            txtLargoQ2.setFont(pristinaFont);
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

        lbtnAbrirMenu = new logica.JLabelRotar();
        jPanelMenu = new javax.swing.JPanel();
        lbtnVolverAtras = new javax.swing.JLabel();
        lbtnIrCargas = new javax.swing.JLabel();
        lbtnIrCreditos = new javax.swing.JLabel();
        lbtnSalir = new javax.swing.JLabel();
        lbtnIrLinea = new javax.swing.JLabel();
        lblMenuFondo = new javax.swing.JLabel();
        txtCargaQ2 = new javax.swing.JTextField();
        txtCargaQ1 = new javax.swing.JTextField();
        txtLargoQ2 = new javax.swing.JTextField();
        txtAnchoQ2 = new javax.swing.JTextField();
        txtAnchoQ1 = new javax.swing.JTextField();
        txtLargoQ1 = new javax.swing.JTextField();
        txtExponenteQ2 = new javax.swing.JTextField();
        txtExponenteQ1 = new javax.swing.JTextField();
        lblCampo = new javax.swing.JLabel();
        flechaIzq = new javax.swing.JLabel();
        flechaDer = new javax.swing.JLabel();
        negativoQ2 = new javax.swing.JLabel();
        positivoQ2 = new javax.swing.JLabel();
        negativoQ1 = new javax.swing.JLabel();
        positivoQ1 = new javax.swing.JLabel();
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

        txtCargaQ2.setBorder(null);
        txtCargaQ2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargaQ2ActionPerformed(evt);
            }
        });
        txtCargaQ2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCargaQ2KeyReleased(evt);
            }
        });
        getContentPane().add(txtCargaQ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 130, 40));

        txtCargaQ1.setBorder(null);
        txtCargaQ1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCargaQ1KeyReleased(evt);
            }
        });
        getContentPane().add(txtCargaQ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 42, 130, 40));

        txtLargoQ2.setBorder(null);
        txtLargoQ2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLargoQ2KeyReleased(evt);
            }
        });
        getContentPane().add(txtLargoQ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, 100, 40));

        txtAnchoQ2.setBorder(null);
        txtAnchoQ2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAnchoQ2KeyReleased(evt);
            }
        });
        getContentPane().add(txtAnchoQ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 300, 100, 40));

        txtAnchoQ1.setBorder(null);
        txtAnchoQ1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAnchoQ1KeyReleased(evt);
            }
        });
        getContentPane().add(txtAnchoQ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 200, 100, 40));

        txtLargoQ1.setBorder(null);
        txtLargoQ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLargoQ1ActionPerformed(evt);
            }
        });
        txtLargoQ1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLargoQ1KeyReleased(evt);
            }
        });
        getContentPane().add(txtLargoQ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, 100, 40));

        txtExponenteQ2.setBorder(null);
        txtExponenteQ2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtExponenteQ2KeyReleased(evt);
            }
        });
        getContentPane().add(txtExponenteQ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 40, 40));

        txtExponenteQ1.setBorder(null);
        txtExponenteQ1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtExponenteQ1KeyReleased(evt);
            }
        });
        getContentPane().add(txtExponenteQ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 12, 40, 40));
        getContentPane().add(lblCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 190, 50));

        flechaIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/FlechaIzq.png"))); // NOI18N
        getContentPane().add(flechaIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, -1));

        flechaDer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/FlechaDer.png"))); // NOI18N
        getContentPane().add(flechaDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, -1, -1));

        negativoQ2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/PlacaNegativo.png"))); // NOI18N
        getContentPane().add(negativoQ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 150, 180));

        positivoQ2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/PlacaPositivo.png"))); // NOI18N
        getContentPane().add(positivoQ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 150, 180));

        negativoQ1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/PlacaNegativo.png"))); // NOI18N
        getContentPane().add(negativoQ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 150, 180));

        positivoQ1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/PlacaPositivo.png"))); // NOI18N
        getContentPane().add(positivoQ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 150, 180));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/2PlacasSeleccion1LargoAncho.png"))); // NOI18N
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

    boolean esNumero(String text){
        try{
            Double.valueOf(text);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
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
    
    void actualizarCampo(){
        double e0 = 8.8e-12;
        if(esNumero(txtCargaQ1.getText()) && esNumero(txtExponenteQ1.getText()) && esNumero(txtLargoQ1.getText()) && esNumero(txtAnchoQ1.getText())){
            double cargaQ1 = Double.parseDouble(txtCargaQ1.getText());
            double exponenteQ1 = Double.parseDouble(txtExponenteQ1.getText());
            double cargaCompletaQ1 = cargaQ1 * Math.pow(10, exponenteQ1);
            double largoQ1 = Double.parseDouble(txtLargoQ1.getText());
            double anchoQ1 = Double.parseDouble(txtAnchoQ1.getText());
            double areaQ1 = largoQ1 * anchoQ1;
            double sigmaQ1 = cargaCompletaQ1 / areaQ1;
            double campoQ1 = Math.abs(sigmaQ1 / (2 * e0));
            if(esNumero(txtCargaQ2.getText()) && esNumero(txtExponenteQ2.getText()) && esNumero(txtAnchoQ2.getText()) && esNumero(txtLargoQ2.getText())){
                double cargaQ2 = Double.parseDouble(txtCargaQ2.getText());
                double exponenteQ2 = Double.parseDouble(txtExponenteQ2.getText());
                double cargaCompletaQ2 = cargaQ2 * Math.pow(10, exponenteQ2);
                double anchoQ2 = Double.parseDouble(txtAnchoQ2.getText());
                double largoQ2 = Double.parseDouble(txtLargoQ2.getText());
                double areaQ2 = anchoQ2 * largoQ2;
                double sigmaQ2 = cargaCompletaQ2 / areaQ2;
                double campoQ2 = Math.abs(sigmaQ2 / (2 * e0));
                    if(esPositivo(areaQ1) && esPositivo(areaQ2)){
                        double campoResultante;
                        if(cargaCompletaQ1 == 0 || cargaCompletaQ2 == 0){
                            lblCampo.setText(null);
                            return;
                        }
                        if(cargaCompletaQ1 > 0 && cargaCompletaQ2 > 0){
                            campoResultante = campoQ1 - campoQ2;
                            if(campoQ1 > campoQ2){
                                flechaDer.setVisible(true);
                                flechaIzq.setVisible(false);
                            }else{
                                flechaIzq.setVisible(true);
                                flechaDer.setVisible(false);
                            }
                        }
                        else if(cargaCompletaQ1 > 0 && cargaCompletaQ2 < 0){
                            campoResultante = campoQ1 + campoQ2;
                            flechaDer.setVisible(true);
                            flechaIzq.setVisible(false);
                        }
                        else if(cargaCompletaQ1 < 0 && cargaCompletaQ2 > 0){
                            campoResultante = campoQ1 + campoQ2;
                            flechaIzq.setVisible(true);
                            flechaDer.setVisible(false);
                        }
                        else{
                            campoResultante = campoQ1 - campoQ2;
                            if(campoQ1 > campoQ2){
                                flechaIzq.setVisible(true);
                                flechaDer.setVisible(false);
                            }else{
                                flechaIzq.setVisible(false);
                                flechaDer.setVisible(true);
                            }
                        }
                        if(campoResultante == 0){
                            flechaIzq.setVisible(false);
                            flechaDer.setVisible(false);
                        }
                        campoResultante = Math.abs(campoResultante);
                                DecimalFormat f = new DecimalFormat("0.##E0");
                                String campoFormatoCientifico = f.format(campoResultante);
                                String campoFormateado = campoFormatoCientifico.replace("E", "x10^");
                                lblCampo.setText(campoFormateado);
                }
            }
        }
            if(esNumero(txtCargaQ1.getText()) && !esNumero(txtCargaQ2.getText())){
                double cargaQ1 = Double.parseDouble(txtCargaQ1.getText());
                if(cargaQ1 > 0 && txtCargaQ2.getText().equals("")){
                    positivoQ1.setVisible(true);
                    negativoQ1.setVisible(false);
                    positivoQ2.setVisible(false);
                    negativoQ2.setVisible(false);
                }
                if(cargaQ1 < 0 && txtCargaQ2.getText().equals("")){
                    positivoQ1.setVisible(false);
                    negativoQ1.setVisible(true);
                    positivoQ2.setVisible(false);
                    negativoQ2.setVisible(false);
                }      
            }
            if(esNumero(txtCargaQ2.getText()) && !esNumero(txtCargaQ1.getText())){
                double cargaQ2 = Double.parseDouble(txtCargaQ2.getText());
                if(cargaQ2 > 0 && txtCargaQ1.getText().equals("")){
                    positivoQ1.setVisible(false);
                    negativoQ1.setVisible(false);
                    positivoQ2.setVisible(true);
                    negativoQ2.setVisible(false);
                }
                if(cargaQ2 < 0 && txtCargaQ1.getText().equals("")){
                    positivoQ1.setVisible(false);
                    negativoQ1.setVisible(false);
                    positivoQ2.setVisible(false);
                    negativoQ2.setVisible(true);
                }
            }
            if(esNumero(txtCargaQ1.getText()) && esNumero(txtCargaQ2.getText())){
                double cargaQ1 = Double.parseDouble(txtCargaQ1.getText());
                double cargaQ2 = Double.parseDouble(txtCargaQ2.getText());
                if(cargaQ1 > 0 && cargaQ2 > 0){
                    positivoQ1.setVisible(true);
                    negativoQ1.setVisible(false);
                    positivoQ2.setVisible(true);
                    negativoQ2.setVisible(false);
                }
                if(cargaQ1 < 0 && cargaQ2 < 0){
                    positivoQ1.setVisible(false);
                    negativoQ1.setVisible(true);
                    positivoQ2.setVisible(false);
                    negativoQ2.setVisible(true);
                }
                if(cargaQ1 > 0 && cargaQ2 < 0){
                    positivoQ1.setVisible(true);
                    negativoQ1.setVisible(false);
                    positivoQ2.setVisible(false);
                    negativoQ2.setVisible(true);
                }
                if(cargaQ1 < 0 && cargaQ2 > 0){
                    positivoQ1.setVisible(false);
                    negativoQ1.setVisible(true);
                    positivoQ2.setVisible(true);
                    negativoQ2.setVisible(false);
                }
            }
    }
    
    void revisarExponente(JTextField jText){
        if(jText.getText().equals("")){
            jText.setBackground(new Color(0,0,0,0));
            lblCampo.setText(null);
            return;
        }
        if(esNumero(jText.getText())){
            double exponente = Double.parseDouble(jText.getText());
            if(exponente >= -12 && exponente <= 12){
                actualizarCampo();
                jText.setBackground(new Color(0,0,0,0));
                return;
            }
        }
        jText.setBackground(new Color(100,0,0,100));
        lblCampo.setText(null);
    }
    
    void revisarTexto(JTextField jText){
        if(!txtCargaQ1.getText().equals("") || !txtCargaQ2.getText().equals("")){
            if(esNumero(jText.getText())){
                double carga = Double.parseDouble(jText.getText());
                if(carga != 0){
                    actualizarCampo();
                    jText.setBackground(new Color(0,0,0,0));
                }else{
                    lblCampo.setText(null);
                    jText.setBackground(new Color(100,0,0,100));
                }
                return;
            }
            if(jText.getText().equals("")){
                lblCampo.setText(null);
                if(!esNumero(txtCargaQ1.getText()) && esNumero(txtCargaQ2.getText())){
                    double cargaQ2 = Double.parseDouble(txtCargaQ2.getText());
                    if(cargaQ2 > 0){
                        positivoQ1.setVisible(false);
                        negativoQ1.setVisible(false);
                        positivoQ2.setVisible(true);
                        negativoQ2.setVisible(false);
                    }else{
                        positivoQ1.setVisible(false);
                        negativoQ1.setVisible(false);
                        positivoQ2.setVisible(false);
                        negativoQ2.setVisible(true);
                    }
                }
                if(esNumero(txtCargaQ1.getText()) && !esNumero(txtCargaQ2.getText())){
                    double cargaQ1 = Double.parseDouble(txtCargaQ1.getText());
                    if(cargaQ1 > 0){
                        positivoQ1.setVisible(true);
                        negativoQ1.setVisible(false);
                        positivoQ2.setVisible(false);
                        negativoQ2.setVisible(false);
                    }else{
                        positivoQ1.setVisible(false);
                        negativoQ1.setVisible(true);
                        positivoQ2.setVisible(false);
                        negativoQ2.setVisible(false);
                    }
                }
                jText.setBackground(new Color(0,0,0,0));
                return;
            }
            jText.setBackground(new Color(100,0,0,100));
            lblCampo.setText(null);
            return;
        }
        positivoQ1.setVisible(false);
        negativoQ1.setVisible(false);
        positivoQ2.setVisible(false);
        negativoQ2.setVisible(false);
    }
    
    boolean esPositivo(double numero){
        return numero > 0;
    }
    
    void revisarTextoPositivo(JTextField jText){
        if(esNumero(jText.getText())){
            double valor = Double.parseDouble(jText.getText());
            if(esPositivo(valor)){
                actualizarCampo();
                jText.setBackground(new Color(0,0,0,0));
                return;
            }
        }
        if(jText.getText().equals("")){
            lblCampo.setText(null);
            jText.setBackground(new Color(0,0,0,0));
            return;
        }
        jText.setBackground(new Color(100,0,0,100));
        lblCampo.setText(null);
    }
    
    private void txtCargaQ1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargaQ1KeyReleased
        revisarTexto(txtCargaQ1);
    }//GEN-LAST:event_txtCargaQ1KeyReleased

    private void txtLargoQ1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLargoQ1KeyReleased
        revisarTextoPositivo(txtLargoQ1);
    }//GEN-LAST:event_txtLargoQ1KeyReleased

    private void txtExponenteQ1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExponenteQ1KeyReleased
        revisarExponente(txtExponenteQ1);
    }//GEN-LAST:event_txtExponenteQ1KeyReleased

    private void txtCargaQ2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargaQ2KeyReleased
        revisarTexto(txtCargaQ2);
    }//GEN-LAST:event_txtCargaQ2KeyReleased

    private void txtAnchoQ1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnchoQ1KeyReleased
        revisarTextoPositivo(txtAnchoQ1);
    }//GEN-LAST:event_txtAnchoQ1KeyReleased

    private void txtExponenteQ2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExponenteQ2KeyReleased
        revisarExponente(txtExponenteQ2);
    }//GEN-LAST:event_txtExponenteQ2KeyReleased

    private void txtLargoQ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLargoQ1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLargoQ1ActionPerformed

    private void txtCargaQ2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargaQ2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargaQ2ActionPerformed

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

    private void txtLargoQ2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLargoQ2KeyReleased
        revisarTextoPositivo(txtLargoQ2);
    }//GEN-LAST:event_txtLargoQ2KeyReleased

    private void txtAnchoQ2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnchoQ2KeyReleased
        revisarTextoPositivo(txtAnchoQ2);
    }//GEN-LAST:event_txtAnchoQ2KeyReleased

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
            java.util.logging.Logger.getLogger(Frm2PlacaOpcion0LargoAncho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm2PlacaOpcion0LargoAncho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm2PlacaOpcion0LargoAncho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm2PlacaOpcion0LargoAncho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Frm2PlacaOpcion0LargoAncho().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel flechaDer;
    private javax.swing.JLabel flechaIzq;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelPantallaNegra;
    private javax.swing.JLabel lblCampo;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblMenuFondo;
    private logica.JLabelRotar lbtnAbrirMenu;
    private javax.swing.JLabel lbtnIrCargas;
    private javax.swing.JLabel lbtnIrCreditos;
    private javax.swing.JLabel lbtnIrLinea;
    private javax.swing.JLabel lbtnSalir;
    private javax.swing.JLabel lbtnVolverAtras;
    private javax.swing.JLabel negativoQ1;
    private javax.swing.JLabel negativoQ2;
    private javax.swing.JLabel positivoQ1;
    private javax.swing.JLabel positivoQ2;
    private javax.swing.JTextField txtAnchoQ1;
    private javax.swing.JTextField txtAnchoQ2;
    private javax.swing.JTextField txtCargaQ1;
    private javax.swing.JTextField txtCargaQ2;
    private javax.swing.JTextField txtExponenteQ1;
    private javax.swing.JTextField txtExponenteQ2;
    private javax.swing.JTextField txtLargoQ1;
    private javax.swing.JTextField txtLargoQ2;
    // End of variables declaration//GEN-END:variables
}
