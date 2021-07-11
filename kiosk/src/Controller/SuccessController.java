package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import domain.Kitchen_Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SuccessController implements Initializable {
	
	    @FXML
	    private Button btncheck;

	    @FXML
	    void check(ActionEvent event) {

	    	btncheck.getScene().getWindow().hide();
	    	
	    	try {
	    		Stage stage = new Stage();
	    		Parent parent = FXMLLoader.load(getClass().getResource("/FXML/main.fxml"));
	    		Scene scene = new Scene(parent);
	    		stage.setScene(scene);
	    		stage.setResizable(false);
	    		stage.setTitle("MAIN PAGE");
	    		stage.show();
	    		
	    	}catch (Exception e) {
				
			}    	
	    	
	    }
	
	// �ʱⰪ
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
}
