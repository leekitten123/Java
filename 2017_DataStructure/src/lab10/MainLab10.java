package lab10;

public class MainLab10 {

	public static void main(String[] args) {

		// 인접 리스트 사용.
		AdjacenyListGraph graph01 = new AdjacenyListGraph();
		
		graph01.insert(0, 4); graph01.insert(0, 5);
		graph01.insert(1, 2); graph01.insert(1, 3); graph01.insert(1, 5);
		graph01.insert(2, 1); graph01.insert(2, 3);  graph01.insert(2, 4);
		graph01.insert(3, 1); graph01.insert(3, 2);
		graph01.insert(4, 0); graph01.insert(4, 2); graph01.insert(4, 5);
		graph01.insert(5, 0); graph01.insert(5, 1); graph01.insert(5, 4);
		
		graph01.display();
		System.out.println();
		graph01.DFS(0);
		
		System.out.println();
		
		
		// 행렬.
		int[][] matrix = {
				{0, 0, 0, 0, 1, 1},
				{0, 0, 1, 1, 0, 1},
				{0, 1, 0, 1, 1, 0},
				{0, 1, 1, 0, 0, 0},
				{1, 0, 1, 0, 0, 1},
				{1, 1, 0, 0, 1, 0}};
		
		
		// 행렬을 인접 리스트로 변환해서 사용.
		AdjacenyListGraph graph02 = new AdjacenyListGraph(matrix);
		
		graph02.display();
		System.out.println();
		graph02.DFS(0);
		
		System.out.println();
		
		
		// 인접 행렬을 사용.
		
		AdjacencyMatrixGraph graph03 = new AdjacencyMatrixGraph(matrix);
		
		graph03.display();
		System.out.println();
		graph03.DFS(0);
	}
}