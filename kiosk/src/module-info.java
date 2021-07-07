module kiosk {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml, javafx.controls;
	opens Controller to javafx.graphics, javafx.fxml, javafx.controls;
	opens domain to javafx.base;
	opens DAO to java.sql;
}
