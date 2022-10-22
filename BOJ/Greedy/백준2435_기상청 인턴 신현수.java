package 백준.PS10월;

import java.io.*;
import java.util.*;

public class PS1022_2435 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] temperature = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            temperature[i] = Integer.parseInt(st.nextToken()); // 온도 입력 받아 저장
        }

        int max = 0;

        for (int i = 0; i < k; i++) {
            max = max + temperature[i];
        }

        int temp = max;

        for (int i = k; i < n; i++) {
            temp = temp - temperature[i - k] + temperature[i];
            max = Math.max(max, temp); // 더 큰 수를 저장
        }

        System.out.println(max);
    }
}
