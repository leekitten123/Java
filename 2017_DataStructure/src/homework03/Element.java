package homework03;

/***
 * 
 * Data Structure Hw03 <Maze Problem>
 * 20133243 Lee Sang Wook
 *
 * Documentation
 * 
 * Element 클래스는 미로에서 위치 정보를 보여주기 위한 정보입니다.
 * row, col, dir라는 필드와 생성자로 구성되어 있습니다.  
 * row는 가로, col은 세로, dir은 다음으로 어느 방향으로 이동해야 하는지를 알려줍니다.
 * 생성자는 3가지의 정보를 모두 받아와서 초기화합니다. 
 * 
 ***/

public class Element {

	public int row;
	public int col;
	public int dir;
	
	public Element(int row, int col, int dir) {
		
		this.row = row;
		this.col = col;
		this.dir = dir;
	}
}