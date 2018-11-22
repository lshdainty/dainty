import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel{

   @Override
   protected void paintComponent(Graphics g) {
      // TODO Auto-generated method stub
      super.paintComponent(g);
      g.drawString("이상혁",230,470);
      g.drawLine(0,0,500,0);	//캔버스 테두리
      g.drawLine(0,0,0,500);	//캔버스 테두리
      g.drawLine(500,0,500,500);	//캔버스 테두리
      g.drawLine(0,500,500,500);	//캔버스 테두리
      g.drawOval(150,50,200,200);	//얼굴
      g.drawArc(195,80,50,50,0,180);	//왼눈썹
      g.drawOval(200,90,40,40);	//왼눈
      g.setColor(Color.black);
      g.fillOval(205, 100, 30, 30);	//왼눈동자
      g.fillOval(260, 100, 30, 30);	//오른눈동자
      g.drawOval(255,90,40,40);	//오른눈
      g.drawArc(250,80,50,50,0,180);	//왼눈썹
      g.drawArc(215,170,70,70,180,180);	//입
      g.drawLine(250, 250, 250, 400);	//몸통
      g.drawLine(250, 250, 150, 300);	//왼팔
      g.drawLine(250, 250, 350, 300);	//오른팔
      g.drawLine(250, 400, 150, 450);	//왼다리
      g.drawLine(250, 400, 350, 450);	//오른다리
      g.setColor(Color.pink);
      g.fillOval(205,130,90,70);	//코
      g.setColor(Color.white);
      g.fillOval(210, 150, 30, 30);	
      g.fillOval(260, 150, 30, 30);
   }
   // 그림을 그리기 위해 필요한 메소드를 override해야한다고 했다.
   
}

class MyFrame extends JFrame {
   public MyFrame() {
      setTitle("그래픽테스트");
      setSize(600,600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      // Panel을 생성하여 추가한다. 
      MyPanel myPanel = new MyPanel();
      add(myPanel);
      
   }
}

public class WDB {
   
   public static void main(String[] args) {
      MyFrame myFrame = new MyFrame();
   }
   
}