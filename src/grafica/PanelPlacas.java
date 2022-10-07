package grafica;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logica.Placa;

public class PanelPlacas extends JPanel {

    public PanelPlacas() {
        miInicializador();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(2.0F));
        g2D.setFont(new Font("SansSerif", 1, 12));
        lineasCampo(g2D);
        graficarPlacas(g2D);
    }

    private void lineasCampo(Graphics2D g2D) {
        int incrementoX = getWidth() / (FrmPlaca.placas.tamano() + 1);
        int xPrimeraPlaca = FrmPlaca.placas.devolver(0).getxPlaca();

        for (int i = 0; i <= FrmPlaca.placas.tamano(); i++) {
            if (FrmPlaca.placas.sumarCampos(i * incrementoX + 1) != 0.0D) {
                int xMedio = i * incrementoX + xPrimeraPlaca / 2;
                for (int k = 50; k <= getHeight() - 50; k += 50) {
                    g2D.drawLine(i * incrementoX, k, xPrimeraPlaca + i * incrementoX, k);
                    if (FrmPlaca.placas.sumarCampos(i * incrementoX + 1) > 0.0D) {
                        int[] flechaX = {xMedio, xMedio, xMedio + 10};
                        int[] flechaY = {k + 5, k - 5, k};
                        g2D.fillPolygon(flechaX, flechaY, 3);
                    } else {

                        int[] flechaX = {xMedio, xMedio, xMedio - 10};
                        int[] flechaY = {k + 5, k - 5, k};
                        g2D.fillPolygon(flechaX, flechaY, 3);
                    }
                }
            }
        }
    }

    private void graficarPlacas(Graphics2D g2D) {
        for (int i = 0; i < FrmPlaca.placas.tamano(); i++) {
            JLabel lbl = new JLabel();
            Placa actual = FrmPlaca.placas.devolver(i);
            lbl.setBounds(actual.getxPlaca() - 25, 50, 50, 400);
            lbl.setOpaque(true);

            if (actual.getSigma() > 0.0D) {
                ImageIcon placa = new ImageIcon(getClass().getResource("img/lblPlacaPos.png"));
                lbl.setIcon(placa);
            } else if (actual.getSigma() < 0.0D) {
                ImageIcon placa2 = new ImageIcon(getClass().getResource("img/lblPlacaNeg.png"));
                lbl.setIcon(placa2);
                
            }
            add(lbl);
        }
    }

    public int placasEntrePuntos(Point puntoA, Point puntoB) {
        int x1, x2, cantidadPlacas = 0;

        if (puntoA.getX() > puntoB.getX()) {
            x1 = (int) puntoB.getX();
            x2 = (int) puntoA.getX();
        } else {

            x1 = (int) puntoA.getX();
            x2 = (int) puntoB.getX();
        }

        for (int i = x1; i < x2; i += 50) {
            if (!getComponentAt(i, 100).equals(this)) {
                cantidadPlacas++;
            }
        }
        return cantidadPlacas;
    }

    private void miInicializador() {
        setBounds(40, 40, 670, 500);
        FrmPlaca.placas.determinarXPlacas(getWidth());
        setLayout((LayoutManager) null);
    }
}