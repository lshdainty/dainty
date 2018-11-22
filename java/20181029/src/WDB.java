import java.util.ArrayList;

public class WDB {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		(new Thread(new Producer(buffer))).start();
		(new Thread(new Consumer(buffer))).start();

	}

}

class Buffer{
	//private int data;
	//private boolean empty = true;
	private ArrayList<Integer> dataList;
	
	private final int MAX = 3;
	private int pos = 0;
	
	public Buffer() {
		dataList = new ArrayList<Integer>();
		dataList.add(-1);
		dataList.add(-1);
		dataList.add(-1);
	}
	
	public boolean isEmpty() {
		if(pos == 0)
			return true;
		return false;
	}
	
	public boolean isFull() {
		if(pos == MAX)
			return true;
		return false;
	}
	
	public synchronized int get() {
		
		while(isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {

			}
		}
		pos--;
		print();
		notifyAll();
		return dataList.get(pos);
	}
	
	public synchronized void put(int data) {
		while(isFull()) {	//���ۿ� ��ǰ�� �̹� ���� ���
			try {
				wait();	//�����ڰ� ��ٷ����Ѵ�.
			} catch (InterruptedException e) {

			}
		}
		dataList.set(pos,data);
		pos++;
		print();
		notifyAll();
	}
	
	public void print() {
		System.out.print("����: ");
		for(int i=0; i<3; i++) {
			if(i<pos) {
				System.out.print(dataList.get(i) + " ");
			}
			else {
				System.out.print(" ");
			}
		}
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
			System.out.println("������ : " + i + "�� ������ �����Ͽ����ϴ�.");
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
			System.out.println("�Һ��� : " + data + "�� ������ �Һ��Ͽ����ϴ�.");
			try {
				Thread.sleep((int)(Math.random()*100));
			}catch(Exception e) {
				
			}
		}
	}
}