package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0521_2660 {
    static final int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] friend = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    friend[i][j] = INF;
                }
            }
        }

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == -1 && y == -1) {
                break;
            }

            friend[x][y] = friend[y][x] = 1; // 친구 관계는 양방향
        }

        // 플로이드 와샬 알고리즘 수행
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    friend[i][j] = Math.min(friend[i][j], friend[i][k] + friend[k][j]);
                }
            }
        }

        int[] friendScore = new int[n + 1];
        int ansScore = INF;

        for (int i = 1; i <= n; i++) {
            int maxScore = 0;
            for (int j = 1; j <= n; j++) {
                if (maxScore != INF) {
                    maxScore = Math.max(maxScore, friend[i][j]);
                }
            }
            friendScore[i] = maxScore;
            ansScore = Math.min(ansScore, friendScore[i]);
        }

        int ansCount = 0;

        StringBuilder firstLine = new StringBuilder();
        StringBuilder secondLine = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (ansScore == friendScore[i]) {
                ansCount++;
                secondLine.append(i + " ");
            }
        }

        firstLine.append(ansScore + " " + ansCount);

        System.out.println(firstLine);
        System.out.println(secondLine);

    }
}
