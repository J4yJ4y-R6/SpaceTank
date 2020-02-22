package name.panitz.game.framework.fx;

import name.panitz.game.framework.GraphicsTool;
import name.panitz.game.framework.GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

public class FXContextTool implements GraphicsTool<Image>{
  GraphicsContext gc;

  public FXContextTool(GraphicsContext gc) {
    this.gc = gc;
  }

  @Override
  public void drawImage(Image img, double x, double y) {
    gc.drawImage(img, x, y);
  }

  @Override
  public void drawRect(double x, double y, double w, double h) {
    gc.setLineWidth(1);
    gc.strokeRect(x, y, w, h);        
  }

  @Override
  public void fillRect(double x, double y, double w, double h) {
    gc.fillRect(x, y, w, h);		
  }

  @Override
  public void drawOval(double x, double y, double w, double h) {
    gc.setLineWidth(2);
    gc.strokeOval(x, y, w, h);
  }

  @Override
  public void fillOval(double x, double y, double w, double h) {
    gc.fillOval(x, y, w, h);
  }

  @Override
  public void drawLine(double x1, double y1, double x2, double y2) {
    gc.strokeLine(x1, y1, x2, y2);
  }

  
  @Override
  public void drawString(double x,double y,int fontSize, String fontName, String text){
    gc.setFont(new Font(fontName, fontSize));
    gc.fillText(text,x,y);
  }
  @Override 
  public Image generateImage(String name,GameObject<Image> go){
    Image image = new Image(getClass().getClassLoader().getResourceAsStream(name));
    go.setWidth(image.getWidth());
    go.setHeight(image.getHeight());
    return image;
  }

  @Override
  public void setColor(double r, double g, double b) {
    gc.setFill(new javafx.scene.paint.Color(r, g, b, 1));
    gc.setStroke(new javafx.scene.paint.Color(r, g, b, 1));
  }
}
