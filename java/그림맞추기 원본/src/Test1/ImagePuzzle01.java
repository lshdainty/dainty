package Test1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ImagePuzzle01 extends JFrame implements ActionListener{
	JButton[] btn;
	int count=0;
	int game[];
	int row = 4;
	int col = 4;
	int clickCount,oldNum,curNum;
	Image original;
	BufferedImage img[];
	
	public ImagePuzzle01() {
		//원본 그림 읽기
		MediaTracker tracker = new MediaTracker(this);
		original = Toolkit.getDefaultToolkit().getImage("test2.jpg");
		tracker.addImage(original, 0);
		try {
			tracker.waitForAll();
		}catch(InterruptedException e) {
			
		}
		int width = original.getWidth(this)/col;
		int height = original.getHeight(this)/row;
		setSize(new Dimension(width*col,height*row));
		
		//이미지 잘라서 넣기
		img = new BufferedImage[row*col];
		int cnt = 0;
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				img[cnt] = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
				Graphics g = img[cnt].getGraphics();
				//원본이미지에서 필요한 부분만 잘라서 그리기
				g.drawImage(original, 0, 0, width, height, j*width, i*height, (j+1)*width, (i+1)*height, this);
				cnt++;
			}
		}
		
		//게임 배열
		game = new int[row*col];
		
		//버튼 만들기
		btn = new JButton[row*col];
		
		for(int i=0; i<row*col; i++) {
			btn[i] = new JButton();
			btn[i].addActionListener(this);
			add(btn[i]);
		}
		
		shuffle();	//숫자 섞고 버튼에 이미지 입히기
		setLayout(new GridLayout(row,col));
		
		setResizable(false);
		setVisible(true);
	}	//ImagePuzzle01메소드
	
	//숫자 섞고 버튼에 이미지 입히기
	private void shuffle() {
		Random rnd = new Random();
		
		do {
			for(int i =0; i<row*col; i++) {
				game[i] = 0;
			}
			//배열에 중복값없이 넣기
			for(int i =0; i<row*col; i++) {
				int temp = 0;
				do {
					temp = rnd.nextInt(row*col);
				}while(game[temp]!=0);
				game[temp] = i;
			}
		}while(endGame());	//섞이지 않았으면 다시 섞어라
		
		//배열값으로 이미지를 선택해서 버튼에 부여
		for(int i=0; i<row*col; i++) {
			btn[i].setIcon(new ImageIcon(img[game[i]]));
		}
	}
	
	public static void main(String[] args) {
		new ImagePuzzle01();
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton curBtn = (JButton)e.getSource();
		
		for(int i=0; i<btn.length; i++) {
			if(curBtn.getIcon().equals(btn[i].getIcon())) {
				//System.out.println(i+":"+game[i]);
				curNum = i;
				break;
			}
		}
		
		if(clickCount==0) {	//첫번째 클릭이면
			clickCount++;
			oldNum = curNum;
		}
		else {	//두번째 클릭이면
			if(oldNum!=curNum) {	//이전 것과 같지 않다면
				
				//이미지 변경
				btn[oldNum].setIcon(new ImageIcon(img[game[curNum]]));
				btn[curNum].setIcon(new ImageIcon(img[game[oldNum]]));
				
				//배열값 변경
				int t = game[oldNum];
				game[oldNum] = game[curNum];
				game[curNum] = t;
				
				//여기서 게임 종료확인
				if(endGame()) {
					JOptionPane.showMessageDialog(this, "Success!");
					//게임 재시작을 확인
					int reStart = JOptionPane.showConfirmDialog(this,"restart?","exit?",JOptionPane.YES_NO_OPTION);
					if(reStart==JOptionPane.YES_OPTION) {
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
	
	private Boolean endGame() {
		boolean endGame = true;
		
		for(int i=0; i<game.length; i++) {
			if(i!=game[i]) {
				endGame = false;
			}
		}
		return endGame;
	}	//endGame
}	//ImagePuzzle01 class