package lab04;

public class CircularQueue {

	private final int MAX_QUEUE_SIZE = 3;
	
	private int[] queue = new int[MAX_QUEUE_SIZE];
		
	private int front;
	private int rear;
		
	public CircularQueue () { front = -1; rear = -1; }
		
	public void enQueue(int value) {
			
		rear = (rear + 1) % MAX_QUEUE_SIZE;
		
		if (front == rear) {
			System.out.println("Queue is full");
		} else {
			queue[rear] = value;
		}
	}
		
	public int deQueue() {
			
		if (front == rear) {
			System.out.println("Queue is empty");
			return -1; 
		} else {
			front = (front + 1) % MAX_QUEUE_SIZE;
			return queue[front];
		}
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