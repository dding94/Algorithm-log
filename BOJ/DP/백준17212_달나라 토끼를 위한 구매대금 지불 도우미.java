//달나라 토끼를 위한 구매대금 지불 도우미
package 백준.PS2월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS0227_17212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] money = {1, 2, 5, 7};
        int[] d = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            d[i] = i;
        }

        for (int i = 0; i < money.length; i++) {
            for (int j = money[i]; j <= n; j++) {
                d[j] = Math.min(d[j], d[j - money[i]] + 1);
            }
        }

        System.out.println(d[n]);
    }
}
