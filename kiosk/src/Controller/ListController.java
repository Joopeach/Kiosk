package Controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import DAO.KitchenDao;
import DAO.ProductDao;
import domain.Cart;
import domain.Kitchen_Order;
import domain.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
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
    
    public Kitchen_Order getorder() {
    	return order;
    }
    
    private static Kitchen_Order order;
    
    ProductDao productDao = ProductDao.getProductDao();
	
	ArrayList<Product> products = productDao.allproduct();

    ObservableList<Cart> carts= FXCollections.observableArrayList();
    
    @FXML
    void btn_1(ActionEvent event) {
    	
    	// 리스트 담을 임시 객체 생성
     	Product sproduct = new Product();
    	
    	
    	for( Product product : products ) {
        	
			if( product.getPnum() ==  Integer.parseInt( btn_1.getText() ) ) {
				sproduct = product;
			}
    	}
  	
    	int s = 0 ;	// 스위치
    	
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
    		Cart cart = new Cart(sproduct.getPnum(), sproduct.getPtitle() , count , sproduct.getPprice() * count  );
    		carts.add(cart); 	
    	} ; 

    		// 화면 새로고침
        	loadpage2( "table" ); 	
    	
    }

    @FXML
    void btn_2(ActionEvent event) {
    	
    	// 리스트 담을 임시 객체 생성
     	Product sproduct = new Product();
    	
    	
    	for( Product product : products ) {
        	
			if( product.getPnum() ==  Integer.parseInt( btn_2.getText() ) ) {
				sproduct = product;
			}
    	}
  	
    	int s = 0 ;
    	
    	if(  sproduct.getPnum() == Integer.parseInt( btn_2.getText( ))  ) {
    		
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
    		Cart cart = new Cart(sproduct.getPnum(), sproduct.getPtitle() , count , sproduct.getPprice() * count  );
    		carts.add(cart); 	
    	} ; 

    		// 화면 새로고침
        	loadpage2( "table" );
    	
    }

    @FXML
    void btn_3(ActionEvent event) {

    	// 리스트 담을 임시 객체 생성
     	Product sproduct = new Product();
    	
    	
    	for( Product product : products ) {
        	
			if( product.getPnum() ==  Integer.parseInt( btn_3.getText() ) ) {
				sproduct = product;
			}
    	}
  	
    	int s = 0 ;
    	
    	if(  sproduct.getPnum() == Integer.parseInt( btn_3.getText( ))  ) {
    		
    		for(  int i = 0 ; i<carts.size() ; i++  ) {
    			
    			if( carts.get(i).getTitle().equals(sproduct.getPtitle() ) ) {
    				carts.get(i).setCups( carts.get(i).getCups() + 1  ) ;
    				carts.get(i).setPrice(carts.get(i).getCups() * carts.get(i).getPrice());
    				s = 1;
    				System.out.println( carts.get(i).getCups() );	
    			}
    			
    		}
    	}
    	if( s == 0 ) { 
    		int count = 1;
    		Cart cart = new Cart(sproduct.getPnum(), sproduct.getPtitle() , count , sproduct.getPprice() * count  );
    		carts.add(cart); 	
    	} ; 

    		// 화면 새로고침
        	loadpage2( "table" );
    }
    
    @FXML
    void btn_4(ActionEvent event) {

    	// 리스트 담을 임시 객체 생성
     	Product sproduct = new Product();
    	
    	
    	for( Product product : products ) {
        	
			if( product.getPnum() ==  Integer.parseInt( btn_4.getText() ) ) {
				sproduct = product;
			}
    	}
  	
    	int s = 0 ;
    	
    	if(  sproduct.getPnum() == Integer.parseInt( btn_4.getText( ))  ) {
    		
    		for(  int i = 0 ; i<carts.size() ; i++  ) {
    			
    			if( carts.get(i).getTitle().equals(sproduct.getPtitle() ) ) {
    				carts.get(i).setCups( carts.get(i).getCups() + 1  ) ;
    				carts.get(i).setPrice(carts.get(i).getCups() * carts.get(i).getPrice());
    				s = 1;
    				System.out.println( carts.get(i).getCups() );	
    			}
    			
    		}
    	}
    	if( s == 0 ) { 
    		int count = 1;
    		Cart cart = new Cart(sproduct.getPnum(), sproduct.getPtitle() , count , sproduct.getPprice() * count  );
    		carts.add(cart); 	
    	} ; 

    		// 화면 새로고침
        	loadpage2( "table" );
    }

    @FXML
    void btn_5(ActionEvent event) {

    	// 리스트 담을 임시 객체 생성
     	Product sproduct = new Product();
    	
    	
    	for( Product product : products ) {
        	
			if( product.getPnum() ==  Integer.parseInt( btn_5.getText() ) ) {
				sproduct = product;
			}
    	}
  	
    	int s = 0 ;
    	
    	if(  sproduct.getPnum() == Integer.parseInt( btn_5.getText( ))  ) {
    		
    		for(  int i = 0 ; i<carts.size() ; i++  ) {
    			
    			if( carts.get(i).getTitle().equals(sproduct.getPtitle() ) ) {
    				carts.get(i).setCups( carts.get(i).getCups() + 1  ) ;
    				carts.get(i).setPrice(carts.get(i).getCups() * carts.get(i).getPrice());
    				s = 1;
    				System.out.println( carts.get(i).getCups() );	
    			}
    			
    		}
    	}
    	if( s == 0 ) { 
    		int count = 1;
    		Cart cart = new Cart(sproduct.getPnum(), sproduct.getPtitle() , count , sproduct.getPprice() * count  );
    		carts.add(cart); 	
    	} ; 

    		// 화면 새로고침
        	loadpage2( "table" );
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

    // 주문완료 버튼 클릭
    @FXML
    void success(ActionEvent event) {
    	    	
    	carts = TableController.getinstance().getcart();
    	
    	// 주문완료 버튼 클릭 => order DB 저장하기
    	for(int i=0; i<carts.size(); i++) {
    		
    		int pnum = carts.get(i).getNum();
    		int oquantity = carts.get(i).getCups();
    		int oprice = carts.get(i).getPrice();
    		
//    		System.out.println(pnum);
//    		System.out.println(oquantity);
//        	System.out.println(oprice);
        	
        	//접수 시간
        	Date date = new Date();
        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
        	String odate = format.format(date);
//        	System.out.println(order.getOtime());
        	
        	Kitchen_Order order = new Kitchen_Order(pnum, 1, oquantity, oprice, odate, "주문 접수");
        	
        	// 임시 객체 생성해 담고
        	ArrayList<Kitchen_Order> orders = new ArrayList<>();
        	orders.add(order);
        	
        	KitchenDao kitchenDao = KitchenDao.getKitchenDao();
        	
        	int result = kitchenDao.addorder(order);
        	
        	if(result == 1) {	// 성공
        		
        		// 화면 전환
        		btnsuccess.getScene().getWindow().hide();
        		
        		try {
		    		Stage stage = new Stage();
		    		Parent parent = FXMLLoader.load(getClass().getResource("/FXML/success.fxml"));
		    		Scene scene = new Scene(parent);
		    		stage.setScene(scene);
		    		stage.setResizable(false);
		    		stage.setTitle("SUCCESS PAGE");
		    		stage.show();
		    		
		    	}catch (Exception e) {
					e.printStackTrace();
				}    	
        	} else {	// 실패
        		
        		System.out.println("db 저장 실패");
        	}
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
		btn_2.setText("2");
		btn_3.setText("3");
		btn_4.setText("4");
		btn_5.setText("5");
		
		// dao 객체 생성
		ProductDao productDao = ProductDao.getProductDao();
		
		// dao 메소드 실행
		ArrayList<Product> products = productDao.allproduct();
		
		try {
			// 각 컨트롤러에 값 넣기
			lbl_1.setText(" KRW : " + products.get(0).getPprice() + "원");
			
			lbl_2.setText(" KRW : " + products.get(1).getPprice() + "원");
			
			lbl_3.setText(" KRW : " + products.get(2).getPprice() + "원");
			
			lbl_4.setText(" KRW : " + products.get(3).getPprice() + "원");
			
			lbl_5.setText(" KRW : " + products.get(4).getPprice() + "원");
			
		}
		catch (Exception e) {
			
		}
	}
	
}
