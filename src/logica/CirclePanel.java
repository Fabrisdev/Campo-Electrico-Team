package logica;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class CirclePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
        g.fillOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
    }
}