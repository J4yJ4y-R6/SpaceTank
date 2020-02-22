package name.panitz.game.framework.swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

import name.panitz.game.framework.GraphicsTool;
import name.panitz.game.framework.GameObject;

public class SwingGraphicsTool implements GraphicsTool<Image>{
  Graphics g;
	
  public SwingGraphicsTool(Graphics g) {
    this.g = g;
  }

  @Override
  public void drawImage(Image img, double x, double y) {
    g.drawImage(img, (int)x, (int)y, null);
  }

  @Override
  public void drawRect(double x, double y, double w, double h) {
    g.drawRect((int)x, (int)y, (int)w, (int)h);
  }
  
  @Override
  public void fillRect(double x, double y, double w, double h) {
    g.fillRect((int)x, (int)y, (int)w, (int)h);
  }

  @Override
  public void drawOval(double x, double y, double w, double h) {
    g.drawOval((int)x, (int)y, (int)w, (int)h);		
  }

  @Override
  public void fillOval(double x, double y, double w, double h) {
    g.fillOval((int)x, (int)y, (int)w, (int)h);
  }

  @Override
  public void drawLine(double x1, double y1, double x2, double y2) {
    g.drawLine((int)x1,(int)y1, (int)x2, (int)y2); 
  }

  @Override
  public void drawString(double x,double y,int fontSize, String fontName, String text){
    g.setFont(new Font(fontName, Font.PLAIN, fontSize));
    g.drawString(text, (int)x, (int)y);
  }

  @Override
  public  Image generateImage(String name, GameObject<Image> go){
    ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource(name));
    go.setWidth(image.getIconWidth());
    go.setHeight(image.getIconHeight());
    return image.getImage();
  }

  @Override
  public void setColor(double r, double gr, double b) {
    g.setColor(new Color((float)r, (float)gr, (float)b));
  }
}

