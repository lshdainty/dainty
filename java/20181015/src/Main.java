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
		//정수형 박스
		Box<Integer> b1 = new Box<Integer>();
		//문자형 박스
		Box<String> bs = new Box<String>();
		
		b1.set(11);
		bs.set("ghdrlfehd");
		
		Integer i = b1.get();
		String s = bs.get();
		
		System.out.println(i);
		System.out.println(s);
		*/
		
		ArrayList<String> list = new ArrayList<String>();
		//원소를 리스트 맨 끝에 삽입
		list.add("우유");
		list.add("빵");
		list.add("버터");
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("---------------------------------");
		
		list.add(1,"사과");
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
		
		list.add("사과");
		for(String s : list) {
			System.out.println(  s);
		}
		
		System.out.println("---------------------------------");
		
		//첫번째부터 검색
		int index = list.indexOf("사과");
		System.out.println(index);
		
		System.out.println("---------------------------------");
		
		//마지막부터 검색
		index = list.lastIndexOf("사과");
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

//이러한 불편으로 제네릭을 만들었고 밑처럼 변환한다
class Box<T>{
	private T data;
	void set(T o) {data = o;}
	T get() {return data;}
}