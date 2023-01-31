package 에프랩스터디.이코테;

import java.io.*;
import java.util.*;
public class ps0131_안전영역 {
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int answer = 0;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int max = 0;
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        for (int k = 0; k <= max; k++) {
            visit = new boolean[n][n];
            int safeZone = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j] && map[i][j] > k) {
                        safeZone++;
                        bfs(i, j, k);
                    }
                }
            }

            answer = Math.max(answer, safeZone);
        }

        System.out.println(answer);
    }

    private static void bfs(int x, int y, int rain) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            //현재 위치
            x = now.x;
            y = now.y;

            //가야할 방향 (상하좌우)
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                //예외처리 (방문할 수 있는가)
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (!visit[nx][ny] && map[nx][ny] > rain) {
                        visit[nx][ny] = true;
                        q.add(new Node(nx, ny));
                    }
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
