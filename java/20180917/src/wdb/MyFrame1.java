package wdb;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame1 extends JFrame{
	public MyFrame1() {
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("홍길동");
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("안녕하세요");
		JButton button1 = new JButton("버튼1");
		JButton button2 = new JButton("버튼2");
		JButton button3 = new JButton("버튼3");
		JTextField textField1 = new JTextField(10);
		JTextField textField2 = new JTextField(10);
		textField1.setText("편집가능");
		textField2.setText("편집불가능");
		textField2.setEditable(false);
		
		panel.add(label);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(textField1);
		panel.add(textField2);
		this.add(panel);
		
		setVisible(true);
	}
}
