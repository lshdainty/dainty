package wdb20181108;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import wdb20181108.model.MemberDBBean;

public class ListProcessURI implements CommandProcess {
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		//DBCP로 접속한 뒤 사용자 정보를 모두 받아와서
		//ArrayList<MemberBean>으로 request.setAttribute("members",) 한 뒤 
		//return "/20181108/list.jsp";
		MemberDBBean db = MemberDBBean.getInstance();	//싱글톤으로 만들겠다.
		request.setAttribute("members",db.getList());
		return "/20181108/list.jsp";
	}
}
