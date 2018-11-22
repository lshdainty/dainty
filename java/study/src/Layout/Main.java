package Layout;

import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		MyFrame myframe = new MyFrame();
	}
}

class MyFrame extends JFrame {
	MyFrame(){
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("test");
		
		JPanel panel = new MyPanel();
		add(panel);
		
		setVisible(true);
	}
}

class MyPanel extends JPanel{
	MyPanel(){
		//setLayout(new FlowLayout(FlowLayout.LEADING));	//LEADING CENTER TRAILING
		//add(new JButton("test1"));
		//add(new JButton("test3"));
		//add(new JButton("test5"));
		//add(new JButton("test7"));
		//add(new JButton("test9"));
		
		//setLayout(new BorderLayout());
		//add(new JButton("center"),BorderLayout.CENTER);
		//add(new JButton("line_start"),BorderLayout.LINE_START);
		//add(new JButton("line_end"),BorderLayout.LINE_END);
		//add(new JButton("page_start"),BorderLayout.PAGE_START);
		//add(new JButton("page_end"),BorderLayout.PAGE_END);
		
		setLayout(new GridLayout(3,2));
		add(new JButton("button1"));
		add(new JButton("button2"));
		add(new JButton("button3"));

		
	}
}