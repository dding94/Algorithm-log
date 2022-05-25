package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0525_3184 {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static int n, m;
    static boolean[][] check;
    static char[][] map;
    static int sheepCnt = 0;
    static int wolfCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j] && (map[i][j] == 'v' || map[i][j] == 'o')) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(sheepCnt + " " + wolfCnt);
    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        check[x][y] = true;
        int areaWolfCnt = 0;
        int areaSheepCnt = 0;
        if (map[x][y] == 'v') {
            areaWolfCnt++;
        }else{
            areaSheepCnt++;
        }

        while (!q.isEmpty()) {
            Node now = q.poll();

            x = now.x;
            y = now.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (map[nx][ny] != '#' && !check[nx][ny]) {
                        check[nx][ny] = true;
                        q.add(new Node(nx, ny));
                        if (map[nx][ny] == 'v') {
                            areaWolfCnt++;
                        }
                        if (map[nx][ny] == 'o') {
                            areaSheepCnt++;
                        }
                    }
                }
            }
        }

        if (areaSheepCnt > areaWolfCnt) {
            sheepCnt += areaSheepCnt;
        }else{
            wolfCnt += areaWolfCnt;
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
