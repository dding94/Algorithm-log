package 백준.PS9월;


import java.io.*;
import java.util.StringTokenizer;

public class PS0908_2422 {

    static int n, m, ans;
    static boolean[][] valid;
    static int[] choiceNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = 0;
        valid = new boolean[n + 1][n + 1];
        choiceNum = new int[3];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            valid[u][v] = true;
            valid[v][u] = true;
        }

        dfs(0, 1);

        System.out.println(ans);
    }

    private static void dfs(int depth,int start) {
        if (depth == 3) {
            if (check()) {
                ans++;
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            choiceNum[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }

    private static boolean check() {

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (valid[choiceNum[i]][choiceNum[j]]) {
                    return false;
                }
            }
        }

        return true;
    }
}
