package 백준.PS11월;

import java.io.*;

public class PS1111_13413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            String a = br.readLine();
            String b = br.readLine();

            int wCount = 0;
            int bCount = 0;

            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (a.charAt(i) == 'W') {
                        wCount++;
                    } else {
                        bCount++;
                    }
                }
            }

            sb.append(Math.max(wCount, bCount) + "\n");
        }

        System.out.println(sb);
    }

}
