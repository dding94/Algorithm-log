package 백준23.PS3월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PS0307_스티커 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;

            int[][] d = new int[2][n + 1];
            int[][] a = new int[2][n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                a[0][i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                a[1][i] = Integer.parseInt(st.nextToken());
            }

            d[0][1] = a[0][1];
            d[1][1] = a[1][1];

            for (int i = 2; i <= n; i++) {
                d[0][i] = Math.max(d[1][i - 1], d[1][i - 2]) + a[0][i];
                d[1][i] = Math.max(d[0][i - 1], d[0][i - 2]) + a[1][i];
            }

            sb.append(Math.max(d[0][n], d[1][n])).append("\n");
        }

        System.out.println(sb);
    }
}
