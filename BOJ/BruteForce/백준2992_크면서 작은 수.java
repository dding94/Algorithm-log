package 백준.PS7월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS0710_2992 {
    static String x;
    static int origin;
    static boolean[] visit;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        x = br.readLine();
        origin = Integer.parseInt(x);
        visit = new boolean[x.length()];

        dfs(0, "");

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }

    private static void dfs(int depth, String num) {
        if (depth == x.length()) {
            int temp = Integer.parseInt(num);
            if (temp <= origin) {
                return;
            }

            ans = Math.min(ans, temp);
            return;
        }

        for (int i = 0; i < x.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, num + x.charAt(i));
                visit[i] = false;
            }
        }
    }
}
