package graphic;
import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		MyFrame myframe = new MyFrame();
	}
}

class MyFrame extends JFrame{
	MyFrame(){
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("graphic");
		
		JPanel panel = new MyPanel();
		add(panel);
		
		setVisible(true);
	}
}

class MyPanel extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("���� �׷��� �׽�Ʈ���̴�.", 10, 100);	//���� ����
		g.drawLine(20, 20, 100, 100);	//���߱�(������ġx,������ġy,����ġx,����ġ,y)
		g.drawRect(30, 30, 50, 50);		//������ �簢��(������ġx,������ġy,�簢�� ũ��x,�簢�� ũ��y)
		g.fillRect(40, 40, 50, 50);		//ä���� �簢��
		g.drawRoundRect(100,100,50,50,30,30);	//������ �簢��(������ġx,������ġy,�簢�� ũ��x,�簢�� ũ��y,����,����)
		g.fillRoundRect(200,200,50,50,30,30);	//������ �簢��(������ġx,������ġy,�簢�� ũ��x,�簢�� ũ��y,����,����)
		g.drawOval(100, 200, 50, 50);	//������ ����(������ġx,������ġy,x,y)
		g.fillOval(200, 100, 50, 50);
		g.drawArc(300, 300, 50, 50, 190, 160);
		g.fillArc(200, 400, 50, 50, 190, 160);
	}
	
}