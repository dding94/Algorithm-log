//백준 패션왕 신해빈
package 백준.PS3월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PS0315_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hm = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String key = st.nextToken();

                if (hm.containsKey(key)) {
                    hm.put(key, hm.get(key) + 1);
                }else{
                    hm.put(key, 1);
                }
            }

            int ans = 1;
            for (Integer value : hm.values()) {
                ans *= (value + 1); // + 1은 안입는경우 생각
            }

            sb.append(ans - 1 + "\n"); // 전부 안입은 경우 -1 해줘야 함
        }
        System.out.println(sb);
    }
}
