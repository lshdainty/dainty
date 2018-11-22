interface Stack{	//1501205 �̻���
	boolean isEmpty();
	void push(char item);
	char pop();
	void delete();
	char peek();
}

class ArrayStack implements Stack{
	private int top;
	private int stackSize;
	private char itemArray[];
	
	public ArrayStack(int stackSize) {	//������
		top = -1;
		this.stackSize = stackSize;	//5
		itemArray = new char[this.stackSize];	//5
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == this.stackSize-1);
	}
	
	public void push(char item) {
		if(isFull()) {	//���� top�� stackSize-1�� ���ٸ� ���ÿ� ��� ĭ���� �����Ͱ� ����ִ�.(�� �������� ����)
			System.out.println("Inserting fail! Array Stack is full");
		}
		else {	//top�� -1�� ������ �迭�� �ε����� 0���� �����ϱ� ������ ù��° ���Ұ� ���� ++top�̶� itemArray[0]�� �ȴ�.
			itemArray[++top]=item;
			System.out.println("Inserted Item : " + item);
		}
	}
	
	public char pop() {
		if(isEmpty()) {	//top == -1�̶�� ���� �迭�� ���Ұ� �ϳ��� ���ٴ� ���̴ϱ� �������͵� ���� ������ �͵� ����.
			System.out.println("Deleting fail! Array Stack is empty");
			return 0;
		}
		else {	//
			return itemArray[top--];	//pop�� �ϰ� �������� �ִ� ���� ���� ���� �ǹǷ� top--�� �Ѵ�.(2�� �ε����� pop�ϰ� top--�� itemArray[1]�� ���ϵȴ�.
		}
	}
	
	public void delete() {
		if(isEmpty()) {	//top == -1�̶�� ���� �迭�� ���Ұ� �ϳ��� ���ٴ� ���̴ϱ� �������͵� ���� ������ �͵� ����.
			System.out.println("Deleting fail! Array Stack is empty");
		}
		else {
			top--;	//���� top�� ������ �ε������� 1�� �����ؾ� pop�� ������ ���� �ȴ�.(2�� pop�ϰ� top--�� 1�� �ȴ�.)
		}
	}
	
	public char peek() {
		if(isEmpty()) {	//top�� -1�̸� �迭���� ���� �ϳ��� ���ٴ� ���̹Ƿ� ������ ���� ����.
			System.out.println("Peeking fail! Array Stack is empty");
			return 0;
		}
		else {	//������ �迭�� ���� �����Ѵ�.
			return itemArray[top];
		}
	}
	
	public void printStack() {
		if(isEmpty()) {	//���� �ϳ��� �����Ƿ� �迭�� ����ٰ� ���
			System.out.printf("Array Stack is Empty %n %n");
		}
		else {
			System.out.printf("Array Stack>>");
			for(int i = 0; i<=top; i++) {
				System.out.printf("%c ", itemArray[i]);	//�迭�� ����ִ� ������ ����Ѵ�. ����ϴ� ������ top���� �ݺ��Ͽ� ��� ���Ҹ� ���
			}
			System.out.println();
			System.out.println();
		}
	}
}


public class Ex7_1 {

	public static void main(String[] args) {
		int stackSize = 5;
		char deletedItem;
		ArrayStack s = new ArrayStack(stackSize);
		
		s.push('A');
		s.printStack();
		
		s.push('B');
		s.printStack();
		
		s.push('C');
		s.printStack();
		
		deletedItem = s.pop();
		if(deletedItem != 0) {
			System.out.println("deleted Item : " + deletedItem);
		}
		s.printStack();
	}

}
