package 백준.PS11월;

import java.io.*;
import java.util.StringTokenizer;

public class PS1122_16564 {

    static int[] unit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        unit = new int[n];

        for (int i = 0; i < n; i++) {
            unit[i] = Integer.parseInt(br.readLine());
        }

        int left = 0;
        int right = 1000000001;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (level(mid) > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        System.out.println(right);

    }

    private static long level(int mid) {
         long count = 0;

         for (int i = 0; i < unit.length; i++) {
            if (mid >= unit[i]) {
                count += (mid - unit[i]);
            }
        }

         return count;
    }

}
