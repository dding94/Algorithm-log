package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0702_3980 {

    static int n = 11;
    static int max = 0;
    static int[][] map;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            map = new int[n][n];
            visit = new boolean[n];
            max = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, 0);
            sb.append(max).append('\n');
        }

        System.out.println(sb);
    }

    private static void dfs(int depth, int sum) {
        if (depth == n) {
            max = Math.max(max, sum);
            return;
        }


        for (int i = 0; i < n; i++) {
            if (!visit[i] && map[depth][i] != 0) {
                visit[i] = true;
                dfs(depth + 1, sum + map[depth][i]);
                visit[i] = false;
            }
        }
    }
}
