//백준 촌수계산
package 백준.PS3월;

import java.io.*;
import java.util.*;

public class PS0313_2644 {
    static ArrayList<Integer> a[];
    static boolean[] check;
    static int x, y;

    static class Node{
        int x;
        int count;

        public Node(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        a = new ArrayList[n+1];
        check = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            a[u].add(v);
            a[v].add(u);
        }

        bfs();

        System.out.println(-1);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, 0));

        check[x] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            x = now.x;

            if(x == y){
                System.out.println(now.count);
                System.exit(0);
            }
            for (int y : a[x]) {
                if (check[y] == false) {
                    q.add(new Node(y, now.count + 1));
                    check[y] = true;
                }
            }
        }

    }
}
