package grafica;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import logica.CargaFuente;
import logica.Vector;

public class PanelCargas extends JPanel {

    public PanelCargas() {
        miInicializador();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(2.0F));
        graficarCampo(g2D);
        try {
            dibujarCargas(g2D);
        } catch (IOException ex) {
            System.exit(0);
        }
    }

    private void representarVector(int xOrigen, int yOrigen, Graphics2D g2D) {
        Vector vec = FrmCargas.cargas.sumarCampos(xOrigen, yOrigen);
        double moduloEscalado = Math.round(Math.log10(vec.getModulo()));
        int xFinal = (int) (xOrigen + moduloEscalado);

        if (xFinal != Integer.MAX_VALUE && xFinal != Integer.MIN_VALUE && xFinal != 0) {
            AffineTransform vieja = g2D.getTransform();
            g2D.rotate(vec.getAngulo(), xOrigen, yOrigen);
            g2D.drawLine(xOrigen, yOrigen, xFinal, yOrigen);
            int[] puntosX = {xFinal + 8, xFinal, xFinal};
            int[] puntosY = {yOrigen, yOrigen + 4, yOrigen - 4};
            g2D.fillPolygon(puntosX, puntosY, 3);
            g2D.setTransform(vieja);
        }
    }

    private void graficarCampo(Graphics2D g2D) {
        for (int i = 50; i <= getWidth() - 50; i += 50) {
            for (int j = 50; j <= getHeight() - 50; j += 50) {
                representarVector(i, -j + getHeight(), g2D);
            }
        }
    }

    private void dibujarCargas(Graphics2D g2D) throws IOException {
        for (int i = 0; i < FrmCargas.cargas.tamano(); i++) {
            Image img;
            CargaFuente car = FrmCargas.cargas.devolver(i);
            if (car.getValorCarga() > 0.0D) {
                img = ImageIO.read(getClass().getResourceAsStream("img/CargaPositiva.png"));
            } else if (car.getValorCarga() < 0.0D) {
                img = ImageIO.read(getClass().getResourceAsStream("img/CargaNegativa.png"));
            } else {

                img = ImageIO.read(getClass().getResourceAsStream("img/CargaNula.png"));
            }
            int x = (int) car.getxCarga();
            int y = (int) car.getyCarga();
            g2D.drawImage(img, x - 16, y - 16, this);
        }
    }

    private void miInicializador() {
        setBounds(40, 40, 700, 500);
        setLayout((LayoutManager) null);
    }
}