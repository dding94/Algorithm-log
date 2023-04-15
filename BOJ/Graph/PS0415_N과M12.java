package 백준23.PS4월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class PS0415_N과M12 {

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
        visit = new boolean[n];
        answer = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        dfs(0, 0);

        for (String h : hs) {
            sb.append(h).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int depth, int start) {
        if (depth == m) {
            for (int num : answer) {
                sb.append(num).append(" ");
            }
            hs.add(sb.toString());
            sb.setLength(0);
            return;
        }

        for (int i = start; i < n; i++) {
            answer[depth] = numbers[i];
            dfs(depth + 1, i);
        }
    }
}
