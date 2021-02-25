package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SecimScreenController implements Initializable{
	 @FXML
	    private Button btn1;

	    @FXML
	    private Button btn2;

	    @FXML
	    void btn1action(ActionEvent event) throws IOException {
	    	Main.Oyunmodu=1;
	    	Parent yeni = FXMLLoader.load(getClass().getResource("Oyun.fxml"));
	    	Scene yeniOyun = new Scene(yeni);
	    		Stage  window = (Stage)(((Node) event.getSource()).getScene().getWindow());
	    		window.setScene(yeniOyun);
	    		window.show();
	    }

	    @FXML
	    void btn2action(ActionEvent event) throws IOException {
	    	Main.Oyunmodu=2;
	    	Parent yeni = FXMLLoader.load(getClass().getResource("Oyun.fxml"));
	    	Scene yeniOyun = new Scene(yeni);
	    		Stage  window = (Stage)(((Node) event.getSource()).getScene().getWindow());
	    		window.setScene(yeniOyun);
	    		window.show();		
	    }
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
