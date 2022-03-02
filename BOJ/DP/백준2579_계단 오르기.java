package 백준.PS3월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS0302_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] floor = new int[n+1];
        int[] d = new int[n+1];

        for (int i = 1; i <= n; i++) {
            floor[i] = Integer.parseInt(br.readLine());
        }

        d[1] = floor[1];
        if (n >= 2) {
            d[2] = floor[2] + floor[1];
        }

        for (int i = 3; i <= n; i++) {
            d[i] = Math.max(d[i - 3] + floor[i - 1], d[i - 2]) + floor[i];
        }

        System.out.println(d[n]);
    }
}
