package grafica;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import logica.Vector;

public class PanelVector extends JPanel {

    private Rectangle tamano;
    private int xOrigen;
    private int yOrigen;

    public PanelVector(Rectangle r) {
        this.tamano = r;
        miInicializador();
    }
    private Vector vector;
    private double valorCarga;
    private int contador;

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        if(valorCarga > 0){
            g2D.setColor(Color.RED);
        }else if(valorCarga < 0){
            g2D.setColor(Color.BLUE);
        }else{
            g2D.setColor(Color.WHITE);
        }
        g2D.setStroke(new BasicStroke(8.0F));
        representarVector(g2D);
        representarCarga(g2D);
    }

    private void representarVector(Graphics2D g2D) {
        double moduloEscalado = Math.round(Math.log(this.vector.getModulo()));
        int xFinal = (int) (this.xOrigen + moduloEscalado + 30.0D);

        if (xFinal != Integer.MAX_VALUE && xFinal != Integer.MIN_VALUE && xFinal != 0) {
            AffineTransform vieja = g2D.getTransform();
            g2D.rotate(this.vector.getAngulo(), this.xOrigen, this.yOrigen);
            g2D.drawLine(this.xOrigen, this.yOrigen, xFinal, this.yOrigen);
            int[] puntosX = {xFinal + 10, xFinal, xFinal};
            int[] puntosY = {this.yOrigen, this.yOrigen + 6, this.yOrigen - 6};
            g2D.fillPolygon(puntosX, puntosY, 3);
            g2D.setTransform(vieja);
        }
    }

    private void representarCarga(Graphics2D g2D) {
        Image img = null;
        try {
            if (this.valorCarga > 0.0D) {
                img = ImageIO.read(getClass().getResourceAsStream("img/carga_pos_16x.png"));
            } else if (this.valorCarga < 0.0D) {
                img = ImageIO.read(getClass().getResourceAsStream("img/carga_neg_16x.png"));
            } else {

                img = ImageIO.read(getClass().getResourceAsStream("img/carga_nula_16x.png"));
            }

        } catch (IOException ex) {

        }
        g2D.drawImage(img, this.xOrigen - 8, this.yOrigen - 8, this);
    }

    public void representacion(Vector v, Point p, double vCarga) {
        this.xOrigen = (int) p.getX() - 4;
        this.yOrigen = (int) p.getY() + 20;
        this.vector = v;
        this.valorCarga = vCarga;
        repaint();
    }

    private void miInicializador() {
        setBounds(this.tamano);
        setOpaque(false);
        setLayout((LayoutManager) null);
        this.contador = 0;
        this.vector = new Vector(0.0D, 0.0D);
    }
}
