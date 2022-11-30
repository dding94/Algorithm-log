package 백준.PS11월;

import java.io.*;
import java.util.StringTokenizer;

public class PS1130_19939 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= m; i++) {
            n -= i;
            if (n < 0) {
                break;
            }
        }

        if (n >= 0) {
            sb.append(n % m > 0 ? m : m - 1);
        } else {
            sb.append(-1);
        }

        System.out.println(sb);
    }

}
