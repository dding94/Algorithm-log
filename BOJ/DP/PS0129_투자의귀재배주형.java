package 백준23.PS1월;

import java.io.*;
import java.util.StringTokenizer;

public class PS0129_투자의귀재배주형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[] d = new int[y + 1];

        //초기값 설정
        d[0] = h;

        for (int i = 1; i <= y; i++) {
            d[i] = (int) (d[i - 1] * 1.05);
            if (i >= 3) {
                d[i] = (int) Math.max(d[i], d[i - 3] * 1.2);
            }

            if (i >= 5) {
                d[i] = (int) Math.max(d[i], d[i - 5] * 1.35);
            }
        }

        System.out.println(d[y]);

    }

}
