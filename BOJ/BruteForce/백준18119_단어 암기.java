package 백준.PS10월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PS1008_18119 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = n;

        boolean[][] words = new boolean[n][26];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                words[i][c - 'a'] = true;
            }
        }

        boolean[] check = new boolean[n];
        Arrays.fill(check, true);

        int[] cnt = new int[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            char x = st.nextToken().charAt(0);

            if (o == 1) {
                for (int j = 0; j < n; j++) {
                    if (words[j][x - 'a']) {
                        cnt[j]++;
                        if (check[j]) {
                            ans--;
                            check[j] = false;
                        }
                    }
                }
            }else if (o == 2) {
                for (int j = 0; j < n; j++) {
                    if (!check[j] && words[j][x - 'a']) {
                        cnt[j]--;
                        if (cnt[j] == 0) {
                            check[j] = true;
                            ans++;
                        }
                    }
                }
            }
            sb.append(ans + "\n");
        }

        System.out.println(sb);
    }

}
