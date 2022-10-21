package 백준.PS10월;

import java.io.*;
import java.util.StringTokenizer;

public class PS1021_5671 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = "";
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int ans = 0;
            while (n <= m) {
                String num = Integer.toString(n);
                boolean isDuplicate = false;

                for (int i = 0; i < num.length() - 1; i++) {
                    for (int j = i + 1; j < num.length(); j++) {
                        if (num.charAt(i) == num.charAt(j)) {
                            isDuplicate = true;
                            break;
                        }
                    }
                }

                if (!isDuplicate) {
                    ans++;
                }
                n++;
            }

            System.out.println(ans);
        }
    }

}
