package wdb1;

public class wdb {

	public static void main(String[] args) {
		MyDb myObject = new MyDb();
		myObject.connectDB();
		//myObject.insertmember();	책 제목만 조회
		//myObject.select();	모든 행의 모든 열을 조회
		//myObject.allRetrieve();	열조회
		//myObject.deleteBookID(6);	행삭제
		myObject.allRetrieve();
		//prepareStatement를 이용한 쿼리객체 사용
		myObject.insert(7,"test","test","test",25000);
		myObject.allRetrieve();
	}
}