package Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

	public static void main(String[] args) {
		MyFrame myframe = new MyFrame();
		
	}
}

class MyFrame extends JFrame{
	
	MyFrame(){
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("color");
		
		JPanel panel = new MyPanel();
		add(panel);
		
		setVisible(true);
	}
}

class MyPanel extends JPanel implements ActionListener{
	Color color = new Color(0,0,0);
	
	MyPanel(){
		setLayout(new BorderLayout());
		JButton button = new JButton("시파 버튼 눌러라");
		button.addActionListener(this);
		add(button,BorderLayout.PAGE_END);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		g.fillRect(0, 0, 500, 500);
	}
	
	public void actionPerformed(ActionEvent e) {
		color = new Color((int)(Math.random()*255.0),(int)(Math.random()*255.0),(int)(Math.random()*255.0));
		repaint();
	}
}