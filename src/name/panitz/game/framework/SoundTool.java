package name.panitz.game.framework;

public interface SoundTool<S> {
  S loadSound(String fileName);
  void playSound(S sound);
}
