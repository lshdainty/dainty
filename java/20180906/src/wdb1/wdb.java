package wdb1;

public class wdb {

	public static void main(String[] args) {
		MyDb myObject = new MyDb();
		myObject.connectDB();
		//myObject.insertmember();	å ���� ��ȸ
		//myObject.select();	��� ���� ��� ���� ��ȸ
		//myObject.allRetrieve();	����ȸ
		//myObject.deleteBookID(6);	�����
		myObject.allRetrieve();
		//prepareStatement�� �̿��� ������ü ���
		myObject.insert(7,"test","test","test",25000);
		myObject.allRetrieve();
	}
}