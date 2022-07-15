package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0715_22953 {

    static int n, k, c;
    static long max = 1000000000000l;
    static long ans = max;
    static int[] chef;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        chef = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            chef[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(ans);
    }

    private static void dfs(int depth) {
        if (depth == c) {
            binarySearch();
            return;
        }

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (chef[i] != 1) {
                chef[i]--;
                dfs(depth + 1);
                chef[i]++;
            }
        }

        dfs(depth + 1);
    }

    private static void binarySearch() {
        long left = 1;
        long right = max;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int i = 0; i < n; i++) {
                count += mid / chef[i];
            }

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = Math.min(ans, mid);
            }
        }
    }

}
