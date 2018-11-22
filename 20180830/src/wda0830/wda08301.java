package wda0830;

import java.sql.DriverManager;
import java.sql.SQLException;

public class wda08301 {
	public static void main(String[] args) {
		//1. jdbc드라이버 적재
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재 성공");
		}catch(ClassNotFoundException e) {
			//e.printStackTrace(); 시뻘건줄 나타남
			System.out.println("드라이버를 찾을 수 없습니다,");
		}
		
		//2. 데이터베이스 연결
		String url = "jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String id = "s1501205";
		String pw = "p1501205";
		try{
			DriverManager.getConnection(url, id, pw);
			System.out.println("데이터베이스 연결 성공");
		}catch(SQLException e) {
			//e.printStackTrace(); 시뻘건줄 나타남
			System.out.println("데이터베이스 연결에 실패하였습니다.");
			return;
		}
		
		//3. 데이터베이스 연결 종료
	}
}
