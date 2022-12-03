package 백준.PS12월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS1203_2775 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[][] d = new int[15][15];

        for (int i = 0; i < 15; i++) {
            d[i][1] = 1; // i층 1호
            d[0][i] = i; // 0층 i호
        }

        for (int i = 1; i < 15; i++) { // 1층부터 14층까지
            for (int j = 2; j < 15; j++) { // 2호부터 14호까지
                d[i][j] = d[i][j - 1] + d[i - 1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(d[k][n] + "\n");
        }

        System.out.println(sb);
    }

}
