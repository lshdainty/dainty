package traffic_lights;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

	MyPanel myPanel;
	public MyTimerTask(MyPanel myPanel) {
		this.myPanel = myPanel;
	}
	
	@Override
	public void run() {
		myPanel.count++;
		if(myPanel.count>=3) {
			myPanel.count = 0;
		}
		myPanel.repaint();
	}

}
