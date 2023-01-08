package 백준23.PS1월;

import java.io.*;

public class PS0108_점화식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] d = new long[36];

        d[0] = 1;
        d[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                d[i] += d[j] * d[i - 1 - j];
            }
        }

        System.out.println(d[n]);
    }
}
