package 백준.PS8월;

import java.io.*;

public class PS0809_9996 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] pattern = br.readLine().split("\\*");

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            if (!s.startsWith(pattern[0])) {
                sb.append("NE" + "\n");
                continue;
            }

            s = s.substring(pattern[0].length());

            if (!s.endsWith(pattern[1])) {
                sb.append("NE" + "\n");
                continue;
            }

            sb.append("DA" + "\n");
        }

        System.out.println(sb);
    }

}
