package grafica;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import logica.Placas;

public class PanelAnimacion extends JPanel {

    private BufferedImage imagenCarga;
    private double anguloRotacion;
    private int velocidad;
    private int contador;

    public PanelAnimacion(Point a, Point b, double valCar, double vel) {
        this.xInicial = (int)a.getX() + 20;
        this.yInicial = (int)a.getY() + 35;
        this.xFinal = this.xInicial + (int)a.distance(b);
        this.valorCarga = valCar;
        this.anguloRotacion = Placas.anguloDespl(a, b);
        this.velocidad = (int)Math.ceil(Math.log(Math.ceil(vel))) + 2;
        miInicializador();
    }
    private int xInicial;
    private int yInicial;
    private int xFinal;
    private double valorCarga;

    public void paintComponent(Graphics g) {
        setLocation(40, 40);
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.rotate(this.anguloRotacion, this.xInicial, this.yInicial);
        if (this.xInicial + this.velocidad * this.contador - this.xFinal > 1) {
            g2D.drawImage(this.imagenCarga, this.xInicial - 8, this.yInicial - 8, this);
            this.contador = 0;
        } else {

            g2D.drawImage(this.imagenCarga, this.xInicial - 8 + this.velocidad * this.contador, this.yInicial - 8, this);
        }
        g2D.dispose();
    }

    private void moverCarga() {
        repaint();
    }

    private void miInicializador() {
        setBounds(40, 40, 700, 500);
        setOpaque(false);
        setLayout((LayoutManager) null);
        this.contador = 0;
        try {
            if (this.valorCarga > 0.0D) {
                this.imagenCarga = ImageIO.read(getClass().getResourceAsStream("img/carga_pos_16x.png"));
            } else if (this.valorCarga < 0.0D) {
                this.imagenCarga = ImageIO.read(getClass().getResourceAsStream("img/carga_neg_16x.png"));
            } else {

                this.imagenCarga = ImageIO.read(getClass().getResourceAsStream("img/carga_nula_16x.png"));
            }

        } catch (IOException ex) {

        }

        Timer timer = new Timer(200, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PanelAnimacion.this.contador++;
                PanelAnimacion.this.moverCarga();
            }
        });
        timer.setInitialDelay(0);
        timer.start();
    }
}