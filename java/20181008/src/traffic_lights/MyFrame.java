package traffic_lights;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
	MyFrame(){
		setSize(300,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("신호등");
		
		JPanel panel = new MyPanel();
		
		add(panel);
		setVisible(true);
	}
}
