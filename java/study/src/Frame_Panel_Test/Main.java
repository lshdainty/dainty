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
		label.setText("�ڹ� ���ڿ� ���� ���� ȯ���մϴ�. ������ ������ �����Ͻÿ�");
		
		JButton button1 = new JButton("�޺�����");
		JButton button2 = new JButton("������������");
		JButton button3 = new JButton("�Ұ������");		
		
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