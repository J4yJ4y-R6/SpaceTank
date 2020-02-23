package backend;

import name.panitz.game.framework.*;

import java.util.ArrayList;
import java.util.List;

public class SpaceTank<I,S> extends AbstractGame<I,S> {
  List<GameObject<I>> backgorund = new ArrayList<>();
  List<GameObject<I>> enemy = new ArrayList<>();
  List<ImageObject<I>> shield = new ArrayList<>();

  int health = 3;
  int highscore;
  int alienX = 5;
  int alienY = 50;

  TextObject<I> healthText = new TextObject<>(new Vertex(720,20)
          ,"Health: " + health,"Berlin Sans FB",20);

  TextObject<I> highscoreText = new TextObject<>(new Vertex(5,20)
          ,"Highscore: " + highscore,"Berlin Sans FB",20);

  public SpaceTank(double widthScreen, double heightScreen) {
    super(new ImageObject<>("hexe.png", new Vertex(widthScreen/2,heightScreen*0.90)),widthScreen,heightScreen);

    backgorund.add(new ImageObject<>("space.gif"));
    backgorund.add(healthText);
    backgorund.add(highscoreText);

    for (int aliens = 0; aliens <= 10; aliens++) {
      String alienType = "alien" + (int) (Math.random() * 3) + ".png";
      if (aliens % 5 == 0 && aliens != 0) {
        alienY += 30;
        alienX = 5;
      }
      enemy.add(new ImageObject<>(alienType,new Vertex(alienX,alienY)));
      alienX += 30;
    }

    getGOss().add(backgorund);

    getButtons().add(new Button("Pause", ()-> pause()));
    getButtons().add(new Button("Start", ()-> start()));
    getButtons().add(new Button("Exit", ()-> System.exit(0)));
  }

  @Override
  public void doChecks() {
    if (health<= 0){
      enemy.add(new TextObject<>(new Vertex(100,300)
              ,"GAME OVER","Berlin Sans FB",56));
    }
  }

  @Override
  public boolean isStopped() {
    return super.isStopped() || health<=0;
  }
}