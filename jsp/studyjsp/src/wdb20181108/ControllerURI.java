package wdb20181108;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerURI
 */
@WebServlet(
		urlPatterns = { 
				"/ControllerURI", 
				"*.do"
		}, 
		initParams = { 
				@WebInitParam(name = "propertyConfig", value = "commandURI.properties")
		})
public class ControllerURI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//명령어와 명령어 처리 클래스를 쌍으로 저장
	private Map<String,Object> commandMap = new HashMap<String,Object>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerURI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    //명령어와 처리 클래스가 매핑되어 있는 properties 파일을 읽어서 HashMap객체인 commandMap에 저장
	public void init(ServletConfig config) throws ServletException {
		//initParams에서 propertyConfig의 값을 읽어옴
		String props = config.getInitParameter("propertyConfig");
		String realFolder = "/property";	//프로퍼티가 저장된 폴더명
		//웹 애플리케이션 루트 경로
		ServletContext context = config.getServletContext();
		//realFolder를 웹 애플리케이션 시스템상의 절대 경로로 변경
		String realPath = context.getRealPath(realFolder) + "\\" +props;
		
		//명령어와 처리 클래스의 매핑 정보를 저장할 Properties 객체 생성
		Properties pr = new Properties();
		FileInputStream f  = null;
		try {
			//command.properties파일의 내용을 읽어옴
			f=new FileInputStream(realPath);
			//command.properties의 내용을 Properties 객체 pr에 저장
			pr.load(f);
		}catch(Exception e) {
			
		}finally {
			if(f!=null)try {f.close();}catch(Exception e) {}
		}
		
		Iterator<?> keyIter = pr.keySet().iterator();
		//Iterator 객체에 저장된 명령어와 처리 클래스를 commandMap에 저장
		while(keyIter.hasNext()) {
			String command = (String)keyIter.next();
			String className = pr.getProperty(command);
			try {
				Class<?> commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance();
				commandMap.put(command,commandInstance);
			}catch(Exception e) {
				throw new ServletException(e);
			}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestPro(request,response);
		//웹 브라우저 요청 처리 메소드 호출
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestPro(request,response);
		//웹 브라우저 요청 처리 메소드 호출
	}
	
	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		CommandProcess com = null;
		try {
			String command = request.getRequestURI();
			if(command.indexOf(request.getContextPath())==0)
				command = command.substring(request.getContextPath().length());
			com = (CommandProcess)commandMap.get(command);
			if(com==null) {
				view="/20181108/process.jsp";
			}
			else {
				view = com.requestPro(request, response);
			}
		}catch(Throwable e) {
			throw new ServletException(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
