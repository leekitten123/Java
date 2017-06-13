package lab04;

public class Queue {

	private final int MAX_QUEUE_SIZE = 100;
	
	private int[] queue = new int[MAX_QUEUE_SIZE];
		
	private int front;
	private int rear;
		
	public Queue () { front = -1; rear = -1; }
		
	public void enQueue(int value) {
			
		if (rear == MAX_QUEUE_SIZE - 1) {
				
			return;
		}

		queue[++rear] = value;
	}
		
	public int deQueue() {
			
		if (front == rear) {
				
			return -1;
		}
			
		return queue[++front];
	}
		
	public boolean isFull() { return (rear == (MAX_QUEUE_SIZE - 1)) ? true : false; }
		
	public boolean isEmpty() { return (front == rear) ? true : false; }
		
	public void print() {
			
		for (int i = front + 1 ; i <= rear ; i++) {
			System.out.print(queue[i]);
		}
		
		System.out.println();
	}
}
