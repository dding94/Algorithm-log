package 백준.PS9월;

import java.io.*;
import java.util.*;

public class PS0909_1189 {

    static int n, m, k, ans;
    static char[][] map;
    static int[][] dist;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
                dist[i][j] = -1;
            }
        }

        dfs(1, new Node(n - 1, 0));
        System.out.println(ans);
    }

    static private void dfs(int depth, Node now) {
        if (depth == k) {
            if (now.x == 0 && now.y == m - 1) {
                ans++;
            }
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nx = now.x + dx[k];
            int ny = now.y + dy[k];

            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (map[nx][ny] != 'T' && dist[nx][ny] == -1) {
                    dist[now.x][now.y] = 1;
                    dfs(depth + 1, new Node(nx, ny));
                    dist[now.x][now.y] = -1;
                }
            }
        }
    }


    private static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
