package action;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MyListener1 implements ActionListener{
	
	JPanel myPanel = null;
	JButton button = null;
	
	//������
	public MyListener1(JPanel myPanel) {
		this.myPanel = myPanel;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button1 = (JButton)e.getSource();
		
		if(button1.getText().equals("��ũ��"))
			myPanel.setBackground(Color.PINK);
		else if(button1.getText().equals("�����"))
			myPanel.setBackground(Color.YELLOW);
	}
}
