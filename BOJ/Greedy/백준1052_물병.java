package 백준.PS6월;

import java.io.*;
import java.util.StringTokenizer;

public class Ps0620_1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int ans = 0;

        while (true) {
            int count = 0;
            int num = n;
            while (num != 0) {
                if (num % 2 == 1) {
                    count += 1;
                }
                num = num / 2;
            }

            if (count <= k) {
                break;
            }
            ans += 1;
            n += 1;

        }
        System.out.println(ans);
    }
}
