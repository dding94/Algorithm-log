package 백준.PS8월;

import java.io.*;
import java.util.StringTokenizer;

public class PS0831_19949 {

    static int n = 10;
    static int ans = 0;
    static int[] answer = new int[n];
    static int[] quiz = new int[n];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            quiz[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(ans);

    }

    static void dfs(int depth) {
        if (depth == n) {
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (answer[i] == quiz[i]) {
                    count++;
                }

                if (count >= 5) {
                    ans++;
                    return;
                }
            }

            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (depth >= 2) {
                if (answer[depth - 1] == i && answer[depth - 2] == i) {
                    continue;
                }
            }
            answer[depth] = i;
            dfs(depth + 1);
        }
    }

}
