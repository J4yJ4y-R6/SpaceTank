package name.panitz.game.framework;

public class Vertex {
  public double x;
  public double y;

  public Vertex(double x, double y) {
    this.x = x;
    this.y = y;
  }  

  @Override
  public String toString() {
    return "("+x+", "+y+")";
  }  

  public void move(Vertex that){
    x += that.x;
    y += that.y;
  }

  public void moveTo(Vertex that){
    x = that.x;
    y = that.y;
  }

  public Vertex mult(double d) {
    return new Vertex(d*x,d*y);
  }
}

