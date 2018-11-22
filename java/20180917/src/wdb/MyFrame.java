package wdb;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.Image;

class MyFrame extends JFrame {
	public MyFrame() {
		this.setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Title Test");
  
		// �������� �������� ����
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("toad.png");
		setIconImage(img);
  
		// �����̳ʿ� ��ġ �����ڸ� ����
		this.setLayout(new FlowLayout());
  
		// �����̳ʿ� ������Ʈ�� �߰��ϴ� �ڵ� ����
		// 1. ��ư ������Ʈ�� ����
		JButton button1 = new JButton("��ư");
		JButton button2 = new JButton("��ư");
  
		// 2. ������ ��ư ������Ʈ�� �����̳ʿ� �߰�
		this.add(button1);
		this.add(button2);
  
		setVisible(true);
	}
}