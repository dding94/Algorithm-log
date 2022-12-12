package 백준.PS12월;

import java.io.*;
import java.util.StringTokenizer;

public class ps1212_14912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;

            while (num > 0) {
                if (num % 10 == m) {
                    answer++;
                }
                num /= 10;
            }
        }

        System.out.println(answer);
    }

}
