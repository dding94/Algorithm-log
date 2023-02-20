package 에프랩스터디.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ps0220_1로만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] d = new int[n + 1];
        d[1] = 0;

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;

            if (i % 2 == 0) {
                d[i] = Math.min(d[i], d[i / 2] + 1);
            }

            if (i % 3 == 0) {
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }
        }

        System.out.println(d[n]);
    }

}
