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
		//패널 사이즈
		setSize(300,300);
		//패널 종료를 눌렀을때 프로그램이 종료되도록 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//타이틀 이름
		setTitle("Frame test");
		
		//툴킷 생성
		Toolkit kit = Toolkit.getDefaultToolkit();
		//아이콘 변경
		setIconImage(kit.getImage("test.png"));
		
		setLayout(new FlowLayout());
		
		JButton button = new JButton();
		button.setText("버튼");
		this.add(button);
		
		/*-----------------------------------------*/
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("안녕하세요");
		
		setVisible(true);
	}
}