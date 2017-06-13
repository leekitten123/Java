package homework05;

/***
 * 
 * Data Structure Hw05 <Shortest Path>
 * 20133243 Lee Sang Wook
 *
 * Documentation
 * 
 * 인접 행렬을 가지고 다익스트라 알고리즘을 통해서 정한 정점으로부터
 * 모든 정점에 대해 가장 비용이 적은 경로를 통해 갈 때,
 * 그 비용을 구할 수 있는 알고리즘입니다.
 * 인접 행렬과 초기 정점값을 입력받습니다.
 * 각 정점에 대한 방문 여부를 기록하는 visit 배열을 만들고,
 * 각 정점을 향할 때의 짧은 경로를 저장할 distance 배열을 만듭니다.
 * distance를 INF로 초기화 해주고, 초기 정점에 대한 처리를 해줍니다.
 * 초기 정점에서의 모든 정점에 대한 경로를 distance에 저장합니다.
 * 그 후로, 모든 정점에 방문 할 때까지 반복문을 실행합니다.
 * 방문하지 않은 연결된 정점에서 distance가 가장 작은 점을 다음 정점으로 선택합니다.
 * 그 정점을 방문했다고 표기한 후, 그 정점에서 이동할 수 있는 정점들에 대해서 거리를 구합니다.
 * 그리고 이미 해당 정점에 대한 이동거리보다 작으면 그 정점을 기록해줍니다.
 * 모든 정점을 방문 할 때까지 실행해줍니다.
 * 
 ***/

public class Homework05 {
	
	// 100이라는 수를 INF라고 잡고 무한대를 의미합니다.
	private static final int INF = 100;
	
	public static void main(String[] args) {
		
		// Homework05에 사용할 인접 행렬입니다.
		int[][] cost = {
				{INF,   2,   4,   5, INF, INF, INF},
				{INF, INF, INF,   2,   7, INF, INF},
				{INF, INF, INF,   1, INF,   4, INF},
				{INF,   2,   1, INF,   4,   3, INF},
				{INF,   7, INF,   4, INF,   1,   5},
				{INF, INF,   4,   3,   1, INF,   7},
				{INF, INF, INF, INF,   7,   5, INF}};
		
		// 인접 행렬을 출력해줍니다.
		printMatrix(cost);
		
		// 출력을 위한 띄어쓰기를 합니다.
		System.out.println();
		
		// 다익스트라 알고리즘을 통해 단계마다 정점의 가장 짧은 경로를 계산해서 출력합니다.
		shortest(0, cost);
	}
	
	// 다익스트라 알고리즘을 통해 단계마다 정점의 가장 짧은 경로를 계산해주는 함수입니다.
	// 모든 정점에 방문 할때까지 가장 짧은 경로만을 저장해두는 방식으로 진행됩니다.
	private static void shortest(int v, int[][] cost) {
		
		// 인접 행렬의 크기를 저장하는 변수.
		int size = cost.length;
		// 반복문의 종료 여부를 판단하기 위한 변수.
		// 초기 정점을 빼고 나머지 정점이 모두 방문 할때까지의 횟수입니다.
		int cycle = size - 1;
		
		// 각 정점에 대한 방문여부를 보여줍니다.
		boolean[] visit = new boolean[size];
		// 초기정점으로부터 각 정점에대한 최소 경로를 기록합니다.
		int[] distance = new int[size];
		
		// 초기 distance를 무한대로 초기화해줍니다.
		for (int i = 0 ; i < size ; i++) {
			
			distance[i] = INF;
		}

		// 초기 정점을 방문표시하고,
		visit[v] = true;
		// 초기 정점에서 초기정점의 거리는 0으로 초기화합니다.
		distance[v] = 0;
		
		// 초기 정점에서 연결되있는 정점에 대한 이동거리를 인접행렬의 cost로 표기해줍니다.
		for (int i = 0 ; i < size ; i++) {
			
			distance[i] = (cost[v][i] != INF) ? cost[v][i] : distance[i];
		}
	
		// 모든 정점에 방문할 때까지 반복합니다.
		while (cycle-- != 0) {
			
			// distance의 최소값을 구하기 위한 min변수를 INF로 초기화합니다.
			int min = INF;
			
			// 모든 정점에 대한 반복.
			for (int i = 0 ; i < size ; i++) {
				
				// 방문하지 않은 정점이고, min보다 작으면,
				if (!visit[i] && (min > distance[i])) {

					// min과 v를 수정해서,
					// 가장 짧은 거리의 정점이 선택되도록 합니다.
					min = distance[i];
					v = i;
				}
			}
			
			// 해당 정점을 방문표시를 합니다.
			visit[v] = true;
			
			// 모든 정점에대한 반복을 합니다.
			for (int i = 0 ; i < size ; i++) {
				
				// 방분하지 않은 정점이고, 현재 기록되어 있는 비용보다 새로 계산한 정점으로의 경로가 짧으면,
				if (!visit[i] && ((distance[v] + cost[v][i]) < distance[i])) {
					
					// 경로를 새로 구한 짧은 경로의 비용으로 대체합니다.
					distance[i] = distance[v] + cost[v][i];
				}
			}
			
			// 경로들을 출력합니다.
			System.out.print("DIST:");
			
			// 모든 정점으로의 경로를 출력합니다.
			for (int i = 0 ; i < size ; i++) {

				// 모든 정점으로의 경로를 출력합니다.
				printValue(distance[i]);
			}
			
			// 출력을 위한 띄어쓰기를 합니다.
			System.out.println();	
		}
	}
	
	// 인접 행렬을 출력하는 함수입니다.
	private static void printMatrix(int[][] matrix) {
		
		// 배열의 크기만큼 반복합니다.
		for (int i = 0 ; i < matrix.length ; i++) {

			// 배열의 크기만큼 반복합니다.
			for (int j = 0 ; j < matrix.length ; j++) {
				
				// 해당 배열값을 출력합니다.
				printValue(matrix[i][j]);
			}
			
			// 출력을 위한 띄어쓰기를 합니다.
			System.out.println();
		}
	}
	
	// 값이 100보다 크면 예쁜출력을 위한 INF출력,
	// 그렇지 않다면 그 값을 그냥 출력하기 위한 함수 입니다.
	private static void printValue(int value) {
		
		// INF보다 크면,
		if (value >= INF) {
			
			// " INF" 출력.
			System.out.print(" INF");
			
		} else {
			
			// 그렇지 않다면 값을 출력.
			System.out.printf("%4d", value);
		}
	}
}