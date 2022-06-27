package 백준.PS6월;

import java.io.*;
import java.util.StringTokenizer;

public class PS0627_13702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] makgeolli = new int[n];
        long right = 0;
        for (int i = 0; i < n; i++) {
            makgeolli[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, makgeolli[i]);
        }

        long left = 1;

        while (left <= right) {
            long mid = (left + right) / 2;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                sum += makgeolli[i] / mid;
            }

            if (sum >= k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);

    }
}
