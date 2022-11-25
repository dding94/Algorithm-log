package 백준.PS11월;

import java.io.*;

public class PS1125_9324 {

    static int[] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String s = br.readLine();
            StringBuilder temp = new StringBuilder();
            alpha = new int[26];

            for (int i = 0; i < s.length(); i++) {
                alpha[s.charAt(i) - 65]++;
                temp.append(s.charAt(i));
                if (alpha[s.charAt(i) - 65] == 3) {
                    temp.append(s.charAt(i));
                    alpha[s.charAt(i) - 65] = 0;
                    i++;
                }
            }

            sb.append(s.equals(temp.toString()) ? "OK" : "FAKE").append("\n");

        }

        System.out.println(sb);
    }

}
