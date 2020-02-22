package name.panitz.game.example.simple;

import java.util.ArrayList;
import java.util.List;

import name.panitz.game.framework.AbstractGame;
import name.panitz.game.framework.Button;
import name.panitz.game.framework.KeyCode;
import name.panitz.game.framework.SoundObject;
import name.panitz.game.framework.GameObject;
import name.panitz.game.framework.ImageObject;
import name.panitz.game.framework.TextObject;
import name.panitz.game.framework.Vertex;

public class SimpleGame<I,S> extends AbstractGame<I,S>{
  List<GameObject<I>> hintergrund = new ArrayList<>();
  List<GameObject<I>> gegner = new ArrayList<>();
  List<ImageObject<I>> wolken = new ArrayList<>();

  int stiche = 0;

  TextObject<I> infoText
    = new TextObject<>(new Vertex(30,35)
       ,"Kleines Beispielspiel","Helvetica",28);	

  SoundObject<S> outch = new SoundObject<>("outch.wav");
  
  public SimpleGame() {
    super(new ImageObject<>("hexe.png"
        ,new Vertex(200,200),new Vertex(1,1)),800,600);
    
    hintergrund.add(new ImageObject<>("wiese.jpg"));
    hintergrund.add(infoText);

    wolken.add(new ImageObject<>("wolke.png"
        ,new Vertex(800,10),new Vertex(-1,0)));
    wolken.add(new ImageObject<>("wolke.png"
        ,new Vertex(880,90),new Vertex(-1.2,0)));
    wolken.add(new ImageObject<>("wolke.png"
        ,new Vertex(1080,60),new Vertex(-1.1,0)));
    wolken.add(new ImageObject<>("wolke.png"
        ,new Vertex(980,110),new Vertex(-0.9,0)));

    gegner.add(new ImageObject<>("biene.png"
        ,new Vertex(800,100),new Vertex(-1,0)));
    gegner.add(new ImageObject<>("biene.png"
        ,new Vertex(800,300),new Vertex(-1.5,0)));

    getGOss().add(hintergrund);
    getGOss().add(wolken);
    goss.add(gegner);
    
    getButtons().add(new Button("Pause", ()-> pause()));
    getButtons().add(new Button("Start", ()-> start()));
    getButtons().add(new Button("Exit", ()-> System.exit(0)));
  }

  @Override
  public void doChecks() {
    for (GameObject<I> g:wolken){
      if (g.getPos().x+g.getWidth()<0) {
        g.getPos().x = getWidth();
      }
    }

    for (GameObject<I> g:gegner){
      if (g.getPos().x+g.getWidth()<0) {
        g.getPos().x = getWidth();
      }
      if (player.touches(g)){
        stiche++;
        infoText.text = "Bienenstiche: "+stiche; 
        g.getPos().moveTo(new Vertex(getWidth()+10,g.getPos().y));
        playSound(outch);
      }
    }
    if (stiche>=10){
      gegner.add(new TextObject<>(new Vertex(100,300)
          ,"Du hast verloren","Helvetica",56));
    }
  }

  @Override
  public boolean isStopped() {
    return super.isStopped() || stiche>=10;
  }

  @Override
  public void keyPressedReaction(KeyCode keycode) {
    if (keycode!=null)
     switch (keycode){
      case RIGHT_ARROW:
        getPlayer().getVelocity().move(new Vertex(1,0));
        break;
      case LEFT_ARROW:
        getPlayer().getVelocity().move(new Vertex(-1,0));
        break;
      case DOWN_ARROW:
        getPlayer().getVelocity().move(new Vertex(0,1));
        break;
      case UP_ARROW:
        getPlayer().getVelocity().move(new Vertex(0,-1));
        break;
      default: ;
     }
  }
}

