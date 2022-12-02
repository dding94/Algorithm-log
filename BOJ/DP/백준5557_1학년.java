package 백준.PS12월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PS1202_5557 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n + 1];
        long[][] d = new long[n + 1][21];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        d[1][a[1]]=1;

        for (int i = 2; i < n; i++) {
            for (int j = 0; j <= 20; j++) {
                if (d[i - 1][j] != 0) {
                    if (j + a[i] <= 20) {
                        d[i][j + a[i]] += d[i - 1][j];
                    }
                    if (j - a[i] >= 0) {
                        d[i][j - a[i]] += d[i - 1][j];
                    }
                }
            }
        }

        System.out.println(d[n - 1][a[n]]);
    }

}
