import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
	MyFrame(){
		setSize(240,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("���� ���� �̺�Ʈ");
		setVisible(true);
		JPanel panel = new MyPanel();
		add(panel);
	}
}
