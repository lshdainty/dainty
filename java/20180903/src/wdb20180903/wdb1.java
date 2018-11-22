package wdb20180903;

public class wdb1 {
	public static void main(String[] args) {
		MyDb myObject = new MyDb();
		myObject.connectDB();
		//myObject.insertmember();
		myObject.select();
	}
}
