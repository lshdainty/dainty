import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
	
	MyFrame() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�̺�Ʈ ������");

		JPanel myPanel = new myPanel();
		
		add(myPanel);
		setVisible(true);
	}
}
