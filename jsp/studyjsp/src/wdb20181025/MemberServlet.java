package wdb20181025;

import java.io.IOException;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		
		response.getWriter().print(login(userid,password));
	}
	
	private int login(String userid , String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbid = null;
		String dbpasswd = null;
		int result = 0;
		//dbcp를 이용해 사용자의 id를 이용해서 검색
		
		try{
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/TestDB");
			conn = ds.getConnection();
			
			String sql = "select userid,password from member1 where userid=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,userid);
			rs = pstmt.executeQuery();
			
			//1 = 성공 , 0 비번틀림 , -1 아이디없음
			if(rs.next()){
				dbid = rs.getString("userid");
				dbpasswd = rs.getString("password");
			
				if(userid.equals(dbid)&&password.equals(dbpasswd)){
					result = 1;
				}else{
					result = 0;
				}
			}else{
				result = -1;
			}
		}catch(Exception e){
			
		}finally{
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException e){
					
				}
			}
			if(pstmt!=null){
				try{
					pstmt.close();
				}catch(SQLException e){
					
				}
			}
			if(conn!=null){
				try{
					conn.close();
				}catch(SQLException e){
					
				}
			}
		}
		
		return result;
	}
}
