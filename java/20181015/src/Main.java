import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		/*
		//String data = "dsafadsfdsaf";
		Integer data = 10;
		Box box = new Box();
		box.set(data);
		data = (Integer) box.get();
		System.out.println(data);
		*/
		
		/*
		//������ �ڽ�
		Box<Integer> b1 = new Box<Integer>();
		//������ �ڽ�
		Box<String> bs = new Box<String>();
		
		b1.set(11);
		bs.set("ghdrlfehd");
		
		Integer i = b1.get();
		String s = bs.get();
		
		System.out.println(i);
		System.out.println(s);
		*/
		
		ArrayList<String> list = new ArrayList<String>();
		//���Ҹ� ����Ʈ �� ���� ����
		list.add("����");
		list.add("��");
		list.add("����");
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("---------------------------------");
		
		list.add(1,"���");
		Iterator<String> iter = list.iterator();
		
		for(; iter.hasNext();) {
			System.out.println(iter.next());
		}
		System.out.println("---------------------------------");
		
		list.remove(2);
		iter = list.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("---------------------------------");
		
		for(String s : list) {
			System.out.println(s);
		}
		System.out.println("1   ");
		
		System.out.println("---------------------------------");
		
		list.add("���");
		for(String s : list) {
			System.out.println(  s);
		}
		
		System.out.println("---------------------------------");
		
		//ù��°���� �˻�
		int index = list.indexOf("���");
		System.out.println(index);
		
		System.out.println("---------------------------------");
		
		//���������� �˻�
		index = list.lastIndexOf("���");
		System.out.println(index);
	}
}
/*
class Box{
	private Object data;
	void set(Object o) {data = o;}
	Object get() {return data;}
}

class BoxInteger{
	private Integer data;
	void set(Integer o) {data = o;}
	Integer get() {return data;}
}

class BoxString{
	private String data;
	void set(String o) {data = o;}
	String get() {return data;}
}
*/

//�̷��� �������� ���׸��� ������� ��ó�� ��ȯ�Ѵ�
class Box<T>{
	private T data;
	void set(T o) {data = o;}
	T get() {return data;}
}