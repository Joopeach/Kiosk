package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AdminController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	
    @FXML
    private Button btnlogin;

    @FXML
    private TextField txtid;

    @FXML
    private PasswordField txtpw;
	
	@FXML
    void login(ActionEvent event) {
		System.out.println("아이디 : " + txtid.getText() + ", 비밀번호 : " + txtpw.getText());
    	MemberDao memberdao = MemberDao.getMemberDao();
    	int result = memberdao.getcheck(txtid.getText(), txtpw.getText());
    	if(result == 1) {//로그인 성공하여 메뉴등록화면으로
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("로그인 성공");
    		alert.setContentText("메뉴등록화면으로 돌아갑니다");
    		alert.showAndWait();    		
    		
    	}else {//아이디와 비밀번호 확인 또는 오류
    		System.out.println("오류");
    	}
    	
    	
    }

}
