package 랜덤;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WDB {
	public static void main(String[] args) throws IOException {
		try {
			RandomAccessFile raf = new RandomAccessFile("d:\\random.bin","rw");
			
			raf.writeInt(10);
			raf.seek(4);
			raf.writeInt(6546);	//�й�
			raf.writeUTF("test1");	//�̸�
			raf.writeInt(100);	//����
			raf.writeInt(90);	//����
			raf.writeInt(80);	//����
			raf.seek(44);
			raf.writeInt(7897);	//�й�
			raf.writeUTF("test2");	//�̸�
			raf.writeInt(70);	//����
			raf.writeInt(60);	//����
			raf.writeInt(50);	//����
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
