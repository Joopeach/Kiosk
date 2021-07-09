package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.MemberDao;
import domain.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

public class JoinController implements Initializable {
	
	Member member;
	MemberDao dao;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
    @FXML
    private TextField txtnum;

    @FXML
    private Button btnjoin;

    @FXML
    private PasswordField txtpw;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtphone;

    @FXML
    void join(ActionEvent event) {
    	int num = Integer.parseInt(txtnum.getText());
    	String id = txtid.getText();
    	String pw = txtpw.getText();
    	String name = txtname.getText();
    	String email = txtemail.getText();
    	String phone = txtphone.getText();
    	
//    	System.out.println("회원번호 : " + num );
//    	System.out.println("id : " + id );
//    	System.out.println("pw : " + pw );
//    	System.out.println("name : " + name );
//    	System.out.println("email : " + email );
//    	System.out.println("phone : " + phone );
    

    	member = new Member(num, id, pw, name, email, phone);
    	dao = MemberDao.getMemberDao();
    	int result = dao.joinin(member); 
    	if(result == 1) {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setContentText("등록성공");
    		alert.showAndWait();
    		try {
    			Parent parent = FXMLLoader.load(getClass().getResource("/FXML/main.fxml"));
    			
    			Scene scene = new Scene(parent);
    			Stage stage = new Stage();
    			stage.setScene(scene);
    			
    			stage.setResizable(false); // stage 크기 고정 
    			stage.setTitle("MAIN PAGE"); // stage 상단 이름 

    			stage.show();
    			
    		} catch(Exception e) {
    			e.printStackTrace();
    		} 	
    	}else if(result == 2) {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setContentText("중복 아이디가 있습니다");
    		alert.showAndWait();
    	}
    	}

    }

	


