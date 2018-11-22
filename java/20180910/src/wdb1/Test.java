package wdb1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class Test {
	
	public void divideByZero() {
		int x,y;
	
		Scanner input = new Scanner(System.in);
		System.out.print("나누어지는 수 : ");
		x = input.nextInt();
		System.out.print("나누는 수 : ");
		y = input.nextInt();
		try{
			int result = x / y;
		}catch(Exception e){
			y = 1;
		}finally {
			int result = x / y;
			System.out.println("예외처리구문 finally.");
		}
		System.out.println("프로그램은 계속 진행");
	}
	
	void ArrayIndexOutOf() {
		int[] array = {1,2,3,4,5};
		int i =0;	
		
		try {
			for (i = 0; i < array.length + 1; i++) {
				System.out.println(array[i] + " ");
			} 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("인덱스" + i + "사용할 수 없네요");
		}
	}
	
	void getBookList() {	//db에 있는 책리스트 가져와서 예외처리
		
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버를 로딩할 수 없습니다.");
			return;
		}
		
		//2.연결
		String url = "jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String user = "s1501205";
		String password = "p1501205";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("db에 연결할 수 없습니다.");
			return;
		}
		
		//3.statement 객체생성
		try {
			stmt = conn.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Statement객체를 생성할 수 없네요");
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			return;
		}
		
		//4.쿼리 실행 및 결과 반환
		String sql = "select * from books";
		
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("쿼리를 실행할 수 없네요");
			try{
				conn.close();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		//5.결과처리
		try {
			while(rs.next()) {
				String bookName = rs.getString(2);
				System.out.println(bookName);
			}
		}catch(SQLException e) {
			System.out.println("커서를 조작하는데 문제가 있네요");
		}finally {
			try {
				rs.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.println("db연결종료");
		}
		
		//6.연결종료
	}
	
	void getBookListThrows() throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String user = "s1501205";
		String password = "p1501205";
		try {
			conn = DriverManager.getConnection(url, user, password);
			String sql = "select * from books";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String bookName = rs.getString(2);
				System.out.println(bookName);
			}
		}catch(Exception e) {
			
		}
	}
}