package 백준.PS7월;

import java.io.*;
import java.util.Stack;

public class PS0719_4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = 1;

        while (true) {
            String s = br.readLine();
            int ans = 0;

            if (s.contains("-")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '}') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        stack.push('{');
                        ans += 1;
                    }
                } else {
                    stack.add(s.charAt(i));
                }
            }

            if (!stack.isEmpty()) {
                ans += stack.size() / 2;
            }

            sb.append(cnt + ". " + ans + "\n");
            cnt++;
        }

        System.out.println(sb);

    }


}
