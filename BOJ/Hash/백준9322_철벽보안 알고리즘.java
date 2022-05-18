//철벽보안 알고리즘
package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0518_9322 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<Integer, Integer> hm = new HashMap<>();
            String[] s1 = new String[n];
            String[] s2 = new String[n];
            String[] pass = new String[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                s1[i] = st.nextToken();
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                s2[i] = st.nextToken();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                pass[i] = st.nextToken();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (s1[i].equals(s2[j])) {
                        hm.put(i, j);
                    }
                }
            }
            for (Integer i : hm.values()) {
                sb.append(pass[i] + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
