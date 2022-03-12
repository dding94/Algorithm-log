package 백준.PS3월;

import java.io.*;
import java.util.*;

public class PS0312_1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] d = new int[n + 1][m + 1];


        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                d[i + 1][j + 1] = s.charAt(j) - '0';
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(d[i][j] == 1){
                    d[i][j] = Math.min(d[i - 1][j], Math.min(d[i - 1][j - 1], d[i][j - 1])) + 1;
                    if (ans < d[i][j]) {
                        ans = d[i][j];
                    }
                }
            }
        }

        System.out.println(ans * ans);

    }
}
