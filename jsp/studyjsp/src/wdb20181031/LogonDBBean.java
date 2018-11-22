package wdb20181031;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

public class LogonDBBean {
	
	//싱글턴 생성 시작
	private static LogonDBBean instance = new LogonDBBean();
	
	public static LogonDBBean getInstance() {	//db를 처리하는 것은 싱글턴이다.?
		return instance;
	}
	
	private LogonDBBean() {};
	//싱글턴 생성 끝
	
	//커넥션 풀 생성 시작
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/TestDB");
		return ds.getConnection();
	}
	//커넥션 풀 생성 끝
	
	//회원가입 insert하기 시작
	public void insertMember(LogonDataBean member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String orgPass = member.getPasswd();
			
			String sql = "insert into member1 values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,member.getId());
			pstmt.setString(2,orgPass);
			pstmt.setString(3,member.getName());
			pstmt.setTimestamp(4,member.getReg_date());
			pstmt.setString(5,member.getAddress());
			pstmt.setString(6,member.getTel());
			pstmt.executeUpdate();
		}catch(Exception e) {
			
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e) {
					
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception e) {
					
				}
			}
		}
	}
	//회원가입 insert하기 끝
	
	//로그인 체크 시작
	public int userCheck(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			
			String sql = "select passwd from member1 where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpasswd = rs.getString("passwd");
				if(dbpasswd.equals(passwd)) {
					x=1;	//인증 성공	아이디도 있고 비번 맞음
				}
				else {
					x=0;	//인증 실패	아이디는 있으나 비번 틀림
				}
			}
			else {
				x=-1;	//아이디가 없음
			}
		}catch(Exception e) {
			
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(Exception e) {
					
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e) {
					
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception e) {
					
				}
			}
		}
		return x;
	}
	//로그인 체크 끝
	
	//아이디 중복 확인 시작
	public int confirmId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			
			String sql = "select id from member1 where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x=1;	//아이디가 존재하여 가입 불가
			}
			else {
				x=-1;	//아이디가 존재하지 않아 가입 가능
			}
		}catch(Exception e) {
			
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(Exception e) {
					
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e) {
					
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception e) {
					
				}
			}
		}
		
		return x;
	}
	//아이디 중복 확인 끝
	
	//회원 정보 수정을 위한 데이터 가져오기 select 끝
	public LogonDataBean getMember(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LogonDataBean member = null;
		
		try {
			conn = getConnection();
			
			String sql = "select * from member1 where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpasswd = rs.getString("passwd");
				if(dbpasswd.equals(passwd)) {
					member = new LogonDataBean();
					member.setId(rs.getString("id"));
					member.setName(rs.getString("name"));
					member.setReg_date(rs.getTimestamp("reg_date"));
					member.setAddress(rs.getString("address"));
					member.setTel(rs.getString("tel"));
				}
			}
		}catch(Exception e) {
			
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(Exception e) {
					
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e) {
					
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception e) {
					
				}
			}
		}
		
		return member;
	}
	//회원 정보 수정을 위한 데이터 가져오기 select 끝
	
	//회원 정보 수정 처리 update 시작
	public int updateMember(LogonDataBean member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x=-1;
		
		try {
			conn = getConnection();
			
			String passwd = member.getPasswd();
			
			String sql = "select passwd from member1 where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpasswd = rs.getString("passwd");
				if(dbpasswd.equals(passwd)) {
					String sql1 = "update member1 set name=?,address=?,tel=? where id=?";
					pstmt = conn.prepareStatement(sql1);
					pstmt.setString(1, member.getName());
					pstmt.setString(2, member.getAddress());
					pstmt.setString(3, member.getTel());
					pstmt.setString(4, member.getId());
					pstmt.executeUpdate();
					x=1;	//수정 성공
				}
				else {
					x=0;	//수정 실패
				}
			}
		}catch(Exception e) {
			
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(Exception e) {
					
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e) {
					
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception e) {
					
				}
			}
		}
		
		return x;
	}
	//회원 정보 수정 처리 update 끝
	
	//회원 탈퇴 처리 delete 시작
	public int deleteMember(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x=-1;
		
		try {
			conn = getConnection();
			
			String sql = "select passwd from member1 where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpasswd = rs.getString("passwd");
				if(dbpasswd.equals(passwd)) {
					String sql1 = "delete from member1 where id=?";
					pstmt = conn.prepareStatement(sql1);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					x=1;	//탈퇴 성공
				}
				else {
					x=0;	//탈퇴 실패
				}
				
			}
		}catch(Exception e) {
			
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(Exception e) {
					
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e) {
					
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception e) {
					
				}
			}
		}
		
		return x;
	}
	//회원 탈퇴 처리 delete 끝
}
