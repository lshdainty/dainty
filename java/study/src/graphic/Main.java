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
		g.drawString("드디어 그래픽 테스트중이다.", 10, 100);	//글자 적기
		g.drawLine(20, 20, 100, 100);	//선긋기(시작위치x,시작위치y,끝위치x,끝위치,y)
		g.drawRect(30, 30, 50, 50);		//선으로 사각형(시작위치x,시작위치y,사각형 크기x,사각형 크기y)
		g.fillRect(40, 40, 50, 50);		//채워진 사각형
		g.drawRoundRect(100,100,50,50,30,30);	//선으로 사각형(시작위치x,시작위치y,사각형 크기x,사각형 크기y,라운드,라운드)
		g.fillRoundRect(200,200,50,50,30,30);	//선으로 사각형(시작위치x,시작위치y,사각형 크기x,사각형 크기y,라운드,라운드)
		g.drawOval(100, 200, 50, 50);	//선으로 원형(시작위치x,시작위치y,x,y)
		g.fillOval(200, 100, 50, 50);
		g.drawArc(300, 300, 50, 50, 190, 160);
		g.fillArc(200, 400, 50, 50, 190, 160);
	}
	
}