package 백준.PS9월;

import java.io.*;
import java.util.*;

public class PS0911_16439 {

    static int n, m;
    static int[][] chicken;
    static boolean[] visit;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        chicken = new int[n][m];
        visit = new boolean[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                chicken[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(ans);
    }

    private static void dfs(int depth, int start) {
        if (depth == 3) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int temp = 0;
                for (int j = 0; j < m; j++) {
                    if (visit[j]) {
                        temp = Math.max((temp), chicken[i][j]);
                    }
                }
                sum += temp;
            }
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = start; i < m; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }

}
