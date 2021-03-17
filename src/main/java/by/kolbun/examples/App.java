package by.kolbun.examples;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application {

	private static int INIT_X;
	private static int INIT_Y;
	private static final int INIT_WIDTH = 800;
	private static final int INIT_HEIGHT = 500;

	static {

		//		GraphicsDevice.getLocalGraphicsEnvironment().getScreenDevices();
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		INIT_X = (int) (screenSize.getWidth() - INIT_WIDTH) / 2;
		INIT_Y = (int) (screenSize.getHeight() - INIT_HEIGHT) / 2;
	}

	@Override
	public void start(Stage primaryStage) throws IOException {

		/*primaryStage.setTitle("JavaFX testing");
		primaryStage.setWidth(800);
		primaryStage.setHeight(500);
		primaryStage.setResizable(false);
		primaryStage.setX(INIT_X);
		primaryStage.setY(INIT_Y);
//		primaryStage.initStyle(StageStyle.UNDECORATED);

		//

		GridPane mainField = new GridPane();
		VBox menuPane = new VBox();

		menuPane.setPadding(new Insets(5));
		menuPane.setAlignment(Pos.BASELINE_RIGHT);
		menuPane.setMaxHeight(480);
		menuPane.setMinWidth(250);
		menuPane.setBackground(new Background(new BackgroundFill(Paint.valueOf("rgb(120,180,180)"), null, null)));

		mainField.setAlignment(Pos.BASELINE_LEFT);
		mainField.setGridLinesVisible(true);
		mainField.setMinWidth(500);
		mainField.setBackground(new Background(new BackgroundFill(Paint.valueOf("rgb(200,120,120)"), null, null)));

		//

		GridPane mainPane = new GridPane();
		mainPane.setGridLinesVisible(true);
		mainPane.setPadding(new Insets(5));
		Paint bgPaint = Paint.valueOf("rgb(180,180,180)");
		Insets bgInsets = new Insets(0);
		mainPane.setBackground(new Background(new BackgroundFill(bgPaint, null, bgInsets)));


		mainPane.addRow(0, mainField, menuPane);

		//

		Scene scene = new Scene(mainPane);

		//

		primaryStage.setScene(scene);
		primaryStage.show();*/

		URL resource = getClass().getResource("/main.fxml");
		Parent root = FXMLLoader.load(resource);

		primaryStage.setTitle("JavaFX testing");
		primaryStage.setWidth(800);
		primaryStage.setHeight(560);
		primaryStage.setResizable(false);
		primaryStage.setX(INIT_X);
		primaryStage.setY(INIT_Y);
//		primaryStage.initStyle(StageStyle.UNDECORATED);

		//
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);

		primaryStage.show();

	}

	public static void main(String[] args) {

		launch();
	}

}