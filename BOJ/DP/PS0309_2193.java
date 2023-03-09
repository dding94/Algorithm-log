package 백준23.PS3월;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PS0309_2193 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] d = new long[n + 1];

        d[0] = 0;
        d[1] = 1;
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }

        System.out.println(d[n]);
    }
}
