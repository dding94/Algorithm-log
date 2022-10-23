package 백준.PS9월;

import java.io.*;
import java.util.*;

public class PS0914_1246 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] people = new int[m];

        for (int i = 0; i < m; i++) {
            people[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(people);

        int max = -1;
        int price = -1;

        for (int i = 0; i < m; i++) {
            int temp = people[i] * Math.min(n, m - i);

            if (max < temp) {
                max = temp;
                price = people[i];
            }
        }

        System.out.println(price + " " + max);
    }

}
