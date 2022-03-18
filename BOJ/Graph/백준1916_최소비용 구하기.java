package 백준.PS3월;

import java.io.*;
import java.util.*;

public class PS0318_1916 {
    static class Node{
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static ArrayList<Node>[] list;
    static int[] dist;
    static int start, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

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

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();

        System.out.println(dist[end]);
    }

    static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.cost > dist[now.v]) {
                continue;
            }

            for (Node next : list[now.v]) {
                if (dist[next.v] > next.cost + now.cost) {
                    dist[next.v] = next.cost + now.cost;
                    q.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}
