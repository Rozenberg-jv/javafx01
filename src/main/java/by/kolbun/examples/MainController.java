package by.kolbun.examples;

import by.kolbun.examples.render.ExampleRender;
import by.kolbun.examples.render.impl.ExampleRenderImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class MainController {

	@FXML
	public Button startButton;

	@FXML
	public Button exitButton;

	@FXML
	public Button middleButton;

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

	@FXML
	public void clickMiddle(MouseEvent event) throws IOException {

		Stage settingsStage = new Stage();
		settingsStage.setTitle("settings");
		settingsStage.setWidth(400);
		settingsStage.setHeight(560);
		settingsStage.setResizable(false);
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int initX = (int) (screenSize.getWidth() - 400) / 2;
		int initY = (int) (screenSize.getHeight() - 560) / 2;
		settingsStage.setX(initX);
		settingsStage.setY(initY);
		settingsStage.initModality(Modality.WINDOW_MODAL);
		URL resource = getClass().getResource("/settings.fxml");
		Parent root = FXMLLoader.load(resource);
		Scene scene = new Scene(root);
		settingsStage.setScene(scene);

		settingsStage.show();
	}
}
