//주사위
package 백준.PS4월;

import java.io.*;
import java.util.*;

public class PS0430_1041 {
    static long n;
    static long one, two, three;
    static int[] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dice = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        long minAF = Math.min(dice[0], dice[5]);
        long minBE = Math.min(dice[1], dice[4]);
        long minCD = Math.min(dice[2], dice[3]);

        one = Math.min(minAF, Math.min(minBE, minCD));
        two = Math.min(minAF + minBE, Math.min(minAF + minCD, minBE + minCD));
        three = minAF + minBE + minCD;

        System.out.println(findAnswer());
    }

    static long findAnswer() {
        long sum = 0;

        if (n == 1) {
            long max = Integer.MIN_VALUE;
            for (int i = 0; i < 6; i++) {
                max = Math.max(max, dice[i]);
                sum += dice[i];
            }
            return sum - max;
        }

        long onePlane = 4 * (n - 1) * (n - 2) + (n - 2) * (n - 2);
        long secondPlane = 4 * (n - 1) + 4 * (n - 2);
        long thirdPlane = 4;

        return (one * onePlane) + (two * secondPlane) + (three * thirdPlane);
    }
}
