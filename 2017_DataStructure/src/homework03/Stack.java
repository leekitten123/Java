package homework03;

/***
 * 
 * Data Structure Hw03 <Maze Problem>
 * 20133243 Lee Sang Wook
 *
 * Documentation
 * 
 * Stack 클래스는 Element 정보를 사용하는 스택입니다.
 * 최대 크기는 100입니다.
 * push()와 pop()을 통해서 정보를 data 배열에 넣고 뺄 수 있습니다.
 * isEmpty()와 isFull()을 통해서 Stack의 비었는지,
 * 다 찼는지 여부를 확인할 수 있습니다.
 * display()는 data배열에 Element정보에서 row와 col을 보여줍니다.
 * 
 ***/

public class Stack {

	private final int SIZE = 100;
	
	private Element[] data = new Element[SIZE];
	private int top;
	
	public Stack() { top = -1; }
	
	public void push(Element data) { this.data[++top] = data; }
	public Element pop() { return this.data[top--]; }
	
	public int size() {	return top + 1; }
	
	public boolean isEmpty() { return top == -1; }
	public boolean isFull() { return top == SIZE -1; }
	
	public void display() {

		for (int i = 0 ; i < size() ; i++) {
			
			System.out.println(" " + data[i].row + "   " + data[i].col);
		}		
	}
}