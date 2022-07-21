package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0721_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int lan[] = new int[k];
        long left = 1;
        long right = -1;

        for (int i = 0; i < k; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, lan[i]);
        }

        while (left <= right) {
            long mid = (left + right) / 2;

            int lanCount = 0;
            for (int i = 0; i < k; i++) {
                lanCount += (lan[i] / mid);
            }

            if (lanCount >= n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
