import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
	private myPanel myPanel;	
	private int offset = 10;
	
	public MyKeyListener(myPanel myPanel) {
		this.myPanel = myPanel;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		if(keycode == KeyEvent.VK_RIGHT) {
			myPanel.x = myPanel.x + offset;
			System.out.println(keycode);
		}
		else if(keycode == KeyEvent.VK_LEFT) {
			myPanel.x = myPanel.x - offset;
			System.out.println(keycode);
		}
		else if(keycode == KeyEvent.VK_UP) {
			myPanel.y = myPanel.y - offset;
			System.out.println(keycode);
		}
		else if(keycode == KeyEvent.VK_DOWN) {
			myPanel.y = myPanel.y + offset;
			System.out.println(keycode);
		}
		myPanel.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
