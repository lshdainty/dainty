package Test1;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame{
	public LoginPanel login = null;
	public PuzzlePanel puzzlePanel = null;
	public FinishPanel finishPanel = null;
	
	//생성자
	public MainFrame() {	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("그림 퍼즐 게임");
		
		this.login = new LoginPanel(this);	//로그인 패널 생성
		this.add(login);	//프레임에 로그인 패널 추가
		this.setVisible(true);	//눈에 보이게 한다.
	}
	
	//하나의 프레임에서 패널을 변경하기 위한 코드
	public void change(String panelName,String id) {
		if(panelName.equals("login")) {	//패널 이름을 가져와서 login하고 같으면
			getContentPane().removeAll();	//컨테이너에 있는 모든것을 가져와서 삭제하고
			this.login = new LoginPanel(this);
			getContentPane().add(login);	//로그인 패널을 추가한다.
			revalidate();
			repaint();
		}
		else if(panelName.equals("puzzlePanel")){
			getContentPane().removeAll();	//컨테이너에 있는 모든 것을 가져와서 삭제
			this.puzzlePanel = new PuzzlePanel(this,id);	
			getContentPane().add(puzzlePanel);	//게임 패널 추가
			revalidate();
			repaint();
		}
	}
	
	public void fchange(String panelName ,String id, int count , long actual_time) {
		if(panelName.equals("finishPanel")) {
			getContentPane().removeAll();	//컨테이너에 있는 모든 것을 가져와서 삭제
			this.finishPanel = new FinishPanel(this,id,count,actual_time);	
			getContentPane().add(finishPanel);	//마지막 결과패널 추가
			revalidate();
			repaint();
		}
	}
}	//ImagePuzzle01 class