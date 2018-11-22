package Frame_Panel_Test;

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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("test1");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.blue);
		JPanel panelA = new JPanel();
		panelA.setBackground(Color.green);
		JPanel panelB = new JPanel();
		panelB.setBackground(Color.red);
		
		JLabel label = new JLabel();
		label.setText("자바 피자에 오신 것을 환영합니다. 피자의 종류를 선택하시오");
		
		JButton button1 = new JButton("콤보피자");
		JButton button2 = new JButton("포테이토피자");
		JButton button3 = new JButton("불고기피자");		
		
		this.add(panel);
		panel.add(panelA);
		panel.add(panelB);
		panelA.add(label);
		panelB.add(button1);
		panelB.add(button2);
		panelB.add(button3);
		
		setVisible(true);
	}
}