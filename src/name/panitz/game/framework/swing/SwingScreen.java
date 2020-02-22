package name.panitz.game.framework.swing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.sound.sampled.AudioInputStream;
import javax.swing.JPanel;
import javax.swing.Timer;

import name.panitz.game.framework.GameLogic;
import name.panitz.game.framework.KeyCode;
import name.panitz.game.framework.SoundObject;


@SuppressWarnings("serial")
public class SwingScreen extends JPanel{
  GameLogic<Image,AudioInputStream> logic;
  Timer t;

  private JavaSoundTool soundTool = new JavaSoundTool();

  public SwingScreen(GameLogic<Image,AudioInputStream> gl) {
    this.logic = gl;

    t = new Timer(13, (ev)->{
      logic.move();
      logic.doChecks();
      repaint();
      getToolkit().sync();

      logic.playSounds(soundTool);
      requestFocus();
    });
    t.start();
		
    addKeyListener(new KeyAdapter() {	
      @Override
      public void keyPressed(KeyEvent e) {
        logic.keyPressedReaction(KeyCode.fromCode(e.getKeyCode()));
      }
      @Override
      public void keyReleased(KeyEvent e) {
        logic.keyReleasedReaction(KeyCode.fromCode(e.getKeyCode()));
      }

    });
    setFocusable(true);
    requestFocus();
  }
	
  @Override
  public Dimension getPreferredSize() {
    return new Dimension((int)logic.getWidth(),(int)logic.getHeight());
  }
	
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    logic.paintTo(new SwingGraphicsTool(g));
  }

}

