package 백준.PS11월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PS1127_11441 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] sum = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            sb.append(sum[j] - sum[i - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
