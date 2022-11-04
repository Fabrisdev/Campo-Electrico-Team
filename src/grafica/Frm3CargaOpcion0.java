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
public class Frm3CargaOpcion0 extends javax.swing.JFrame {

    /**
     * Creates new form FrmOpcionesCargas
     */
      private boolean menuAbierto;
    private boolean menuMoviendose;
    
    public Frm3CargaOpcion0() {
        initComponents();
        setTitle("PR: Tres cargas | Equipo Dinamita");
        URL icono = getClass().getResource("/grafica/img/Logo_Proyecto.png");
        ImageIcon imagenIcono = new ImageIcon(icono);
        this.setIconImage( imagenIcono.getImage());
        this.setResizable(false);
        setLocationRelativeTo(null);
        txtCargaQ1.setBackground(new Color(0,0,0,0));
        txtDistanciaQ1.setBackground(new Color(0,0,0,0));
        txtExponenteQ1.setBackground(new Color(0,0,0,0));
        txtCargaQ2.setBackground(new Color(0,0,0,0));
        txtDistanciaQ2.setBackground(new Color(0,0,0,0));
        txtExponenteQ2.setBackground(new Color(0,0,0,0));
        txtCargaQ3.setBackground(new Color(0,0,0,0));
        txtDistanciaQ3.setBackground(new Color(0,0,0,0));
        txtExponenteQ3.setBackground(new Color(0,0,0,0));
        positivaQ1.setVisible(false);
        negativaQ1.setVisible(false);
        positivaQ2.setVisible(false);
        negativaQ2.setVisible(false);
        positivaQ3.setVisible(false);
        negativaQ3.setVisible(false);
        flechaIzq.setVisible(false);
        flechaDer.setVisible(false);
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
            txtDistanciaQ1.setFont(pristinaFont);
            txtExponenteQ1.setFont(pristinaFont);
            txtCargaQ2.setFont(pristinaFont);
            txtExponenteQ2.setFont(pristinaFont);
            txtDistanciaQ2.setFont(pristinaFont);
            txtCargaQ3.setFont(pristinaFont);
            txtDistanciaQ3.setFont(pristinaFont);
            txtExponenteQ3.setFont(pristinaFont);
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
        lbtnIrPlacas = new javax.swing.JLabel();
        lbtnIrCreditos = new javax.swing.JLabel();
        lbtnSalir = new javax.swing.JLabel();
        lblIrLinea = new javax.swing.JLabel();
        lblMenuFondo = new javax.swing.JLabel();
        txtCargaQ2 = new javax.swing.JTextField();
        txtCargaQ3 = new javax.swing.JTextField();
        txtCargaQ1 = new javax.swing.JTextField();
        txtDistanciaQ3 = new javax.swing.JTextField();
        txtDistanciaQ2 = new javax.swing.JTextField();
        txtDistanciaQ1 = new javax.swing.JTextField();
        txtExponenteQ3 = new javax.swing.JTextField();
        txtExponenteQ2 = new javax.swing.JTextField();
        txtExponenteQ1 = new javax.swing.JTextField();
        lblCampo = new javax.swing.JLabel();
        positivaQ1 = new javax.swing.JLabel();
        negativaQ1 = new javax.swing.JLabel();
        positivaQ2 = new javax.swing.JLabel();
        negativaQ2 = new javax.swing.JLabel();
        positivaQ3 = new javax.swing.JLabel();
        negativaQ3 = new javax.swing.JLabel();
        flechaIzq = new javax.swing.JLabel();
        flechaDer = new javax.swing.JLabel();
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

        lblIrLinea.setText("jLabel1");
        lblIrLinea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIrLineaMouseClicked(evt);
            }
        });
        jPanelMenu.add(lblIrLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 400, 50));

        lblMenuFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/menuDeslizableCarga.png"))); // NOI18N
        jPanelMenu.add(lblMenuFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 560));

        getContentPane().add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -560, 408, 560));

        txtCargaQ2.setBorder(null);
        txtCargaQ2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCargaQ2KeyReleased(evt);
            }
        });
        getContentPane().add(txtCargaQ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 130, 40));

        txtCargaQ3.setBorder(null);
        txtCargaQ3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCargaQ3KeyReleased(evt);
            }
        });
        getContentPane().add(txtCargaQ3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 130, 40));

        txtCargaQ1.setBorder(null);
        txtCargaQ1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCargaQ1KeyReleased(evt);
            }
        });
        getContentPane().add(txtCargaQ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 42, 130, 40));

        txtDistanciaQ3.setBorder(null);
        txtDistanciaQ3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDistanciaQ3KeyReleased(evt);
            }
        });
        getContentPane().add(txtDistanciaQ3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 310, 150, 40));

        txtDistanciaQ2.setBorder(null);
        txtDistanciaQ2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDistanciaQ2KeyReleased(evt);
            }
        });
        getContentPane().add(txtDistanciaQ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 260, 150, 40));

        txtDistanciaQ1.setBorder(null);
        txtDistanciaQ1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDistanciaQ1KeyReleased(evt);
            }
        });
        getContentPane().add(txtDistanciaQ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 200, 150, 40));

        txtExponenteQ3.setBorder(null);
        txtExponenteQ3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtExponenteQ3KeyReleased(evt);
            }
        });
        getContentPane().add(txtExponenteQ3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, 40, 40));

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
        getContentPane().add(lblCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 170, 50));

        positivaQ1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/Positiva.png"))); // NOI18N
        getContentPane().add(positivaQ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 237, -1, -1));

        negativaQ1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/Negativa.png"))); // NOI18N
        getContentPane().add(negativaQ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 237, -1, -1));

        positivaQ2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/Positiva.png"))); // NOI18N
        getContentPane().add(positivaQ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 237, -1, -1));

        negativaQ2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/Negativa.png"))); // NOI18N
        getContentPane().add(negativaQ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 237, -1, -1));

        positivaQ3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/Positiva.png"))); // NOI18N
        getContentPane().add(positivaQ3, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 237, -1, -1));

        negativaQ3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/Negativa.png"))); // NOI18N
        getContentPane().add(negativaQ3, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 237, -1, -1));

        flechaIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/FlechaIzq.png"))); // NOI18N
        getContentPane().add(flechaIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));

        flechaDer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/FlechaDer.png"))); // NOI18N
        getContentPane().add(flechaDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica/img/3Opcion1Seleccion.png"))); // NOI18N
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
    
    void actualizarCampo(){
        double k = 9e9;
        if(esNumero(txtCargaQ1.getText()) && esNumero(txtExponenteQ1.getText()) && esNumero(txtDistanciaQ1.getText())){
            double cargaQ1 = Double.parseDouble(txtCargaQ1.getText());
            double exponenteQ1 = Double.parseDouble(txtExponenteQ1.getText());
            double cargaCompletaQ1 = cargaQ1 * Math.pow(10, exponenteQ1);
            double distanciaQ1 = Double.parseDouble(txtDistanciaQ1.getText());
            double campoQ1 = (k * Math.abs(cargaCompletaQ1)) / Math.pow(distanciaQ1, 2);
            if(esNumero(txtCargaQ2.getText()) && esNumero(txtExponenteQ2.getText()) && esNumero(txtDistanciaQ2.getText())){
                double cargaQ2 = Double.parseDouble(txtCargaQ2.getText());
                double exponenteQ2 = Double.parseDouble(txtExponenteQ2.getText());
                double cargaCompletaQ2 = cargaQ2 * Math.pow(10, exponenteQ2);
                double distanciaQ2 = Double.parseDouble(txtDistanciaQ2.getText());
                double campoQ2 = (k * Math.abs(cargaCompletaQ2)) / Math.pow(distanciaQ2, 2);
                if(esNumero(txtCargaQ3.getText()) && esNumero(txtExponenteQ3.getText()) && esNumero(txtDistanciaQ3.getText())){
                    double distanciaIncompletaQ3 = Double.parseDouble(txtDistanciaQ3.getText());
                    double distanciaQ3 = distanciaQ2 + distanciaIncompletaQ3;
                    if(esPositivo(distanciaQ1) && esPositivo(distanciaQ2) && esPositivo(distanciaQ3)){
                        double cargaQ3 = Double.parseDouble(txtCargaQ3.getText());
                        double exponenteQ3 = Double.parseDouble(txtExponenteQ3.getText());
                        double cargaCompletaQ3 = cargaQ3 * Math.pow(10, exponenteQ3);
                        double campoQ3 = (k * Math.abs(cargaCompletaQ3)) / Math.pow(distanciaQ3, 2);
                        double campoResultante;
                        if(cargaCompletaQ1 > 0 && cargaCompletaQ2 > 0 && cargaCompletaQ3 > 0){
                            campoResultante = (campoQ2 + campoQ3) - campoQ1;
                            if((campoQ2 + campoQ3) > campoQ1){
                                flechaIzq.setVisible(true);
                                flechaDer.setVisible(false);
                            }else if((campoQ2 + campoQ3) < campoQ1){
                                flechaIzq.setVisible(false);
                                flechaDer.setVisible(true);
                            }else{
                                flechaIzq.setVisible(false);
                                flechaDer.setVisible(false);
                            }
                        }
                        else if(cargaCompletaQ1 < 0 && cargaCompletaQ2 > 0 && cargaCompletaQ3 > 0){
                            campoResultante = campoQ1 + campoQ2 + campoQ3;
                            flechaIzq.setVisible(true);
                            flechaDer.setVisible(false);
                        }
                        else if(cargaCompletaQ1 > 0 && cargaCompletaQ2 < 0 && cargaCompletaQ3 > 0){
                            campoResultante = (campoQ1 + campoQ2) - campoQ3;
                            if((campoQ1 + campoQ2) > campoQ3){
                                flechaDer.setVisible(true);
                                flechaIzq.setVisible(false);
                            }else if((campoQ1 + campoQ2) < campoQ3){
                                flechaDer.setVisible(false);
                                flechaIzq.setVisible(true);
                            }else{
                                flechaIzq.setVisible(false);
                                flechaDer.setVisible(false);
                            }
                        }
                        else if(cargaCompletaQ1 > 0 && cargaCompletaQ2 > 0 && cargaCompletaQ3 < 0){
                            campoResultante = (campoQ1 + campoQ3) - campoQ2;
                            if((campoQ1 + campoQ3) > campoQ2){
                                flechaDer.setVisible(true);
                                flechaIzq.setVisible(false);
                            }else if((campoQ1 + campoQ3) < campoQ2){
                                flechaDer.setVisible(false);
                                flechaIzq.setVisible(true);
                            }else{
                                flechaIzq.setVisible(false);
                                flechaDer.setVisible(false);
                            }
                        }
                        else if(cargaCompletaQ1 > 0 && cargaCompletaQ2 < 0 && cargaCompletaQ3 < 0){
                            campoResultante = campoQ1 + campoQ2 + campoQ3;
                            flechaDer.setVisible(true);
                            flechaIzq.setVisible(false);
                        }
                        else if(cargaCompletaQ1 < 0 && cargaCompletaQ2 > 0 && cargaCompletaQ3 < 0){
                            campoResultante = (campoQ1 + campoQ2) - campoQ3;
                            if((campoQ1 + campoQ2) > campoQ3){
                                flechaDer.setVisible(false);
                                flechaIzq.setVisible(true);
                            }else if((campoQ1 + campoQ2) < campoQ3){
                                flechaDer.setVisible(true);
                                flechaIzq.setVisible(false);
                            }else{
                                flechaIzq.setVisible(false);
                                flechaDer.setVisible(false);
                            }
                        }
                        else if(cargaCompletaQ1 < 0 && cargaCompletaQ2 < 0 && cargaCompletaQ3 > 0){
                            campoResultante = (campoQ1 + campoQ3) - campoQ2;
                            if((campoQ1 + campoQ3) > campoQ2){
                                flechaDer.setVisible(false);
                                flechaIzq.setVisible(true);
                            }else if((campoQ1 + campoQ3) < campoQ2){
                                flechaDer.setVisible(true);
                                flechaIzq.setVisible(false);
                            }else{
                                flechaIzq.setVisible(false);
                                flechaDer.setVisible(false);
                            }
                        }
                        else{
                            campoResultante = (campoQ2 + campoQ3) - campoQ1;
                            if((campoQ2 + campoQ3) > campoQ1){
                                flechaDer.setVisible(true);
                                flechaIzq.setVisible(false);
                            }else if((campoQ2 + campoQ3) < campoQ1){
                                flechaDer.setVisible(false);
                                flechaIzq.setVisible(true);
                            }else{
                                flechaIzq.setVisible(false);
                                flechaDer.setVisible(false);
                            }
                        }
                        DecimalFormat f = new DecimalFormat("0.##E0");
                        lblCampo.setText(f.format(campoResultante));
                    }
                }
            }
            /*
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
            */
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
        if(esNumero(jText.getText())){
            actualizarCampo();
            jText.setBackground(new Color(0,0,0,0));
            return;
        }
        if(jText.getText().equals("")){
            lblCampo.setText(null);
            jText.setBackground(new Color(0,0,0,0));
            return;
        }
        jText.setBackground(new Color(100,0,0,100));
        lblCampo.setText(null);
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
        if(esNumero(txtCargaQ1.getText())){
            double carga = Double.parseDouble(txtCargaQ1.getText());
            if(carga > 0){
                positivaQ1.setVisible(true);
                negativaQ1.setVisible(false);
            }else if(carga < 0){
                negativaQ1.setVisible(true);
                positivaQ1.setVisible(false);
            }else{
                positivaQ1.setVisible(false);
                negativaQ1.setVisible(false);
            }
        }else{
            positivaQ1.setVisible(false);
            negativaQ1.setVisible(false);
        }
    }//GEN-LAST:event_txtCargaQ1KeyReleased

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
    
    private void txtDistanciaQ1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDistanciaQ1KeyReleased
        revisarTextoPositivo(txtDistanciaQ1);
        
    }//GEN-LAST:event_txtDistanciaQ1KeyReleased

    private void txtExponenteQ1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExponenteQ1KeyReleased
        revisarExponente(txtExponenteQ1);
    }//GEN-LAST:event_txtExponenteQ1KeyReleased

    private void txtCargaQ3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargaQ3KeyReleased
        revisarTexto(txtCargaQ3);
        if(esNumero(txtCargaQ3.getText())){
            double carga = Double.parseDouble(txtCargaQ3.getText());
            if(carga > 0){
                positivaQ3.setVisible(true);
                negativaQ3.setVisible(false);
            }else if(carga < 0){
                negativaQ3.setVisible(true);
                positivaQ3.setVisible(false);
            }else{
                positivaQ3.setVisible(false);
                negativaQ3.setVisible(false);
            }
        }else{
            positivaQ3.setVisible(false);
            negativaQ3.setVisible(false);
        }
    }//GEN-LAST:event_txtCargaQ3KeyReleased

    private void txtCargaQ2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargaQ2KeyReleased
        revisarTexto(txtCargaQ2);
        if(esNumero(txtCargaQ2.getText())){
            double carga = Double.parseDouble(txtCargaQ2.getText());
            if(carga > 0){
                positivaQ2.setVisible(true);
                negativaQ2.setVisible(false);
            }else if(carga < 0){
                negativaQ2.setVisible(true);
                positivaQ2.setVisible(false);
            }else{
                positivaQ2.setVisible(false);
                negativaQ2.setVisible(false);
            }
        }else{
            positivaQ2.setVisible(false);
            negativaQ2.setVisible(false);
        }
    }//GEN-LAST:event_txtCargaQ2KeyReleased

    private void txtDistanciaQ2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDistanciaQ2KeyReleased
        revisarTextoPositivo(txtDistanciaQ2);
    }//GEN-LAST:event_txtDistanciaQ2KeyReleased

    private void txtDistanciaQ3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDistanciaQ3KeyReleased
        revisarTextoPositivo(txtDistanciaQ3);
    }//GEN-LAST:event_txtDistanciaQ3KeyReleased

    private void txtExponenteQ2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExponenteQ2KeyReleased
        revisarExponente(txtExponenteQ2);
    }//GEN-LAST:event_txtExponenteQ2KeyReleased

    private void txtExponenteQ3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExponenteQ3KeyReleased
       revisarExponente(txtExponenteQ3);
    }//GEN-LAST:event_txtExponenteQ3KeyReleased

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

    private void lbtnIrPlacasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbtnIrPlacasMouseClicked
        setVisible(false);
        new FrmOpcionesPlacas().setVisible(true);
    }//GEN-LAST:event_lbtnIrPlacasMouseClicked

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

    private void lblIrLineaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIrLineaMouseClicked
        setVisible(false);
        new FrmOpcionesLineas().setVisible(true);
    }//GEN-LAST:event_lblIrLineaMouseClicked

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
            java.util.logging.Logger.getLogger(Frm3CargaOpcion0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm3CargaOpcion0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm3CargaOpcion0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm3CargaOpcion0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm3CargaOpcion0().setVisible(true);
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
    private javax.swing.JLabel lblIrLinea;
    private javax.swing.JLabel lblMenuFondo;
    private logica.JLabelRotar lbtnAbrirMenu;
    private javax.swing.JLabel lbtnIrCreditos;
    private javax.swing.JLabel lbtnIrPlacas;
    private javax.swing.JLabel lbtnSalir;
    private javax.swing.JLabel lbtnVolverAtras;
    private javax.swing.JLabel negativaQ1;
    private javax.swing.JLabel negativaQ2;
    private javax.swing.JLabel negativaQ3;
    private javax.swing.JLabel positivaQ1;
    private javax.swing.JLabel positivaQ2;
    private javax.swing.JLabel positivaQ3;
    private javax.swing.JTextField txtCargaQ1;
    private javax.swing.JTextField txtCargaQ2;
    private javax.swing.JTextField txtCargaQ3;
    private javax.swing.JTextField txtDistanciaQ1;
    private javax.swing.JTextField txtDistanciaQ2;
    private javax.swing.JTextField txtDistanciaQ3;
    private javax.swing.JTextField txtExponenteQ1;
    private javax.swing.JTextField txtExponenteQ2;
    private javax.swing.JTextField txtExponenteQ3;
    // End of variables declaration//GEN-END:variables
}
