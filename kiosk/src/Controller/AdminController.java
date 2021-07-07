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
		System.out.println("���̵� : " + txtid.getText() + ", ��й�ȣ : " + txtpw.getText());
    	MemberDao memberdao = MemberDao.getMemberDao();
    	int result = memberdao.getcheck(txtid.getText(), txtpw.getText());
    	if(result == 1) {//�α��� �����Ͽ� �޴����ȭ������
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("�α��� ����");
    		alert.setContentText("�޴����ȭ������ ���ư��ϴ�");
    		alert.showAndWait();    		
    		
    	}else {//���̵�� ��й�ȣ Ȯ�� �Ǵ� ����
    		System.out.println("����");
    	}
    	
    	
    }

}
