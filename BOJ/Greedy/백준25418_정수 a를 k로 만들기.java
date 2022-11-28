package 백준.PS11월;

import java.io.*;
import java.util.StringTokenizer;

public class PS1128_25418 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while (a != k) {
            cnt++;
            if (k % 2 == 0 && k / 2 >= a) {
                k /= 2;
            } else {
                k--;
            }
        }

        System.out.println(cnt);

    }

}
