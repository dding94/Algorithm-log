package 에프랩스터디.이코테;

import java.util.*;
import java.io.*;

public class ps0203_연산자끼워넣기2 {


    static int a[];
    static int n;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int mul = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());

        dfs(1, a[0], plus, minus, mul, div);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int index, int cal, int plus, int minus, int mul, int div) {
        if (index == n) {
            if (max < cal) {
                max = cal;
            }
            if (min > cal) {
                min = cal;
            }
            return;
        }

        if (plus != 0) {
            dfs(index + 1, cal + a[index], plus - 1, minus, mul, div);
        }
        if (minus != 0) {
            dfs(index + 1, cal - a[index], plus, minus - 1, mul, div);
        }
        if (mul != 0) {
            dfs(index + 1, cal * a[index], plus, minus, mul - 1, div);
        }
        if (div != 0) {
            dfs(index + 1, cal / a[index], plus, minus, mul, div - 1);
        }
    }

}
