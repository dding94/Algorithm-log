package 백준.PS10월;

import java.io.*;

public class PS1007_2018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 1;
        int sum = 1;
        int ans = 0;

        while (left <= right) {
            if (sum == n) {
                ans++;
            }
            if (sum < n) {
                right++;
                sum += right;
            } else if (sum >= n) {
                sum -= left;
                left++;
            }
        }

        System.out.println(ans);
    }

}
