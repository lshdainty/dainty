package Test1;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame{
	//public LoginPanel login = null;
	//public PuzzlePanel puzzlePanel = null;
	
	//생성자
	public MainFrame() {	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("그림 퍼즐 만들기");
		
//		login = new LoginPanel(this);
//		puzzlePanel = new PuzzlePanel(this);
//		login.setSize(280,150);
//		puzzlePanel.setSize(puzzlePanel.getWidth(),puzzlePanel.getHeight());
//		this.add(login);
//		setVisible(true);
		
		LoginPanel login = new LoginPanel();
		setSize(280,150);
		this.add(login);
		setVisible(true);
		
		PuzzlePanel puzzlePanel = new PuzzlePanel();	//그림퍼즐 객체생성
		setSize(puzzlePanel.getWidth(),puzzlePanel.getHeight());	//크기는 사진의 크기
		setResizable(false);	//사이즈조정 불가
		this.add(puzzlePanel);	//프레임에 panel추가
		setVisible(true);	//눈에 보이게 하기
	}	//ImagePuzzle01메소드
	
//	public void change(String panelName) {
//		if(panelName.equals("login")) {
//			getContentPane().removeAll();
//			getContentPane().add(login);
//			revalidate();
//			repaint();
//		}
//		else {
//			getContentPane().removeAll();
//			getContentPane().add(puzzlePanel);
//			revalidate();
//			repaint();
//		}
//	}
}	//ImagePuzzle01 class