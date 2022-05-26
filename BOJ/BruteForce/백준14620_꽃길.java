//꽃길
package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0526_14620 {
    static int n, max;
    static int[][] map;
    static boolean[][] check;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        max = Integer.MAX_VALUE;
        map = new int[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(0);

        System.out.println(max);
    }

    private static void dfs(int flower) {
        if (flower == 3) {
            funcFlower();
            return;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    check[i][j] = true;
                    dfs(flower + 1);
                    check[i][j] = false;
                }
            }
        }
    }

    private static void funcFlower() {
        boolean[][] visit = new boolean[n][n];
        int landPriceSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j]) {
                    if (!isVisitCheck(i, j, visit)) {
                        return;
                    }
                }
            }
        }

        int sumLandPrice = blooming(visit);
        max = Math.min(max, sumLandPrice);
    }

    private static boolean isVisitCheck(int x, int y, boolean[][] visit) {
        if (visit[x][y]) {
            return false;
        }
        visit[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (0 <= nx && nx < n && 0 <= ny && ny < n && !visit[nx][ny]) {
                visit[nx][ny] = true;
            }else{
                return false;
            }
        }

        return true;
    }

    private static int blooming(boolean[][] visit) {
        int landPrice = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j]) {
                    landPrice += map[i][j];
                }
            }
        }

        return landPrice;
    }
}
