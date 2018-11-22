package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

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
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//4.���� �޽����� ����ϰ� , ������ ������ ���´�.
				while((data=in.readLine())!=null) {
					System.out.println(data+socket.getInetAddress());
				}
				socket.close();
				//5.��� ����Ѵ�.
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
