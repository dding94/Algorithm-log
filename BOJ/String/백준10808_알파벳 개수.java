//알파벳 개수
package 백준.PS4월;

import java.io.*;

public class PS0409_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int[] alpha = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : alpha) {
            sb.append(i + " ");
        }

        System.out.println(sb);
    }
}
