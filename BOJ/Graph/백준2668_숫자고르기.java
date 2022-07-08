package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0708_2668 {
    static List<Integer> list;
    static int[] num;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        num = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            visit[i] = true;
            dfs(i, i);
            visit[i] = false;
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();

        sb.append(list.size() + "\n");

        for (Integer num : list) {
            sb.append(num + "\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int start, int target) {
        if (num[start] == target) {
            list.add(target);
            return;
        }

        if (!visit[num[start]]) {
            visit[num[start]] = true;
            dfs(num[start], target);
            visit[num[start]] = false;
        }
    }

}
