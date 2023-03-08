package 백준23.PS3월;

import java.io.*;
import java.util.StringTokenizer;

public class PS0308_연속합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] d = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        d[0] = a[0];
        int max = a[0];

        for (int i = 1; i < n; i++) {
            d[i] = Math.max(d[i - 1] + a[i], a[i]);
            max = Math.max(max, d[i]);
        }

        System.out.println(max);
    }

}
