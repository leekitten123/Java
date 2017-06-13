package homework02;

import java.util.Scanner;

import lab04.Stack;

/***
 * 
 * Data Structure Hw02 <Infix-Postfix>
 * 20133243 Lee Sang Wook
 *
 ***/

public class Homework02 {

	// 메인 메소드 
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		// Infix와 Postfix를 저장할 변수 
		String infix ="";
		String postfix = "" ;
		
		// Infix 형태의 수식을 입력 
		System.out.print("수식을 입력하세요: ");
		infix = scanner.next();
		
		// Postfix의 형태로 치환 
		postfix = infixToPostfix(infix);
		
		// Infix, Postfix, Evaluation 을 차례로 출력 
		System.out.println(infix);
		System.out.println(postfix);
		System.out.println(postfixToEvaluation(postfix));
		
		scanner.close();
	}
	
	// Infix를 Postfix로 변경하는 메소드 
	private static String infixToPostfix(String infix) {
		
		// 연산자를 임시 저장할 스택 
		Stack stack = new Stack();
		
		// 결과 값을 저장할 문자열 
		String str = "";
		
		// 입력된 Infix 형태의 수식의 문자 개수만큼 포문 실행 
		for (int i = 0 ; i < infix.length() ; i++) {
			
			// 입력된 문자가 피연산자일 경우, 결과값에 추가 
			if (Character.isDigit(infix.charAt(i))) {	
				str += infix.charAt(i);
			
			// 입력된 문자가 '(' 일 경우 스택에 푸쉬 
			} else if (infix.charAt(i) == '(') {
				stack.push(infix.charAt(i));
			
			// 입력된 문자가 ')' 일 경우 스택에서 '(' 문자가 나올떄까지 푸쉬 값을 결과값에 순차로 추가  
			} else if (infix.charAt(i) == ')') {
				while (true) {
					
					int temp = stack.pop();
					
					if (temp == '(') {
						break;
					} else {
						str += (char) temp;
					}
				}
				
			// 입력된 문자가 그 외의 연산자일 경우의 과정 
			} else {
				
				int temp = 0;
				
				// 스택의 가장 위의 값을 팝 
				if (!stack.isEmpty())
					temp = stack.pop();
				
				// 현재의 문자와 스택에서 팝해온 문자의 우선순위를 비교하여 그에 맞게 처리 
				// 현재 문자의 우선순위가 높다면, 팝해온 문자를 다시 푸쉬하고, 현재 문자도 푸쉬 
				if (tokenPriority(infix.charAt(i)) > tokenPriority((char) temp)) {
					
					if (temp != 0)
						stack.push(temp);
					
					stack.push(infix.charAt(i));
					
				// 스택에서 팝한 문자의 우선순위가 높다면, 스택에서 팝한 문자를 결과값에 추가하고,
				// 현재 문자를 스택에 푸쉬
				} else {
					str += (char) temp;
					
					stack.push(infix.charAt(i));
				}
			}
		}
		
		// 마지막으로 스택에 남은 문자들을 결과값에 순차적으로 추가 
		while(!stack.isEmpty())
			str += (char) stack.pop();
		
		// 최종적으로 만들어낸 결과값을 스트링으로 리턴 
		return str;
	}
	
	// 입력된 토큰의 우선 순위를 구해주는 메소드 
	public static int tokenPriority(char c) {
		switch (c) {
		case ')': 
			return 3;
		case '*': 
		case '/':
			return 2;
		case '+':
		case '-':
			return 1;	
		case '(':
			return 0;
		}
		
		return -1;
	}
	
	// Postfix 형태의 수식에서 결과값을 구하는 메소드 
	private static int postfixToEvaluation (String postfix) {
		
		// 연산에 사용할 임시 스택 
		Stack stack = new Stack();
		
		// 입력된 수식의 길이만큼 반복 
		for (int i = 0 ; i < postfix.length() ; i++) {
			
			// 현재의 문자가 피연산자라면 스택에 푸쉬 
			if (Character.isDigit(postfix.charAt(i))) {
				stack.push(Integer.parseInt(Character.toString(postfix.charAt(i))));
				
			// 그 외의 연산자일 경우 
			} else {
				
				// 스택의 가장 최근 두개의 값을 팝
				int op2 = stack.pop();
				int op1 = stack.pop();
				
				// 연산자의 종류에 따라 두 값을 연
				switch(postfix.charAt(i)) {
				
				case '+':	stack.push(op1 + op2); break;
				case '-':	stack.push(op1 - op2); break;
				case '*':	stack.push(op1 * op2); break;
				case '/':	stack.push(op1 / op2); break;
				}
			}
		}
		
		// 최종적으로 스택에 남은 연산의 결과값을 리턴 
		return stack.pop();
	}
}


