package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DAO.ProductDao;
import domain.Product;
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
    private Button btn_3;

    @FXML
    private Button btn_2;

    @FXML
    private Label lbl_1;

    @FXML
    private Label lbl_3;

    @FXML
    private Label lbl_2;

    @FXML
    private TableView<Product> tableview;

    @FXML
    private Button btncancel;

    @FXML
    private Button btnsuccess;
    
    @FXML
    void btn_1(ActionEvent event) {

    	ProductDao productDao = ProductDao.getProductDao();
    	
    	ObservableList<Product> products = productDao.allproduct();
    	
    	// 제품명
    	TableColumn tc = tableview.getColumns().get(0);
    	tc.setCellValueFactory(new PropertyValueFactory("ptitle"));
//    	tc.setText(products.get(1).getPtitle());
    	
    	// 수량
    	tc = tableview.getColumns().get(1);
    	tc.setCellValueFactory(new PropertyValueFactory("pstock"));
    	
    	// 가격
    	tc = tableview.getColumns().get(2);
    	tc.setCellValueFactory(new PropertyValueFactory("pprice"));
    	
    	tableview.setItems(products);
  
    }

    @FXML
    void btn_2(ActionEvent event) {
    	
    }

    @FXML
    void btn_3(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {

    	
    }

    @FXML
    void success(ActionEvent event) {

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
		ObservableList<Product> products = productDao.allproduct();
		
		// 각 컨트롤러에 값 넣기
//		System.out.println(products.get(0).getPtitle());
		btn_1.setText(products.get(0).getPtitle());
		lbl_1.setText(" KRW : " + products.get(0).getPprice() + "원");
		
		btn_2.setText(products.get(1).getPtitle());
		lbl_2.setText(" KRW : " + products.get(1).getPprice() + "원");
		
		btn_3.setText(products.get(2).getPtitle());
		lbl_3.setText(" KRW : " + products.get(2).getPprice() + "원");
		
	}
	
}
