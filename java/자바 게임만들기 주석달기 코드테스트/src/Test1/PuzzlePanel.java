package Test1;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PuzzlePanel extends JPanel implements ActionListener{	//그림퍼즐 패널
	//MainFrame mainFrame;
	JButton[] btn;	//버튼 배열 생성
	int count;	//원본에서는 사용하는것이 없지만 이걸 클릭 카운트로 사용 예정
	int game[];		//전체 게임 열과 행의 곱한 수
	int row = 0;
	int col = 0;
	int clickCount,oldNum,curNum;	//클릭을 했는지 안했는지에 대한 카운트
	Image original;	//이미지 가져와서 저장하기 위한 변수
	String photo;	//사진 경로 저장변수
	BufferedImage img[];	//이미지를 잘라서 저장하기 위한 배열
	/*bufferedImage로 한 이유는 image 클래스를 상속받은 클래스로 직접 이미지 데이터를 처리할 수 있다.
	 * 픽셀을 읽거나 쓸 수 있다.
	 */
	
	public PuzzlePanel() {	//생성자
		//this.mainFrame = mainFrame;
		
		String x = JOptionPane.showInputDialog(null,"행의 숫자를 입력해주세요",JOptionPane.OK_CANCEL_OPTION);	//행을 입력받는다.
		String y = JOptionPane.showInputDialog(null,"열의 숫자를 입력해주세요",JOptionPane.OK_CANCEL_OPTION);	//열을 입력받는다.
		photo = JOptionPane.showInputDialog(null,"사진 경로를 입력해주세요",JOptionPane.OK_CANCEL_OPTION);	//사진 경로를 입력받는다.
		this.row = Integer.parseInt(x);
		this.col = Integer.parseInt(y);
		
		//원본 그림 읽기
		try {
			original = ImageIO.read(new File(photo));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		int width = original.getWidth(this)/col;	//넓이는 사진의 전체 넓이에서 열의 수만큼 나눈다.
		int height = original.getHeight(this)/row;	//높이는 사진의 전체 높이에서 행의 수만큼 나눈다.
		
		//이미지 잘라서 넣기
		img = new BufferedImage[row*col];	//이미지 배열의 크기는 행과 열의 수만큼 곱한 것이 크기가 된다.
		int cnt = 0;	//배열의 인덱스
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				img[cnt] = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);	//이미지 배열에 그 이미지의 가로시작위치,세로시작위치를 객체로 생성후 대입한다.
				Graphics g = img[cnt].getGraphics();
				//원본이미지에서 필요한 부분만 잘라서 그리기
				g.drawImage(original, 0, 0, width, height, j*width, i*height, (j+1)*width, (i+1)*height, this);
				cnt++;	//배열의 인덱스 증가
			}
		}
		
		//게임 배열
		game = new int[row*col];
		
		//버튼 만들기
		btn = new JButton[row*col];
		
		for(int i=0; i<row*col; i++) {
			btn[i] = new JButton();	//인덱스 수만큼 버튼을 생성
			btn[i].addActionListener(this);	//각 버튼에 이벤트 리스터 생성
			add(btn[i]);	//버튼 배열 추가
		}
		
		shuffle();	//숫자 섞고 버튼에 이미지 입히기
		setLayout(new GridLayout(row,col));	//레이아웃은 grid로 하고 행,열수를 지정
		
		//setResizable(false);	//사이즈를 늘리면 버튼이 커지고 이미지는 그대로이므로 크기를 고정시킨다.
		//setVisible(true);	//눈에 보이도록 한다.
	}	//ImagePuzzle01메소드
	
	//숫자 섞고 버튼에 이미지 입히기
	private void shuffle() {
		Random rnd = new Random();
			
		do {
			for(int i =0; i<row*col; i++) {
				game[i] = 0;	//각 게임값을 0으로 초기화
			}
			//배열에 중복값없이 넣기
			for(int i =0; i<row*col; i++) {
				int temp = 0;
				do {
					temp = rnd.nextInt(row*col);	//temp에는 랜덤정수값이 들어간다.
				}while(game[temp]!=0);	//game[랜덤값]이 0이 아니면 값이 있다는 것이므로 다시 돌린다.
				game[temp] = i;	//game[랜덤값]에 i를 넣는다.
			}
		}while(endGame());	//섞이지 않았으면 다시 섞어라
		
		//배열값으로 이미지를 선택해서 버튼에 부여
		for(int i=0; i<row*col; i++) {
			btn[i].setIcon(new ImageIcon(img[game[i]]));	//버튼의 각 인덱스에 랜덤으로 변경된 그림을 설정한다.
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton curBtn = (JButton)e.getSource();
		
		for(int i=0; i<btn.length; i++) {	//버튼의 길이만큼 반복문 실행
			if(curBtn.getIcon().equals(btn[i].getIcon())) {	//이벤트의 이미지를 가져와서 비교하는데 버튼에 저장된 이미지와 같으면
				//System.out.println(i+":"+game[i]);
				curNum = i;	//curNum에 i를 저장한다.	이미지가 같아야 번호를 저장할 수 있으므로
				break;
			}
		}
		
		if(clickCount==0) {	//첫번째 클릭이면
			clickCount++;	//카운트 증가후
			oldNum = curNum;	//oldNum에 현재의 값을 넣는다.
		}
		else {	//두번째 클릭이면
			if(oldNum!=curNum) {	//같은 그림을 클릭했을 수도 있으므로 첫번째(oldnum)과 두번째(curnum)가 같지않다면 실행
				
				this.count++;	//몇번을 카운트했는지 알려주기 위한 count
				
				//이미지 변경
				btn[oldNum].setIcon(new ImageIcon(img[game[curNum]]));
				btn[curNum].setIcon(new ImageIcon(img[game[oldNum]]));
				
				//배열값 변경
				int t = game[oldNum];
				game[oldNum] = game[curNum];
				game[curNum] = t;
				
				//여기서 게임 종료확인
				if(endGame()) {	//인덱스 번호와 게임의 번호가 같은지 확인 true이면
					JOptionPane.showMessageDialog(this, "Success!");	//성공했다는 메세지를 출력
					JOptionPane.showMessageDialog(this, count+"번 클릭했습니다.");
					//게임 재시작을 확인
					int reStart = JOptionPane.showConfirmDialog(this,"restart?","exit?",JOptionPane.YES_NO_OPTION);
					if(reStart==JOptionPane.YES_OPTION) {
						count = 0;
						shuffle();	//섞기
						repaint();	//다시 그리기
					}
					else {
						System.exit(0);
					}
				}
			}
			clickCount = 0;
		}
	}	//actionPerformed
	
	private Boolean endGame() {	//버튼의 순서가 i와 같으면 모든 그림을 맞췄다 더이상 할 것이 없다.
		boolean endGame = true;
		
		for(int i=0; i<game.length; i++) {
			if(i!=game[i]) {	//게임의 인덱스 번호와 i가 같지않다면 
				endGame = false;	//게임은 끝난 것이 아니다
			}
		}
		return endGame;
	}	//endGame
}
