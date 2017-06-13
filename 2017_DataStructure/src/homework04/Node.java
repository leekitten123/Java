package homework04;

/***
 * 
 * Data Structure Hw04 <BST>
 * 20133243 Lee Sang Wook
 *
 * Documentation
 * 
 * BinarySearchTree에서 사용할 노드입니다.
 * 사용할 데이터 타입은 Integer입니다.
 * 트리 구조에서 사용할 수 있도록 left와 right에 연결 될 수 있도록 노드를 정의했습니다.
 * 생성자는 데이터 선언시 반드시 사용할 데이터를 입력 받도록 정의했습니다. 
 * 좌측, 우측 노드를 연결할 때, 멤버를 Public으로 정의해서 다른 클래스에서도 접근가능하게 했습니다.
 * 
 ***/

public class Node {

	// 노드안에서 사용할 데이터이고, 인트형입니다.
	public int data;
	
	// 현 노드와 연결할 좌,우 노드입니다.
	public Node left;
	public Node right;
	
	// 노드의 기본 생성자로 노드안의 데이터하나를 반드시 입력 받아야합니다.
	Node (int data) {
		
		this.data = data;
		this.left = null;
		this.right = null;
	}
}