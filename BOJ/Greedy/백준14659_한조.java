package 백준.PS12월;

import java.io.*;
import java.util.StringTokenizer;

public class PS1213_14659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arrow = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrow[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = i + 1; j < n; j++) {
                if (arrow[i] > arrow[j]) {
                    count++;
                } else {
                    break;
                }
            }
            ans = Math.max(ans, count);
        }
        System.out.println(ans);
    }

}
