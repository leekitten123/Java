package lab04;

public class Stack {

	private final int SIZE = 100;
	
	private int[] stack = new int[SIZE];
	private int top;
	
	public Stack() { top = -1; }
	
	public void push(int val) { stack[++top] = val; }
	public int pop() { return stack[top--]; }
	
	public boolean isEmpty() { return top == -1; }
	public boolean isFull() { return top == SIZE -1; }
	
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