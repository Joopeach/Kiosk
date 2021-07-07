package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/FXML/main.fxml"));
			
			Scene scene = new Scene(parent);
			
			stage.setScene(scene);
			
			stage.setResizable(false); // stage ũ�� ���� 
			stage.setTitle("MAIN PAGE"); // stage ��� �̸� 

			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
