package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DAO.ProductDao;
import domain.Cart;
import domain.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ListController implements Initializable {

	@FXML
    private BorderPane borderpane;

    @FXML
    private AnchorPane cp;

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;
    
    @FXML
    private Button btn_4;

    @FXML
    private Button btn_5;

    @FXML
    private Label lbl_1;

    @FXML
    private Label lbl_2;

    @FXML
    private Label lbl_3;
    
    @FXML
    private Label lbl_4;

    @FXML
    private Label lbl_5;

    @FXML
    private TableView<Cart> tableview;

    @FXML
    private Button btncancel;

    @FXML
    private Button btnsuccess;

    
    @FXML
    void btn_1(ActionEvent event) {
    	
    	ProductDao productDao = ProductDao.getProductDao();
    	
    	ArrayList<Product> products = productDao.allproduct();
    	
    	ObservableList<Cart> carts = FXCollections.observableArrayList();
    	
    	Cart cart = new Cart(products.get(0).getPtitle(), 1, products.get(0).getPprice());
    	
    	if(btn_1.getText().equals("아메리카노")) {
    		
     		System.out.println("아메리카노 버튼 클릭");
     		
     		// 리스트 담을 임시 객체 생성
	
     		carts.add(cart);
     		
     		// 확인용
//     		System.out.println(carts.get(0).getTitle());
//     		System.out.println(carts.get(0).getCups());
//     		System.out.println(carts.get(0).getPrice());	
     		
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
    	
    	// tableview에 있으면 cups 수 1씩 증가
     	if(tableview.getColumns().get(0).equals("아메리카노")) {
     		System.out.println("아메리카노 있음");	
     		
     		// 수량 증가 
     		cart.setCups(cart.getCups() +1);
     		
     		//tableview 새로고침 => 화면전환
     			
     	}
    	
    }

    @FXML
    void btn_2(ActionEvent event) {
    	
    }

    @FXML
    void btn_3(ActionEvent event) {

    }
    
    @FXML
    void btn_4(ActionEvent event) {

    }

    @FXML
    void btn_5(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {
    	
    	// 화면 전환
    	btncancel.getScene().getWindow().hide();

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

    @FXML
    void success(ActionEvent event) {

    	// 화면 전환
    	btnsuccess.getScene().getWindow().hide();

    	try {
    		Stage stage = new Stage();
    		Parent parent = FXMLLoader.load(getClass().getResource("/FXML/success.fxml"));
    		Scene scene = new Scene(parent);
    		stage.setResizable(false);
    		stage.setTitle("SUCCESS PAGE");
    		stage.show();
    		
    	}catch (Exception e) {
			
		}    	
    }
    
    // 페이지 이동 메소드
    public void loadpage(String page) {
    	
    	try {
    		Parent parent = FXMLLoader.load(getClass().getResource("/FXML/" + page + ".fxml"));
    		
    		borderpane.setTop(parent);
    		
    	}catch (Exception e) {
    		
		}
    	
    }
	    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// dao 객체 생성
		ProductDao productDao = ProductDao.getProductDao();
		
		// dao 메소드 실행
		ArrayList<Product> products = productDao.allproduct();
		
		try {
			// 각 컨트롤러에 값 넣기
	//		System.out.println(products.get(0).getPtitle());
			btn_1.setText(products.get(0).getPtitle());
			lbl_1.setText(" KRW : " + products.get(0).getPprice() + "원");
			
			btn_2.setText(products.get(1).getPtitle());
			lbl_2.setText(" KRW : " + products.get(1).getPprice() + "원");
			
			btn_3.setText(products.get(2).getPtitle());
			lbl_3.setText(" KRW : " + products.get(2).getPprice() + "원");
			
			btn_4.setText(products.get(3).getPtitle());
			lbl_4.setText(" KRW : " + products.get(3).getPprice() + "원");
			
			btn_5.setText(products.get(4).getPtitle());
			lbl_5.setText(" KRW : " + products.get(4).getPprice() + "원");
			
		}
		catch (Exception e) {
			
		}
	}
	
}
