//내려가기
package 백준.PS3월;

import java.io.*;
import java.util.*;

public class PS0301_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n + 1][3];
        int[][] maxD = new int[n + 1][3];
        int[][] minD = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            maxD[i][0] = Math.max(maxD[i - 1][0], maxD[i - 1][1]) + map[i][0];
            maxD[i][1] = Math.max(maxD[i - 1][0], Math.max(maxD[i - 1][1], maxD[i - 1][2])) +  map[i][1];
            maxD[i][2] = Math.max(maxD[i - 1][2], maxD[i - 1][1]) + map[i][2];

            minD[i][0] = Math.min(minD[i - 1][0], minD[i - 1][1]) + map[i][0];
            minD[i][1] = Math.min(minD[i - 1][0], Math.min(minD[i - 1][1], minD[i - 1][2])) +  map[i][1];
            minD[i][2] = Math.min(minD[i - 1][2], minD[i - 1][1]) + map[i][2];
        }

        int maxAns = 0;
        int minAns = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (maxAns < maxD[n][i]) {
                maxAns = maxD[n][i];
            }

            if (minAns > minD[n][i]) {
                minAns = minD[n][i];
            }
        }

        System.out.print(maxAns + " " + minAns);
    }
}
