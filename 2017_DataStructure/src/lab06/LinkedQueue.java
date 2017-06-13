package lab06;

public class LinkedQueue {

	public Node front;
	public Node rear;
	
	public LinkedQueue() { front = null; rear = null; }
	
	public void enqueue(int data) {
		
		Node temp = new Node();
		temp.data = data;
		
		if (front == null) {
			
			front = temp;
			rear = temp;
		} else {
			
			rear.next = temp;
			rear = temp;
		}
	}
	
	public int dequeue() {

		int num = front.data;;
		
		if (front == rear) {
			front = null;
			rear = null;
		} else {
			front = front.next;
		}
		
		return num;
	}
	
	public boolean isEmpty() { return (front == null) ? true : false; }
	
	public void display() {
		
		if (!isEmpty()) {
			
			Node p = front;
			
			while (p != null) {
				System.out.print((char)p.data);
				p = p.next;
			}
			
			System.out.println();
		} else {
		
			System.out.println("Queue is Empty!");
		}
	}

	public boolean search(int data) {
		
		Node p = front;
		
		while (p != rear) {
			
			if (p.data == data) {
				return true;
			}
			
			p = p.next;
		}
		
		return false;
	}
	
	public int length() {
		
		Node p = front;
		
		int length = 0;
		
		while (p != null) {
			
			p = p.next;
			length++;
		}
		
		return length;
	}
}