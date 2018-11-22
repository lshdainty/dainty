import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
	
	MyFrame() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("이벤트 프레임");

		JPanel myPanel = new myPanel();
		
		add(myPanel);
		setVisible(true);
	}
}
