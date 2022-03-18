//서강 그라운드
package 백준.PS3월;

import java.io.*;
import java.util.*;

public class PS0318_14938 {

    static class Node{
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static int n, m, r;
    static ArrayList<Node>[] list;
    static int[] dist, item;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        dist = new int[n + 1];
        visit = new boolean[n + 1];
        item = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
            list[v].add(new Node(u, w));
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dijkstra(i));
        }

        System.out.println(ans);
    }

    static int dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visit, false);

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (!visit[now.v]) {
                visit[now.v] = true;

                for (Node next : list[now.v]) {
                    if (!visit[next.v] && dist[next.v] > now.cost + next.cost) {
                        dist[next.v] = now.cost + next.cost;
                        q.add(new Node(next.v, dist[next.v]));
                    }
                }
            }
        }
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (m >= dist[i]) {
                sum += item[i];
            }
        }

        return sum;
    }
}
