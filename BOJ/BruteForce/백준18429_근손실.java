//근손실
package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0520_18429 {

    static int n, k, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ans = 0;
        int[] healthKit = new int[n];
        boolean[] check = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            healthKit[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 500, healthKit, check);

        System.out.println(ans);
    }

    private static void dfs(int depth, int weight, int[] healthKit,boolean[] check) {
        if (depth == n) {
            ans++;
            return;
        }

        if (weight < 500) {
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(depth + 1, weight - k + healthKit[i], healthKit, check);
                check[i] = false;
            }
        }
    }
}
