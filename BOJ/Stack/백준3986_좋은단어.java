package 백준.PS9월;

import java.io.*;
import java.util.*;

public class PS0901_3986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < s.length(); j++) {
                if (stack.size() > 0 && stack.peek() == s.charAt(j)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(j));
                }
            }

            if (stack.isEmpty()) {
                ans++;
            }
        }

        System.out.println(ans);
    }

}
