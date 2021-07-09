package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.Member;

public class MemberDao {
	
	Connection conn;
	private static MemberDao memberdao = new MemberDao();
	
	public static MemberDao getMemberDao() {
		return memberdao;
	}
	
	public MemberDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/kiosk?serverTime=UTC","root","971130");
			System.out.println("DB연동 성공");
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
				return 1;//로그인성공
			}else {
				return 2;//아이디 또는 비밀번호 확인
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;//검증 실패
	}
	
	public int joinin(Member member) {
		
		//중복회원 검증
			String sql1 = "select * from member where id = ? ";
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql1);
					pstmt.setString(1, member.getId());
					
					ResultSet rs = pstmt.executeQuery();
					
					if(rs.next()) {
						return 2;//중복회원
					}else {
						String sql = "insert into member values(?,?,?,?,?,?)";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, member.getNum());
						pstmt.setString(2, member.getId());
						pstmt.setString(3, member.getPw());
						pstmt.setString(4, member.getName());
						pstmt.setString(5, member.getEmail());
						pstmt.setString(6, member.getPhone());
						
						pstmt.executeUpdate();
						
						return 1;//등록성공
					}
				}catch (Exception e) {
					// TODO: handle exception
				}
				
				return 0;//디비오류
		
		
		
		
//		String sql = "insert into member values(?,?,?,?,?,?)";
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, member.getNum());
//			pstmt.setString(2, member.getId());
//			pstmt.setString(3, member.getPw());
//			pstmt.setString(4, member.getName());
//			pstmt.setString(5, member.getEmail());
//			pstmt.setString(6, member.getPhone());
//			
//			pstmt.executeUpdate();
//			
//			return 1;//등록성공
//			
//		}catch (Exception e) {
//			// TODO: handle exception
//		}		
//		return 0;//오류 
	}
}
