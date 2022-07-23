package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0713_21735 {

    static int n, m, ans;
    static int[] snowPoint;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        snowPoint = new int[n + 1];
        ans = -1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            snowPoint[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0);

        System.out.println(ans);
    }

    private static void dfs(int depth, int snowSize, int i) {
        if (depth == m || i == n) {
            ans = Math.max(ans, snowSize);
            return;
        }

        if (i < n) {
            dfs(depth + 1, snowSize + snowPoint[i + 1], i + 1);
        }

        if (i + 1 < n) {
            dfs(depth + 1, snowSize / 2 + snowPoint[i + 2], i + 2);
        }
    }
}
