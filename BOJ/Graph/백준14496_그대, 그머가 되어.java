package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0731_14496 {

    static int a, b, n, m, ans;
    static ArrayList<Integer>[] list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = -1;

        visit = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        bfs();
        System.out.println(ans);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(a, 0));
        visit[a] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == b) {
                ans = now.dist;
                return;
            }

            for (Integer next : list[now.x]) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(new Node(next, now.dist + 1));
                }
            }
        }

    }

    static class Node{
        int x;
        int dist;

        public Node(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }
    }
}
