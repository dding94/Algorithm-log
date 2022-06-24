package 백준.PS6월;

import java.io.*;
import java.util.*;

public class PS0624_2573 {

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};
    static int n, m;
    static int[][] iceberg;
    static boolean[][] visit;
    static boolean[][] checkVisit;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        iceberg = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        while (true) {
            checkVisit = new boolean[n][m];
            flag = false;

            for (int i = 1; i < n - 1; i++) {
                if (flag) {
                    break;
                }
                for (int j = 1; j < m - 1; j++) {
                    if (flag) {
                        break;
                    }
                    if (!flag && iceberg[i][j] != 0) {
                        flag = true;
                        bfs(i, j);
                        ans++;
                    }
                }
            }

            int blockCount = 0;

            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (!checkVisit[i][j] && iceberg[i][j] != 0) {
                        blockCount++;
                        checkBfs(i, j);
                    }
                }
            }

            if (blockCount > 1) {
                System.out.println(ans);
                break;
            }

            if (!flag) {
                System.out.println(0);
                break;
            }
        }

    }

    private static void checkBfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        checkVisit[x][y] = true;
        q.add(new Node(x, y));

        while (!q.isEmpty()) {
            Node now = q.poll();
            x = now.x;
            y = now.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && !checkVisit[nx][ny]) {
                    if (iceberg[nx][ny] != 0) {
                        q.add(new Node(nx, ny));
                        checkVisit[nx][ny] = true;
                    }
                }
            }
        }


    }

    private static void bfs(int x, int y) {
        visit = new boolean[n][m];
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

                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visit[nx][ny]) {
                    if (iceberg[nx][ny] != 0) {
                        q.add(new Node(nx, ny));
                        visit[nx][ny] = true;
                    } else {
                        if (iceberg[x][y] > 0) {
                            iceberg[x][y] -= 1;
                        }
                    }
                }
            }
        }



    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
