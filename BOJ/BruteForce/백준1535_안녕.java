//안녕
package 백준.PS4월;

import java.io.*;
import java.util.*;

public class PS0418_1535 {

    static int n;
    static int[] l, j;
    static int heart = 100, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        l = new int[n]; //체력
        j = new int[n]; //기쁨

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            l[i] = Integer.parseInt(st.nextToken());
            j[i] = Integer.parseInt(st2.nextToken());
        }

        max = 0;
        dfs(0, heart, 0);

        System.out.println(max);
    }


    static void dfs(int depth, int nowHeart, int nowHappy) {
        if (nowHeart <= 0) {
            return;
        }
        if (depth == n) {
            if (max < nowHappy) {
                max = nowHappy;
            }
            return;
        }

        dfs(depth + 1, nowHeart, nowHappy);
        dfs(depth + 1, nowHeart - l[depth], nowHappy + j[depth]);
    }
}
