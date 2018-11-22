import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class myPanel extends JPanel{
	BufferedImage img = null;
	int x = 0;
	int y = 0;
	
	//������
	public myPanel() {
		try {
			img = ImageIO.read(new File("C:\\Users\\bon320-15\\Desktop\\1.png"));
		}catch(Exception e) {
			System.out.println("�̹����� ã���� �����ϴ�.");
			System.exit(1);
		}
		//������ ���
		this.addKeyListener(new MyKeyListener(this));
		this.setFocusable(true);	// ��Ŀ�� ���� �� �ְ� ����
		this.requestFocus();	//��Ŀ�� ��û
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img,x,y,null);
	}
}