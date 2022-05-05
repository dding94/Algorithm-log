package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0505_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> answer = new ArrayList<>();
        int[] people = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < n; i++) {
            answer.add(people[n - i - 1], n - i);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : answer) {
            sb.append(i + " ");
        }

        System.out.println(sb);
    }
}
