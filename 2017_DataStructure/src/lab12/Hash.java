package lab12;

public class Hash {

	private final int MAX_SIZE = 7;
	private HashTable[] hashTable = new HashTable[MAX_SIZE];
	
	Hash() {
		
		for (int i = 0 ; i < MAX_SIZE ; i++) {
			
			hashTable[i] = new HashTable(); 
		}
	}
	
	public int hash(int key) { return key % MAX_SIZE; }
	
	public boolean findKey(int key) {
		
		int index = hash(key);
		
		for (int i = 0 ; i < MAX_SIZE ; i++) {
			
			index = (index + 1) % MAX_SIZE;
			
			if (!hashTable[index].isEmpty()) {
				
				if (hashTable[index].key == key) {
					
					
					System.out.println("Found");
					return true;
				}
			}
		}
		
		System.out.println("Not Found");
		return false;
	}
	
	public boolean insertKey(int key) {
		
		int index = hash(key);
		int flag = hash(key);
		
		if (hashTable[index].isEmpty()) {
				
			hashTable[index].key = key;
			hashTable[index].flag = flag;
			hashTable[index].empty = false;
			
			return true;
				
		} else if (!(hashTable[index].flag == flag && hashTable[index].key == key)) {
			
			if (!isFull()) {
				
				while (true) {
					
					index = (index + 1) % MAX_SIZE;	
					
					if (hashTable[index].isEmpty()) {

						hashTable[index].key = key;
						hashTable[index].flag = flag;
						hashTable[index].empty = false;
						
						return true;
						
					} else {
						
						if (hashTable[index].flag == flag && hashTable[index].key == key) {
							
							break;
						}
					}
				}	
			}
		}
		
		return false;
	}
	
	public boolean deleteKey(int key) {
		
		int index = hash(key);
		
		for (int i = index ; i < index + MAX_SIZE ; i++) {
		
			if (!hashTable[i % MAX_SIZE].isEmpty()) {
				
				if (hashTable[i % MAX_SIZE].flag == index && hashTable[i % MAX_SIZE].key == key) {
				
					hashTable[i].empty = true;
					
					return true;
					//break;
				}	
			}	
		}
		
		return false;
	}
	
	public boolean isFull() {
		
		for (int i = 0 ; i < MAX_SIZE ; i++) {
			
			if (hashTable[i].isEmpty()) {
				
				return false;
			}
		}
		
		return true;
	}
	
	public void print() {
		
		System.out.print("(");
		
		for (int i = 0 ; i < MAX_SIZE ; i++) {
			
			if (i != MAX_SIZE - 1) {
			
				if (!hashTable[i].isEmpty()) {
					
					System.out.printf("%2d, ", hashTable[i].key);
				} else {
					
					System.out.print("__, ");
				}
				
			} else {
				
				if (!hashTable[i].isEmpty()) {
					
					System.out.printf("%2d", hashTable[i].key);
				} else {
					
					System.out.print("__");
				}
			}
		}
		
		System.out.println(")");
	}
}