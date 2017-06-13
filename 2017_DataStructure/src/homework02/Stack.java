package homework02;

/***
 * 
 * Data Structure Hw02 <Infix-Postfix>
 * 20133243 Lee Sang Wook
 *
 ***/

public class Stack {
	
	// 스택의 크기 
	private final int SIZE = 100;
	
	// 값 저장하는 변수 
	private int[] stack = new int[SIZE];
	
	// 값이 유효한 최상단의 위
	private int top;
	
	// 초기화 
	public Stack() { top = -1; }
	
	// 값을 스택의 최상단에 추가 
	public void push(int val) { stack[++top] = val; }
	
	// 저장된 값의 가장 최상단의 값을 가져온다.
	public int pop() { return stack[top--]; }
	
	// 현재 저장하고 있는 값이 비면 true, 아니면 false 
	public boolean isEmpty() { return top == -1; }
	
	// 현재 저장공간이 남아 있는지 확인. 있으면 false, 아니면 true
	public boolean isFull() { return top == SIZE -1; }
	
	// 현재 저장하고 있는 값을 상단부터 순차적으로 출력 
	public void display() {
		
		if (isEmpty()) {

			System.out.println("Stack is Empty!");
		
		} else {
			
			for (int i = top ; i >= 0 ; i--) {
				
				System.out.print((char) stack[i]);
			}
			
			System.out.println();
		}
	}
}

