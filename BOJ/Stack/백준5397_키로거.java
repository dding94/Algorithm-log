package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0801_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '<') {
                    if (!left.isEmpty()) {
                        right.add(left.pop());
                    }
                    continue;
                }

                if (s.charAt(i) == '>') {
                    if (!right.isEmpty()) {
                        left.add(right.pop());
                    }
                    continue;
                }

                if (s.charAt(i) == '-') {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    continue;
                }
                left.add(s.charAt(i));
            }

            while (!left.isEmpty()) {
                right.add(left.pop());
            }

            StringBuilder sb = new StringBuilder();
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }

            answer.append(sb + "\n");
            sb.setLength(0);
        }

        System.out.println(answer);
    }
}
