package action;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MyListener1 implements ActionListener{
	
	JPanel myPanel = null;
	JButton button = null;
	
	//생성자
	public MyListener1(JPanel myPanel) {
		this.myPanel = myPanel;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button1 = (JButton)e.getSource();
		
		if(button1.getText().equals("핑크색"))
			myPanel.setBackground(Color.PINK);
		else if(button1.getText().equals("노란색"))
			myPanel.setBackground(Color.YELLOW);
	}
}
