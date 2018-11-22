import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

//1.리스너 인터페이스 상속
//2.버튼에 리스너 등록\
//3.리스너 이벤트 처리 메소드 구현 

public class MyPanel extends JPanel implements ActionListener{	//1번 인터페이스 상속
	private JButton button;
	private Color color = new Color(0,0,0);
	BufferedImage img = null;
	
	MyPanel(){
		setLayout(new BorderLayout());
		button = new JButton("색상 변경");
		button.addActionListener(this);	//2번 버튼에 리스너 등록
		add(button, BorderLayout.SOUTH);
		try {
			img = ImageIO.read(new File("C:\\Users\\bon320-15\\Desktop\\이미지.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(color);
		g.fillRect(10, 10, 200, 20);
		Font f1 = new Font("serif",Font.PLAIN,20);
		g.setFont(f1);
		g.drawString("serif 20 PLAIN", 20 ,60);
		Font f2 = new Font("San Serif",Font.BOLD,20);
		g.setFont(f2);
		g.drawString("San Serif 20 BOLD", 20, 80);
		Font f3 = new Font("굴림체",Font.ITALIC,20);
		g.setFont(f3);
		g.drawString("굴림체 20 ITALIC", 20, 100);
		Font f4 = new Font("궁서체",Font.PLAIN,20);
		g.setFont(f4);
		g.drawString("궁서체 20 PLAIN", 20, 120);
		Font f5 = new Font("맑은고딕",Font.BOLD,20);
		g.setFont(f5);
		g.drawString("맑은고딕 20 BOLD", 20, 140);
		
		g.drawImage(img,0,0,null);
	}



	@Override	//3번 리스너 이벤트 처리 메소드 구현
	public void actionPerformed(ActionEvent e) {
		color = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		System.out.println("리스너 이벤트 처리 메소드 호출");
		repaint();
	}
}
