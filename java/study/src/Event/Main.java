package Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	public static void main(String[] args) {
		MyFrame myframe = new MyFrame();
	}
}

class MyFrame extends JFrame{
	MyFrame(){
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�̺�Ʈ");
		
		JPanel panel = new MyPanel();
		add(panel);
		
		setVisible(true);
	}
}

class MyPanel extends JPanel{
	MyPanel(){
		JButton button = new JButton("�̺�Ʈ ��ư ����");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button.getText().equals("�̺�Ʈ ��ư ����"))
					button.setText("��ư�� ���Ⱦ�...");
				else
					button.setText("�̺�Ʈ ��ư ����");
			}
		});
		add(button);
	}
	
//	class MyListener implements ActionListener{
//		public void actionPerformed(ActionEvent e) {
//			JButton button = (JButton) e.getSource();
//			if(button.getText().equals("�̺�Ʈ ��ư ����"))
//				button.setText("��ư�� ���Ⱦ�...");
//			else
//				button.setText("�̺�Ʈ ��ư ����");
//		}
//	}
}


//class MyListener implements ActionListener{
//	public void actionPerformed(ActionEvent e) {
//		JButton button = (JButton) e.getSource();
//		if(button.getText().equals("�̺�Ʈ ��ư ����"))
//			button.setText("��ư�� ���Ⱦ�...");
//		else
//			button.setText("�̺�Ʈ ��ư ����");
//	}
//}