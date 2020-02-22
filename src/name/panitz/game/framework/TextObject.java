package name.panitz.game.framework;
public class TextObject<I> extends AbstractGameObject<I>{
  public String text;
  public String fontName;
  public int fontSize;
	
  public TextObject(Vertex position, String text, String fntName,int fntSize) {
    super(0,0,position);
    this.text = text ;
    this.fontName = fntName;
    this.fontSize = fntSize;
  }
	
  @Override
  public void paintTo(GraphicsTool<I> g) {
    g.drawString(getPos().x,getPos().y,fontSize,fontName,text);
  }
}

