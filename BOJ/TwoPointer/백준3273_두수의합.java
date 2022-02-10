//두수의 합
package 백준.PS2월;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PS0210_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int x = Integer.parseInt(br.readLine());

        int start = 0;
        int end = n - 1;
        int ans = 0;
        while (start < end) {
            int sum = a[start] + a[end];

            if (sum == x) {
                ans++;
            }

            if (sum <= x) {
                start++;
            }else{
                end--;
            }
        }

        System.out.println(ans);
    }
}
