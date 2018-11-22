package wdb20180903;

import java.sql.*;

public class MyDb {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public void connectDB() {
		//1. JDBC 드라이버 예제
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재 성공.");
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();   오류를 나타내주는 부분으로 수업시간에는 필요없어 주석
			System.out.println("드라이버를 찾을 수 없습니다.");
			return ;
		}
		
		
		// 2. 데이터베이스 연결
		String url ="jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String id = "s1501205";
		String pw = "p1501205";
		try {
			this.conn = DriverManager.getConnection(url, id, pw);
			System.out.println("데이터베이스 연결 성공.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();  오류를 나타내주는 부분으로 수업시간에는 필요없어 주석
			System.out.println("데이터 베이스 연결에 실패하였습니다..");
			return ;
		}
	}
	
	public void insertmember() {
		//집어넣을 데이터 : powerjava 'yjc' 2018' 20000
		
		//statement 객체를 생성
		
		try {
			this.stmt = this.conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Statement객체 생성에 문제가 있습니다");
			// TODO Auto-generated catch block
			//e.printStackTrace();   오류를 나타내주는 부분으로 수업시간에는 필요없어 주석
 		}
		
		//sql문장을 작성
		
		String sql = "insert into books values(7,'sql', 'kuj','2013',17000)";
		System.out.println(sql); //확인용
		
		//db에 실행
		
		try {
			int n = stmt.executeUpdate(sql);
			System.out.println("결과에 반영된 행의 수는 : " + n);
			conn.close();	//연결 종료
		} catch (SQLException e) {
			System.out.println("sql실행에 문제가 있습니다.");
			// TODO Auto-generated catch block
			//e.printStackTrace();   오류를 나타내주는 부분으로 수업시간에는 필요없어 주석
		}
	}
	
	public void select() {
		try {
			this.stmt = this.conn.createStatement();
		} catch (SQLException e){
			System.out.println("Statement객체 생성에 문제가 있네요");
		}
		String sql = "select * from books";
		try{
			this.rs = this.stmt.executeQuery(sql);
			
			while(rs.next()) {
				String title = rs.getString("title");
				System.out.println(title);
			}
		} catch (SQLException e) {
			//e.printStackTrace();   오류를 나타내주는 부분으로 수업시간에는 필요없어 주석
		}
	}
}
