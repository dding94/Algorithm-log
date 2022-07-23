package 백준.PS7월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PS0711_18430 {

    static int n, m;
    static int[][] map;
    static boolean[][] visit;
    static int ans = 0;
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

        dfs(0, 0, 0);

        System.out.println(ans);
    }

    private static void dfs(int i, int j, int sum) {
        if (j == m) {
            j = 0;
            i++;
        }

        if (i == n) {
            ans = Math.max(ans, sum);
            return;
        }


        if (!visit[i][j]) {
            if (isRange(i, j - 1) && isRange(i + 1, j) && !visit[i][j - 1] && !visit[i + 1][j]) {
                visit[i][j] = visit[i][j - 1] = visit[i + 1][j] = true;
                dfs(i, j + 1, sum + (map[i][j] * 2) + map[i][j - 1] + map[i + 1][j]);
                visit[i][j] = visit[i][j - 1] = visit[i + 1][j] = false;
            }

            if (isRange(i, j - 1) && isRange(i - 1, j) && !visit[i][j - 1] && !visit[i - 1][j]) {
                visit[i][j] = visit[i][j - 1] = visit[i - 1][j] = true;
                dfs(i, j + 1, sum + (map[i][j] * 2) + map[i][j - 1] + map[i - 1][j]);
                visit[i][j] = visit[i][j - 1] = visit[i - 1][j] = false;
            }

            if (isRange(i, j + 1) && isRange(i + 1, j) && !visit[i][j + 1] && !visit[i + 1][j]) {
                visit[i][j] = visit[i][j + 1] = visit[i + 1][j] = true;
                dfs(i, j + 1, sum + (map[i][j] * 2) + map[i][j + 1] + map[i + 1][j]);
                visit[i][j] = visit[i][j + 1] = visit[i + 1][j] = false;
            }

            if (isRange(i, j + 1) && isRange(i - 1, j) && !visit[i][j + 1] && !visit[i - 1][j]) {
                visit[i][j] = visit[i][j + 1] = visit[i - 1][j] = true;
                dfs(i, j + 1, sum + (map[i][j] * 2) + map[i][j + 1] + map[i - 1][j]);
                visit[i][j] = visit[i][j + 1] = visit[i - 1][j] = false;
            }
        }

        dfs(i, j + 1, sum);

    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
