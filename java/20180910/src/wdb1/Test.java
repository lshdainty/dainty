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
		System.out.print("���������� �� : ");
		x = input.nextInt();
		System.out.print("������ �� : ");
		y = input.nextInt();
		try{
			int result = x / y;
		}catch(Exception e){
			y = 1;
		}finally {
			int result = x / y;
			System.out.println("����ó������ finally.");
		}
		System.out.println("���α׷��� ��� ����");
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
			System.out.println("�ε���" + i + "����� �� ���׿�");
		}
	}
	
	void getBookList() {	//db�� �ִ� å����Ʈ �����ͼ� ����ó��
		
		//1.����̹� �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("����̹��� �ε��� �� �����ϴ�.");
			return;
		}
		
		//2.����
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
			System.out.println("db�� ������ �� �����ϴ�.");
			return;
		}
		
		//3.statement ��ü����
		try {
			stmt = conn.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Statement��ü�� ������ �� ���׿�");
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			return;
		}
		
		//4.���� ���� �� ��� ��ȯ
		String sql = "select * from books";
		
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("������ ������ �� ���׿�");
			try{
				conn.close();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		//5.���ó��
		try {
			while(rs.next()) {
				String bookName = rs.getString(2);
				System.out.println(bookName);
			}
		}catch(SQLException e) {
			System.out.println("Ŀ���� �����ϴµ� ������ �ֳ׿�");
		}finally {
			try {
				rs.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.println("db��������");
		}
		
		//6.��������
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