//택배
package 백준.PS4월;

import java.io.*;
import java.util.*;

public class PS0404_1719 {

    static class Node{
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static ArrayList<Node>[] list;
    static int dist[];
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
            list[v].add(new Node(u, w));
        }

        for (int i = 1; i <= n; i++) {
            dijkstra(i);
        }

        System.out.println(sb);

    }

    static void dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visit = new boolean[n + 1];
        int[] path = new int[n + 1]; //노드 추적

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        dist[start] = 0;
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (!visit[now.v]) {
                visit[now.v] = true;
            }

            for (Node next : list[now.v]) {
                if (!visit[next.v] && dist[next.v] > now.cost + next.cost) {
                    dist[next.v] = now.cost + next.cost;
                    path[next.v] = now.v;
                    q.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if(i==start){
                sb.append("- ");
            }else{
                int answer = find(i, start, path);
                sb.append(answer + " ");
            }
        }
        sb.append("\n");
    }

    static int find(int i, int start, int[] path){
        if (path[i] == start) {
            return i;
        }

        return find(path[i], start, path);
    }
}
