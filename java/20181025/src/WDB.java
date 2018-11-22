public class WDB {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		(new Thread(new Producer(buffer))).start();
		(new Thread(new Consumer(buffer))).start();

	}

}

class Buffer{
	private int data;
	private boolean empty = true;	//상태정보
	
	public synchronized int get() {
		while(empty) {
			try {
				wait();
			}catch(Exception e) {
				
			}
		}
		empty = true;
		notifyAll();
		return data;
	}
	
	public synchronized void put(int data) {
		while(!empty) {
			try {
				wait();
			}catch(Exception e) {
				
			}
		}
		empty = false;
		this.data = data;
		notifyAll();
	}
}

class Producer implements Runnable{
	private Buffer buffer;
	
	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		for(int i=0; i<10; i++) {
			buffer.put(i);
			System.out.println("생산자 : " + i + "번 케익을 생산하였습니다.");
			try{
				Thread.sleep((int)(Math.random()*100));
			}catch(Exception e) {
				
			}
		}
	}
}

class Consumer implements Runnable{
	private Buffer buffer;
	
	public Consumer(Buffer drop) {
		this.buffer = drop;
	}

	public void run() {
		for(int i=0; i<10; i++) {
			int data = buffer.get();
			System.out.println("소비자 : " + data + "번 케익을 소비하였습니다.");
			try {
				Thread.sleep((int)(Math.random()*100));
			}catch(Exception e) {
				
			}
		}
	}
}