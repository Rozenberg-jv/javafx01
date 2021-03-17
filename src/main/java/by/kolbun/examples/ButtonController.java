package by.kolbun.examples;

import by.kolbun.examples.logic.ExampleLogic;
import by.kolbun.examples.logic.impl.ExampleLogicImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ButtonController {

	@FXML
	public Button startButton;

	@FXML
	public Button exitButton;

	/*   */

	private final ExampleLogic exampleLogic = new ExampleLogicImpl();

	@FXML
	public void clickExit() {

		System.out.println("exit");
		Stage stageOnClose = (Stage) exitButton.getScene().getWindow();
		stageOnClose.close();
	}

	@FXML
	public void clickStart(MouseEvent event) {

		System.out.println("start");

		exampleLogic.execute(startButton.getScene().getWindow());
	}

}
