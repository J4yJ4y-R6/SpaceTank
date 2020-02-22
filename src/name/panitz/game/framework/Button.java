package name.panitz.game.framework;

public class Button {
  public String name;
  public Runnable action;
  public Button(String name, Runnable action) {
    this.name = name;
    this.action = action;
  }
}
