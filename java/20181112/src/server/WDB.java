package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class WDB {
	public static void main(String[] args) {
		//서버를 생성
		String data;
		try {
			//1.서버 소켓을 만든다.
			ServerSocket serverSocket = new ServerSocket(5555);
			System.out.println("서버 소켓 5555포트로 대기중");
			
			//2. 클라이언트의 접속을 기다린다.
			//  클라이언트가 접속하면 소켓을 생성한다.
			while(true) {
				Socket socket = serverSocket.accept();
				//3. 생성된 소켓으로부터 클라이언트 보내는 메시지를 받는다.
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//4.받은 메시지를 출력하고 , 소켓의 접속을 끊는다.
				while((data=in.readLine())!=null) {
					System.out.println(data+socket.getInetAddress());
				}
				socket.close();
				//5.계속 대기한다.
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
