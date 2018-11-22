package wdb20181108.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import wdb20181031.LogonDBBean;

public class MemberDBBean {
	//싱글턴 생성 시작
	private static MemberDBBean instance = new MemberDBBean();
		
	public static MemberDBBean getInstance() {	//db를 처리하는 것은 싱글톤이다.
		return instance;
	}
		
	private MemberDBBean() {};
	//싱글턴 생성 끝
	
	public ArrayList<Member> getList(){
		ArrayList<Member> list = null;
		Member m = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/TestDB");
			conn = ds.getConnection();
			
			list = new ArrayList<Member>();
			
			String sql = "select * from member1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				m = new Member();
				m.setId(rs.getString("id"));
				m.setPasswd(rs.getString("passwd"));
				m.setName(rs.getString("name"));
				m.setReg_date(rs.getTimestamp("reg_date"));
				m.setAddress(rs.getString("address"));
				m.setTel(rs.getString("tel"));
				list.add(m);
			}
		}catch(Exception e) {
			
		}finally {
			if(rs!=null) {
				try {rs.close();}catch(Exception e) {}
			}
			if(pstmt!=null) {
				try {pstmt.close();}catch(Exception e) {}
			}
			if(conn!=null) {
				try {conn.close();}catch(Exception e) {}
			}
		}
		return list;
	}
}
