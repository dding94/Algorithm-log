//완전 트리
package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0706_9934 {

    static StringBuilder[] ans;
    static int[] list;
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        n = (int) Math.pow(2, k) - 1;

        list = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        ans = new StringBuilder[k];
        for (int i = 0; i < k; i++) {
            ans[i] = new StringBuilder();
        }

        dfs(0, list.length - 1, 0);

        for (StringBuilder s : ans) {
            System.out.println(s);
        }
    }

    private static void dfs(int start, int end, int depth) {
        if (depth == k) {
            return;
        }

        int mid = (start + end) / 2;
        ans[depth].append(list[mid] + " ");

        dfs(start, mid - 1, depth + 1);
        dfs(mid + 1, end, depth + 1);

    }

}
