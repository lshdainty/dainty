import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel{

   @Override
   protected void paintComponent(Graphics g) {
      // TODO Auto-generated method stub
      super.paintComponent(g);
      g.drawString("�̻���",230,470);
      g.drawLine(0,0,500,0);	//ĵ���� �׵θ�
      g.drawLine(0,0,0,500);	//ĵ���� �׵θ�
      g.drawLine(500,0,500,500);	//ĵ���� �׵θ�
      g.drawLine(0,500,500,500);	//ĵ���� �׵θ�
      g.drawOval(150,50,200,200);	//��
      g.drawArc(195,80,50,50,0,180);	//�޴���
      g.drawOval(200,90,40,40);	//�޴�
      g.setColor(Color.black);
      g.fillOval(205, 100, 30, 30);	//�޴�����
      g.fillOval(260, 100, 30, 30);	//����������
      g.drawOval(255,90,40,40);	//������
      g.drawArc(250,80,50,50,0,180);	//�޴���
      g.drawArc(215,170,70,70,180,180);	//��
      g.drawLine(250, 250, 250, 400);	//����
      g.drawLine(250, 250, 150, 300);	//����
      g.drawLine(250, 250, 350, 300);	//������
      g.drawLine(250, 400, 150, 450);	//�޴ٸ�
      g.drawLine(250, 400, 350, 450);	//�����ٸ�
      g.setColor(Color.pink);
      g.fillOval(205,130,90,70);	//��
      g.setColor(Color.white);
      g.fillOval(210, 150, 30, 30);	
      g.fillOval(260, 150, 30, 30);
   }
   // �׸��� �׸��� ���� �ʿ��� �޼ҵ带 override�ؾ��Ѵٰ� �ߴ�.
   
}

class MyFrame extends JFrame {
   public MyFrame() {
      setTitle("�׷����׽�Ʈ");
      setSize(600,600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      // Panel�� �����Ͽ� �߰��Ѵ�. 
      MyPanel myPanel = new MyPanel();
      add(myPanel);
      
   }
}

public class WDB {
   
   public static void main(String[] args) {
      MyFrame myFrame = new MyFrame();
   }
   
}