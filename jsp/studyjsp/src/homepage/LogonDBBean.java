package homepage;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

public class LogonDBBean {
	
	//싱글톤 시작 -> 전역객체 생성해서 이 한개로만 공유하여 사용한다.
	private static LogonDBBean instance = new LogonDBBean();
	
	public static LogonDBBean getInstance() {
		return instance;
	}
	
	private LogonDBBean() {};
	//싱글톤 끝 
	
	//커넥션 풀 생성 시작
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/TestDB");
		return ds.getConnection();
	}
	//커넥션 풀 생성 끝
	
	//회원 가입 처리를 위한 insert부분 시작
	public void insertMember(LogonDataBean member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into member values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(1, member.getName());
			pstmt.setTimestamp(1, member.getReg_date());
			pstmt.setString(1, member.getAddress());
			pstmt.setString(1, member.getTel());
			pstmt.executeQuery();
		}catch(Exception e) {
			
		}finally {
			if(pstmt!=null) {try {pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try {conn.close();}catch(Exception e) {}}
		}
	}
	//회원 가입 처리를 위한 insert부분 끝
}
