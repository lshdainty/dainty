package traffic_lights;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	
	int count =0;
	
	public MyPanel() {
		setLayout(new BorderLayout());
		JButton b = new JButton("신호등 변경");
		b.addActionListener(new MyActionListener(this));
		add(b,BorderLayout.SOUTH);
		
		//타이버처리
		Timer timer = new Timer();
		MyTimerTask task = new MyTimerTask(this);
		timer.schedule(task,10000,10000);
		//                  지연시간 ,반복시간(ms)
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawOval(100, 100, 100, 100);
		g.drawOval(100, 200, 100, 100);
		g.drawOval(100, 300, 100, 100);
		
		if(count==0) {
			g.setColor(Color.RED);
			g.fillOval(100, 100, 100, 100);
		}
		else if(count ==1) {
			g.setColor(Color.YELLOW);
			g.fillOval(100, 200, 100, 100);
		}
		else if(count ==2) {
			g.setColor(Color.GREEN);
			g.fillOval(100, 300, 100, 100);
		}
	}
}
