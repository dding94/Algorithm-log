package 백준.PS12월;

import java.io.*;
import java.util.*;

public class PS1207_20044 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n * 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n * 2; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(score);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, score[i] + score[n * 2 - 1 - i]);
        }

        System.out.println(min);
    }

}
