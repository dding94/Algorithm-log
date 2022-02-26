//동전 2
package 백준.PS2월;

import java.io.*;
import java.util.*;

public class PS0226_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        int[] money = new int[n];
        int[] d = new int[k + 1];

        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(d, 10001);

        d[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = money[i]; j <= k; j++) {
                d[j] = Math.min(d[j], d[j - money[i]] + 1);
            }
        }

        System.out.println(d[k] == 10001 ? -1 : d[k]);

    }
}
