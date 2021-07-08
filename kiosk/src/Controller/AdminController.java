package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

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
    private Button btnjoin;

    @FXML
    void join(ActionEvent event) {//ȸ�����
    	
    	try {
        	Parent parent = FXMLLoader.load(getClass().getResource("/FXML/join.fxml"));
        	Scene scene = new Scene(parent);
        	Stage stage = new Stage();
        	stage.setScene(scene);
        	stage.setResizable(false);
        	stage.setTitle("ȸ�����");
        	stage.show();        	
        }
        	catch(Exception e) {
        		e.printStackTrace();
        	} 
    	
    	

    }

	
	@FXML
    void login(ActionEvent event) {
		System.out.println("���̵� : " + txtid.getText() + ", ��й�ȣ : " + txtpw.getText());
    	MemberDao memberdao = MemberDao.getMemberDao();
    	int result = memberdao.getcheck(txtid.getText(), txtpw.getText());
    	if(result == 1) {//�α��� �����Ͽ� �޴����ȭ������
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("�α��� ����");
    		alert.setContentText("�޴����ȭ������ ���ư��ϴ�");
    		alert.showAndWait();  
    		try {
            	Parent parent = FXMLLoader.load(getClass().getResource("/FXML/padd.fxml"));
            	Scene scene = new Scene(parent);
            	Stage stage = new Stage();
            	stage.setScene(scene);
            	stage.setResizable(false);
            	stage.setTitle("�޴� ���");
            	stage.show();        	
            }
            	catch(Exception e) {
            		e.printStackTrace();
            	} 	
    	}else {//���̵�� ��й�ȣ Ȯ�� �Ǵ� ����
    		System.out.println("������ ����޴��Դϴ�");
    	}
    	
    	
    }

}
