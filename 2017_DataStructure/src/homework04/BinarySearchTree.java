package homework04;

/***
 * 
 * Data Structure Hw04 <BST>
 * 20133243 Lee Sang Wook
 *
 * Documentation
 * 
 * 노드를 사용해서 만든 BinarySearhTree입니다.
 * BST는 기본적으로 트리구조이고, 작은 값은 좌측 노드에 큰 값은 우측 노드에 연결합니다.
 * 멤버 함수로는 root가 있고, BST의 뿌리가 되는 노드입니다.
 * 생성자는 BST클래스를 객체로 생성하는 역활을 합니다.
 * 정의되어 있는 메소드에는 크게 6가지가 있습니다.
 * Insert, Delete, FindMin, Search, Draw, IsEmpty가 있습니다.
 * Insert, Delete, Search, Draw는 오버로딩을 통해서 외부 클래스에서 접근시 보다 편리하게 사용할 수 있도록 했습니다.
 * 또한 위의 효과로 외부 클래스에서 트리의 root 접근을 불가능하게 했습니다.
 * Insert는 값을 하나 입력하면 BST에 값을 추가해 줍니다.
 * Delete는 값을 하나 입력하면 BST에서 해당값이 있을 경우 제거해줍니다.
 * FindMin은 가장 작은 값 즉, 최좌측 노드를 불러옵니다.
 * Search는 입력받은 값이 존재 여부에 따라 True or False값을 반환합니다.
 * Draw는 현재 BST를 레벨에 맞게 출력해줍니다.
 * IsEmpty는 BST가 생성되어있는지 여부에 따라 True or False값을 반환합니다.
 * 
 ***/

public class BinarySearchTree {

	// BST의 뿌리가 되는 root 노드입니다.
	private Node root;
	
	// BST를 생성하는 생성자입니다. root에 null값을 넣어 초기화합니다.
	public BinarySearchTree() { root = null; }
	
	// 생성한 BST에 입력받은 값을 대입해줍니다.
	// value값 하나만을 입력받아 외부 클래스에서 접근하기 쉽게 정의한 메소드입니다.
	public void insert(int value) { root = insert(root, value); }
	
	// 생성한 BST에 입력받은 값을 대입해줍니다.
	// 기본적인 알고리즘은 재귀함수를 통해서 현재 노드와 비교하여,
	// 크면 우측, 작으면 좌측으로 이동해서 null값이 있는곳에 새 노드를 추가합니다.
	private Node insert(Node node, int value) {
	
		// 현재로 이동한 위치에 노드가 존재하지 않으면,
		if (node == null) {
			
			// value값을 가진 node를 추가
			node = new Node(value);
			
		// 현재 비교하는 대상의 노드값과 비교해서 value값이 작다면 	
		} else if (value < node.data) {
			
			// 좌측 노드로 이동해서 계속 비교 
			node.left = insert(node.left, value);
		
		// 현재 비교하는 대상의 노드값과 비교해서 value값이 크다면 	
		} else if (value > node.data) {
			
			// 우측 노드로 이동해서 계속 비교 
			node.right = insert(node.right, value);
		}
			
		// node값을 반환
		return node;
	}
	
	// BST에 입력받은 value값이 존재한다면 삭제한다.
	// value값 하나만을 입력받아 외부 클래스에서 접근하기 쉽게 정의한 메소드입니다.
	public void delete(int value) { root = delete(root, value); }
	
	// BST에 입력받은 value값이 존재한다면 삭제한다.
	// 기본적인 알고리즘은 재귀함수를 통해서 현재 노드와 비교하여,
	// 크면 우측, 작으면 좌측으로 이동해서 값이 존재하는 곳의 노드를 삭제
	// 없다면 삭제 할 수 없다.
	private Node delete(Node node, int value) {
		
		// 현재 위치의 노드가 null값이면 안된다.
		if (node != null) {
			
			// value값이 노드 값보다 작다면,
			if (value < node.data) {
				
				// 비교 노드를 좌측으로 이동 
				node.left = delete(node.left, value);
			
			// value 값이 노드 값보다 크다면,	
			} else if (value > node.data) {
				
				// 비교 노드를 우측으로 이동 
				node.right = delete(node.right, value);
			
			// 비교 대상의 좌, 우측에 노드가 없다면,
			} else if (node.left == null && node.right == null) {
				
				// 현재 노드를 그냥 없앤다.
				node = null;
			
			// 비교 댜상의 좌측에만 노드가 없다면,	
			} else if (node.left == null) {
				
				// 현재 노드를 제거하고 우측에 있떤 노드를 가져와서 연결.
				node = node.right;
			
			// 비교 대상의 우측에만 노드가 없다면,	
			} else if (node.right == null) {
				
				// 현재 노드를 제거하고 좌측에 있던 노드를 가져와서 연결.
				node = node.left;
			
			// 비교 대상의 좌, 우측에 모드가 모두 있다면,	
			} else {
				
				// 현재 노드에 우측에 연결된 노드의 최좌측에 연결되어있는 노드를 가져와 현 노드를 대신 
				Node temp = findMin(node.right);
				node.data = temp.data;
				node.right = delete(node.right, node.data);
			}
			
		// 현위치의 노드가 null일 경우
		} else {
			
			System.out.println("Tree Is Empty");
		}
		
		// 노드를 반환
		return node;
	}
	
	// 입력받은 노드의 가장 좌측, 가장 작은 값의 노드를 반환
	private Node findMin(Node node) { return node.left == null ? node : findMin(node.left); }

	// BST에 입력받은 value값이 존재하면 True 아니면 False를 반환 
	// value값 하나만을 입력받아 외부 클래스에서 접근하기 쉽게 정의한 메소드입니다.
	public boolean search(int value) { return (search(root, value) != null) ? true : false; }
	
	// BST에 입력받은 value값이 존재면 True 아니면 False를 반환
	// 기본적인 알고리즘은 재귀함수를 통해서 현재 노드와 비교하여,
	// 크면 우측, 작으면 좌측으로 이동해서 값이 존재하는 곳의 노드를 탐색 
	private Node search(Node node, int value) {
		
		// 현재 위치의 노드가 null, 없다면 찾지 못했으므로,
		if (node == null) {
			
			// null 반환
			return null;
			
		// 현재 위치의 노드가 존재한다면,	
		} else {
			
			// 값을 비교해보고 같으면 그 노드를 반환 
			if (value == node.data) {
				
				return node;
			
			// 값을 비교해보고 노드값보다 작다면,
			} else if (value < node.data) {
				
				// 비교할 노드를 좌측으로 이동해서 계속 비교 
				node = search(node.left, value);
				
			// 값을 비교해보고 노드값보다 크다면,	
			} else if (value > node.data) {
				
				// 비교할 노드를 우측으로 이동해서 계속 비교 
				node = search(node.right, value);
			}
			
			// 노드 값을 반환 
			return node;
		}
	}
	
	// BST에 저장되어 있는 값을 출력. 
	// 외부 클래스에서 접근하기 쉽게 정의한 메소드입니다.
	public void draw() { draw(root, 1); }
	
	// BST에 저장되어 있는 값을 출력.
	// 기본적인 알고리즘은 재귀함수를 통해서 현재 노드와 비교하여,
	// 트리 구조에 맞게 길을 표시해서 출력한다.
	private void draw(Node node, int level) {
		
		// 현 위치에 노드가 존재하고, 레벨이 7이하여야한다.
		if (node != null && level <= 7) {
			
			// 우측에 연결된 노드를 같은 방식으로 재귀로 출력해준다.
			draw(node.right, level + 1);
			
			// 현재 레벨에 맞게 보기 좋게 띄어쓰기를 해준다.
			for (int i = 1 ; i <= level - 1 ; i++) {
				
				System.out.print("  ");
			}
			
			// 현 위치 노드의 값을 출력한다.
			System.out.print(node.data);
			
			// 좌, 우측에 노드가 모두 존재한다면,
			if (node.left != null && node.right != null) {
				
				// <를 그려 양쪽 모두 노드가 있음을 길로 표
				System.out.println("<");
				
			// 우측에만 노드가 있다면	
			} else if (node.right != null) {
				
				// /을 그려 우측에만 노드가 있음을 길로 표시 
				System.out.println("/");
				
			// 좌측에만 노드가 있다면,	
			} else if (node.left != null) {
				
				// \을 그려 좌측에만 노드가 있음을 길로 표시 
				System.out.println("\\");
			
				// 좌, 우측 모두 노드가 없다면 띄어쓰기만 해준다.
			} else {
				
				System.out.println();
			}
			
			// 좌측에 연결된 노드를 같은 방식으로 재귀로 출력해준다.
			draw(node.left, level + 1);
		}
	}

	// 현재 생성된 BST가 비어있는지를 확인하는 메소드입니다.
	// root가 존재하면 true, 존재하지 않으면 false입니다.
	public boolean isEmpty() { return (root == null) ? true : false; }
}