package 에프랩스터디.이코테;

import java.io.*;
import java.util.*;

public class PS0213_수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {

            int left = 0;
            int right = a.length - 1;
            boolean flag = false;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (a[mid] == b[i]) {
                    flag = true;
                    break;
                } else if (a[mid] < b[i]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (flag) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }

        System.out.println(sb);
    }

}
