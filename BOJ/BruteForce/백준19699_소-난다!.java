package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0528_19699 {
    static int n, m;
    static HashSet<Integer> hs = new HashSet<>();
    static boolean check[];
    static int cowWeight[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cowWeight = new int[n];
        check = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cowWeight[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);

        ArrayList<Integer> list = new ArrayList<>(hs);
        Collections.sort(list);

        if (list.size() == 0) {
            System.out.println(-1);
        } else {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
        }
    }

    private static void dfs(int depth, int sum, int start) {
        if (depth == m) {
            if (isPrime(sum)) {
                hs.add(sum);
            }
            return;
        }

        for (int i = start; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(depth + 1, sum + cowWeight[i], i + 1);
                check[i] = false;
            }
        }
    }


    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
