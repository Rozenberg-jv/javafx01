package by.kolbun.examples.render.impl;

import by.kolbun.examples.logic.ExampleLogic;
import by.kolbun.examples.logic.impl.ExampleLogicImpl;
import by.kolbun.examples.model.Bot;
import by.kolbun.examples.model.MObject;
import by.kolbun.examples.model.MObjectType;
import by.kolbun.examples.model.algo.commands.Command;
import by.kolbun.examples.model.algo.commands.impl.MoveCommand;
import by.kolbun.examples.render.ExampleRender;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;

import java.util.ArrayList;
import java.util.List;

public class ExampleRenderImpl implements ExampleRender {

  private static final int[][] exampleCells =
      {
          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2},
          {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
          {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
          {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
          {2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
      };

  private static final List<MObject> exampleList = new ArrayList<>() {{

    List<Command> commands = new ArrayList<>();
    commands.add(new MoveCommand(1, 0));
    commands.add(new MoveCommand(0, 1));
    commands.add(new MoveCommand(-1, 0));
    commands.add(new MoveCommand(0, -1));

    add(new Bot(5, 5, commands));
    add(new Bot(26, 26, commands));
    add(new Bot(5, 26, commands));
    add(new Bot(26, 5, commands));

    add(new MObject(0, 0, MObjectType.WALL));
    add(new MObject(0, 31, MObjectType.WALL));
    add(new MObject(31, 31, MObjectType.WALL));
    add(new MObject(31, 0, MObjectType.WALL));

    add(new MObject(0, 1, MObjectType.FOOD));
    add(new MObject(1, 0, MObjectType.FOOD));

    add(new MObject(0, 30, MObjectType.POISON));
    add(new MObject(1, 31, MObjectType.POISON));

    add(new MObject(30, 31, MObjectType.CORPSE));
    add(new MObject(31, 30, MObjectType.CORPSE));

    add(new MObject(30, 0, MObjectType.POISON));
    add(new MObject(31, 1, MObjectType.POISON));
  }};

  /*   */

  private final ExampleLogic logic = new ExampleLogicImpl();

//  private static final int PERIOD_RATE_MS = 1000;
  private static final int PERIOD_RATE_MS = 250;

  public static boolean stop = false;

  @Override
  public void execute(Object obj) {

		/*Stage stage = (Stage) obj;

		Scene scene = stage.getScene();

		Node node = scene.getRoot().lookup("#grid");

		GridPane grid = (GridPane) node; */

    GridPane grid = (GridPane) obj;

    initGrid(grid);

    startThread(PERIOD_RATE_MS, grid);


    /*for (int i = 0; i < exampleCells.length; i++) {
      for (int j = 0; j < exampleCells[i].length; j++) {
        Ellipse ellipse = new Ellipse(5, 5);
        ellipse.setFill(Paint.valueOf(calcPaintForEllipse(exampleCells[i][j])));
        grid.add(ellipse, i, j);
      }
    }*/

  }

  private void initGrid(GridPane grid) {

    for (int i = 0; i < 32; i++) {
      for (int j = 0; j < 32; j++) {
        Ellipse ellipse = new Ellipse(5, 5);
        ellipse.setFill(Paint.valueOf("#FFF"));
        grid.add(ellipse, i, j);
      }
    }
  }

  private void startThread(int periodRateMs, GridPane grid) {

    logic.init(exampleList);

    Thread thread = new Thread(() -> {
      int stepCount = 0;

      while (!stop) {
        try {
          Thread.sleep(periodRateMs);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        logic.step();

        renderGrid(grid, exampleList);

        System.out.println(stepCount++);
      }
    });

    thread.start();
  }

  private void renderGrid(GridPane grid, List<MObject> mObjects) {

    ObservableList<Node> children = grid.getChildren();

    for (int i = 0; i < 32; i++) {
      for (int j = 0; j < 32; j++) {
        Ellipse ellipse = (Ellipse) children.get(i * 32 + j + 1);
        ellipse.setFill(Paint.valueOf("#FFF"));
      }
    }

    for (MObject mObject : mObjects) {
      ((Ellipse) children.get(mObject.getPos().indexNumber() + 1)).setFill(Paint.valueOf(calcPaintForEllipse(mObject.getType().code())));
    }
  }

  private String calcPaintForEllipse(int i) {

    String result = "";

    switch (i) {
      case 0:
        result = "#00F";
        break;
      case 1:
        result = "#000";
        break;
      case 2:
        result = "#F00";
        break;
      case 3:
        result = "#0F0";
        break;
      case 4:
        result = "#A0A0A0";
        break;
      default:
        result = "#FFF";
        break;
    }

    return result;
  }
}
