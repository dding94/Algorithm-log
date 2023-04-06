package 백준23.PS4월;

import java.io.*;
import java.util.*;

public class PS0406_N과M5 {

    static int n, m;
    static int[] numbers;
    static int[] answer;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        visit = new boolean[n];
        answer = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        dfs(0);

        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            for (int num : answer) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                answer[depth] = numbers[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
