package 백준.PS9월;

import java.io.*;
import java.util.StringTokenizer;

public class PS0924_1940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] armor = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            armor[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int i = 0; i < armor.length - 1; i++) {
            for (int j = i + 1; j < armor.length; j++) {
                if (armor[i] + armor[j] == m) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }

}
