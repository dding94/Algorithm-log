package 백준.PS6월;

import java.io.*;

public class PS0629_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] d = new int[41];

        d[0] = 1;
        d[1] = 1;
        d[2] = 2;
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }

        int ans = 1;

        int beforeSeat = 0;
        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(br.readLine());
            ans *= d[temp - beforeSeat - 1];
            beforeSeat = temp;
        }
        ans *= d[n - beforeSeat];

        System.out.println(ans);
    }
}
