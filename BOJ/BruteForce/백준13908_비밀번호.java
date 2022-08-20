package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0820_13908 {

    static int n, m, answer;
    static boolean[] pass = new boolean[10];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;

        if (m != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                pass[Integer.parseInt(st.nextToken())] = true;
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int depth, int count) {
        if (depth == n) {
            if (count == m) {
                answer++;
                return;
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (pass[i]) {
                pass[i] = false;
                dfs(depth + 1, count + 1);
                pass[i] = true;
                continue;
            }
            dfs(depth + 1, count);
        }
    }
}
