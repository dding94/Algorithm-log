package 백준.PS8월;

import java.io.*;
import java.util.*;
import 백준.PS8월.PS0823_16174.Node;

public class PS0823_16174 {

    static int n;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visit = new boolean[n][n];
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

    }

    public static void bfs() {
        Queue<백준.PS8월.PS0823_16174.Node> q = new LinkedList<>();
        visit[0][0] = true;
        q.add(new 백준.PS8월.PS0823_16174.Node(0, 0));

        while (!q.isEmpty()) {
            백준.PS8월.PS0823_16174.Node now = q.poll();
            int x = now.x;
            int y = now.y;

            int value = map[now.x][now.y];

            if (value == -1) {
                System.out.println("HaruHaru");
                return;
            }

            for (int k = 0; k < 2; k++) {
                int nx = x + dx[k] * value;
                int ny = y + dy[k] * value;

                if (0 <= nx && nx < n && 0 <= ny && ny < n && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    q.add(new 백준.PS8월.PS0823_16174.Node(nx, ny));
                }
            }

        }
        System.out.println("Hing");
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
