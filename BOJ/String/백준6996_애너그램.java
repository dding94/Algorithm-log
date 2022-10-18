package 백준.PS10월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PS1018_6996 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");

            String a = split[0];
            String b = split[1];

            char[] aChar = a.toCharArray();
            char[] bChar = b.toCharArray();

            Arrays.sort(aChar);
            Arrays.sort(bChar);

            if (!Arrays.equals(aChar, bChar)) {
                sb.append(a + " & " + b + " are NOT anagrams." + "\n");
            } else {
                sb.append(a + " & " + b + " are anagrams." + "\n");
            }
        }

        System.out.println(sb);
    }

}
