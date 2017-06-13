package lab04;

import java.io.BufferedReader;
import java.io.IOException;

public final class Lab04 {

	public static void postfix(String str) {
		
		Stack stack = new Stack();
		
		for (int i = 0 ; i < str.length() ; i++) {
			
			if (Character.isDigit(str.charAt(i))) {
				
				System.out.print(str.charAt(i));
				
			} else if (str.charAt(i) == '(') {
				
				stack.push(str.charAt(i));
				
			} else if (str.charAt(i) == ')') {
				
				while(true) {
					
					int temp = stack.pop();
					
					if (temp == '(') {
						
						break;
					} else {
						
						System.out.print((char) temp);
					}
				}
			} else if (str.charAt(i) == '$') {
				
				System.out.print((char) stack.pop());
				
			} else {
				
				int temp = 0;
				
				if (!stack.isEmpty()) {
					temp = stack.pop();
				}
				
				if (tokenPriority(str.charAt(i)) > tokenPriority((char) temp)) {
					
					if (temp != 0) {
						stack.push(temp);
					}
					
					stack.push(str.charAt(i));
					
				} else {
					System.out.print((char) temp);
					
					stack.push(str.charAt(i));
				}
				
			}
		}
		
		System.out.println();
	}

	public static int tokenPriority(char c) {
	
		switch (c) {
		case ')':
			return 3;
			
		case '*': case '/':
			return 2;
			
		case '+': case '-':
			return 1;
			
		case '(':
			return 0;
		}
		
		return -1;
	}

	public static void postfixEvalulation(String str) {
		
		Stack stack = new Stack();
		
		for (int i = 0 ; i < str.length() ; i++) {
			
			if (Character.isDigit(str.charAt(i))) {
				stack.push(Integer.parseInt(Character.toString(str.charAt(i))));
			} else {
				
				int op2 = stack.pop();
				int op1 = stack.pop();
				
				switch(str.charAt(i)) {
				
				case '+':	stack.push(op1 + op2); break;
				case '-':	stack.push(op1 - op2); break;
				case '*':	stack.push(op1 * op2); break;
				case '/':	stack.push(op1 / op2); break;
				}
			}
		}
		
		System.out.println(stack.pop());
	}

	public static void palidrome(BufferedReader br) throws IOException {
		
		Stack stack1 = new Stack();
		
		String message = " is Palindrome";
		
		while (br.ready()) {
			
			String str = br.readLine();
			
			if (str.length() % 2 == 0) {
				
				for (int i = 0 ; i < str.length()/2 ; i++) {
				
					stack1.push(str.charAt(i));
				}

			} else {
				
				for (int i = 0 ; i <= str.length()/2 ; i++) {
					
					stack1.push(str.charAt(i));
				}
			}
			
			for (int i = str.length() / 2 ; !stack1.isEmpty() ; i++) {
					
				if (!compare((char) stack1.pop(), str.charAt(i))) {
					
					message =" is not Palindrorme";
					break;
				}
			}

			System.out.println(str + message);
		}
	}

	public static void paildromeBalanced(BufferedReader br) throws IOException {
		
		while (br.ready()) {
		
			String buffer = br.readLine();
		
			Stack stack = new Stack();
			
			char c ;
			
			String ans = "balanced";

			for (int i = 0 ; i < buffer.length() ; i++) {
				
				switch (buffer.charAt(i)) {
				case '{':
				case '[':
				case '(':
					stack.push(buffer.charAt(i));
					break;
				
				case '}':
					c = (char) stack.pop();
					ans = (c == '{') ? ans : "unbalanced"; 
				case ']':
					c = (char) stack.pop();
					ans = (c == '[') ? ans : "unbalanced";
				case ')':
					c = (char) stack.pop();
					ans = (c == '(') ? ans : "unbalanced";
				}
			
				if (ans.equals("unbalanced")) {
					break;
				}
			}
			
			System.out.println(buffer + " " + ans);
		}
	}
	
	public static boolean compare(char a, char b) { return a == b ? true : false; }
}