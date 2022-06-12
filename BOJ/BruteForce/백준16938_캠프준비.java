//캠프 준비
package 백준.PS6월;

import java.io.*;
import java.util.*;

public class PS0612_16938 {

    static int n, l, r, x, ans;
    static int[] level;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //문제
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        level = new int[n];
        ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);


        System.out.println(ans);


    }

    private static void dfs(int depth, int max, int min, int sum, int start) {
        if (depth > 1) {
            if (l <= sum && sum <= r && max - min >= x) {
                ans++;
            }
        }

        if (start == n) {
            return;
        }

        for (int i = start; i < n; i++) {
            dfs(depth + 1, Math.max(max, level[i]), Math.min(min, level[i]), sum + level[i], i + 1);
        }
    }
}
