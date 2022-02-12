//백준 N과 M(10)
package 백준.PS2월;

import java.util.*;
import java.io.*;

public class PS0212_15664 {

    static int[] a, ans;
    static boolean[] check;
    static int n, m;
    static StringBuilder sb;
    static LinkedHashSet<String> hs = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];
        ans = new int[m];
        check = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        dfs(0, 0);

        hs.forEach(System.out::println);

    }

    static void dfs(int index, int start) {
        if(index == m){
            sb = new StringBuilder();
            for (int i : ans) {
                sb.append(i).append(" ");
            }
            hs.add(sb.toString());
            return;
        }

        for (int i = start; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                ans[index] = a[i];
                dfs(index + 1, i);
                check[i] = false;
            }
        }
    }
}
