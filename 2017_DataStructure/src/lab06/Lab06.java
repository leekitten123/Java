package lab06;

public final class Lab06 {
	
	public static SingleList invert(Node head) {
		
		Node middle = null;
		Node trail = null;
		
		Node temp = head;
		
		while(temp != null) {
			trail = middle;
			middle = temp;
			temp = temp.next;
			middle.next = trail;
		}
		
		SingleList sl = new SingleList();
		sl.head = middle;
		
		return sl;
	}

	public static SingleList concatenate(Node head1, Node head2) {
		
		SingleList sl = new SingleList();
		
		for (Node temp = head1 ; temp != null ; temp = temp.next) {
			sl.insert(temp.data);
		}
		
		for (Node temp = head2 ; temp != null ; temp = temp.next) {
			sl.insert(temp.data);
		}
		
		return sl;
	}
}
