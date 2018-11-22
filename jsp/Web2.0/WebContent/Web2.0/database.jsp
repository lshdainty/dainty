<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,javax.sql.*,javax.naming.*,org.json.simple.*" %>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");

	String userid = request.getParameter("id");
	String userpw = request.getParameter("passwd");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	JSONObject jsonObject;
	JSONArray jsonArray = new JSONArray();
	
	try{
		String url = "jdbc:mariadb://localhost:3306/test";
		String id="root";
		String pw="1234";
		
		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection(url,id,pw);
		
		String sql = "select * from member where mid=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,userid);
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			if(userpw.equals(rs.getString("mpw"))){	//아이디도 있고 비번도 맞고
				jsonObject = new JSONObject();
				jsonObject.put("mno", rs.getInt("mno"));
				jsonObject.put("mid", rs.getString("mid"));
				jsonObject.put("mpw", rs.getString("mpw"));
				jsonObject.put("mname", rs.getString("mname"));
				jsonArray.add(jsonObject);
				out.println(jsonArray);
			}
			else{
				out.println(0);	//비번 틀림
			}
		}
		else{
			out.println(-1);	//아이디가 없음
		}
	}catch(Exception e){
		out.println(e);
	}finally{
		if(rs!=null)try{rs.close();}catch(Exception e){}
		if(pstmt!=null)try{pstmt.close();}catch(Exception e){}
		if(conn!=null)try{conn.close();}catch(Exception e){}
	}
%>