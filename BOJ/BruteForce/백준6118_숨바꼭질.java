package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0510_6118 {
    static ArrayList<Integer> list[];
    static int[] dist;
    static int count, maxDist, minIndex;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        dist = new int[n + 1];
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

        minIndex = 1;
        maxDist = Integer.MIN_VALUE;
        count = 1;

        bfs();

        System.out.println(minIndex + " " + maxDist + " " + count);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));
        dist[1] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (maxDist < now.dist) {
                maxDist = now.dist;
                minIndex = now.index;
                count = 1;
            }else if (maxDist == now.dist) {
                minIndex = Math.min(minIndex, now.index);
                count++;
            }

            for (Integer next : list[now.index]) {
                if (dist[next] == 0 && next != 1) {
                    q.add(new Node(next, now.dist + 1));
                    dist[next] = dist[now.index] + 1;
                }
            }
        }

    }


    static class Node{
        int index;
        int dist;

        public Node(int num, int dist) {
            this.index = num;
            this.dist = dist;
        }
    }
}
