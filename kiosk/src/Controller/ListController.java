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
    	
    	if(btn_1.getText().equals("�Ƹ޸�ī��")) {
    		
     		System.out.println("�Ƹ޸�ī�� ��ư Ŭ��");
     		
     		// ����Ʈ ���� �ӽ� ��ü ����
	
     		carts.add(cart);
     		
     		// Ȯ�ο�
//     		System.out.println(carts.get(0).getTitle());
//     		System.out.println(carts.get(0).getCups());
//     		System.out.println(carts.get(0).getPrice());	
     		
     		// ��ǰ��
     		TableColumn tc = tableview.getColumns().get(0);
     		tc.setCellValueFactory(new PropertyValueFactory("title"));
        	
        	// ����
        	tc = tableview.getColumns().get(1);
        	tc.setCellValueFactory(new PropertyValueFactory("cups"));
        	
        	// ����
        	tc = tableview.getColumns().get(2);
        	tc.setCellValueFactory(new PropertyValueFactory("price"));
        	
        	tableview.setItems(carts);
        	
    	}
    	
    	// tableview�� ������ cups �� 1�� ����
     	if(tableview.getColumns().get(0).equals("�Ƹ޸�ī��")) {
     		System.out.println("�Ƹ޸�ī�� ����");	
     		
     		// ���� ���� 
     		cart.setCups(cart.getCups() +1);
     		
     		//tableview ���ΰ�ħ => ȭ����ȯ
     			
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
    	
    	// ȭ�� ��ȯ
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

    	// ȭ�� ��ȯ
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
    
    // ������ �̵� �޼ҵ�
    public void loadpage(String page) {
    	
    	try {
    		Parent parent = FXMLLoader.load(getClass().getResource("/FXML/" + page + ".fxml"));
    		
    		borderpane.setTop(parent);
    		
    	}catch (Exception e) {
    		
		}
    	
    }
	    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// dao ��ü ����
		ProductDao productDao = ProductDao.getProductDao();
		
		// dao �޼ҵ� ����
		ArrayList<Product> products = productDao.allproduct();
		
		try {
			// �� ��Ʈ�ѷ��� �� �ֱ�
	//		System.out.println(products.get(0).getPtitle());
			btn_1.setText(products.get(0).getPtitle());
			lbl_1.setText(" KRW : " + products.get(0).getPprice() + "��");
			
			btn_2.setText(products.get(1).getPtitle());
			lbl_2.setText(" KRW : " + products.get(1).getPprice() + "��");
			
			btn_3.setText(products.get(2).getPtitle());
			lbl_3.setText(" KRW : " + products.get(2).getPprice() + "��");
			
			btn_4.setText(products.get(3).getPtitle());
			lbl_4.setText(" KRW : " + products.get(3).getPprice() + "��");
			
			btn_5.setText(products.get(4).getPtitle());
			lbl_5.setText(" KRW : " + products.get(4).getPprice() + "��");
			
		}
		catch (Exception e) {
			
		}
	}
	
}
