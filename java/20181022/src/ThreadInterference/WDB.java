package ThreadInterference;

class Counter{
	private int value=0;
	
	public void increment() {
		value++;
	}
	
	public void decrement() {
		value--;
	}
	
	public void printCount() {
		System.out.println(value);
	}
}

class MyThread extends Thread{
	Counter sharedCount;
	
	MyThread(Counter c){
		this.sharedCount = c;
	}
	
	public void run() {
		for(int i =0; i<100; i++) {
			sharedCount.increment();
			sharedCount.decrement();
		}
		sharedCount.printCount();
	}
}

public class WDB {
	
	public static void main(String[] args) {
		Counter c = new Counter();
		MyThread t1 = new MyThread(c);
		MyThread t2 = new MyThread(c);
		t1.start();
		t2.start();
	}
	
}
