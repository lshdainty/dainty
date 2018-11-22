package thread;

/* 1. ThreadŬ������ ��ӹ޾� Ŭ������ �ۼ�
 * 2. run�޼ҵ� ������
 * 3. Thread ��ü ����
 * 4. start�޼ҵ� ȣ��
 */

class MyThread extends Thread{
	
	@Override
	public void run() {
		for(int i =0; i<100; i++) {
			System.out.println(i+1);
		}
	}
}

/* 11. Runnable �������̽��� ������ Ŭ������ �ۼ��Ѵ�.
 * 12. run�޼ҵ� ������
 * 13. Thread ��ü�� �����ϰ� �̶� MyRunnable��ü�� �μ��� ���޽�Ų��.
 * 14. Thread ��ü�� start�޼ҵ带 �����Ѵ�.
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
		
		//start�޼ҵ� ȣ��
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
