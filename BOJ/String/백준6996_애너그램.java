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

            char[] a = split[0].toCharArray();
            char[] b = split[1].toCharArray();

            if (a.length != b.length) {
                sb.append(String.valueOf(a) + " & " + String.valueOf(b) + "are NOT anagrams" + "\n");
                continue;
            }

            Arrays.sort(a);
            Arrays.sort(b);

            if (!String.valueOf(a).equals(String.valueOf(b))) {
                sb.append(String.valueOf(a) + " & " + String.valueOf(b) + "are NOT anagrams" + "\n");
            } else {
                sb.append(String.valueOf(a) + " & " + String.valueOf(b) + "are anagrams" + "\n");
            }
        }

        System.out.println(sb);
    }

}
