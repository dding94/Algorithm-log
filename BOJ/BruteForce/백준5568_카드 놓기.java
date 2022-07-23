package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0704_5568 {

    static int[] card;
    static boolean[] visit;
    static int n, k;
    static Set<Integer> ansList = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        card = new int[n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(br.readLine());
        }


        dfs(0, "");

        System.out.println(ansList.size());
    }

    private static void dfs(int depth, String num) {
        if (depth == k) {
            ansList.add(Integer.parseInt(num));
            return;
        }


        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, num + card[i]);
                visit[i] = false;
            }
        }
    }
}
