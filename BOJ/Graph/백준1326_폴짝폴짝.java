package 백준.PS10월;

import java.io.*;
import java.util.*;

public class PS1013_1326 {

    static int[] map;
    static boolean[] visit;
    static int a, b, n, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1];
        visit = new boolean[n + 1];
        ans = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(a, 0));
        visit[a] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == b) {
                ans = Math.min(ans, now.jump);
                return;
            }

            for (int i = 1; now.x + (map[now.x] * i) <= n; i++) {
                int next = now.x + (map[now.x] * i);
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(new Node(next, now.jump + 1));
                }

            }

            for (int i = 1; now.x - (map[now.x] * i) >= 1; i++) {
                int next = now.x - (map[now.x] * i);
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(new Node(next, now.jump + 1));
                }
            }
        }
    }

    private static class Node{
        int x;
        int jump;

        public Node(int x, int jump) {
            this.x = x;
            this.jump = jump;
        }
    }

}
