package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController implements Initializable {
	
	@FXML
	private AnchorPane anchorpane;

	@FXML
    private ImageView image1;

    @FXML
    private Label lblchoice;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private Button btncoffee;

    @FXML
    private Button btnadmin;

    @FXML
    void admin(ActionEvent event) {
    	
    }

    @FXML
    void adminlogin(MouseEvent event) {

    }
    
    @FXML
    void coffee(ActionEvent event) {

    	try {
    		Stage stage = new Stage();
    		Parent parent = FXMLLoader.load(getClass().getResource("/FXML/list.fxml"));
    		Scene scene = new Scene(parent);
    		stage.setScene(scene);
    		stage.setResizable(false);
    		stage.setTitle("COFFEE PAGE");
    		stage.show();
    		
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
	
    // �ʱⰪ
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
}
