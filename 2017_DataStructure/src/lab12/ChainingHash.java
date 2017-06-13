package lab12;

public class ChainingHash {

	private final int MAX_SIZE = 21;
	private Node[] hashTable = new Node[MAX_SIZE];
	
	ChainingHash() {
		
		for (int i = 0 ; i < MAX_SIZE ; i++) {
			
			hashTable[i] = new Node();
		}
	}
	
	public int hash(int key) { return key % MAX_SIZE; }
	
	public boolean findKey(int key) {
		
		Node p = hashTable[hash(key)];
		
		while (p.next != null) {
			
			p = p.next;
			
			if (p.key == key) {
				
				return true;
			}
		}
		
		return false;
	}
	
	public void insertKey(int key) {

		if (!findKey(key)) {
			
			Node p = hashTable[hash(key)];
			
			while (p.next != null) {
				
				p = p.next;
			}
			
			p.next = new Node(key);
		}
	}

	public void deleteKey(int key) {
	
		Node p = hashTable[hash(key)];
		
		while (p.next != null) {
			
			if (p.next.key == key) {
				
				p.next = p.next.next;
				
				break;
			}
			
			p = p.next;
		}
	}
	
	public void print() {
		
		System.out.println("Index | Key | Key | Key | Key | Key");
		
		for (int i = 0 ; i < MAX_SIZE ; i++) {
			
			System.out.printf("  %2d  ", i);
			
			Node p = hashTable[i];
				
			while (p.next != null) {
					
				p = p.next;
					
				System.out.printf("| %3d ", p.key);
			}
			
			System.out.println();
		}
	}
}
