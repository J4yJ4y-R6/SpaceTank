package name.panitz.game.framework;

public class SoundObject<S> {
  String fileName;
  S sound;
  public SoundObject(String fileName) {
    super();
    this.fileName = fileName;
  }
  public void playSound(SoundTool<S> st){
    try{ 
      if (sound==null) sound = st.loadSound(fileName);
    
      st.playSound(sound);
      sound = null;
    }catch(Exception e){System.err.println(e);}
  }

}
