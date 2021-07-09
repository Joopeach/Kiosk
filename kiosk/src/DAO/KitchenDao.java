package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.Kitchen_Order;
import domain.Order;
import domain.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KitchenDao {
	
	Connection conn;
	//현재 클래스 객체
	private static KitchenDao kitchendao = new KitchenDao();
	
	public static KitchenDao getKitchenDao() {
		return kitchendao;
	}
	
	//객체 초기값
	public KitchenDao() {
		//db연동
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/kiosk?serverTime=UTC","root","1234");
			System.out.println("DB연동 성공");
		} catch (Exception e) {
			e.printStackTrace();
	}

	}
	// Kitchen Order 테이블에 등록하는 메소드
	public int ordercheck(Kitchen_Order kitchen_Order) {
		String sql = "insert into kitchenorder(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,kitchen_Order.getOnum());
			pstmt.setInt(2,kitchen_Order.getNum());
			pstmt.setInt(3,kitchen_Order.getPnum());
			pstmt.setInt(4,kitchen_Order.getOquantity());
			pstmt.setInt(5,kitchen_Order.getOprice());
			pstmt.setString(6,kitchen_Order.getOsituation());
			
			
			pstmt.executeUpdate();
			
			return 1; //등록성공
			}// try 끝
		catch (Exception e) {
			
		} return 0;}// 등록오류
		
		// 모든 제품 출력 
		public ObservableList<Order> allproduct(){
			
			// db에서 찾은 모든 제품을 저장할 리스트 
			ObservableList<Order> products = FXCollections.observableArrayList();
		
			// 1. sql 작성
			String SQL = "select * from kitchen_order";
						// * : 와일드카드 => 모든 필드
			// 2. sql 조작
			try {
				PreparedStatement statement = conn.prepareStatement(SQL);
			// 3. sql 실행
				ResultSet resultSet = statement.executeQuery(); // select 검색 => 쿼리 실행 
			// 4. sql 결과 
					// 결과 하나씩 제품의 객체 생성해서 => 리스트에 객체 하나씩 담기 
			while( resultSet.next() ) {
					// 결과의 객체 생성 
				Order order = new Order( // 베이커리 먼저
								resultSet.getInt(1),
								resultSet.getString(2),
								resultSet.getString(3),
								resultSet.getInt(4),
								resultSet.getInt(5),
								resultSet.getString(6));
								
								// 리스트에 저장 
								products.add(order);
								
							}
							return products;	// 성공시 리스트 반환 
						}catch (Exception e) {	}
						return null; // 실패시 null
					}
		
		public void orderupdate( Order order ) {
			
			String SQL = "select * from kitchen_order id";
			
		}
		
		
		
		
	}
	
