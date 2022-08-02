package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0802_9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()); //동전의 종류 개수
            int[] coin = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            int[] d = new int[m + 1];
            d[0] = 1;

            for (int i = 0; i < n; i++) {
                for (int j = coin[i]; j <= m; j++) {
                    d[j] += d[j - coin[i]];
                }
            }

            sb.append(d[m] + "\n");
        }

        System.out.println(sb);
    }
}
