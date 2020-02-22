package name.panitz.game.framework;

public interface GraphicsTool<I> {
  void drawImage(I img,double x,double y);
  void drawRect(double x,double y,double w,double h);
  void fillRect(double x,double y,double w,double h);
  void drawOval(double x,double y,double w,double h);
  void fillOval(double x,double y,double w,double h);
  void drawLine(double x1,double y1,double x2,double y2);

  void setColor(double red, double green, double blue);
  void drawString(double x,double y,int fntsize, String fntName, String text);
  
  default void drawString(double x,double y,int fontSize, String text){
    drawString(x,y,fontSize,"Helvetica",text);
  }
  
  default void drawString(double x,double y,String text){
    drawString(x,y,20,"Helvetica",text);
  }

  default void drawCircle(double x,double y,double w){
    drawOval(x, y, w, w);
  }
  default void fillCircle(double x,double y,double w){
    fillOval(x, y, w, w);
  }

  I generateImage(String name, GameObject<I> go);
}

