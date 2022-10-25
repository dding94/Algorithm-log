package 백준.PS10월;

import java.io.*;
import java.util.*;

public class PS1025_20300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] power = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            power[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(power);
        long ans = 0;

        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                ans = Math.max(power[i] + power[n - 1 - i], ans);
            }
        } else {
            ans = power[n - 1];
            for (int i = 0; i < n / 2; i++) {
                ans = Math.max(power[i] + power[n - 2 - i], ans);
            }
        }

        System.out.println(ans);
    }
}
