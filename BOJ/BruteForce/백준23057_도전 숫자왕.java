package 백준.PS9월;

import java.io.*;
import java.util.*;

public class PS0903_23057 {

    static int n;
    static int[] card;
    static Set<Integer> hs = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        card = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            sum += card[i];
        }

        dfs(0, 0);

        System.out.println(sum - hs.size() + 1);
    }

    private static void dfs(int depth, int sum) {
        if (depth == n) {
            hs.add(sum);
            return;
        }

        dfs(depth + 1, sum + card[depth]);
        dfs(depth + 1, sum);
    }

}
