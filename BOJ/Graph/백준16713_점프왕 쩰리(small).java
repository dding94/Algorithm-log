package 백준.PS9월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PS0922_16713 {

    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int[][] map;
    static boolean[][] visit;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs() ? "HaruHaru" : "Hing");
    }

    private static boolean bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        visit[0][0] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            int jump = map[x][y];

            if (x == n - 1 && y == n - 1) {
                return true;
            }

            for (int k = 0; k < 2; k++) {
                int nx = x + dx[k] * jump;
                int ny = y + dy[k] * jump;

                if (0 <= nx && nx < n && 0 <= ny && ny < n && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }

        return false;
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
