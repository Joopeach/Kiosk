package Controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import DAO.ProductDao;
import domain.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class PaddController implements Initializable {
	ProductDao productdao;
	Product product;
	private String pimage;
	
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
    private ImageView pimg;
    
    @FXML
    private Stage filestage;
    

    @FXML
    void image(ActionEvent event) {//이미지 등록버튼
    	
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.getExtensionFilters().addAll(new ExtensionFilter("그림파일 : Image File", "*.png", "*.jpg"));
    	File file = fileChooser.showOpenDialog(filestage);
    	if(file != null) {
    		pimage = file.toURI().toString();
    		Image image = new Image(file.toURI().toString());
    		pimg.setImage(image);
    		
    	}

    }

    @FXML
    void upload(ActionEvent event) {//메뉴 등록버튼
    	int pnum = Integer.parseInt(txtpnum.getText());
    	String ptitle = txtptitle.getText();
    	String pcontents = txtpcontents.getText();
    	int pprice = Integer.parseInt(txtpprice.getText());
    	String pstock = txtpstock.getText();
    	
    	if(pstock.equals("")) {
    		product = new Product(pnum, ptitle, pcontents, pprice, pimage);
    		productdao = ProductDao.getProductDao();
    		productdao.coffeeadd(product);
    		System.out.println("음료 등록 완료");
    		
    	}else {
    		product = new Product(pnum, ptitle, pcontents, pprice,Integer.parseInt(pstock), pimage);
    		productdao = ProductDao.getProductDao();
    		productdao.bakeryadd(product);
    		System.out.println("베이커리 등록 완료");
    	}

    }

}
