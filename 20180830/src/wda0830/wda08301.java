package wda0830;

import java.sql.DriverManager;
import java.sql.SQLException;

public class wda08301 {
	public static void main(String[] args) {
		//1. jdbc����̹� ����
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적용했습니다.");
		}catch(ClassNotFoundException e) {
			//e.printStackTrace(); �û����� ��Ÿ��
			System.out.println("����̹��� ã�� �� �����ϴ�,");
		}
		
		//2. �����ͺ��̽� ����
		String url = "jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String id = "s1501205";
		String pw = "p1501205";
		try{
			DriverManager.getConnection(url, id, pw);
			System.out.println("�����ͺ��̽� ���� ����");
		}catch(SQLException e) {
			//e.printStackTrace(); �û����� ��Ÿ��
			System.out.println("�����ͺ��̽� ���ῡ �����Ͽ����ϴ�.");
			return;
		}
		
		//3. �����ͺ��̽� ���� ����
	}
}
