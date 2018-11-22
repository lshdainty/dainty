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
		setTitle("이벤트");
		
		JPanel panel = new MyPanel();
		add(panel);
		
		setVisible(true);
	}
}

class MyPanel extends JPanel{
	MyPanel(){
		JButton button = new JButton("이벤트 버튼 예제");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button.getText().equals("이벤트 버튼 예제"))
					button.setText("버튼이 눌렸어...");
				else
					button.setText("이벤트 버튼 예제");
			}
		});
		add(button);
	}
	
//	class MyListener implements ActionListener{
//		public void actionPerformed(ActionEvent e) {
//			JButton button = (JButton) e.getSource();
//			if(button.getText().equals("이벤트 버튼 예제"))
//				button.setText("버튼이 눌렸어...");
//			else
//				button.setText("이벤트 버튼 예제");
//		}
//	}
}


//class MyListener implements ActionListener{
//	public void actionPerformed(ActionEvent e) {
//		JButton button = (JButton) e.getSource();
//		if(button.getText().equals("이벤트 버튼 예제"))
//			button.setText("버튼이 눌렸어...");
//		else
//			button.setText("이벤트 버튼 예제");
//	}
//}