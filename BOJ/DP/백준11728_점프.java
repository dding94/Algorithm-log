//배열 합치기
package 백준.PS2월;

import java.io.*;
import java.util.*;

public class PS0210_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];
        int[] ans = new int[n + m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int aPos = 0;
        int bPos = 0;
        int ansPos = 0;

        while (aPos < a.length && bPos < b.length) {
            if (a[aPos] > b[bPos]) {
                ans[ansPos++] = b[bPos++];
            }else{
                ans[ansPos++] = a[aPos++];
            }
        }

        while (aPos < a.length) {
            ans[ansPos++] = a[aPos++];
        }
        while (bPos < b.length) {
            ans[ansPos++] = b[bPos++];
        }

        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
           sb.append(i + " ");
        }

        System.out.println(sb);
    }
}
