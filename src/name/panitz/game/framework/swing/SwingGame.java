package name.panitz.game.framework.swing;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.sound.sampled.AudioInputStream;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

import name.panitz.game.framework.Button;
import name.panitz.game.framework.GameLogic;

@SuppressWarnings("serial")
public class SwingGame extends JPanel {
  GameLogic<Image, AudioInputStream> logic;

  public SwingGame(GameLogic<Image, AudioInputStream> logic) {
    super();
    this.logic = logic;
    SwingScreen swsc = new SwingScreen(logic);
    this.setLayout(new BorderLayout());
    add(swsc, BorderLayout.CENTER);
    JPanel buttonsPanel = new JPanel();
    for (Button b :logic.getButtons()){
      JButton jb = new JButton(b.name);
      jb.addActionListener(ev->b.action.run());
      buttonsPanel.add(jb);
    }
    add(buttonsPanel, BorderLayout.SOUTH);
  }


  public static void startGame(GameLogic<Image, AudioInputStream> game) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(new SwingGame(game));
    f.pack();
    f.setVisible(true);
  }

}
