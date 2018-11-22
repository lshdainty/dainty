import java.util.HashMap;
import java.util.LinkedList;

public class WDB {

	public static void main(String[] args) {
		//리스트 생성
		LinkedList<String> list = new LinkedList<String>();
		
		//리스트 추가
		list.add("우유");
		list.add("빵");
		list.add("버터");
		
		//리스트 출력
		for(int i =0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	System.out.println("******************************");
		
		//리스트 내용 변경
		list.set(1,"소보루");
		
		//변경된 내용르로 출력
		for(int i =0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	System.out.println("******************************");
		
		/*map안에 hashmap이란게 있다.
		 * Integer는 키값에 대한 타입 , String은 값에 대한 타입
		 * 배열과 비슷하지만 인덱스를 integer로 할 수도 있고 String으로 할 수도 있다.
		 */
		HashMap<Integer,String> st = new HashMap<Integer,String>();
		st.put(1, "홍길동");
		st.put(2, "성춘향");
		
		//값 출력
		String a = st.get(1);
		System.out.println(a);
		
	System.out.println("******************************");
		
		HashMap<String,String> st1 = new HashMap<String,String>();
		st1.put("홍길동전", "홍길동");
		st1.put("춘향전", "성춘향");
		
		//값 출력
		String a1 = st1.get("춘향전");
		System.out.println(a1);
	}

}