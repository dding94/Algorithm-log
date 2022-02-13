package 백준.PS2월;

import java.util.*;
import java.io.*;

public class PS0213_1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] d = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            d[i] = 1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
            if (ans < d[i]) {
                ans = d[i];
            }
        }

        System.out.println(ans);
    }
}
