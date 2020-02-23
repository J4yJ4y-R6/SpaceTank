package main;

import name.panitz.game.example.simple.SimpleGame;
import name.panitz.game.framework.fx.GameApplication;

public class FX extends GameApplication {
  public FX() {
    super(new SimpleGame<>());
  }
  public static void main(String [] args) {
    FX.launch();
  }
}
