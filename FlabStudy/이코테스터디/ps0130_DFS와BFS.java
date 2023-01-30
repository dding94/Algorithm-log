package 에프랩스터디;

import java.io.*;
import java.util.*;

public class ps0130_DFS와BFS {

    static boolean[] visit;
    static List<List<Integer>> list = new ArrayList<>();

    static int start;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }

        for (List<Integer> graph : list) {
            graph.sort((o1, o2) -> o1 - o2);
        }

        visit = new boolean[n + 1];
        visit[start] = true;
        sb.append(start);
        dfs(start);
        System.out.println(sb);


        visit = new boolean[n + 1];
        sb.setLength(0);
        sb.append(start);
        bfs();
        System.out.println(sb);

    }

    private static void dfs(int start) {
        for (Integer next : list.get(start)) {
            if (!visit[next]) {
                visit[next] = true;
                sb.append(" ").append(next);
                dfs(next);
            }
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        visit[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            Integer now = q.poll();

            for (Integer next : list.get(now)) {
                if (!visit[next]) {
                    sb.append(" ").append(next);
                    visit[next] = true;
                    q.add(next);
                }
            }
        }

    }
}
