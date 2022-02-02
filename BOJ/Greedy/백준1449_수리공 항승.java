//백준 1449 수리공 항승

import java.io.*;
import java.util.*;

public class PS0202_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int cnt = 0;
        int last = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] - last == l) {
                cnt++;
                last = a[i];

            } else if (a[i] - last > l - 1) {
                cnt++;
                last = a[i];
            }

        }

        System.out.println(cnt+1);
    }
}
