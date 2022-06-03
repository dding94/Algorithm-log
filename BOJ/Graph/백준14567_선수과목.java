//선수과목
package 백준.PS6월;

import java.util.*;
import java.io.*;

public class PS0603_14567 {
    static int n, m;
    static int[] subjects, ans;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        subjects = new int[n + 1];
        ans = new int[n + 1];
        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            subjects[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (subjects[i] == 0) {
                q.add(i);
                ans[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (Integer next : list[now]) {
                subjects[next]--;

                if (subjects[next] == 0) {
                    q.add(next);
                    ans[next] = ans[now] + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(ans[i] + " ");
        }
        System.out.println(sb);
    }
}
