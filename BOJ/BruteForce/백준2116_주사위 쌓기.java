package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0513_2116 {
    static int[] opposite = new int[]{5, 3, 4, 1, 2, 0};
    static int[][] dice;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dice = new int[n][6];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < 6; i++) {
            maxResult(0, dice[0][i], 0, n);
            ans = Math.max(ans, max);
        }

        System.out.println(ans);
    }

    private static void maxResult(int depth, int bottom, int sum, int n) {
        if (depth == n) {
            max = Math.max(max, sum);
            return;
        }

        //현재 바닥의 위치
        int nowBottomIdx = 0;
        for (int i = 0; i < 6; i++) {
            if (dice[depth][i] == bottom) {
                nowBottomIdx = i;
                break;
            }
        }

        //현재 상단의 위치, 다음 주사위의 바닥
        int nowTopIdx = opposite[nowBottomIdx];

        int side = 0;
        for (int i = 0; i < 6; i++) {
            if (i != nowBottomIdx && i != nowTopIdx) {
                side = Math.max(side, dice[depth][i]);
            }
        }

        maxResult(depth + 1, dice[depth][nowTopIdx], sum + side, n);
    }
}
