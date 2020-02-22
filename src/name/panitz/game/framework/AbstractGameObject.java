package name.panitz.game.framework;

public abstract class AbstractGameObject<I> implements GameObject<I>{
  double width;
  double height;
  Vertex position;
  Vertex velocity;
	
  public AbstractGameObject(double width, double height, Vertex position,Vertex velocity) {
    this.width = width;
    this.height = height;
    this.position = position;
    this.velocity = velocity;
  }
	
  public AbstractGameObject(double width, double height, Vertex position) {
    this(width,height,position,new Vertex(0,0));
  }

  public AbstractGameObject(double width, double height) {
    this(width,height,new Vertex(0,0));
  }

  public AbstractGameObject(double width) {
    this(width,width);
  }

  @Override
  public double getWidth() {
    return width;
  }

  @Override
  public double getHeight() {
    return height;
  }

  @Override
  public Vertex getPos() {
    return position;
  }

  @Override
  public void setWidth(double w) {
    width = w; 
  }

  @Override
  public void setHeight(double h) {
    height = h;
  }

  @Override
  public Vertex getVelocity() {
    return velocity;
  }

  @Override
  public void setVelocity(Vertex v) {
    velocity = v;
  }
}

