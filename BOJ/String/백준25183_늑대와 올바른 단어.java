package 백준.PS11월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS1103_25183 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String regex = "(w+o+l+f+)+";
        int w = 0;
        int o = 0;
        int l = 0;
        int f = 0;
        boolean flag = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'w') {
                w++;
            }
            if (s.charAt(i) == 'o') {
                o++;
            }
            if (s.charAt(i) == 'l') {
                l++;
            }
            if (s.charAt(i) == 'f') {
                f++;
            }

            if (i < s.length() - 1 && s.charAt(i) == 'f' && s.charAt(i + 1) == 'w') {
                if (!isCount(w, o, l, f)) {
                    flag = true;
                    break;
                }
            }

        }
        if (!flag && s.matches(regex) && isCount(w, o, l, f)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }



    }

    private static boolean isCount(int w, int o, int l, int f) {
        return (w == o && o == l && l == f && f == w);
    }
}
