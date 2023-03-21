package 백준23.PS3월;

import java.io.*;
import java.util.*;

public class PS0321_소수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int num = a % b;

        for (int i = 0; i < n - 1; i++) {
            num *= 10;
            num %= b;
        }

        num *= 10;
        System.out.print(num / b);
    }
}
