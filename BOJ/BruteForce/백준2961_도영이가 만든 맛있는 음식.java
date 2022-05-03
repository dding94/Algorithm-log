package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0503_2961 {
    static int n;
    static long min = Long.MAX_VALUE;
    static int[] s;
    static int[] b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //개수
        s = new int[n]; //신맛
        b = new int[n]; //쓴맛

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i] =Integer.parseInt(st.nextToken());
            b[i] =Integer.parseInt(st.nextToken());
        }

        findAnswer(0, 1, 0, 0);

        System.out.println(min);
    }

    static void findAnswer(int depth, long sinMat, long ssonMAt, int count) {
        if (depth == n) {
            if (count != 0) {
                min = Math.min(min, Math.abs(sinMat - ssonMAt));
                return;
            }
        }

        if (depth >= n) {
            return;
        }

        findAnswer(depth + 1, sinMat * s[depth], ssonMAt + b[depth], count + 1);
        findAnswer(depth + 1, sinMat, ssonMAt, count);
    }
}
