package action;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import buttonevent.MyListener;

public class MyFrame extends JFrame{
	private JButton buttonYellow;
	private JButton buttonPink;
	private JPanel panel;
	
	//생성자
	public MyFrame() {
		setSize(300,200);	//프레인 크기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//x표시 누르면 꺼짐(이것이 없으면 창은 꺼도 프로그램은 계속 돌아가는중)
		setTitle("액션 이벤트 예제");	//타이틀 명
		
		//컴포넌트 생성(버튼 색상)
		panel = new JPanel();	//패널 생성
		buttonPink = new JButton("핑크색");	//버튼 핑크
		buttonYellow = new JButton("노란색");	//버튼 엘로우
		panel.add(buttonPink);
		buttonPink.addActionListener(new MyListener1(panel));
		panel.add(buttonYellow);
		buttonYellow.addActionListener(new MyListener1(panel));
		
		//키보드 
		panel.addKeyListener(new MyKeyListener(panel));
		
		
		this.add(panel);
		this.setVisible(true);
		//키보드
		panel.setFocusable(true);	//이 컴포넌트가 event 포커스를 받을 수 있도록 설정 해주는것이다.

	}
}
