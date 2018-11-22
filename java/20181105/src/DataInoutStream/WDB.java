package DataInoutStream;

import java.io.*;
import java.util.Date;

class BinaryFile{
	public void write() {
		//바이너리 파일을 생성하여 데이터를 저장
		//기초 자료형 단위로 데이터 저장하기 위한 클래스
		
		DataOutputStream dos = null;
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("D:\\output2.bin");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			dos = new DataOutputStream(bos);
			
			//파일에 정수값을 저장
			dos.writeInt(100);
			//파일에 실수값을 저장
			dos.writeDouble(3.141592);
			//문자열을 저장
			dos.writeUTF("홍길동");
			
			//실제 파일에 완전히 적어주기 위한 메소드
			dos.flush();
			
			dos.close();
			
		} catch (IOException e) {
			
		}
	}
	
	public void read() {
		//바이너리 파일을 읽어서 화면에 출력
		//기초 자료형 단위로 데이터 읽기하기 위한 클래스
		
		DataInputStream dis = null;
		FileInputStream fis;
		try {
			fis = new FileInputStream("D:\\output2.bin");
			BufferedInputStream bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			
			//파일에 정수값을 읽어온다.
			int a = dis.readInt();
			//파일에 실수값을 읽어온다.
			double b = dis.readDouble();
			//문자열을 읽어온다.
			String c = dis.readUTF();
			
			System.out.format("정수값 : %d 실수값 : %f 문자열 %s", a,b,c);
			
			dis.close();
			
		} catch (IOException e) {
			
		}
	}
	
	public void serial() {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		
		Date a = new Date();
		System.out.println(a);
		try {
			oos = new ObjectOutputStream(new FileOutputStream("D:object.dat"));
			oos.writeObject(a);
			oos.flush();
			oos.close();
			
			//10초 후에
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				
			}
			ois = new ObjectInputStream(new FileInputStream("D:object.dat"));
			
			Date b = (Date)ois.readObject();
			System.out.println(b);
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} catch (ClassNotFoundException e) {

		}
		
	}
}

public class WDB {

	public static void main(String[] args) {
		BinaryFile bf = new BinaryFile();
		bf.write();
		bf.read();
		bf.serial();
	}

}
