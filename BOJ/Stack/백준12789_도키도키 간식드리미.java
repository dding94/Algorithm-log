package 백준.PS11월;

import java.io.*;
import java.util.*;

public class PS1105_12789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        int iter = 1;

        while (!q.isEmpty()) {
            if (q.peek() == iter) {
                q.poll();
                iter++;
            } else if (!stack.isEmpty() && stack.peek() == iter) {
                stack.pop();
                iter++;
            } else {
                stack.push(q.poll());
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == iter) {
                stack.pop();
                iter++;
            } else {
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");

    }
}
