package 백준.PS5월;

import java.io.*;

public class PS0530_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int[] alpha = new int[26];

        for (char c : s.toCharArray()) {
            alpha[c - 'A']++;
        }

        int odd = 0;
        int mid = 0;

        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 == 1) {
                mid = i;
                odd++;
            }
        }

        StringBuilder sb = new StringBuilder();
        if ((s.length() % 2 != 0 && odd > 1) || (s.length() % 2 == 0 && odd > 0)) {
            System.out.println("I'm Sorry Hansoo");
        }else{
            String ans = "";
            for (int i = 0; i < alpha.length; i++) {
                for (int j = 0; j < alpha[i] / 2; j++) {
                    ans += ((char) (i + 'A'));
                }
            }
            String rev = reverseString(ans);
            if (odd == 1) {
                ans += ((char) (mid + 'A'));
            }
            System.out.print(ans + rev);

        }
    }

    public static String reverseString(String s) {
        return (new StringBuffer(s)).reverse().toString();
    }
}
