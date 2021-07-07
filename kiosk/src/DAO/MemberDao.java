package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {
	
	Connection conn;
	private static MemberDao memberdao = new MemberDao();
	
	public static MemberDao getMemberDao() {
		return memberdao;
	}
	
	public MemberDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/kiosk?serverTime=UTC","root","1234");
			System.out.println("DB���� ����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getcheck(String id, String password){
		String sql = "select * from member where id = ? and pw = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("ID : "+id+" PASSWORD : "+password);
				return 1;//�α��μ���
			}else {
				return 2;//���̵� �Ǵ� ��й�ȣ Ȯ��
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;//���� ����
	}
	
	
	
}
