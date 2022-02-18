//수찾기
package 백준.PS2월;

import java.io.*;
import java.util.*;

public class PS0218_1920 {
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int x : b) {
            sb.append(search(x, 0, a.length - 1) + "\n");
        }

        System.out.println(sb);
    }

    private static int search(int target, int start, int end) {
        if (start > end) {
            return 0;
        }

        int mid = (start + end) / 2;

        if (a[mid] == target) {
            return 1;
        } else if (a[mid] > target) {
            return search(target, start, mid -1);
        } else if (a[mid] < target) {
            return search(target, mid + 1, end);
        }

        return 0;
    }
}
