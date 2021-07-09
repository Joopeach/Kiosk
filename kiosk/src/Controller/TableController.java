package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import domain.Cart;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableController implements Initializable {

	 @FXML
	 private TableView<Cart> tableview;
	 
	 private ObservableList<Cart> carts;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		carts = ListController.getinstance().getcart();
		
		// 제품명
 		TableColumn tc = tableview.getColumns().get(0);
 		tc.setCellValueFactory(new PropertyValueFactory("title"));
    	
    	// 수량
    	tc = tableview.getColumns().get(1);
    	tc.setCellValueFactory(new PropertyValueFactory("cups"));
    	
    	// 가격
    	tc = tableview.getColumns().get(2);
    	tc.setCellValueFactory(new PropertyValueFactory("price"));
    	
    	tableview.setItems(carts);
		
	}
	
}
