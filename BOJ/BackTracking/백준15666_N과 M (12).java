package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0716_15666 {

    static int n, m;
    static int[] num, select;
    static Set<String> hs = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];
        select = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        dfs(0, 0);

        hs.forEach(System.out::println);
    }

    private static void dfs(int depth, int start) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < m; i++) {
                sb.append(select[i] + " ");
            }

            hs.add(sb.toString());

            return;
        }

        for (int i = start; i < n; i++) {
            select[depth] = num[i];
            dfs(depth + 1, i);
        }
    }
}
