package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0522_17085 {
    static int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dfs(0, 0);

        Collections.sort(list);

        System.out.println(n > list.size() ? -1 : list.get(n - 1));
    }

    static void dfs(int depth, long sum) {
        if (!list.contains(sum)) {
            list.add(sum);
        }

        if (depth >= 10) {
            return;
        }

        dfs(depth + 1, sum * 10 + num[depth]);
        dfs(depth + 1, sum);
    }
}
