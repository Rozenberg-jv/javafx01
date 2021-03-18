package by.kolbun.examples;

import by.kolbun.examples.render.ExampleRender;
import by.kolbun.examples.render.impl.ExampleRenderImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ButtonController {

  @FXML
  public Button startButton;

  @FXML
  public Button exitButton;

  @FXML
  public GridPane grid;

  /*   */

  private final ExampleRender exampleRender = new ExampleRenderImpl();


  @FXML
  public void clickExit() {

    ExampleRenderImpl.stop = true;
    System.out.println("exit");
    Stage stageOnClose = (Stage) exitButton.getScene().getWindow();
    stageOnClose.close();
  }

  @FXML
  public void clickStart(MouseEvent event) {

    System.out.println("start");

    exampleRender.execute(grid);
  }

}
