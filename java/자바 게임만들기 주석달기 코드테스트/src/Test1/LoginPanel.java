package Test1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginPanel extends JPanel{
	private MainFrame mainFrame;	//로그인에서만 설정변경하기 위한 mainFrame(panel을 정중앙에 하기위해서)
	private JButton btnLogin;	//로그인 버튼
	private JButton btnMember;	//회원가입버튼
	private JTextField userid;	//아이디입력
	private JPasswordField userpw;	//비밀번호입력
	private DBPanel db;
	private String id = "";	//field에서 입력받은 값을 저장하는 변수
	private String pw = "";	//field에서 입력받은 값을 저장하는 변수
	
	public LoginPanel(MainFrame mainFrame) {	//생성자
		this.mainFrame = mainFrame;
		this.mainFrame.setSize(280,150);
		this.mainFrame.setLocationRelativeTo(null);	//화면 정중앙 코드
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
					JOptionPane.showMessageDialog(null, "로그인 성공");
					mainFrame.change("puzzlePanel",id);	//1이면 게임프레임으로 넘어가기 위해 puzzelPanel로 변경한다.
				}
				else if(num == 0) {
					JOptionPane.showMessageDialog(null, "비밀번호가 맞지 않습니다.");
				}
				else if(num == -1) {
					JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다.");
				}
			}
		});
		
		btnMember = new JButton("회원가입");	//회원가입 버튼
		btnMember.setBounds(160,80,100,25);
		this.add(btnMember);
		btnMember.addActionListener(new ActionListener() {	//회원가입 버튼에 리스터 설정
			@Override
			public void actionPerformed(ActionEvent e) {
				if((id.equals(""))||(pw.equals(""))) {
					System.out.println(id);
					System.out.println(pw);
					JOptionPane.showMessageDialog(null, "칸을 다 채워주세요");
				}
				else { 
					memberInsert();	//회원가입
				}
			}
		});
	}
	
	public int loginCheck() {
		id = userid.getText();	//입력한 id값 불러오기
		pw = String.valueOf(userpw.getPassword());	//입력한 passwd값 불러오기
		db = DBPanel.getInstance();
		int num = db.select(id, pw);	//db에서 로그인 값 가져오기
		return num;
	}
	
	public void memberInsert() {
		id = userid.getText();	//입력한 id값 불러오기
		pw = String.valueOf(userpw.getPassword());	//입력한 passwd값 불러오기
		db = DBPanel.getInstance();
		db.insertmember(id, pw);	//db에 id,pw 저장하기
	}
}
