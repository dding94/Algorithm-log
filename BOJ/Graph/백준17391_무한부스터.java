package 백준.PS11월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PS1114_17391 {

    static final int[] dx = {0, 1};
    static final int[] dy = {1, 0};
    static int n, m;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));
        visit[0][0] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == n - 1 && now.y == m - 1) {
                System.out.println(now.count);
                return;
            }

            for (int i = 0; i < 2; i++) {
                for (int k = 1; k <= map[now.x][now.y]; k++) {
                    int nx = now.x + (dx[i] * k);
                    int ny = now.y + (dy[i] * k);

                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        if (!visit[nx][ny]) {
                            q.add(new Node(nx, ny, now.count + 1));
                            visit[nx][ny] = true;
                        }
                    }
                }
            }
        }

    }


    private static class Node {

        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}
