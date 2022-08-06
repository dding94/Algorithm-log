package 백준.PS8월;

import java.io.*;

public class PS0806_14916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i += 2) {
            for (int j = 0; j <= n; j += 5) {
                if (i + j == n) {
                    int sum = i / 2 + j / 5;
                    max = Math.min(max, sum);
                }
            }
        }

        System.out.println(max == Integer.MAX_VALUE ? -1 : max);
    }

}
