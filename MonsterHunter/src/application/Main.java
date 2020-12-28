package application;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage stage;

	@Override
	public void start(Stage stage) {
		try {
			Main.stage = stage;
			changeView("Menu.fxml");
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void changeView(String fxml) { // シーン切り替え用の関数
		try {
			stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(fxml))));
		} catch (IOException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
