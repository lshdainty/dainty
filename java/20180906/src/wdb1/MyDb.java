package wdb1;

import java.sql.*;

public class MyDb {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public void connectDB() {
		//1. JDBC ����̹� ����
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//��Ŭ������ ����Ŭ jdbc ����
			System.out.println("����̹� ���� ����.");
		} catch (ClassNotFoundException e) {	//�����ϸ� ������ ������ ��Ÿ����
			//e.printStackTrace();   ������ ��Ÿ���ִ� �κ����� �����ð����� �ʿ���� �ּ�
			System.out.println("����̹��� ã�� �� �����ϴ�.");
			return ;
		}
		
		
		// 2. �����ͺ��̽� ����
		String url ="jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";	//������ db�� ���� ��ũ�� ���������� ������ ����
		String id = "s1501205";
		String pw = "p1501205";
		try {
			this.conn = DriverManager.getConnection(url, id, pw);	//������ ���� ������ ��������
			System.out.println("�����ͺ��̽� ���� ����.");
		} catch (SQLException e) {	//���н� ���������� ��Ÿ���ִ� �κ�
			// TODO Auto-generated catch block
			//e.printStackTrace();  ������ ��Ÿ���ִ� �κ����� �����ð����� �ʿ���� �ּ�
			System.out.println("������ ���̽� ���ῡ �����Ͽ����ϴ�..");
			return ;
		}
	}
	
	/*************************************************************************/
	
	public void insertmember() {
		//������� ������ : powerjava 'yjc' 2018' 20000
		
		//statement ��ü�� ����
		
		try {
			this.stmt = this.conn.createStatement();	//������ db�� ���� ��ü�� �����ϰ� ������ �����Ѵ�.
		} catch (SQLException e) {	//��ü ���� ���н� ���п����� ��Ÿ���ִ� �κ�
			System.out.println("Statement��ü ������ ������ �ֽ��ϴ�");
			// TODO Auto-generated catch block
			//e.printStackTrace();   ������ ��Ÿ���ִ� �κ����� �����ð����� �ʿ���� �ּ�
 		}
		
		//sql������ �ۼ�
		
		String sql = "insert into books values(7,'sql', 'kuj','2013',17000)";
		System.out.println(sql); //Ȯ�ο�
		
		//db�� ����
		
		try {
			int n = stmt.executeUpdate(sql);	//insert�� delete�� executeUpdate���
			System.out.println("����� �ݿ��� ���� ���� : " + n);
			conn.close();	//���� ����
		} catch (SQLException e) {
			System.out.println("sql���࿡ ������ �ֽ��ϴ�.");
			// TODO Auto-generated catch block
			//e.printStackTrace();   ������ ��Ÿ���ִ� �κ����� �����ð����� �ʿ���� �ּ�
		}
	}
	
	/*************************************************************************/
	
	public void select() {	//�˻��� �ϱ� ���� �κ�
		try {
			this.stmt = this.conn.createStatement();	//���� ������ db�� ���� ��ü�� �����ؼ� ������ ����
		} catch (SQLException e){
			System.out.println("Statement��ü ������ ������ �ֳ׿�");
		}
		
		String sql = "select * from books";
		
		try{
			this.rs = this.stmt.executeQuery(sql);
			
			while(rs.next()) {
				String title = rs.getString("title");
				System.out.println(title);
			}
		} catch (SQLException e) {
			//e.printStackTrace();   ������ ��Ÿ���ִ� �κ����� �����ð����� �ʿ���� �ּ�
		}
	}
	
	/*************************************************************************/
	
	public void allRetrieve() {
		
		//1 statement��ü ����
		try {
			this.stmt = this.conn.createStatement();
			System.out.println("Statement ��ü���� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();   ������ ��Ÿ���ִ� �κ����� �����ð����� �ʿ���� �ּ�
			System.out.println("Statement��ü�� ������ �� �����ϴ�.");
		}
		
		//2 sql�ۼ�
		String sql ="select * from books";
		//String sql ="select book_id,rpad(title,25,' '),rpad(publisher,13,' '),year,price from books order by title";
		//���� �ϴ� ���1 sql��ü�� �����ؼ� �����ڱ� 
		
		//3  ���� ���� �� ��� ����
		try {
			this.rs = this.stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();   ������ ��Ÿ���ִ� �κ����� �����ð����� �ʿ���� �ּ�
			System.out.println("���������� ���� �߻�");
		}
		
		//4  ����� ���ϴ� ���·� ���
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
				//�ڸ��� �������ֱ�
			}
		}catch(SQLException e) {
			//e.printStackTrace();   ������ ��Ÿ���ִ� �κ����� �����ð����� �ʿ���� �ּ�
		}
	}

	/*************************************************************************/
	
	public void deleteBookID(int bookID) {
		// TODO Auto-generated method stub
		try {
			this.stmt = this.conn.createStatement();	//������ db�� ���� ��ü�� �����ϰ� ������ �����Ѵ�.
		} catch (SQLException e) {	//��ü ���� ���н� ���п����� ��Ÿ���ִ� �κ�
			System.out.println("Statement��ü ������ ������ �ֽ��ϴ�");
			// TODO Auto-generated catch block
			//e.printStackTrace();   ������ ��Ÿ���ִ� �κ����� �����ð����� �ʿ���� �ּ�
 		}
		
		//sql������ �ۼ�
		
		String sql = "delete from books where book_id =" + bookID;
		System.out.println(sql); //Ȯ�ο�
		
		//db�� ����
		
		try {
			int n = stmt.executeUpdate(sql);	//insert�� delete�� executeUpdate���
			System.out.println("����� �ݿ��� ���� ���� : " + n);
			//conn.close();	//���� ����
		} catch (SQLException e) {
			System.out.println("sql���࿡ ������ �ֽ��ϴ�.");
			// TODO Auto-generated catch block
			//e.printStackTrace();   ������ ��Ÿ���ִ� �κ����� �����ð����� �ʿ���� �ּ�
		}
	}
	
	/*************************************************************************/
	
	public void insert(int id, String name , String pub, String year , int price) {
		PreparedStatement pstmt = null;
		
		//sql������ �ۼ�
		
		String sql = "insert into books values(?,?,?,?,?)";
		
		try{
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setString(3,pub);
			pstmt.setString(4,year);
			pstmt.setInt(5,price);
		}catch(SQLException e) {
			System.out.println("Statement ������ ������ �ֽ��ϴ�.");
		}
		
		//db�� ����
		
		try {
			int n = pstmt.executeUpdate();	//insert�� delete�� executeUpdate���
			System.out.println("����� �ݿ��� ���� ���� : " + n);
			//conn.close();	//���� ����
		} catch (SQLException e) {
			System.out.println("sql���࿡ ������ �ֽ��ϴ�.");
			// TODO Auto-generated catch block
			//e.printStackTrace();   ������ ��Ÿ���ִ� �κ����� �����ð����� �ʿ���� �ּ�
		}
	}
}
