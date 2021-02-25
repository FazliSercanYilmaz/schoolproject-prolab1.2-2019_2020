package application;
	
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public static List<Oyuncu> oyuncular;
	public static List<Pokemon> pokemonlar;
	public static int Oyunmodu;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/Gui/SecimScreen.fxml"));			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		oyuncular = new ArrayList<Oyuncu>();
		pokemonlar = new ArrayList<Pokemon>();
		launch(args);
	}
}
