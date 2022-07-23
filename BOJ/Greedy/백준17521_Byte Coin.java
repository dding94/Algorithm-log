package 백준.PS7월;

import java.util.*;
import java.io.*;

public class PS0707_17521 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long ans = Integer.parseInt(st.nextToken());
        long coin = 0;
        int[] chart = new int[n];

        for(int i=0; i<n; i++) {
            chart[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<n-1; i++) {
            if (chart[i] < chart[i + 1]) {//다음날 오름
                if (ans >= chart[i]) {
                    coin += ans / chart[i];
                    ans %= chart[i];
                }
            } else if (chart[i] > chart[i + 1]) {
                ans += coin * chart[i];
                coin = 0;
            }
        }
        ans += coin * chart[n - 1];
        System.out.println(ans);
    }
}
