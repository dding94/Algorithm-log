package 백준.PS4월;

import java.io.*;

public class PS0414_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int[] dZero = new int[41];
        int[] dOne = new int[41];

        dZero[0] = 1; dZero[1] = 0;
        dOne[0] = 0; dOne[1] = 1;
        for (int i = 2; i <= 40; i++) {
            dZero[i] = dOne[i - 1];
            dOne[i] = dZero[i - 1] + dOne[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());


            sb.append(dZero[n] + " " + dOne[n] + "\n");
        }

        System.out.println(sb);
    }
}
