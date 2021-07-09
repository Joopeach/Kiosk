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
	//���� Ŭ���� ��ü
	private static KitchenDao kitchendao = new KitchenDao();
	
	public static KitchenDao getKitchenDao() {
		return kitchendao;
	}
	
	//��ü �ʱⰪ
	public KitchenDao() {
		//db����
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/kiosk?serverTime=UTC","root","1234");
			System.out.println("DB���� ����");
		} catch (Exception e) {
			e.printStackTrace();
	}

	}
	// Kitchen Order ���̺� ����ϴ� �޼ҵ�
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
			
			return 1; //��ϼ���
			}// try ��
		catch (Exception e) {
			
		} return 0;}// ��Ͽ���
		
		// ��� ��ǰ ��� 
		public ObservableList<Order> allproduct(){
			
			// db���� ã�� ��� ��ǰ�� ������ ����Ʈ 
			ObservableList<Order> products = FXCollections.observableArrayList();
		
			// 1. sql �ۼ�
			String SQL = "select * from kitchen_order";
						// * : ���ϵ�ī�� => ��� �ʵ�
			// 2. sql ����
			try {
				PreparedStatement statement = conn.prepareStatement(SQL);
			// 3. sql ����
				ResultSet resultSet = statement.executeQuery(); // select �˻� => ���� ���� 
			// 4. sql ��� 
					// ��� �ϳ��� ��ǰ�� ��ü �����ؼ� => ����Ʈ�� ��ü �ϳ��� ��� 
			while( resultSet.next() ) {
					// ����� ��ü ���� 
				Order order = new Order( // ����Ŀ�� ����
								resultSet.getInt(1),
								resultSet.getString(2),
								resultSet.getString(3),
								resultSet.getInt(4),
								resultSet.getInt(5),
								resultSet.getString(6));
								
								// ����Ʈ�� ���� 
								products.add(order);
								
							}
							return products;	// ������ ����Ʈ ��ȯ 
						}catch (Exception e) {	}
						return null; // ���н� null
					}
		
		public void orderupdate( Order order ) {
			
			String SQL = "select * from kitchen_order id";
			
		}
		
		
		
		
	}
	
