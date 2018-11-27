package Test1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class FinishPanel extends JPanel{
	private MainFrame mainFrame;	//finish에서만 설정변경하기 위한 mainFrame(panel을 정중앙에 하기위해서)
	private SimpleDateFormat time_format;
	private String show_time;
	private JTable table;
	private DBPanel db;
	
	public FinishPanel(MainFrame mainFrame, String id, int count, long actual_time) {
		this.mainFrame = mainFrame;
		time_format = new SimpleDateFormat("HH:mm:ss.SSS");	//우리에게 익숙한 시간포맷으로 변경한다.
		show_time = time_format.format(actual_time-32400000);	//actual_time은 초로 되어있어 계산을 해야하며 한국시간 기준으로 9시간을 초로 계산해서 빼준다.
		db = DBPanel.getInstance();
		db.insertLog(id,count,show_time);	//db에 id와 클릭횟수 , 게임 시간을 저장한다.
		ArrayList<DBData> list = db.selectLog(id);	//db에서 로그인한 id의 게임 기록을 가져온다.
		//*************************************************
		//db에 기록저장하고 기록을 가져오는것까지
		//*************************************************
		setLayout(new BorderLayout());	//레이아웃의 배치를 border로 셋팅
		
		Vector<String> column = new Vector<>();	//열이름 생성
		column.add("id");
		column.add("count");
		column.add("time");
		column.add("day");
		Vector<Object> dataSet = new Vector<>();	//행의 데이터를 저장하는 객체
		
		for(DBData d : list){
			Vector row = new Vector();	//하나의 행을 저장하는 행 객체
			row.add(d.getId());	//db에서 id값 가져오기
			row.add(d.getCount());	//db에서 클릭값 가져오기
			row.add(d.getTime());	//db에서 게임시간값 가져오기
			row.add(d.getInsertTime());
			dataSet.add(row);	//dateSet에 행을 추가
		}
		
		table = new JTable(dataSet,column);	//JTable에 전체 행과 열을 추가해서 생성
		JScrollPane scrollList = new JScrollPane(table);	//scrollPane에 테이블을 넣어서 생성
		JButton button = new JButton("확인");
		this.mainFrame.setSize(500,500);
		this.mainFrame.setLocationRelativeTo(null);	//화면 정중앙 코드
		add(scrollList,BorderLayout.CENTER);	//패널에 추가
		add(button,BorderLayout.PAGE_END);
		button.addActionListener(new ActionListener() {	//확인 버튼에 리스터 설정
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	//게임 종료
			}
		});
	}
}
