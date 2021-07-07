package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import domain.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductDao {

	Connection conn;
	
	// ���� Ŭ���� ��ü 
	private static ProductDao productDao = new ProductDao();
	
	public static ProductDao getProductDao() {
		return productDao;
	}
	
	// ��ü�� �ʱⰪ
	public ProductDao() {
		
		// db ����
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/kiosk?serverTime=UTC", "root", "1234");
			
			System.out.println("ProductDao ����");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//����Ŀ�� �޴� ����ϴ� �޼ҵ�
	   public int bakeryadd(Product product){
	      
	      String sql = "insert into product values (?,?,?,?,?,?)";
	      try {
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, product.getPnum());
	         pstmt.setString(2, product.getPtitle());
	         pstmt.setString(3, product.getPcontents());
	         pstmt.setInt(4, product.getPprice());
	         pstmt.setInt(5, product.getPstock());
	         pstmt.setString(6, product.getPimage());
	         
	         pstmt.executeUpdate();
	         
	         return 1;//��ϼ���
	         
	         }catch (Exception e) {
	            // TODO: handle exception
	         }
	      
	      return 0;//��Ͻ���
	      
	      
	   }
	   
	   //���� �޴� �߰��޼ҵ�
	   public int coffeeadd(Product product){
	      
	      String sql = "insert into product(pnum, ptitle, pcontents, pprice, pimage) values (?,?,?,?,?)";
	      try {
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, product.getPnum());
	         pstmt.setString(2, product.getPtitle());
	         pstmt.setString(3, product.getPcontents());
	         pstmt.setInt(4, product.getPprice());
	         pstmt.setString(5, product.getPimage());
	         
	         pstmt.executeUpdate();
	         
	         return 1;//��ϼ���
	         
	         }catch (Exception e) {
	            // TODO: handle exception
	         }
	      
	      return 0;//��Ͻ���   
	      
	   }   
	
	// ��� ��ǰ ����ϱ�
	public ObservableList<Product> allproduct() {
		
		ObservableList<Product> products = FXCollections.observableArrayList();
		
		String SQL = "select * from product";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				
				Product product = new Product(
						resultSet.getInt(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getInt(4), 
						resultSet.getInt(5), 
						resultSet.getString(6));
				
				// ����Ʈ�� ����
				products.add(product);
			}
			return products;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	// ���õ� ��ư�� ���� ����ϱ�
	public Product getproduct(String select) {
		
		Product product = new Product();
		
		String SQL = "select * from product where ptitle=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, select);
			
			ResultSet resultSet = pstmt.executeQuery();
			
			if(resultSet.next()) {
				
				product.setPnum(resultSet.getInt(1));
				product.setPtitle(resultSet.getString(2));
				product.setPcontents(resultSet.getString(3));
				product.setPprice(resultSet.getInt(4));
				product.setPstock(resultSet.getInt(5));
				
				return product;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
}
