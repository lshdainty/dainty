package wdb20181108;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageProcessURI implements CommandProcess{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		request.setAttribute("message","요청 uri로 명령어를 전달");
		return "/20181108/process.jsp";
	}
}
