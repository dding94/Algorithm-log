package 백준.PS10월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS1012_11561 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());

            long left = 0;
            long right = (long) Math.sqrt(2 * n - 1);

            while (left <= right) {
                long mid = (left + right) / 2;
                long sum = (mid * (mid + 1)) / 2;

                if (sum <= n) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            System.out.println(right);
        }
    }

}
