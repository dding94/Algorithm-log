package 백준.PS6월;

import java.io.*;
import java.util.*;

public class PS0609_2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rank);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(rank[i] - (i + 1));
        }

        System.out.println(ans);
    }
}
