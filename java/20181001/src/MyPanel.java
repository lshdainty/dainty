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

//1.������ �������̽� ���
//2.��ư�� ������ ���\
//3.������ �̺�Ʈ ó�� �޼ҵ� ���� 

public class MyPanel extends JPanel implements ActionListener{	//1�� �������̽� ���
	private JButton button;
	private Color color = new Color(0,0,0);
	BufferedImage img = null;
	
	MyPanel(){
		setLayout(new BorderLayout());
		button = new JButton("���� ����");
		button.addActionListener(this);	//2�� ��ư�� ������ ���
		add(button, BorderLayout.SOUTH);
		try {
			img = ImageIO.read(new File("C:\\Users\\bon320-15\\Desktop\\�̹���.jpg"));
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
		Font f3 = new Font("����ü",Font.ITALIC,20);
		g.setFont(f3);
		g.drawString("����ü 20 ITALIC", 20, 100);
		Font f4 = new Font("�ü�ü",Font.PLAIN,20);
		g.setFont(f4);
		g.drawString("�ü�ü 20 PLAIN", 20, 120);
		Font f5 = new Font("�������",Font.BOLD,20);
		g.setFont(f5);
		g.drawString("������� 20 BOLD", 20, 140);
		
		g.drawImage(img,0,0,null);
	}



	@Override	//3�� ������ �̺�Ʈ ó�� �޼ҵ� ����
	public void actionPerformed(ActionEvent e) {
		color = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		System.out.println("������ �̺�Ʈ ó�� �޼ҵ� ȣ��");
		repaint();
	}
}
