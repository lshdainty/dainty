package thread;

/* 1. Thread클래스를 상속받아 클래스를 작성
 * 2. run메소드 재정의
 * 3. Thread 객체 생성
 * 4. start메소드 호출
 */

class MyThread extends Thread{
	
	@Override
	public void run() {
		for(int i =0; i<100; i++) {
			System.out.println(i+1);
		}
	}
}

/* 11. Runnable 인터페이스를 구현한 클래스를 작성한다.
 * 12. run메소드 재정의
 * 13. Thread 객체를 생성하고 이때 MyRunnable객체를 인수로 전달시킨다.
 * 14. Thread 객체의 start메소드를 실행한다.
 */

class MyRunnable implements Runnable{
	
	@Override
	public void run() {
		for(int i =0; i<100; i++) {
			System.out.println(i+1);
		}
	}
}


public class Main {

	public static void main(String[] args) {
		/*MyThread t = new MyThread();
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		
		//start메소드 호출
		t.start();
		t1.start();
		t2.start();
		*/
		
		MyRunnable myRunnable = new MyRunnable();
		Thread t = new Thread(myRunnable);
		Thread t1 = new Thread(myRunnable);
		
		
		t.start();
		t1.start();
	}

}
