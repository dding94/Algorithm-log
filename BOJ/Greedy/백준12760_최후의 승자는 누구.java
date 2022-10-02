package 백준.PS9월;

import java.io.*;
import java.util.*;

public class PS0927_12760 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[] max = new int[m];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.sort(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max[j] = Math.max(max[j], arr[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (max[j] == arr[i][j]) {
                    count[i]++;
                }
            }
        }

        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            maxCount = Math.max(maxCount, count[i]);
        }

        for (int i = 0; i < n; i++) {
            if (maxCount == count[i]) {
                sb.append((i + 1) + " ");
            }
        }
        System.out.println(sb);
    }
}
