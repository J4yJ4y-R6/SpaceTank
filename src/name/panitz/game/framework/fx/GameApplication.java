package name.panitz.game.framework.fx;
import javax.sound.sampled.AudioInputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import name.panitz.game.framework.Button;
import name.panitz.game.framework.GameLogic;

public class GameApplication extends Application {  
  Canvas canvas;
  GameLogic<Image,AudioInputStream> game;
  public GameApplication(GameLogic<Image,AudioInputStream> game){
    canvas =  new FXScreen(game);
    this.game = game;
  }

  public void start(Stage stage) throws Exception {
    canvas.setWidth(game.getWidth());
    canvas.setHeight(game.getHeight());
    BorderPane bp = new BorderPane();
    bp.setCenter(canvas);
    FlowPane fp = new FlowPane();
    for (Button b :game.getButtons()){
      javafx.scene.control.Button fxbutton = new javafx.scene.control.Button(b.name);
      fxbutton.setOnAction((ev)->b.action.run());
      fp.getChildren().add(fxbutton);
    }
    bp.setBottom(fp);
    stage.setScene(new Scene(bp));
    stage.show();
  }
}

