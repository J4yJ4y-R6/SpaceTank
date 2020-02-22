package main;

import javafx.stage.Stage;
import name.panitz.game.example.simple.SimpleGame;
import name.panitz.game.framework.fx.GameApplication;

public class FX {
  public static void main(String[] args) {
    GameApplication Game = new GameApplication(new SimpleGame<>());
    Stage stage =  new Stage();
    stage.show();
    Game.start(stage);
  }
}
