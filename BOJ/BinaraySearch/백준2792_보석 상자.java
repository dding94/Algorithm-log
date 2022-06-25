//보석 상자
package 백준.PS6월;

import java.io.*;
import java.util.*;

public class PS0625_2792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] gem = new int[m];

        int left = 1;
        int right = 0;
        for (int i = 0; i < m; i++) {
            gem[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, gem[i]);
        }


        int ans = 0;
        while (left <= right) {
            int student = 0;
            int mid = (left + right) / 2;

            for (int i = 0; i < m; i++) {
                student += gem[i] / mid;
                if (gem[i] % mid != 0) {
                    student += 1;
                }
            }

            if (student > n) {
                left = mid + 1;
            }else {
                right = mid - 1;
                ans = mid;
            }
        }

        System.out.println(ans);

    }
}
