package 백준.PS10월;

import java.io.*;
import java.util.*;

public class PS1026_20115 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] drink = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            drink[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(drink);

        double max = drink[n - 1];

        for (int i = 0; i < n - 1; i++) {
            max += ((double) drink[i] / 2);
        }

        System.out.println(max);

    }
}
