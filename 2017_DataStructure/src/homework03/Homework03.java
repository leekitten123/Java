package homework03;

/***
 * 
 * Data Structure Hw03 <Maze Problem>
 * 20133243 Lee Sang Wook
 *
 * Documentation
 * 
 * Homework03은 Stack을 사용해서 주어진 Matrix에서 길을 찾는 문제입니다.
 * 스택에서 현재 위치정보를 가져온 후, 다음에 해당하는 위치가 비어있다면 Mark해줍니다.
 * 위치를 찾을 때, 북쪽부터 시계방향으로 돌아가면서 다음위치를 탐색합니다.
 * 이런식으로 위치 탐색후, 도착점에 도달할 때까지 반복합니다.
 * 다음 위치로 이동할 때, 현재위치를 스택에 저장해 둡니다.
 * 도착점에 도달했다면, 로직을 종료시킵니다.
 * 종료와 동시에 Path와 Mark된 Matrix를 출력해줍니다.
 *
 ***/

public class Homework03 {
	
	
	// 북쪽과 동쪽 방향을 상수로 저장합니다.
	// 북쪽을 기준으로 시계방향으로 돌면서 0부터 7까지는 방향을 지칭합니다. 
	private final static int NORTH = 0;
	private final static int EAST = 2;
	
	// 방향을 가르키틑 수는 8이상이 될 수 없습니다.
	private final static int MAX_DIRECTION = 8;
	
	// 우리가 탐색해야하는 Maze의 초기화입니다.
	private static int[][] maze = {
			{0, 1, 1, 1, 1, 1},
			{1, 0, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 1},
			{1, 1, 0, 1, 1, 1},
			{1, 0, 1, 0, 0, 1},
			{1, 1, 1, 1, 1, 0}};
	
	// 우리가 Maze를 탐색하면서 들렸던 위치를 Mark해줄 2차원 배열입니다.
	private static int[][] mark = {
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0}};
	
	// 방향에 따라서 좌표에서 수직과 수평으로 얼마나 이동해주어야 하는지를 저장합니다.
	// 0부터 7까지 북쪽을 기준으로 시계방향으로 돌아 가르키는 방향에 대해서 
	// 얼마나 이동해야 하는지를 초기화합니다.
	private static Offset[] move = {
			new Offset(-1, 0), new Offset(-1, 1),
			new Offset(0, 1), new Offset(1, 1),
			new Offset(1, 0), new Offset(1, -1),
			new Offset(0, -1), new Offset(-1, -1)};
	
	// 이동시 위치했던 위치정보를 저장할 스택입니다.
	private static Stack stack = new Stack();
	
	// 마지막 위치에 도달했을 때에 True가 되는 변수입니다.
	private static boolean found = false;
	
	public static void main(String[] args) {
	
		// 처음위치를 (0, 0)으로 잡아주고, Mark에 마크해줍니다.
		// 그와 동시에 스택에 정보를 넣어줍니다.
		mark[0][0] = 1;
		stack.push(new Element(0, 0, EAST));
		
		// 스택이 비었거, 도착점에 도착했다면 실행을 멈춥니다.
		while (!stack.isEmpty() && !found) {
			
			// 현재 위치 정보를 가져옵니다.
			Element temp = stack.pop();
			
			// 정해두지 않은 위치이거나, 도착점에 도착했다면 실행을 멈춥니다.
			while (!found) {
				
				// 현재 위치로부터 다음 위치를 예상해봅니다.
				int nextRow = temp.row + move[temp.dir].vert;
				int nextCol = temp.col + move[temp.dir].horiz;
				
				// 예상 위치가 도착점이라면, 예상 위치를 마크해주고,
				// 현재 위치와 도착 위치 정보를 스택에 넣어 줍니다.
				// 마지막으로 found를 True로 변경해줍니다.
				if (nextRow == 5 && nextCol == 5) {
				
					mark[nextRow][nextCol] = 1;
					
					stack.push(new Element(temp.row, temp.col, temp.dir));
					stack.push(new Element(nextRow, nextCol, NORTH));
					
					found = true;
					
				// 예상 위치가 도착점이 아닌 들를 수 있는 곳이라면,
				// 예상 위치를 마크하고, 현재 위치를 스택에 넣어 줍니다.
				// 그후 temp라는 현재 정보를 나타내는 위치정보에 이동한 정보를 넣어줍니다.
				} else if (maze[nextRow][nextCol] == 0 && mark[nextRow][nextCol] == 0) {
					
					mark[nextRow][nextCol] = 1;
					stack.push(new Element(temp.row, temp.col, temp.dir));
					
					temp = new Element(nextRow, nextCol, NORTH);
				
				// 예상 위치로 이동이 불가능하다면 다음 방향을 탐색하도록 변수를 변경한다.
				} else {
					
					temp.dir++;
				}
				
				// 모든 방향을 탐색해 보았을 경
				if (!(temp.dir < MAX_DIRECTION)) {
					
					Element temp2 = temp; temp = stack.pop();
					stack.push(temp); stack.push(temp2);
				}
			}
		}
		
		// 결과물 출력 부분입니다.
		printPath();
		System.out.println();
		printMarkedMatrix();
	}
	
	// 미로를 이동한 길을 출력합니다.
	private static void printPath() {
		
		System.out.println("row col");
		System.out.println("-------");
		
		stack.display();
	}
	
	
	// 미로를 탈출하면서 들리며 마크했던 위치를 모두 출력합니다.
	private static void printMarkedMatrix() {
		
		System.out.println("Marked Matrix");
		System.out.println("-------------");
		
		for (int i = 0 ; i < 6 ; i++) {
			for (int j = 0 ; j < 6 ; j++) {
				
				System.out.print(mark[i][j] + " ");
			}
			
			System.out.println();
		}
	}
}