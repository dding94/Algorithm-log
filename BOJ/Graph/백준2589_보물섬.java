//보물서
package 백준.PS4월;

import java.io.*;
import java.util.*;

public class PS0408_2589 {

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n, m, ans;
    static int dist[][];
    static char map[][];
    static final int dx[] = {0, 0, 1, -1};
    static final int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }


        System.out.println(ans);
    }

    static void bfs(int x, int y) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = -1;
            }
        }
        int max = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        dist[x][y] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            x = now.x;
            y = now.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (dist[nx][ny] == -1 && map[nx][ny] == 'L') {
                        q.add(new Node(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                        if (dist[nx][ny] > max) {
                            max = dist[nx][ny];
                        }
                    }
                }
            }
        }

        ans = Math.max(ans, max);
    }
}
