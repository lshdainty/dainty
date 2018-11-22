package Paneltest;

import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		MyFrame myframe = new MyFrame();
	}
}

class MyFrame extends JFrame{
	MyFrame(){
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("paneltest");
		
		JPanel panel = new MyPanel();
		this.add(panel);
		
		setVisible(true);
	}
}

class MyPanel extends JPanel{
	MyPanel(){
		JLabel label = new JLabel();
		JButton button1 = new JButton();
		JButton button2 = new JButton();
		JButton button3 = new JButton();
		JTextField text1 = new JTextField(10);
		JTextField text2 = new JTextField(20);
		
		label.setText("�ȳ��ϼ���");
		button1.setText("��ư1");
		button2.setText("��ư2");
		button3.setText("��ư3");
		text1.setText("���� ����");
		text2.setText("���� �Ұ���");
		text2.setEditable(false);
		
		
		add(label);
		add(button1);
		add(button2);
		add(button3);
		add(text1);
		add(text2);
		
	}
}