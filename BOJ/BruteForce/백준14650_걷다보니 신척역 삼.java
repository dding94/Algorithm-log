package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0814_14650 {

    static int n;
    static Set<Integer> hs = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        solve(0, "");

        int count = 0;
        for (Integer h : hs) {
            if (h % 3 == 0) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static void solve(int depth, String s) {
        if (depth == n) {
            if (s.charAt(0) != '0') {
                hs.add(Integer.valueOf(s));
                return;
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            solve(depth + 1, s + i);
        }
    }
}
