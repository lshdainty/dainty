package Test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBPanel {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//연결
	public void connectDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//드라이버 적재
			System.out.println("드라이버 적재 성공.");
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
			return ;
		}
		
		// 2. 데이터베이스 연결
		
		String url ="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id = "study";
		String pw = "study";
		
		/*
		String url = "jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String id = "s1501205";
		String pw = "p1501205";
		*/
		try {
			this.conn = DriverManager.getConnection(url, id, pw);
			System.out.println("데이터베이스 연결 성공.");
		} catch (SQLException e) {
			System.out.println("데이터 베이스 연결에 실패하였습니다..");
			return ;
		}
	}
	
	//회원가입
	public void insertmember(String id, String passwd) {
		try {
			String sql = "insert into game values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "회원가입을 완료하였습니다.");
		} catch (SQLException e) {
			System.out.println("sql실행에 문제가 있습니다.");
		}finally {
			if(pstmt!=null) {
				try {pstmt.close();} catch (SQLException e) {}
			}
			if(conn != null) {
				try {conn.close();} catch (SQLException e) {}
			}
		}
	}
	
	//회원조회
	public int select(String id,String pw) {
		int num = 0;
		try{
			String sql = "select * from game where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbpw = rs.getString("passwd");
				if(pw.equals(dbpw)) {
					num = 1;	//아이디,비번 성공
					JOptionPane.showMessageDialog(null, "로그인 성공");
				}
				else {
					num = 0;	//비번틀림
					JOptionPane.showMessageDialog(null, "비밀번호가 맞지 않습니다.");
				}
			}
			else {
				num = -1;	//아이디 존재x
				JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다.");
			}
		} catch (SQLException e) {
		}finally {
			if(rs!=null) {
				try {rs.close();} catch (SQLException e) {}
			}
			if(pstmt!=null) {
				try {pstmt.close();} catch (SQLException e) {}
			}
			if(conn != null) {
				try {conn.close();} catch (SQLException e) {}
			}
		}
		return num;
	}
}
