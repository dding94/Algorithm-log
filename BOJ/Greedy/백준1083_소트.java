package 백준.PS10월;

import java.io.*;
import java.util.*;

public class PS1024_1083 {

    static int list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        list = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());

        for (int i = 0; i < n && 0 < s; i++) {
            int max = -1, p = -1;

            for (int j = i; j < n && j <= i + s; j++) {
                if (max < list[j]) {
                    max = list[j];
                    p = j;
                }
            }

            for (int j = p; j > i; j--) {
                swap(j - 1, j);
                s--;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i : list) {
            sb.append(i + " ");
        }

        System.out.println(sb);
    }

    private static void swap(int p, int i) {
        int temp = list[p];
        list[p] = list[i];
        list[i] = temp;
    }

}
