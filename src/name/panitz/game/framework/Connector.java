package name.panitz.game.framework;

public class Connector<I> extends AbstractGameObject<I>{
  GameObject<I> o1;
  GameObject<I> o2;
  
  public Connector( GameObject<I> o1, GameObject<I> o2) {
    super(0, 0, o1.getPos(), new Vertex(0,0));
    this.o1 = o1;
    this.o2 = o2;
  }

  @Override
  public void paintTo(GraphicsTool<I> g) {
    g.drawLine(o1.getPos().x+o1.getWidth()/2,o1.getPos().y+o1.getHeight()/2,o2.getPos().x+o2.getWidth()/2,o2.getPos().y+o2.getHeight()/2);
  }

}
