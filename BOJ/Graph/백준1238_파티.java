//백준 파티
package 백준.PS3월;

import java.io.*;
import java.util.*;

public class PS0318_1238 {

    static class Node{
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Node>[] list, reversList;
        int[] dist, reversDist;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        reversList = new ArrayList[n + 1];

        dist = new int[n + 1];
        reversDist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            reversList[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
            reversDist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
            reversList[v].add(new Node(u, w));
        }

        dijkstra(x, list, dist);
        dijkstra(x, reversList, reversDist);

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i] + reversDist[i]);
        }
        System.out.println(ans);

    }

    static void dijkstra(int start, ArrayList<Node>[] list, int[] dist){
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.w > dist[now.v]) {
                continue;
            }

            for (Node next : list[now.v]) {
                if (dist[next.v] > now.w + next.w) {
                    dist[next.v] = now.w + next.w;
                    q.add(new Node(next.v, dist[next.v] ));
                }
            }

        }
    }
}
