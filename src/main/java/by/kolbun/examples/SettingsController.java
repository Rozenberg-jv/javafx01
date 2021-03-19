package by.kolbun.examples;

import by.kolbun.examples.render.impl.ExampleRenderImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SettingsController {

	@FXML
	public Button settingsSubmit;

	@FXML
	public void settingsSubmit(MouseEvent event) {

		ExampleRenderImpl.stop = true;
		System.out.println("settings submit");
		Stage stageOnClose = (Stage) settingsSubmit.getScene().getWindow();
		stageOnClose.close();
	}

}
