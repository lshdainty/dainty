import java.io.*;

public class WDB {

	public static void main(String[] args) {
		//파일로부터 문자 단위로 데이터를 읽어오는 작업을 하는 
		//클래스 : FileReader
		FileReader fi;
		
		//파일로 문자 단위로 데이터를 저장하는 작업을 하는
		//클래스 : FileWriter
		FileWriter fo;
		
		try {
			//파일을 읽기위한 객체를 생성
			fi = new FileReader("D:\\input.txt");	//특수문자이므로 \하나이면 인식불가 그래서 2개를 사용해야 가능
			
			//파일에 쓰기위한 객체를 생성
			fo = new FileWriter("D:\\output.txt");
			
			//한 바이트 읽어서 저장하는 반복구조
			int b;
			while((b = fi.read()) != -1) {	//파일이 바이트단위로 읽다가 파일의 끝을 보면 -1이다.
				//저장하는거
				fo.write(b);
				System.out.print((char)b + " ");
			}
			if(fi != null) {
				fi.close();
			}
			if(fo != null) {
				fo.close();
			}
		} catch (IOException e) {	//ioException은 FilenotFound의 부모쪽이다.
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
