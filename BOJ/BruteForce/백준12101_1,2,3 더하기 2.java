package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0805_12101 {

    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        solve(0, "", n);

        Collections.sort(list);

        if (list.size() < k) {
            System.out.println(-1);
            return;
        }

        String substring = list.get(k - 1).substring(0, list.get(k - 1).length() - 1);

        System.out.println(substring);
    }

    private static void solve(int sum, String s, int n) {
        if (sum == n) {
            list.add(s);
            return;
        }

        if (sum > n) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            solve(sum + i, s + i + "+" ,n);
        }
    }

}
