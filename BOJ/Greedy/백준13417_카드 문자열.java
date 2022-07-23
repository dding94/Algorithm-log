//백준 13417
package 백준.PS6월;

import java.io.*;
import java.util.*;

public class PS0630_13417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Deque<String> dq = new ArrayDeque<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            dq.addFirst(st.nextToken());

            for (int i = 1; i < n; i++) {
                String s = st.nextToken();
                if (dq.getFirst().compareTo(s) < 0) {
                    dq.addLast(s);
                }else {
                    dq.addFirst(s);
                }
            }

            for (String s : dq) {
                sb.append(s);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
