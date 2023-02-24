package 에프랩스터디.이코테;


import java.io.*;

public class ps0224_설탕배달 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] d = new int[5001];

        for (int i = 0; i <= n; i++) {
            d[i] = 9999;
        }

        d[3] = 1;
        d[5] = 1;

        for (int i = 6; i <= n; i++) {
            d[i] = Math.min(d[i - 3] + d[i - 5], Math.min(d[i - 3], d[i - 5])) + 1;
        }

        if (d[n] >= 9999) {
            d[n] = -1;
        }
        System.out.println(d[n]);
    }

}
