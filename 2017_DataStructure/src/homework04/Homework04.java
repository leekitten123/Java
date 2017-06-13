package homework04;

/***
 * 
 * Data Structure Hw04 <BST>
 * 20133243 Lee Sang Wook
 *
 * Documentation
 * 
 * BinarySearhTree를 사용해서 Test해볼 Homework04 메인함수입니다.
 * 처음에 BST를 생성하고, Scanner를 정의합니다.
 * 그리고 지속적으로 quit가 false가되지 않을 때까지 while구문을 통해서 메뉴를 반복해줍니다.
 * 메뉴에는 Insert, Delete, Search, Print, Quit가 있습니다.
 * Insert는 BST에 값을 대입, Delete는 BST에 값을 삭제,
 * Search는 값의 존재여부를 탐색, Print는 BST를 트리 구조로 출력.
 * Quit는 quit변수를 false로 만들어 메뉴를 종료합니다.
 * 마지막으로 스캐너의 사용을 종료함으로써 ㅍ프로그램을 종료합니다.
 * 
 ***/

import java.util.Scanner;

public class Homework04 {

	// 프로그램을 실행할 메인 함수입니다.
	public static void main(String[] args) {
		
		// BST를 기본 생성자로 생성합니다.
		BinarySearchTree bst = new BinarySearchTree();
		
		// 입력에 필요한 Scanner를 정의합니다.
		Scanner scanner = new Scanner(System.in);
		
		// 메뉴 구문을 료할 quit 변수입니다.
		boolean quit = true;
		
		// quit가 false가 될 때까지 계속 반복될 메뉴 부분입니다.
		while (quit) {
			
			// 메뉴를 보여줄 출력 부분입니다.
			System.out.println("1.Insert 2.Delete 3.Search 4.Print 5.Quit");
			
			// 1부터 5까지의 메뉴 중 하나를 입력 받습니다.
			System.out.print("Menu: ");
			int menu = scanner.nextInt();
			
			// 입력받은 메뉴의 숫자에 맞는 작업을 해줍니다.
			switch (menu) {
			
			// 입력하는 부분으로 숫자를 하나 더 입력받아 BST에 입력해줍니다.
			case 1:
				System.out.print("Enter Number To Insert: ");
				bst.insert(scanner.nextInt());
				break;
				
			// 삭제하는 부분으로 숫자를 하나 더 입력받아 BST에서 제거해줍니다.	
			case 2:
				System.out.print("Enter Number To Delete: ");
				bst.delete(scanner.nextInt());
				break;
				
			// 탐색하는 부분으로 숫자를 하나 더 입력받아 그 숫자가 존재한다면 찾았다고 아니면 못찾았다고 출력합니다.	
			case 3:
				System.out.print("Enter Number To Search: ");
				int temp = scanner.nextInt();
				System.out.println(bst.search(temp) ? temp + " Is Found" : temp + " Is Not Found"); 
				break;
			
			// 출력하는 부분으로 BST의 Draw함수를 사용합니다.	
			case 4:
				bst.draw();
				break;
				
			// 종료하는 부분으로 quit변수를 false로 만들어 while구문을 종료합니다.
			case 5:
				quit = false;
				break;
			}
			
			// 메뉴 구분을 해서 보기 좋게 띄어쓰기를 합니다.
			System.out.println();
		}
		
		// 입력에 사용한 Scanner를 종료합니다.
		scanner.close();
	}
}