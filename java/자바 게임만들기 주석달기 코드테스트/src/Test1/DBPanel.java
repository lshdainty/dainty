package Test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DBPanel {
	
	//싱글톤 생성 시작
	private static DBPanel instance = new DBPanel();
	public static DBPanel getInstance() {
		return instance;
	}
	private DBPanel() {};
	
	//연결
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("드라이버 적재 성공");
		} catch (ClassNotFoundException e1) {
			System.out.println("드라이버 적재 실패");
		}	//드라이버 적재
		
		// 2. 데이터베이스 연결
		///*
		String url ="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id = "study";
		String pw = "study";
		//*/
		
		/*
		String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "study";
		String pw = "study";
		*/
		
		/*
		String url = "jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String id = "s1501205";
		String pw = "p1501205";
		*/
		
		try {
			conn = DriverManager.getConnection(url, id, pw);
			//System.out.println("데이터베이스 연결 성공.");
		} catch (SQLException e) {
			System.out.println("데이터 베이스 연결에 실패하였습니다..");
		}
		return conn;
	}
	
	//회원가입
	public void insertmember(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into game values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "회원가입을 완료하였습니다.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "회원가입에 문제가 있습니다.");
		}finally {
			if(pstmt!=null) {
				try {pstmt.close();} catch (SQLException e) {}
			}
			if(conn != null) {
				try {conn.close();} catch (SQLException e) {}
			}
		}
	}
	
	//게임 로그 기록
	public void insertLog(String id, int count, String show_time) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into game_log(id,count,time) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, count);
			pstmt.setString(3, show_time);
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "기록을 완료하였습니다.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "기록에 실패하였습니다.");
		}finally {
			if(pstmt!=null) {
				try {pstmt.close();} catch (SQLException e) {}
			}
			if(conn != null) {
				try {conn.close();} catch (SQLException e) {}
			}
		}
	}
	
	//게임 로그 가져오기
	public ArrayList<DBData> selectLog(String id){
		ArrayList<DBData> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			list = new ArrayList<>();
			
			String sql = "select * from game_log where id = ? order by insert_time";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DBData d = new DBData();
				d.setId(rs.getString("id"));
				d.setCount(rs.getInt("count"));
				d.setTime(rs.getString("time"));
				d.setInsertTime(rs.getTimestamp("insert_time"));
				list.add(d);
			}
		}catch(Exception e) {
			System.out.println("로그를 불러오지 못했습니다.");
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
		return list;
	}
	
	public int userCheck(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		
		try{
			conn = getConnection();
			String sql = "select * from game where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = 1;
			}
			else {
				num = 0;
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
	
	//회원조회
	public int select(String id,String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		
		try{
			conn = getConnection();
			String sql = "select * from game where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbpw = rs.getString("passwd");
				if(pw.equals(dbpw)) {
					num = 1;	//아이디,비번 성공
				}
				else {
					num = 0;	//비번틀림
				}
			}
			else {
				num = -1;	//아이디 존재x
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
