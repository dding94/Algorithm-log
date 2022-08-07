package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0807_14426 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        String[] S = new String[n];

        for (int i = 0; i < n; i++) {
            S[i] = br.readLine();
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();

            for (int j = 0; j < n; j++) {
                if (S[j].startsWith(s)) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);

    }

}
