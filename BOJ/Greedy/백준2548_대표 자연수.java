package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0529_2548 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] list = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        if (n % 2 == 0) {
            System.out.println(list[n / 2 - 1]);
        } else {
            System.out.println(list[n / 2]);
        }

    }
}
