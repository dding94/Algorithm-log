package 스터디.PS6월1주차;

import java.io.*;
import java.util.*;

public class PS0609_24480 {

    static int n, m, r;
    static int index = 1;
    static boolean visit[];
    static int[] visitProcess;
    static ArrayList<Integer> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        visitProcess = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i], (o1, o2) -> o2 - o1);
        }

        dfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(visitProcess[i] + "\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int r) {
        visit[r] = true;
        visitProcess[r] = index++;

        for (Integer node : list[r]) {
            if (!visit[node]) {
                dfs(node);
            }
        }
    }
}
