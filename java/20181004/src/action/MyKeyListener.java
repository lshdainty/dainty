package action;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MyKeyListener implements KeyListener {
	
	JPanel myPanel = null;
	
	MyKeyListener(JPanel myPanel){
		this.myPanel = myPanel;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		char ch = e.getKeyChar();
		System.out.println(ch);
		
		if(ch == 'r') {
			myPanel.setBackground(Color.red);
		}
		else if(ch == 'g') {
			myPanel.setBackground(Color.green);
		}
		else if(ch == 'b') {
			myPanel.setBackground(Color.blue);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		

	}

	@Override
	public void keyTyped(KeyEvent e) {
		

	}

}
