package Stack;

import java.io.*;
import java.util.*;

public class BOJ2504 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		
		String s = br.readLine();

		int answer = 0;
		int cnt =1;
		for(int i=0; i<s.length(); i++) {
			char cur = s.charAt(i);
			if(cur == '(') {
				stack.push(cur);
				cnt *= 2;
			}
			else if(cur == '[') {
				stack.push(cur);
				cnt *= 3;
			}
			else {
				if(cur == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						System.out.println(0);
						return;
					}
					if(s.charAt(i-1) =='(') {
						answer += cnt;
					}
					stack.pop();
					cnt /= 2;
				}else if(cur==']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						System.out.println(0);
						return;
					}
					if(s.charAt(i-1)=='[') {
						answer += cnt;
					}
					stack.pop();
					cnt /= 3;
				}
			}
		}
		if(!stack.isEmpty()) {
			System.out.println(0);
		}else {
			System.out.println(answer);
		}
 	}
	
}