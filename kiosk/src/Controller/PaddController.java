package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PaddController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	
    @FXML
    private Button btnupload;

    @FXML
    private TextField txtpnum;

    @FXML
    private TextField txtptitle;

    @FXML
    private TextField txtpcontents;

    @FXML
    private TextField txtpprice;

    @FXML
    private TextField txtpstock;

    @FXML
    private Button btnimage;

    @FXML
    void image(ActionEvent event) {

    }

    @FXML
    void upload(ActionEvent event) {

    }

}
