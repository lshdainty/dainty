import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class myPanel extends JPanel{
	BufferedImage img = null;
	int x = 0;
	int y = 0;
	
	//생성자
	public myPanel() {
		try {
			img = ImageIO.read(new File("C:\\Users\\bon320-15\\Desktop\\1.png"));
		}catch(Exception e) {
			System.out.println("이미지를 찾을수 없습니다.");
			System.exit(1);
		}
		//리스터 등록
		this.addKeyListener(new MyKeyListener(this));
		this.setFocusable(true);	// 포커스 받을 수 있게 해줌
		this.requestFocus();	//포커스 요청
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img,x,y,null);
	}
}