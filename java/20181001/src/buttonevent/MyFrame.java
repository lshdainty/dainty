package buttonevent;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	private JButton button;
	
	MyFrame(){	//������
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("��ư �̺�Ʈ ����");
		this.setLayout(new FlowLayout());
		button = new JButton("��ư�� �����ÿ�");
		
		button.addActionListener(new MyListener());
		
		this.add(button);
		this.setVisible(true);
	}
}