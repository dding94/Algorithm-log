package 백준.PS11월;

import java.io.*;
import java.util.StringTokenizer;

public class PS1121_15810 {

    static int[] balloon;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        balloon = new int[n];

        st = new StringTokenizer(br.readLine());
        long max = 0;
        for (int i = 0; i < n; i++) {
            balloon[i] = Integer.parseInt(st.nextToken());
            max = Math.max(balloon[i], max);
        }

        long left = 0;
        long right = max * m;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (makeBalloon(mid) < m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

    private static long makeBalloon(long mid) {
        long count = 0;

        for (int i = 0; i < balloon.length; i++) {
            count += (mid / balloon[i]);
        }

        return count;
    }

}
