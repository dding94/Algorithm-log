package 백준23.PS4월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PS0402_N과M {

    static int n;
    static int m;
    static int[] answer;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = new int[m];
        visit = new boolean[n];

        dfs(0);

    }

    private static void dfs(int depth) {
        if (depth == m) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                answer[depth] = i + 1;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
