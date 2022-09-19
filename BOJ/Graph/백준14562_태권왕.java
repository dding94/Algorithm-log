package 백준.PS9월;

import java.util.Scanner;

public class ds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            t[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int min = dfs(s[i], t[i], 0);
            System.out.println(min);
        }
    }

    public static int dfs(int s, int t, int count) {
        if (s > t) {
            return 100;
        }
        if (s == t) {
            return count;
        } else {
            int min1 = dfs(s * 2, t + 3, count + 1);
            int min2 = dfs(s + 1, t, count + 1);
            return Math.min(min1, min2);
        }
    }
}
