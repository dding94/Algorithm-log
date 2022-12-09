package 백준.PS12월;

import java.io.*;

public class PS1209_13301 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] d = new long[n + 1];

        d[0] = 4;
        d[1] = 6;

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }

        System.out.println(d[n - 1]);

    }

}
