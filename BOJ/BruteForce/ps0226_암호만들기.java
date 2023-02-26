package 에프랩스터디.이코테;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ps0226_암호만들기 {

    static int n, m;
    static String[] words;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        words = new String[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            words[i] = st.nextToken();
        }
        Arrays.sort(words);

        dfs(0, "");

        System.out.println(sb);
    }

    private static void dfs(int depth, String password) {
        if (password.length() == n) {
            if (check(password)) {
                sb.append(password).append('\n');
                return;
            }
        }

        if (depth >= m) {
            return;
        }

        dfs(depth + 1, password + words[depth]);
        dfs(depth + 1, password);
    }

    public static boolean check(String password) {
        int ja = 0;
        int mo = 0;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        return ja >= 2 && mo >= 1;
    }
}
