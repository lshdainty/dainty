import java.util.HashMap;
import java.util.LinkedList;

public class WDB {

	public static void main(String[] args) {
		//����Ʈ ����
		LinkedList<String> list = new LinkedList<String>();
		
		//����Ʈ �߰�
		list.add("����");
		list.add("��");
		list.add("����");
		
		//����Ʈ ���
		for(int i =0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	System.out.println("******************************");
		
		//����Ʈ ���� ����
		list.set(1,"�Һ���");
		
		//����� ���븣�� ���
		for(int i =0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	System.out.println("******************************");
		
		/*map�ȿ� hashmap�̶��� �ִ�.
		 * Integer�� Ű���� ���� Ÿ�� , String�� ���� ���� Ÿ��
		 * �迭�� ��������� �ε����� integer�� �� ���� �ְ� String���� �� ���� �ִ�.
		 */
		HashMap<Integer,String> st = new HashMap<Integer,String>();
		st.put(1, "ȫ�浿");
		st.put(2, "������");
		
		//�� ���
		String a = st.get(1);
		System.out.println(a);
		
	System.out.println("******************************");
		
		HashMap<String,String> st1 = new HashMap<String,String>();
		st1.put("ȫ�浿��", "ȫ�浿");
		st1.put("������", "������");
		
		//�� ���
		String a1 = st1.get("������");
		System.out.println(a1);
	}

}