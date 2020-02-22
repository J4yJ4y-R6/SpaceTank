package name.panitz.game.framework;

public interface GameObject<I> extends Movable, Paintable<I> {
  double getWidth();
  double getHeight();
  void setWidth(double w);
  void setHeight(double h);

  Vertex getPos();

  Vertex getVelocity();
  void setVelocity(Vertex v);


  default boolean isLeftOf(GameObject<?> that) {
    return this.getPos().x + this.getWidth() < that.getPos().x;
  }

  default boolean isRightOf(GameObject<?> that) {
    return that.isLeftOf(this);
  }


  default boolean isAbove(GameObject<?> that) {
    return this.getPos().y + this.getHeight() < that.getPos().y;
  }

  default boolean touches(GameObject<?> that) {
    if (this.isLeftOf(that)) return false;
    if (that.isLeftOf(this)) return false;
    if (this.isAbove(that))  return false;
    if (that.isAbove(this))  return false;
    return true;
  }

 default boolean isStandingOnTopOf(GameObject<?> that) {
    return !(isLeftOf(that) || isRightOf(that)) && isAbove(that)
            && getPos().y + getHeight() + 2 > that.getPos().y;
  }

  
  default void move() {
    getPos().move(getVelocity());
  }
  default double size(){return getWidth() * getHeight();}
  default boolean isLargerThan(GameObject<?> that) {
    return size() > that.size(); 
  }
}

