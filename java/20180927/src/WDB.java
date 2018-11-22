import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel{

   @Override
   protected void paintComponent(Graphics g) {
      // TODO Auto-generated method stub
      super.paintComponent(g);
      g.drawString("ÀÌ»óÇõ",230,470);
      g.drawLine(0,0,500,0);	//Äµ¹ö½º Å×µÎ¸®
      g.drawLine(0,0,0,500);	//Äµ¹ö½º Å×µÎ¸®
      g.drawLine(500,0,500,500);	//Äµ¹ö½º Å×µÎ¸®
      g.drawLine(0,500,500,500);	//Äµ¹ö½º Å×µÎ¸®
      g.drawOval(150,50,200,200);	//¾ó±¼
      g.drawArc(195,80,50,50,0,180);	//¿Þ´«½ç
      g.drawOval(200,90,40,40);	//¿Þ´«
      g.setColor(Color.black);
      g.fillOval(205, 100, 30, 30);	//¿Þ´«µ¿ÀÚ
      g.fillOval(260, 100, 30, 30);	//¿À¸¥´«µ¿ÀÚ
      g.drawOval(255,90,40,40);	//¿À¸¥´«
      g.drawArc(250,80,50,50,0,180);	//¿Þ´«½ç
      g.drawArc(215,170,70,70,180,180);	//ÀÔ
      g.drawLine(250, 250, 250, 400);	//¸öÅë
      g.drawLine(250, 250, 150, 300);	//¿ÞÆÈ
      g.drawLine(250, 250, 350, 300);	//¿À¸¥ÆÈ
      g.drawLine(250, 400, 150, 450);	//¿Þ´Ù¸®
      g.drawLine(250, 400, 350, 450);	//¿À¸¥´Ù¸®
      g.setColor(Color.pink);
      g.fillOval(205,130,90,70);	//ÄÚ
      g.setColor(Color.white);
      g.fillOval(210, 150, 30, 30);	
      g.fillOval(260, 150, 30, 30);
   }
   // ±×¸²À» ±×¸®±â À§ÇØ ÇÊ¿äÇÑ ¸Þ¼Òµå¸¦ overrideÇØ¾ßÇÑ´Ù°í Çß´Ù.
   
}

class MyFrame extends JFrame {
   public MyFrame() {
      setTitle("±×·¡ÇÈÅ×½ºÆ®");
      setSize(600,600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      // PanelÀ» »ý¼ºÇÏ¿© Ãß°¡ÇÑ´Ù. 
      MyPanel myPanel = new MyPanel();
      add(myPanel);
      
   }
}

public class WDB {
   
   public static void main(String[] args) {
      MyFrame myFrame = new MyFrame();
   }
   
}