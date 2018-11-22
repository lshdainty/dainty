interface Stack{	//1501205 이상혁
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
	
	public ArrayStack(int stackSize) {	//생성자
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
		if(isFull()) {	//만약 top이 stackSize-1과 같다면 스택에 모든 칸에는 데이터가 들어있다.(더 넣을수가 없다)
			System.out.println("Inserting fail! Array Stack is full");
		}
		else {	//top이 -1인 이유는 배열의 인덱스는 0부터 시작하기 때문에 첫번째 원소가 들어가면 ++top이라서 itemArray[0]이 된다.
			itemArray[++top]=item;
			System.out.println("Inserted Item : " + item);
		}
	}
	
	public char pop() {
		if(isEmpty()) {	//top == -1이라는 것은 배열에 원소가 하나도 없다는 뜻이니까 꺼내갈것도 없고 삭제할 것도 없다.
			System.out.println("Deleting fail! Array Stack is empty");
			return 0;
		}
		else {	//
			return itemArray[top--];	//pop을 하고 마지막에 있던 값은 없던 것이 되므로 top--를 한다.(2번 인덱스를 pop하고 top--로 itemArray[1]이 리턴된다.
		}
	}
	
	public void delete() {
		if(isEmpty()) {	//top == -1이라는 것은 배열에 원소가 하나도 없다는 뜻이니까 꺼내갈것도 없고 삭제할 것도 없다.
			System.out.println("Deleting fail! Array Stack is empty");
		}
		else {
			top--;	//기존 top의 마지막 인덱스에서 1을 감소해야 pop후 삭제한 것이 된다.(2를 pop하고 top--로 1이 된다.)
		}
	}
	
	public char peek() {
		if(isEmpty()) {	//top이 -1이면 배열안의 값이 하나도 없다는 것이므로 선택할 것이 없다.
			System.out.println("Peeking fail! Array Stack is empty");
			return 0;
		}
		else {	//선택할 배열의 값을 리턴한다.
			return itemArray[top];
		}
	}
	
	public void printStack() {
		if(isEmpty()) {	//값이 하나도 없으므로 배열이 비었다고 출력
			System.out.printf("Array Stack is Empty %n %n");
		}
		else {
			System.out.printf("Array Stack>>");
			for(int i = 0; i<=top; i++) {
				System.out.printf("%c ", itemArray[i]);	//배열에 들어있는 값들을 출력한다. 출력하는 조건은 top까지 반복하여 모든 원소를 출력
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
