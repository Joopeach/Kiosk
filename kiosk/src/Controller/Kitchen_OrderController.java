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

public class Kitchen_OrderController implements Initializable { // 직원이 주방에서 보는 창

	@FXML
    private TableView<Order> tableview;
			// < ? > : 테이블에 넣을 객체의 클래스 
			// 테이블 저장 : ObserbleList

    @FXML
    private Button btnback;

    @FXML
    private Label lblorder;

    @FXML
    void back(ActionEvent event) { // 이전화면 버튼 눌렀을 때
    	try {
    		Parent parent = FXMLLoader.load(getClass().getResource("FXML/admin.fxml"));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	
    }

//    @FXML
//    public void order(MouseEvent event) { // 테이블을 마우스 클릭 했을 때
//    	tableview.setOnMouseClicked( ( MouseEvent event) -> { 
//    	if(click>0) {
//    		Alert alert = new Alert( AlertType.INFORMATION);
//    		alert.setContentText(" 주문을 받으시겠습니까? ");
//    		alert.setHeaderText("주문 접수 완료");
//    		alert.showAndWait(); // 확인 버튼 누르기전까지 대기상태
//    		
//    	} else if(click>1) {
//    		Alert alert = new Alert( AlertType.INFORMATION);
//    		alert.setContentText(" 조리를 완료하였습니까? ");
//    		alert.setHeaderText(" 조리 완료");
//    		alert.showAndWait(); // 확인 버튼 누르기전까지 대기상태 
//    	}
    	

//    }

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { // FXML 초기값
		
		
		
		
		
		
		
		
		
		// 1. Order 에서 가져오기
		KitchenDao kitchenDao = KitchenDao.getKitchenDao();
		ObservableList<Order> orders = kitchenDao.allproduct();
		// 2. 모든 제품을 테이블에 셋팅
					// 각 열에 각 객체의 필드를 넣기 
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
		
		// 테이블에 리스트 담기 
			tableview.setItems(orders);
				
		// 테이블에서 행을 클릭했을때 
		//tableview.setOnMouseClicked( ( MouseEvent event) -> { 실행코드 } );
			
		  tableview.setOnMouseClicked( ( MouseEvent event) -> { 
			  
			  Order order = tableview.getSelectionModel().getSelectedItem();
			  	
			  
			  
		  } );
	}
	
}
