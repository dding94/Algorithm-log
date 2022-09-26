package 백준.PS9월;

import java.io.*;
import java.util.*;

public class PS0926_22864 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count = 0;
        int p = 0;
        int answer = 0;

        while (count != 24) {
            if (p + a <= m) {
                answer += b;
                p += a;
            } else {
                p = p - c < 0 ? 0 : p - c;
            }
            count++;
        }
        System.out.print(answer);
    }

}
