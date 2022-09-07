package 백준.PS9월;

import java.io.*;
import java.util.Stack;

public class PS0907_11899 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.add(')');
                }
            } else {
                stack.add('(');
            }
        }

        System.out.println(stack.size());
    }

}
