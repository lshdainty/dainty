package wdb;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame2 extends JFrame {
	public MyFrame2() {
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("홍길동");
		
		JPanel panel = new JPanel();
		//panel.setLayout(new FlowLayout(FlowLayout.LEADING));
		//panel.setLayout(new BorderLayout());
		panel.setLayout(new GridLayout(5,2));
		for(int i=0; i<10; i++) {
			String name = "버튼" + i;
			panel.add(new JButton(name));
		}
		
		
		//JLabel label = new JLabel("안녕하세요");
		//panel.add(label,BorderLayout.SOUTH);
		
		//JButton button1 = new JButton("버튼1");
		//panel.add(button1,BorderLayout.NORTH);
		
		//JButton button2 = new JButton("버튼2");
		//panel.add(button2,BorderLayout.EAST);
		
		//JButton button3 = new JButton("버튼3");
		//panel.add(button3,BorderLayout.CENTER);
		
		this.add(panel);
		
		setVisible(true);
	}
}
