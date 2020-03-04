package main;

import backend.SpaceTank;
import name.panitz.game.framework.fx.GameApplication;

public class FX extends GameApplication {
  public FX() {
    super(new SpaceTank<>(800,600));
  }
  public static void main(String [] args) {
    FX.launch();
  }
}
