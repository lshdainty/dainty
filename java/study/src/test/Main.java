package test;

import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		MyFrame myframe = new MyFrame();
	}

}

class MyFrame extends JFrame{
	MyFrame(){
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�ڰ� �׽�Ʈ");
		
		JPanel panel = new MyPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JTextField text1 = new JTextField();
		JTextField text2 = new JTextField();
		JButton button = new JButton("�޺�����");
		JButton button1 = new JButton("�������� ����");
		JButton button2 = new JButton("�Ұ�� ����");
		text1.setText("�ڹ� ���ڿ� ���� ���� ȯ���մϴ�.");
		text2.setText("������ ������ �����Ͻʽÿ�");
		text2.setEditable(false);
		
		this.add(panel);
		panel.add(panel1);
		panel.add(panel2);
		panel1.add(text1);
		panel1.add(text2);
		panel2.add(button);
		panel2.add(button1);
		panel2.add(button2);
		
		setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.yellow);
		g.drawLine(10, 10, 50, 50);
	}
}