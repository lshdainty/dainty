package wdb1;

import java.sql.*;

public class MyDb {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public void connectDB() {
		//1. JDBC 드라이버 예제
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//이클립스에 오라클 jdbc 적재
			System.out.println("드라이버 적재 성공.");
		} catch (ClassNotFoundException e) {	//실패하면 실패한 이유를 나타내줌
			//e.printStackTrace();   오류를 나타내주는 부분으로 수업시간에는 필요없어 주석
			System.out.println("드라이버를 찾을 수 없습니다.");
			return ;
		}
		
		
		// 2. 데이터베이스 연결
		String url ="jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";	//연결할 db에 대한 링크와 유저정보를 변수에 저장
		String id = "s1501205";
		String pw = "p1501205";
		try {
			this.conn = DriverManager.getConnection(url, id, pw);	//연결을 위한 변수에 정보저장
			System.out.println("데이터베이스 연결 성공.");
		} catch (SQLException e) {	//실패시 실패정보를 나타내주는 부분
			// TODO Auto-generated catch block
			//e.printStackTrace();  오류를 나타내주는 부분으로 수업시간에는 필요없어 주석
			System.out.println("데이터 베이스 연결에 실패하였습니다..");
			return ;
		}
	}
	
	/*************************************************************************/
	
	public void insertmember() {
		//집어넣을 데이터 : powerjava 'yjc' 2018' 20000
		
		//statement 객체를 생성
		
		try {
			this.stmt = this.conn.createStatement();	//접속한 db에 대한 객체를 생성하고 변수에 저장한다.
		} catch (SQLException e) {	//객체 생성 실패시 실패원인을 나타내주는 부분
			System.out.println("Statement객체 생성에 문제가 있습니다");
			// TODO Auto-generated catch block
			//e.printStackTrace();   오류를 나타내주는 부분으로 수업시간에는 필요없어 주석
 		}
		
		//sql문장을 작성
		
		String sql = "insert into books values(7,'sql', 'kuj','2013',17000)";
		System.out.println(sql); //확인용
		
		//db에 실행
		
		try {
			int n = stmt.executeUpdate(sql);	//insert나 delete는 executeUpdate사용
			System.out.println("결과에 반영된 행의 수는 : " + n);
			conn.close();	//연결 종료
		} catch (SQLException e) {
			System.out.println("sql실행에 문제가 있습니다.");
			// TODO Auto-generated catch block
			//e.printStackTrace();   오류를 나타내주는 부분으로 수업시간에는 필요없어 주석
		}
	}
	
	/*************************************************************************/
	
	public void select() {	//검색을 하기 위한 부분
		try {
			this.stmt = this.conn.createStatement();	//현재 접속한 db에 대한 객체를 생성해서 변수에 저장
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
	
	/*************************************************************************/
	
	public void allRetrieve() {
		
		//1 statement객체 생성
		try {
			this.stmt = this.conn.createStatement();
			System.out.println("Statement 객체생성 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();   오류를 나타내주는 부분으로 수업시간에는 필요없어 주석
			System.out.println("Statement객체를 생성할 수 없습니다.");
		}
		
		//2 sql작성
		String sql ="select * from books";
		//String sql ="select book_id,rpad(title,25,' '),rpad(publisher,13,' '),year,price from books order by title";
		//정렬 하는 방법1 sql자체를 정렬해서 때려박기 
		
		//3  질의 생성 및 결과 반한
		try {
			this.rs = this.stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();   오류를 나타내주는 부분으로 수업시간에는 필요없어 주석
			System.out.println("쿼리실행중 문제 발생");
		}
		
		//4  결과를 원하는 형태로 출력
		try{
			
			//String bookname = rs.getString("title");
			while(rs.next()) {
				int bookID = rs.getInt(1);
				String bookname = rs.getString(2);
				String pub = rs.getString(3);
				String year = rs.getString(4);
				int price = rs.getInt(5);
				
				//System.out.println(bookID + "||" + bookname + "||" + pub + "||" + year + "||" + price);
				System.out.printf("%2d|%-26s|%-14s|%4s|%5d|\n", bookID,bookname,pub,year,price);
				//자리수 지정해주기
			}
		}catch(SQLException e) {
			//e.printStackTrace();   오류를 나타내주는 부분으로 수업시간에는 필요없어 주석
		}
	}

	/*************************************************************************/
	
	public void deleteBookID(int bookID) {
		// TODO Auto-generated method stub
		try {
			this.stmt = this.conn.createStatement();	//접속한 db에 대한 객체를 생성하고 변수에 저장한다.
		} catch (SQLException e) {	//객체 생성 실패시 실패원인을 나타내주는 부분
			System.out.println("Statement객체 생성에 문제가 있습니다");
			// TODO Auto-generated catch block
			//e.printStackTrace();   오류를 나타내주는 부분으로 수업시간에는 필요없어 주석
 		}
		
		//sql문장을 작성
		
		String sql = "delete from books where book_id =" + bookID;
		System.out.println(sql); //확인용
		
		//db에 실행
		
		try {
			int n = stmt.executeUpdate(sql);	//insert나 delete는 executeUpdate사용
			System.out.println("결과에 반영된 행의 수는 : " + n);
			//conn.close();	//연결 종료
		} catch (SQLException e) {
			System.out.println("sql실행에 문제가 있습니다.");
			// TODO Auto-generated catch block
			//e.printStackTrace();   오류를 나타내주는 부분으로 수업시간에는 필요없어 주석
		}
	}
	
	/*************************************************************************/
	
	public void insert(int id, String name , String pub, String year , int price) {
		PreparedStatement pstmt = null;
		
		//sql문장을 작성
		
		String sql = "insert into books values(?,?,?,?,?)";
		
		try{
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setString(3,pub);
			pstmt.setString(4,year);
			pstmt.setInt(5,price);
		}catch(SQLException e) {
			System.out.println("Statement 생성에 문제가 있습니다.");
		}
		
		//db에 실행
		
		try {
			int n = pstmt.executeUpdate();	//insert나 delete는 executeUpdate사용
			System.out.println("결과에 반영된 행의 수는 : " + n);
			//conn.close();	//연결 종료
		} catch (SQLException e) {
			System.out.println("sql실행에 문제가 있습니다.");
			// TODO Auto-generated catch block
			//e.printStackTrace();   오류를 나타내주는 부분으로 수업시간에는 필요없어 주석
		}
	}
}
