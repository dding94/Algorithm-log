package 백준.PS3월;

import java.io.*;
import java.util.*;

public class PS0308_4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long l = Integer.parseInt(st.nextToken());
            long p = Integer.parseInt(st.nextToken());
            long v = Integer.parseInt(st.nextToken());

            if (l == 0 && p == 0 && v == 0) {
                System.out.println(sb);
                break;
            }

            long camp = (v % p) <= l ? (v % p) : l;

            sb.append("Case " + i + ": " + ((v / p) * l + camp) + "\n");
            i++;
        }
    }
}
