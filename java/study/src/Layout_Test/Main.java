package Layout_Test;

import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		MyFrame myframe = new MyFrame();
	}
}

class MyFrame extends JFrame{
	MyFrame(){
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("test2");
		
		JPanel panel = new MyPanel();
		add(panel);
		
		setVisible(true);
	}
}

class MyPanel extends JPanel{
	MyPanel(){
		setLayout(new GridLayout(3,0));
		add(new JButton("button1"));
		add(new JButton("button2"));
		add(new JButton("button3"));
		add(new JButton("button4"));
		add(new JButton("button5"));
		add(new JButton("button6"));
		add(new JButton("button7"));
		add(new JButton("button8"));
		add(new JButton("button9"));
		add(new JButton("button10"));
	}
}