package buttonevent;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	private JButton button;
	
//	public class MyListener implements ActionListener {	내부 클래스
//		
//		int count=0;
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			JButton button1 = (JButton)e.getSource();
//			if(button1.getText().equals("버튼 누름"))
//				button1.setText("버튼을 누르세요");
//			else
//				button1.setText("버튼 누름");	
//		}
//	}
	
	MyFrame(){	//생성자
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("버튼 이벤트 예제");
		this.setLayout(new FlowLayout());
		button = new JButton("버튼을 누르시오");
		
		button.addActionListener(new ActionListener() {	//무명클래스
			
			int count=0;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton button1 = (JButton)e.getSource();
				if(button1.getText().equals("버튼 누름"))
					button1.setText("버튼을 누르세요");
				else
					button1.setText("버튼 누름");	
			}
		});
		
		this.add(button);
		this.setVisible(true);
	}
}