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
  
		// 프레임의 아이콘을 변경
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("toad.png");
		setIconImage(img);
  
		// 컨테이너에 배치 관리자를 설정
		this.setLayout(new FlowLayout());
  
		// 컨테이너에 컴포넌트를 추가하는 코드 삽입
		// 1. 버튼 컴포넌트를 생성
		JButton button1 = new JButton("버튼");
		JButton button2 = new JButton("버튼");
  
		// 2. 생성된 버튼 컴포넌트를 컨테이너에 추가
		this.add(button1);
		this.add(button2);
  
		setVisible(true);
	}
}