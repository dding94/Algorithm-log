package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0720_13565 {

    static int n, m;
    static char map[][];
    static boolean visit[][];
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < m; i++) {
            if (!visit[0][i] && map[0][i] == '0') {
                bfs(0, i);
            }
        }

        for (int i = 0; i < m; i++) {
            if (visit[n - 1][i]) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            x = now.x;
            y = now.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visit[nx][ny] && map[nx][ny] == '0') {
                    visit[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }

        }

    }


    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
