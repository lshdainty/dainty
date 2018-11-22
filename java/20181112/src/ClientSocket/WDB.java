package ClientSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class WDB {

	public static void main(String[] args) {
		//클라이언트를 생성
		//1. 소켓으로 서버에 접속
		Socket socket = null;
		try {
			socket = new Socket("39.127.8.230",5555);
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			
			//2. 9를 입력할 때까지 계속 데이터를 보내고
			//9를 입력하면 접속을 종료한다.
			Scanner scan = new Scanner(System.in);
			String data=null;
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			do{
				data = scan.nextLine();
				out.println(data);
				System.out.println(in.readLine());

			}while(!data.equals("9"));
			out.close();
		} catch (UnknownHostException e) {
		} catch (IOException e) {
		}
	}
}
