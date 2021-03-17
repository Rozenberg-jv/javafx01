package by.kolbun.examples.model;

import by.kolbun.examples.model.algo.Algo;
import by.kolbun.examples.model.algo.commands.Command;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;

import java.util.List;

public class Bot extends MObject {

  private final Algo algo;

  private final Ellipse face = new Ellipse(5, 5);

  {
    face.setFill(Paint.valueOf("#FF4444"));
  }

  public Bot(Position pos, List<Command> commands) {
    super(pos, MObjectType.BOT);
    this.algo = new Algo(commands);
  }

  public void act() {
    algo.performNext();
  }
}
