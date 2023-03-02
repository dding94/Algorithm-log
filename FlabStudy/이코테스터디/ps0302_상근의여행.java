package 에프랩스터디.이코테;

import java.io.*;
import java.util.*;

public class ps0302_상근의여행 {

    static int[][] arr;
    static boolean[] visit;
    static int answer;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            answer = 0;

            arr = new int[n + 1][n + 1];
            visit = new boolean[n + 1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[a][b] = 1;
                arr[b][a] = 1;
            }

            bfs();
            sb.append(answer - 1).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;
        while (!q.isEmpty()) {
            answer++;
            int now = q.poll();
            for (int i = 1; i <= n; i++) {
                if (arr[now][i] != 0 && !visit[i]) {
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
