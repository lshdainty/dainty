package Test1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginPanel extends JPanel{
	private JButton btnLogin;	//로그인 버튼
	private JButton btnMember;	//회원가입버튼
	private JTextField userid;	//아이디입력
	private JPasswordField userpw;	//비밀번호입력
	//private MainFrame mainFrame;
	
	public LoginPanel() {	//생성자
		//this.mainFrame = mainFrame;
		
		JLabel idLabel = new JLabel("id");
		idLabel.setBounds(10,10,80,25);
		this.add(idLabel);
		
		JLabel pwLabel = new JLabel("password");
		pwLabel.setBounds(10,40,80,25);
		this.add(pwLabel);
		
		userid = new JTextField(20);
		userid.setBounds(100,10,160,25);
		this.add(userid);
		
		userpw = new JPasswordField(20);
		userpw.setBounds(100,40,160,25);
		this.add(userpw);
		
		btnLogin = new JButton("로그인");
		btnLogin.setBounds(10,80,100,25);
		this.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginCheck();
				//int num = loginCheck();
				//if(num == 1) {
				//	mainFrame.change("puzzlePanel");
				//}
			}
		});
		
		btnMember = new JButton("회원가입");
		btnMember.setBounds(160,80,100,25);
		this.add(btnMember);
		btnMember.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				memberInsert();
			}
		});
	}
	
	public int loginCheck() {
		String id = userid.getText();
		char[] pw = userpw.getPassword();
		String passwd = null;
		for(int i=0; i<pw.length; i++) {
			passwd = passwd + pw[i];
		} 
		passwd = passwd.substring(4,pw.length+4);	//null값이 비번에 같이 들어가있어서 삭제하는 과정
		DBPanel db = new DBPanel();
		db.connectDB();
		int num = db.select(id, passwd);
		return num;
	}
	
	public void memberInsert() {
		String id = userid.getText();
		char[] pw = userpw.getPassword();
		String passwd = null;
		for(int i=0; i<pw.length; i++) {
			passwd = passwd + pw[i];
		} 
		passwd = passwd.substring(4,pw.length+4);	//null값이 비번에 같이 들어가있어서 삭제하는 과정
		DBPanel db = new DBPanel();
		db.connectDB();
		db.insertmember(id, passwd);
	}
}
