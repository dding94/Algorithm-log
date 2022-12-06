package 백준.PS12월;

import java.io.*;

public class PS1206_15989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int[][] d = new int[10001][4];

        d[1][1] = 1; // 1
        d[2][1] = 1; // 1+1
        d[2][2] = 1; // 2
        d[3][1] = 1; // 1+1+1
        d[3][2] = 1; // 1+2
        d[3][3] = 1; // 3

        for (int i = 4; i <= 10000; i++) {
            d[i][1] = d[i - 1][1];
            d[i][2] = d[i - 2][1] + d[i - 2][2];
            d[i][3] = d[i - 3][1] + d[i - 3][2] + d[i - 3][3];
        }

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            sb.append(d[n][1] + d[n][2] + d[n][3] + "\n");
        }

        System.out.println(sb);
    }

}
