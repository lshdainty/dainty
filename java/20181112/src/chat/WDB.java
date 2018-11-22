package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class MyThread extends Thread{
	Socket socket;
	
	MyThread(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void run() {
		super.run();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			//4. ���� �޼����� ����ϰ� , ������ ������ ���´�.
			String data;
			while(!(data=in.readLine()).equals("9")) {
				System.out.println(data+socket.getInetAddress());
				out.write("server���� : " + data);
			}
			socket.close();
		}catch(IOException e) {
		}
	}
}

public class WDB {
	public static void main(String[] args) {
		//������ ����
		String data;
		try {
			//1.���� ������ �����.
			ServerSocket serverSocket = new ServerSocket(5555);
			System.out.println("���� ��Ĺ 5555 ��Ʈ�� �����");
			
			//2.Ŭ���̾�Ʈ�� ������ ��ٸ���.
			//  Ŭ���̾�Ʈ�� �����ϸ� ������ �����Ѵ�.
			while(true) {
				Socket socket = serverSocket.accept();
				//3.������ �������κ��� Ŭ���̾�Ʈ ������ �޽����� �޴´�.
				MyThread myThread = new MyThread(socket);
				myThread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
