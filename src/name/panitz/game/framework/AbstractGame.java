package name.panitz.game.framework;

import java.util.List;
import java.util.ArrayList;

public abstract class AbstractGame<I,S> implements GameLogic<I,S> {
  protected List<List<? extends GameObject<I>>> goss = new ArrayList<>();
  protected List<Button> buttons = new ArrayList<>();
  protected List<SoundObject<S>> soundsToPlays= new ArrayList<>();
  protected GameObject<I> player;
  double width;
  double height;

  public AbstractGame(GameObject<I> player, double width, double height) {
    this.player = player;
    this.height = height;
    this.width = width; 
  }

  @Override
  public List<List<? extends GameObject<I>>> getGOss(){
    return goss;
  }

  @Override
  public GameObject<I> getPlayer() {
    return player;
  }

  @Override
  public List<Button> getButtons(){
    return buttons;
  }

  public List<SoundObject<S>> getSoundsToPlayOnce() {
    return soundsToPlays;
  }
  
  @Override
  public double getWidth() {
    return width;
  }

  @Override
  public double getHeight() {
    return height;
  }	

  @Override
  public void playSound(SoundObject<S> so) {
    getSoundsToPlayOnce().add(so);
  }
  
  private boolean isStopped = false;
  
  @Override
  public boolean isStopped() {
    return isStopped;
  }
  @Override
  public void start() {
    isStopped  = false;
  }
  
  @Override
  public void pause() {
    isStopped  = true;
    
  }

  @Override
  public void keyPressedReaction(KeyCode keycode){}
  @Override
  public void keyReleasedReaction(KeyCode keycode){}

}

