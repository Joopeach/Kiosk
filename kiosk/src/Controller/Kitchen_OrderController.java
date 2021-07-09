package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DAO.KitchenDao;
import domain.Order;
import domain.Product;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class Kitchen_OrderController implements Initializable { // ������ �ֹ濡�� ���� â

	@FXML
    private TableView<Order> tableview;
			// < ? > : ���̺� ���� ��ü�� Ŭ���� 
			// ���̺� ���� : ObserbleList

    @FXML
    private Button btnback;

    @FXML
    private Label lblorder;

    @FXML
    void back(ActionEvent event) { // ����ȭ�� ��ư ������ ��
    	try {
    		Parent parent = FXMLLoader.load(getClass().getResource("FXML/admin.fxml"));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	
    }

//    @FXML
//    public void order(MouseEvent event) { // ���̺��� ���콺 Ŭ�� ���� ��
//    	tableview.setOnMouseClicked( ( MouseEvent event) -> { 
//    	if(click>0) {
//    		Alert alert = new Alert( AlertType.INFORMATION);
//    		alert.setContentText(" �ֹ��� �����ðڽ��ϱ�? ");
//    		alert.setHeaderText("�ֹ� ���� �Ϸ�");
//    		alert.showAndWait(); // Ȯ�� ��ư ������������ ������
//    		
//    	} else if(click>1) {
//    		Alert alert = new Alert( AlertType.INFORMATION);
//    		alert.setContentText(" ������ �Ϸ��Ͽ����ϱ�? ");
//    		alert.setHeaderText(" ���� �Ϸ�");
//    		alert.showAndWait(); // Ȯ�� ��ư ������������ ������ 
//    	}
    	

//    }

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { // FXML �ʱⰪ
		
		
		
		
		
		
		
		
		
		// 1. Order ���� ��������
		KitchenDao kitchenDao = KitchenDao.getKitchenDao();
		ObservableList<Order> orders = kitchenDao.allproduct();
		// 2. ��� ��ǰ�� ���̺� ����
					// �� ���� �� ��ü�� �ʵ带 �ֱ� 
		TableColumn tc = tableview.getColumns().get(0);
		tc.setCellValueFactory( new PropertyValueFactory("Onum") );
		
		tc = tableview.getColumns().get(1);
		tc.setCellValueFactory( new PropertyValueFactory("Num") );
		
		tc = tableview.getColumns().get(2);
		tc.setCellValueFactory( new PropertyValueFactory("Pnum") );
		
		tc = tableview.getColumns().get(3);
		tc.setCellValueFactory( new PropertyValueFactory("Oquantity") );
		
		tc = tableview.getColumns().get(4);
		tc.setCellValueFactory( new PropertyValueFactory("Oprice") );
		
		tc = tableview.getColumns().get(5);
		tc.setCellValueFactory( new PropertyValueFactory("Osituation") );
		
		// ���̺� ����Ʈ ��� 
			tableview.setItems(orders);
				
		// ���̺��� ���� Ŭ�������� 
		//tableview.setOnMouseClicked( ( MouseEvent event) -> { �����ڵ� } );
			
		  tableview.setOnMouseClicked( ( MouseEvent event) -> { 
			  
			  Order order = tableview.getSelectionModel().getSelectedItem();
			  	
			  
			  
		  } );
	}
	
}
