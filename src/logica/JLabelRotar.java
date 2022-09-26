package logica;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;

public class JLabelRotar extends JLabel {
   private double rotation = 0.0; 
    
   public JLabelRotar() {
      super("");
      Font font = new Font("Verdana", Font.ITALIC, 10);
      FontMetrics metrics = new FontMetrics(font){};
      Rectangle2D bounds = metrics.getStringBounds("", null);
      setBounds(0, 0, (int) bounds.getWidth(), (int) bounds.getHeight());
   }
   @Override
   public void paintComponent(Graphics g) {
      Graphics2D gx = (Graphics2D) g;
      gx.rotate(rotation, getX() + getWidth()/2, getY() + getHeight()/2);
      super.paintComponent(g);
   }
   
   public void setRotation(double rotation){
       this.rotation = rotation;
   }
   
   public double getRotation(){
       return rotation;
   }
}