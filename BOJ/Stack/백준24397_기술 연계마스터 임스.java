package 백준.PS10월;

import java.io.*;
import java.util.Stack;

public class PS1011_24397 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        Stack<Character> stack_one = new Stack<>();
        Stack<Character> stack_two = new Stack<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') {
                stack_two.push(s.charAt(i));
            } else if (s.charAt(i) == 'S') {
                stack_one.push(s.charAt(i));
            } else if (s.charAt(i) == 'K') {
                if (!stack_one.isEmpty()) {
                    ans++;
                    stack_one.pop();
                } else {
                    break;
                }
            } else if (s.charAt(i) == 'R') {
                if (!stack_two.isEmpty()) {
                    ans++;
                    stack_two.pop();
                } else {
                    break;
                }
            } else {
                ans++;
            }
        }
        System.out.println(ans);
    }

}
