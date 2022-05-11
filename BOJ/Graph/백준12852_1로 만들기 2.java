package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0511_12852 {
    static boolean[] check;
    static int ans = 0;
    static int[] backTracking;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        check = new boolean[n + 1];
        backTracking = new int[n + 1];

        bfs(n);

        sb.append(ans + "\n");
        sb.append(n + " ");
        backTrackingPrint(n);

        System.out.println(sb);
    }

    private static void backTrackingPrint(int n) {
        if (backTracking[n] == 0) {
            return;
        }

        sb.append(backTracking[n] + " ");
        backTrackingPrint(backTracking[n]);
    }

    private static void bfs(int n) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.index == n) {
                ans = now.count;
                return;
            }
            if (now.index + 1 <= n) {
                if (!check[now.index + 1]) {
                    q.add(new Node(now.index + 1, now.count + 1));
                    check[now.index + 1] = true;
                    backTracking[now.index + 1] = now.index;
                }
            }

            if (now.index * 2 <= n) {
                if (!check[now.index * 2]) {
                    q.add(new Node(now.index * 2, now.count + 1));
                    check[now.index * 2] = true;
                    backTracking[now.index * 2] = now.index;
                }
            }

            if (now.index * 3 <= n) {
                if (!check[now.index * 3]) {
                    q.add(new Node(now.index * 3, now.count + 1));
                    check[now.index * 3] = true;
                    backTracking[now.index * 3] = now.index;
                }
            }
        }
    }

    static class Node{
        int index;
        int count;

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}
