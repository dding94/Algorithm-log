package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0808_14248 {

    static int n, s, count;
    static int[] stone;
    static boolean[] visit;
    static int[] dx = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visit = new boolean[n];
        stone = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
        }
        int s = Integer.parseInt(br.readLine());

        bfs(s-1);

        System.out.println(count);
    }

    private static void bfs(int x) {
        visit[x] = true;
        count = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        while (!q.isEmpty()) {
            int now = q.poll();

            //왼쪽, 오른쪽
            for (int k = 0; k < 2; k++) {
                int nx = now + (stone[now] * dx[k]);

                if (0 <= nx && nx < n) {
                    if (!visit[nx]) {
                        visit[nx] = true;
                        q.add(nx);
                        count++;
                    }
                }
            }
        }
    }

}
