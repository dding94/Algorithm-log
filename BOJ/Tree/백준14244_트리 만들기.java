package 백준.PS12월;

import java.io.*;
import java.util.StringTokenizer;

public class PS1204_14244 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m - 1; i++) {
            System.out.println(i + " " + (m - 1));
        }

        for (int i = m - 1; i < n - 1; i++) {
            System.out.println(i + " " + (i + 1));
        }

    }
}
