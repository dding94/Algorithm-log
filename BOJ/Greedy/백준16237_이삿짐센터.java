package 백준.PS11월;

import java.io.*;
import java.util.*;

public class PS1113_16237 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        int[] n = new int[5];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            n[i] = Integer.parseInt(st.nextToken());
        }

        while ((n[0] + n[1] + n[2] + n[3] + n[4]) != 0) {
            cnt++;
            int num = 5;
            for (int i = 4; i >= 0; i--) {
                while (n[i] != 0 && num > i) {
                    num -= i + 1;
                    n[i]--;
                }
            }
        }

        System.out.println(cnt);

    }

}
