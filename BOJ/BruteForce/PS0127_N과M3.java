package 백준23.PS1월;

import java.io.*;
import java.util.StringTokenizer;

public class PS0127_N과M3 {

    static int n, m;
    static int a[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n + 1];

        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int index) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            a[index] = i;
            dfs(index + 1);
        }
    }

}
