package wdb1;

import java.sql.SQLException;
import java.util.Scanner;

public class wdb {
	public static void main(String[] args) {
		Test test = new Test();
		//test.divideByZero();
		//test.ArrayIndexOutOf();
		//test.getBookList();
		try {
			test.getBookListThrows();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}