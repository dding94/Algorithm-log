package 백준.PS8월;

import java.io.*;
import java.util.*;


public class PS0827_22233 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), true);
        }

        int cnt = n;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), ",");

            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                if (map.containsKey(s)) {
                    map.remove(s);
                    cnt--;
                }
            }
            sb.append(cnt + "\n");
        }

        System.out.println(sb);
    }
}
