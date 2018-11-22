package ThreadCount;

import javax.swing.*;
import java.awt.*;

public class CountDownTest extends JFrame{
	private JLabel label;
	
	class MyThread extends Thread{
		@Override
		public void run() {
			for(int i=0; i<100; i++) {
				//1000 -> 1��
				try {
					Thread.sleep(1000);
				}catch(Exception e) {
					
				}
				label.setText(i+"");
			}
		}
	}
	
	public CountDownTest() {
		setTitle("ī��Ʈ �ٿ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		
		label = new JLabel("����");
		Font font = new Font("�������",Font.BOLD,100);
		label.setFont(font);
		add(label);
		
		
		MyThread myThread = new MyThread();
		myThread.start();
		
		
		setVisible(true);
	}
}
