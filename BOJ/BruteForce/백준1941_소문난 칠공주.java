package 백준.PS6월;

import java.io.*;
import java.util.*;

public class PS0602_1941 {
    static final int n = 5;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static int count = 0;
    static char[][] map;
    static boolean[][] check;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[n][n];
        visit = new boolean[n * n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0, 0);

        System.out.println(count);
    }


    private static void dfs(int depth, int start,int somCount) {
        if (depth == 7) {
            if (somCount >= 4) {
                if(isBfs()){
                    count++;
                }
                return;
            }
        }


        for (int i = start; i < n * n; i++) {

            visit[i] = true;
            if (map[i / n][i % n] == 'S') {
                dfs(depth + 1, i + 1, somCount + 1);
            }else{
                dfs(depth + 1, i + 1, somCount);
            }
            visit[i] = false;
        }
    }

    private static boolean isBfs() {
        check = new boolean[n][n];
        int[][] bfsMap = new int[n][n];

        int x = 0, y = 0;
        for (int i = 0; i < n * n; i++) {
            if (visit[i]) {
                bfsMap[i / n][i % n] = 1;
                x = i / n;
                y = i % n;
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        check[x][y] = true;
        int count = 1;

        while (!q.isEmpty()) {
            Node now = q.poll();
            x = now.x;
            y = now.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && bfsMap[nx][ny] == 1 && !check[nx][ny]) {
                    q.add(new Node(nx, ny));
                    check[nx][ny] = true;
                    count++;
                }
            }
        }

        if (count == 7) {
            return true;
        } else {
            return false;
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
