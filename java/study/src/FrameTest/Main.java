package FrameTest;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		MyFrame myframe = new MyFrame();
	}

}

class MyFrame extends JFrame{
	MyFrame(){
		//�г� ������
		setSize(300,300);
		//�г� ���Ḧ �������� ���α׷��� ����ǵ��� 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Ÿ��Ʋ �̸�
		setTitle("Frame test");
		
		//��Ŷ ����
		Toolkit kit = Toolkit.getDefaultToolkit();
		//������ ����
		setIconImage(kit.getImage("test.png"));
		
		setLayout(new FlowLayout());
		
		JButton button = new JButton();
		button.setText("��ư");
		this.add(button);
		
		/*-----------------------------------------*/
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("�ȳ��ϼ���");
		
		setVisible(true);
	}
}