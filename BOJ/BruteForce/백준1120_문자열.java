//문자열
package 백준.PS2월;

import java.io.*;
import java.util.*;

public class PS0216_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int ans = a.length();

        for (int i = 0; i <= b.length() - a.length(); i++) {
            int cnt = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(i + j)) {
                    cnt++;
                }
            }
            if (ans > cnt) {
                ans = cnt;
            }
        }
        System.out.println(ans);
    }
}
