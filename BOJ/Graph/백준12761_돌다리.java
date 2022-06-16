package 백준.PS6월;

import java.io.*;
import java.util.*;

public class PS0616_12761 {
    static int a, b, n , m, ans;
    static final int maxMove = 100001;
    static int[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = 0;
        visit = new int[maxMove];
        for (int i = 0; i < maxMove; i++) {
            visit[i] = -1;
        }

        bfs();

        System.out.println(ans);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == m) {
                ans = visit[now];
                return;
            }

            if (now * a < maxMove && visit[now * a] == -1) {
                q.add(now * a);
                visit[now * a] = visit[now] + 1;
            }

            if (now * b < maxMove && visit[now * b] == -1) {
                q.add(now * b);
                visit[now * b] = visit[now] + 1;
            }

            if (now - a >= 0 && visit[now - a] == -1) {
                q.add(now - a);
                visit[now - a] = visit[now] + 1;
            }

            if (now - b >= 0 && visit[now - b] == -1) {
                q.add(now - b);
                visit[now - b] = visit[now] + 1;
            }

            if (now + a < maxMove && visit[now + a] == -1) {
                q.add(now + a);
                visit[now + a] = visit[now] + 1;
            }

            if (now + b < maxMove && visit[now + b] == -1) {
                q.add(now + b);
                visit[now + b] = visit[now] + 1;
            }


            if (now - 1 >= 0 && visit[now - 1] == -1) {
                q.add(now - 1);
                visit[now - 1] = visit[now] + 1;
            }

            if (now + 1 < maxMove && visit[now + 1] == -1) {
                q.add(now + 1);
                visit[now + 1] = visit[now] + 1;
            }

        }
    }
}
