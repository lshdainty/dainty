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
		//	button1.setText("��ư ����");
		//	count++;
		//}
		//else {
		//	button1.setText("��ư�� �����ּ���");
		//	count++;
		//}
		if(button1.getText().equals("��ư ����"))
			button1.setText("��ư�� ��������");
		else
			button1.setText("��ư ����");
		
	}

}
