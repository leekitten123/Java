package lab06;

public class MainLab06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedStack linkedStack = new LinkedStack();
		linkedStack.push('a');
		linkedStack.push('e');
		linkedStack.display();
		
		LinkedQueue linkedQueue = new LinkedQueue();
		linkedQueue.enqueue('b');
		linkedQueue.enqueue('c');
		linkedQueue.enqueue('d');
		linkedQueue.display();
		
		SingleList concatenation = Lab06.concatenate(linkedStack.head, linkedQueue.front);
		concatenation.display();
		
		Lab06.invert(concatenation.head).display();
	}
}