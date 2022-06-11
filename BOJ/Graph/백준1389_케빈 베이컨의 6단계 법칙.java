package 백준.PS6월;

import java.io.*;
import java.util.*;

public class PS0611_1389 {

    static int n, m, dist, ans;
    static ArrayList<Node> list[];
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = Integer.MAX_VALUE;

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, 0));
            list[v].add(new Node(u, 0));
        }

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        System.out.println(ans);
    }

    private static void bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        visit = new boolean[n + 1];

        q.add(new Node(start, 0));
        visit[start] = true;
        int temp = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            temp += now.dist;

            for (Node next : list[now.v]) {
                if (!visit[next.v]) {
                    visit[next.v] = true;
                    q.add(new Node(next.v, now.dist + 1));
                }
            }
        }

        if (dist > temp) {
            dist = temp;
            ans = start;
        }

    }

    private static class Node{
        int v;
        int dist;

        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }

}
