package 백준23.PS4월;

import java.io.*;
import java.util.*;

public class PS0410_N과M9 {

    static int n, m;
    static int[] numbers, answer;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    static Set<String> hs = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        answer = new int[m];
        visit = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        dfs(0);

        for (String h : hs) {
            sb.append(h).append("\n");
        }

        System.out.println(sb);

    }

    private static void dfs(int depth) {
        if (depth == m) {
            for (int num : answer) {
                sb.append(num).append(" ");
            }
            hs.add(sb.toString());
            sb.setLength(0);
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
