package traffic_lights;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener{
	MyPanel myPanel;
	
	public MyActionListener(MyPanel myPanel) {
		this.myPanel = myPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		myPanel.count++;
		if(myPanel.count>=3) {
			myPanel.count = 0;
		}
		myPanel.repaint();
	}
}
