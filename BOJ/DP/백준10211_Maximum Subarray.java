package 백준.PS7월;

import java.io.*;
import java.util.StringTokenizer;

public class PS0705_10211 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] testCase = new int[n];
            int[] d = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                testCase[i] = Integer.parseInt(st.nextToken());
            }
            d[0] = testCase[0];
            int max = d[0];

            for (int i = 1; i < n; i++) {
                d[i] = d[i - 1] + testCase[i];
                if (testCase[i] > d[i - 1] + testCase[i]) {
                    d[i] = testCase[i];
                }

                max = Math.max(max, d[i]);
            }


            sb.append(max + "\n");
        }

        System.out.println(sb);
    }
}
