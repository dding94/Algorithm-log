package 백준.PS12월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS1216_2922 {

    static String s;
    static long ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        dfs(0, 0, 0, false, 1);
        System.out.println(ans);

    }

    static void dfs(int idx, int vowel, int consonant, boolean isExistL, long cnt) {
        if (vowel == 3 || consonant == 3) {
            return;
        }

        if (idx == s.length()) {
            if (!isExistL) {
                return;
            }
            ans += cnt;
            return;
        }

        if (s.charAt(idx) == '_') {
            dfs(idx + 1, vowel + 1, 0, isExistL, cnt * 5);
            dfs(idx + 1, 0, consonant + 1, true, cnt);
            dfs(idx + 1, 0, consonant + 1, isExistL, cnt * 20);
        } else if (isVowel(s.charAt(idx))) {
            dfs(idx + 1, vowel + 1, 0, isExistL, cnt);
        } else if (s.charAt(idx) == 'L') {
            dfs(idx + 1, 0, consonant + 1, true, cnt);
        } else {
            dfs(idx + 1, 0, consonant + 1, isExistL, cnt);
        }
    }

    static boolean isVowel(char c) {
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }

}
