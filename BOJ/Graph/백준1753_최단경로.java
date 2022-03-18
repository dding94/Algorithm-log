//최단 경로
package 백준.PS3월;

import java.io.*;
import java.util.*;

public class PS0318_1753 {
    static class Node{
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static ArrayList<Node>[] list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
        }

        dijkstra(k);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF" + "\n");
            }else {
                sb.append(dist[i] + "\n");
            }
        }
        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        q.add(new Node(start, 0));
        dist[start] = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.w > dist[now.v]) {
                continue;
            }

            for (Node next : list[now.v]) {
                if (dist[next.v] > next.w + now.w) {
                    dist[next.v] = next.w + now.w;
                    q.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}
