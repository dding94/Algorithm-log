package 백준.PS12월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS1211_9507 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        long[] d = new long[68];

        d[0] = 1;
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for (int i = 4; i < 68; i++) {
            d[i] = d[i - 1] + d[i - 2] + d[i - 3] + d[i - 4];
        }

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(d[n] + "\n");
        }

        System.out.println(sb);
    }

}
