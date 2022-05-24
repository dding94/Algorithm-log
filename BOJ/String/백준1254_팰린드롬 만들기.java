package 백준.PS5월;

import java.io.*;

public class PS0524_1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(i))) {
                break;
            }
            cnt++;
        }

        System.out.println(s.length() + cnt);
    }

    private static boolean isPalindrome(String s) {
        int lastIndex = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            if (i == lastIndex) {
                break;
            }
            if (s.charAt(i) != s.charAt(lastIndex)) {
                return false;
            }
            lastIndex--;
        }
        return true;
    }
}
