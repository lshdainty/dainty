package Test1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginPanel extends JPanel{
	private JButton btnLogin;	//로그인 버튼
	private JButton btnMember;	//회원가입버튼
	private JTextField userid;	//아이디입력
	private JPasswordField userpw;	//비밀번호입력
	private MainFrame mainFrame;	//메인 프레임 저장
	
	public LoginPanel(MainFrame mainFrame) {	//생성자
		this.mainFrame = mainFrame;	//생성된 프레임객체를 받아와서 저장한다.
		mainFrame.setSize(280,150);	//login 패널의 사이즈를 지정한다.
		this.setLayout(null);	//절대값 배치를 하기위해 gui관리자를 해제한다.
		
		JLabel idLabel = new JLabel("id");	//id글씨 label
		idLabel.setBounds(10,10,80,25);
		this.add(idLabel);
		
		JLabel pwLabel = new JLabel("password");	//password글씨 label
		pwLabel.setBounds(10,40,80,25);
		this.add(pwLabel);
		
		userid = new JTextField(20);	//id를 받아오기 위한 것
		userid.setBounds(100,10,160,25);
		this.add(userid);
		
		userpw = new JPasswordField(20);	//비밀번호를 받아오기 위한 것
		userpw.setBounds(100,40,160,25);
		this.add(userpw);
		
		btnLogin = new JButton("로그인");	//로그인 버튼
		btnLogin.setBounds(10,80,100,25);
		this.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {	//로그인 버튼에 리스너 설정
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = loginCheck();	//db에서 로그인 성공하면 1을 반환
				if(num == 1) {
					mainFrame.change("puzzlePanel");	//1이면 게임프레임으로 넘어가기 위해 puzzelPanel로 변경한다.
				}
			}
		});
		
		btnMember = new JButton("회원가입");	//회원가입 버튼
		btnMember.setBounds(160,80,100,25);
		this.add(btnMember);
		btnMember.addActionListener(new ActionListener() {	//회원가입 버튼에 리스터 설정
			@Override
			public void actionPerformed(ActionEvent e) {
				memberInsert();	//회원가입
			}
		});
	}
	
	public int loginCheck() {
		String id = userid.getText();	//입력한 id값 불러오기
		char[] pw = userpw.getPassword();	//입력한 passwd값 불러오기
		String passwd = null;
		for(int i=0; i<pw.length; i++) {
			passwd = passwd + pw[i];	//배열로 저장된 문자를 합친다
		} 
		passwd = passwd.substring(4,pw.length+4);	//null값이 비번에 같이 들어가있어서 삭제하는 과정
		DBPanel db = new DBPanel();
		db.connectDB();	//db연결
		int num = db.select(id, passwd);	//db에서 로그인 값 가져오기
		return num;
	}
	
	public void memberInsert() {
		String id = userid.getText();	//입력한 id값 불러오기
		char[] pw = userpw.getPassword();	//입력한 passwd값 불러오기
		String passwd = null;
		for(int i=0; i<pw.length; i++) {	
			passwd = passwd + pw[i];	//배열로 저장된 문자를 합친다.
		} 
		passwd = passwd.substring(4,pw.length+4);	//null값이 비번에 같이 들어가있어서 삭제하는 과정
		DBPanel db = new DBPanel();
		db.connectDB();	//db연결
		db.insertmember(id, passwd);	//db에 id,pw 저장하기
	}
}
