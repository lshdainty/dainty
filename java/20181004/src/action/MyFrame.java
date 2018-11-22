package action;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import buttonevent.MyListener;

public class MyFrame extends JFrame{
	private JButton buttonYellow;
	private JButton buttonPink;
	private JPanel panel;
	
	//������
	public MyFrame() {
		setSize(300,200);	//������ ũ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//xǥ�� ������ ����(�̰��� ������ â�� ���� ���α׷��� ��� ���ư�����)
		setTitle("�׼� �̺�Ʈ ����");	//Ÿ��Ʋ ��
		
		//������Ʈ ����(��ư ����)
		panel = new JPanel();	//�г� ����
		buttonPink = new JButton("��ũ��");	//��ư ��ũ
		buttonYellow = new JButton("�����");	//��ư ���ο�
		panel.add(buttonPink);
		buttonPink.addActionListener(new MyListener1(panel));
		panel.add(buttonYellow);
		buttonYellow.addActionListener(new MyListener1(panel));
		
		//Ű���� 
		panel.addKeyListener(new MyKeyListener(panel));
		
		
		this.add(panel);
		this.setVisible(true);
		//Ű����
		panel.setFocusable(true);	//�� ������Ʈ�� event ��Ŀ���� ���� �� �ֵ��� ���� ���ִ°��̴�.

	}
}
