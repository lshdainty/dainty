package buttonevent;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	private JButton button;
	
//	public class MyListener implements ActionListener {	���� Ŭ����
//		
//		int count=0;
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			JButton button1 = (JButton)e.getSource();
//			if(button1.getText().equals("��ư ����"))
//				button1.setText("��ư�� ��������");
//			else
//				button1.setText("��ư ����");	
//		}
//	}
	
	MyFrame(){	//������
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("��ư �̺�Ʈ ����");
		this.setLayout(new FlowLayout());
		button = new JButton("��ư�� �����ÿ�");
		
		button.addActionListener(new ActionListener() {	//����Ŭ����
			
			int count=0;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton button1 = (JButton)e.getSource();
				if(button1.getText().equals("��ư ����"))
					button1.setText("��ư�� ��������");
				else
					button1.setText("��ư ����");	
			}
		});
		
		this.add(button);
		this.setVisible(true);
	}
}