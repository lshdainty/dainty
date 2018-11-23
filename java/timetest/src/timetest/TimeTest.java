package timetest;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TimeTest extends JFrame{
	static SimpleDateFormat time_format;	//우리가 사용하는 시간값으로 포맷하기위해
	static String show_time;	//진행시간 값을 받아들인다.
	static long start_time;	//시작시간 , 컴퓨터 시간 , 실제 게임 진행시간
	static long current_time;
	static long actual_time;
	
	public static void main(String[] args) {
		Thread th = new Thread();
		th.start();
		
		time_format = new SimpleDateFormat("HH:mm:ss.SSS");
		
		JFrame jf = new JFrame();
		JButton button = new JButton("시작");
		JButton fbutton = new JButton("종료");
		JButton rbutton = new JButton("초기화");
		JLabel label = new JLabel();	//시간 표시 label
		label.setFont(new Font("default",Font.BOLD,20));
		label.setText("00:00:00.000");
		
		jf.setLayout(new BorderLayout());
		//버튼 생성
		jf.add(button,BorderLayout.PAGE_START);
		jf.add(fbutton,BorderLayout.PAGE_END);
		jf.add(rbutton, BorderLayout.LINE_END);
		jf.add(label,BorderLayout.CENTER);
		
		button.addActionListener(new ActionListener() {	//로그인 버튼에 리스너 설정
			@Override
			public void actionPerformed(ActionEvent e) {
				start_time = System.currentTimeMillis();
			}
		});
		
		fbutton.addActionListener(new ActionListener() {	//로그인 버튼에 리스너 설정
			@Override
			public void actionPerformed(ActionEvent e) {
				current_time = System.currentTimeMillis();
				actual_time = current_time - start_time;
				show_time = time_format.format(actual_time-32400000);
				label.setText(show_time);
			}
		});
		
		button.addActionListener(new ActionListener() {	//로그인 버튼에 리스너 설정
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("00:00:00.000");
			}
		});
		
		jf.setSize(500,500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
