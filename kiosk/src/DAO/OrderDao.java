package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class OrderDao {
	
	Connection conn;
	private static OrderDao orderdao = new OrderDao();
	
	public static OrderDao getOrderDao() {
		return orderdao;
	}
	
	public OrderDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/kiosk?serverTime=UTC","root","971130");
			System.out.println("DB연동 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
