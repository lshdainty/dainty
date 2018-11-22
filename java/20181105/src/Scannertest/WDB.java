package Scannertest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WDB {

	public static void main(String[] args) {
		MyScanner myScanner = new MyScanner();
		myScanner.print();

	}
	
}

class MyScanner{
	public void print() {
		Scanner scan = null;
		
		try {
			//문자단위 입력 클래스
			FileReader rf = new FileReader("D:\\input.txt");
			//버퍼를 이용한 클래스
			BufferedReader br = new BufferedReader(rf);
			//Scanner 객체 생성
			scan = new Scanner(br);
			int total = 0;
			int numInt = 0;
			String s = null;
			
			//읽어오면서 토큰 단위로 추출한다.
			while(scan.hasNext()) {
				if(scan.hasNextInt()) {
					s = scan.next();
					numInt = Integer.parseInt(s);
					total = total + numInt;
					System.out.print(total);
				}else {
					System.out.println(scan.next());
				}
				
				//System.out.println(scan.next());	//next는 공백단위로 가져오고 nextLine은 줄 단위로 가져온다.
			}
			if(scan != null) {
				scan.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
