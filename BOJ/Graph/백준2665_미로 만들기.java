//미로 만들기
package 백준.PS3월;

import java.io.*;
import java.util.*;

public class PS0318_2665 {
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map;
    static int[][] dist;
    static int n;
    static final int dx[] = {0, 0, 1, -1};
    static final int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();

        System.out.println(dist[n - 1][n - 1]);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        dist[0][0] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (dist[nx][ny] > dist[x][y]) {
                        if (map[nx][ny] == 1) {
                            dist[nx][ny] = dist[x][y];
                        }else{
                            dist[nx][ny] = dist[x][y] + 1;
                        }
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }
    }
}
