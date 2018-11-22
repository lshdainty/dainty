package buttonevent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyListener implements ActionListener {
	
	int count=0;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button1 = (JButton)e.getSource();
		//if(count%2==0) {
		//	button1.setText("버튼 누름");
		//	count++;
		//}
		//else {
		//	button1.setText("버튼을 눌러주세요");
		//	count++;
		//}
		if(button1.getText().equals("버튼 누름"))
			button1.setText("버튼을 누르세요");
		else
			button1.setText("버튼 누름");
		
	}

}
