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
		//Ŭ���̾�Ʈ�� ����
		//1.�������� ������ ����
		Socket socket = null;
		try {
			socket = new Socket("39.127.8.230",5555);
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			
			//2.9�� �Է��� �� ���� ��� �����͸� ������
			//9�� �Է��ϸ� ������ �����Ѵ�.
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
