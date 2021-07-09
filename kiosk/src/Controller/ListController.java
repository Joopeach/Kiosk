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
    private Button btncancel;

    @FXML
    private Button btnsuccess;
    
    private static ListController instance;
    
    public ListController() {
		instance = this;
	}
    
    public static ListController getinstance() {
    	
		return instance;
    }
    
    public ObservableList<Cart> getcart() {
		return carts;
	}
    
    

    ObservableList<Cart> carts= FXCollections.observableArrayList();
    
    @FXML
    void btn_1(ActionEvent event) {
    	
    	ProductDao productDao = ProductDao.getProductDao();
    	
    	ArrayList<Product> products = productDao.allproduct();
    	
    	// 리스트 담을 임시 객체 생성
     	Product sproduct = new Product();
    	
    	
    	for( Product product : products ) {
        	
			if( product.getPnum() ==  Integer.parseInt( btn_1.getText() ) ) {
				sproduct = product;
			}
    	}
  	
    	int s = 0 ;
    	
    	if(  sproduct.getPnum() == Integer.parseInt( btn_1.getText( ))  ) {
    		
    		for(  int i = 0 ; i<carts.size() ; i++  ) {
    			
    			if( carts.get(i).getTitle().equals(sproduct.getPtitle() ) ) {
    				carts.get(i).setCups( carts.get(i).getCups() + 1  ) ;
    				carts.get(i).setPrice(carts.get(i).getCups() * carts.get(i).getPrice());
    				s = 1;
    				System.out.println(     carts.get(i).getCups() );	
    			}
    			
    		}
    	}
    	if( s == 0 ) { 
    		int count = 1;
    		Cart cart = new Cart(sproduct.getPtitle() , count , sproduct.getPprice() * count  );
    		carts.add(cart); 	
    	} ; 

    		// 화면 새로고침
        	loadpage2( "table" ); 	
    	
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
    
    // 테이블뷰 이동 메소드
    public void loadpage2(String page) {
    	
    	try {
    		Parent parent = FXMLLoader.load(getClass().getResource("/FXML/" + page + ".fxml"));
    		
    		borderpane.setCenter(parent);
    		
    	}catch (Exception e) {
    		
		}
    	
    }
	    
	    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		btn_1.setText("1");
		
		// dao 객체 생성
		ProductDao productDao = ProductDao.getProductDao();
		
		// dao 메소드 실행
		ArrayList<Product> products = productDao.allproduct();
		
		try {
			// 각 컨트롤러에 값 넣기
	//		System.out.println(products.get(0).getPtitle());
			//btn_1.setText(products.get(0).getPtitle());
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
