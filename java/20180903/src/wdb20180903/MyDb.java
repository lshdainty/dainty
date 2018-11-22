package wdb20180903;

import java.sql.*;

public class MyDb {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public void connectDB() {
		//1. JDBC ����̹� ����
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� ���� ����.");
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();   ������ ��Ÿ���ִ� �κ����� �����ð����� �ʿ���� �ּ�
			System.out.println("����̹��� ã�� �� �����ϴ�.");
			return ;
		}
		
		
		// 2. �����ͺ��̽� ����
		String url ="jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String id = "s1501205";
		String pw = "p1501205";
		try {
			this.conn = DriverManager.getConnection(url, id, pw);
			System.out.println("�����ͺ��̽� ���� ����.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();  ������ ��Ÿ���ִ� �κ����� �����ð����� �ʿ���� �ּ�
			System.out.println("������ ���̽� ���ῡ �����Ͽ����ϴ�..");
			return ;
		}
	}
	
	public void insertmember() {
		//������� ������ : powerjava 'yjc' 2018' 20000
		
		//statement ��ü�� ����
		
		try {
			this.stmt = this.conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Statement��ü ������ ������ �ֽ��ϴ�");
			// TODO Auto-generated catch block
			//e.printStackTrace();   ������ ��Ÿ���ִ� �κ����� �����ð����� �ʿ���� �ּ�
 		}
		
		//sql������ �ۼ�
		
		String sql = "insert into books values(7,'sql', 'kuj','2013',17000)";
		System.out.println(sql); //Ȯ�ο�
		
		//db�� ����
		
		try {
			int n = stmt.executeUpdate(sql);
			System.out.println("����� �ݿ��� ���� ���� : " + n);
			conn.close();	//���� ����
		} catch (SQLException e) {
			System.out.println("sql���࿡ ������ �ֽ��ϴ�.");
			// TODO Auto-generated catch block
			//e.printStackTrace();   ������ ��Ÿ���ִ� �κ����� �����ð����� �ʿ���� �ּ�
		}
	}
	
	public void select() {
		try {
			this.stmt = this.conn.createStatement();
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
}
