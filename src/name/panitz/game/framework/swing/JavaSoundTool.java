package name.panitz.game.framework.swing;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import name.panitz.game.framework.SoundTool;

public class JavaSoundTool implements SoundTool<AudioInputStream> {

  @Override
  public AudioInputStream loadSound(String fileName) {
    try {
      InputStream src = getClass().getClassLoader().getResourceAsStream(fileName);
      InputStream bufferedIn = new BufferedInputStream(src);
      // File laden
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
      
      return audioStream;
    } catch (UnsupportedAudioFileException |IOException e) {
      e.printStackTrace();
    }
    System.out.println("ups?");
    return null;
  }

  @Override
  public void playSound(AudioInputStream sound) {
    Clip clip;
    try {
      clip = AudioSystem.getClip();
      clip.open(sound);
      clip.start();
    } catch (LineUnavailableException | IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
