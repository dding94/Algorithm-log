package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0812_15815 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                stack.add(s.charAt(i) - '0');
                continue;
            }

            int num1 = stack.pop();
            int num2 = stack.pop();

            if (s.charAt(i) == '*') {
                stack.add(num1 * num2);
            }
            if (s.charAt(i) == '/') {
                stack.add(num2 / num1);
            }
            if (s.charAt(i) == '+') {
                stack.add(num1 + num2);
            }
            if (s.charAt(i) == '-') {
                stack.add(num1 - num2);
            }
        }

        System.out.println(stack.peek());
    }

}
