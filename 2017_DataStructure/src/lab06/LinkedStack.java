package lab06;

public class LinkedStack {
	
	public Node head;
	
	public LinkedStack() { head = null; }
	
	public void push(int data) {
		
		Node temp = new Node();
		temp.data = data;
		
		if (head == null) {
			head = temp;
		} else {
			temp.next = head;
			head = temp;
		}
	}
	
	public int pop() {
		
		int num = head.data;
		
		head = head.next;
		
		return num;
	}
	
	public boolean isEmpty() { return (head == null) ? true : false; }
	
	public void display() {
		
		if (!isEmpty()) {
			
			Node p = head;
			
			while (p != null) {
				System.out.print((char) p.data);
				
				p = p.next;
			}
			
			System.out.println();
		} else {
			
			System.out.println("Stack is Empty!");
		}
	}

	public boolean search(int data) {
		
		Node p = head;
		
		while (p != null) {
			
			if (p.data == data) {
				return true;
			}
			
			p = p.next;
		}
		
		return false;
	}
	
	public int length() {
		
		Node p = head;
		
		int length = 0;
		
		while (p != null) {
			
			p = p.next;
			length++;
		}
		
		return length;
	}
}